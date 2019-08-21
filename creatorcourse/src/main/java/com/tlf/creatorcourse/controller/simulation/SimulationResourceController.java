package com.tlf.creatorcourse.controller.simulation;

import com.tlf.creatorcourse.common.JsonResult;
import com.tlf.creatorcourse.common.JsonRet;
import com.tlf.creatorcourse.config.UploadPathBean;
import com.tlf.creatorcourse.constants.Constants;
import com.tlf.creatorcourse.entity.simulation.ExperimentTypes;
import com.tlf.creatorcourse.entity.simulation.SceneType;
import com.tlf.creatorcourse.entity.simulation.SimulationResource;
import com.tlf.creatorcourse.entity.taskexperiment.ExperimentAnnex;
import com.tlf.creatorcourse.po.SimulationResourcePO;
import com.tlf.creatorcourse.req.*;
import com.tlf.creatorcourse.service.simulationresource.ISceneTypeService;
import com.tlf.creatorcourse.service.simulationresource.ISimulationResourceService;
import com.tlf.creatorcourse.service.taskexperiment.ITaskExperimentAnnexService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class SimulationResourceController {

    @Autowired
    private ISimulationResourceService simulationResourceService;

    @Autowired
    private ISceneTypeService sceneTypeService;

    @Autowired
    private UploadPathBean uploadPathBean;

    @Autowired
    private ITaskExperimentAnnexService annexService;


    /**
     * 获取资源类型列表
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "get_scene_type_list", method = RequestMethod.POST)
    public JsonResult getSceneTypeList(@RequestBody BaseReq req) {
        List<SceneType> sceneTypes = sceneTypeService.selectList();
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", sceneTypes);
    }

    /**
     * 获取仿真资源列表
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "get_simulation_resource_list", method = RequestMethod.POST)
    public JsonRet getSimulationResourceList(@RequestBody SimReq req) {
        if (req.isInner()) {
            List<SimulationResourcePO> simulationResourcePOS = simulationResourceService.selectListInner(req);
            Integer length = simulationResourceService.selectTotalInner();
            return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", length, simulationResourcePOS);
        } else {
            List<SimulationResourcePO> simulationResourcePOS = simulationResourceService.selectListNotInner(req);
            Integer length = simulationResourceService.selectTotalNotInner(req);
            return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", length, simulationResourcePOS);
        }
    }

    /**
     * 新增仿真资源
     *
     * @param resourceReq
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "add_simulation_resource", method = RequestMethod.POST)
    public JsonResult addSimulationResource(@RequestBody SimulationResourceReq resourceReq) throws IOException {
        List<String> list = simulationResourceService.selectAllName();
        for (String name : list) {
            if (name.equals(resourceReq.getName())) {
                return new JsonResult(Constants.CODE_FAIL, "该名称已经存在", null);
            }
        }
        File file = new File(uploadPathBean.getUploadPath() + "/" + "simulation_resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        String uuid = UUID.randomUUID().toString();
        String simName = uuid + ".cc3d";
//        switch (resourceReq.getTypeId()) {
//            case Constants.CC2D:
//                simName = uuid + ".cc2d";
//                break;
//            case Constants.CC2C:
//                simName = uuid + ".cc2c";
//                break;
//            case Constants.CC2L:
//                simName = uuid + ".cc2l";
//                break;
//            case Constants.CC3D:
//                simName = uuid + ".cc3d";
//                break;
//        }
        Path simPath = Paths.get(file.getAbsolutePath() + "/" + simName);
        simPath.toFile().createNewFile();
//        Files.write(simPath,simBytes );
        SimulationResource simulationResource = new SimulationResource();
        simulationResource.setId(uuid);
        simulationResource.setInner(false);
        simulationResource.setPath("simulation_resource/" + simName);
        simulationResource.setName(resourceReq.getName());
        simulationResource.setTypeId(resourceReq.getTypeId());
        simulationResource.setCreatorId(resourceReq.getCreatorId());
        simulationResource.setExpTypeId(resourceReq.getExpTypeId());
        boolean insert = simulationResourceService.insert(simulationResource);
        if (insert) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
        }
        return new JsonResult(Constants.CODE_FAIL, "FAIL", null);
    }

    /**
     * 克隆资源
     *
     * @param resourceReq
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "clone_simulation_resource", method = RequestMethod.POST)
    public JsonResult cloneSimulationResource(@RequestBody SimulationResourceReq resourceReq) throws IOException {
        SimulationResource simulationResource1 = simulationResourceService.selectByPrimaryKey(resourceReq.getId());
        if (simulationResource1 == null) {
            return new JsonResult(Constants.CODE_FAIL, "要克隆的资源不存在", null);
        }
        List<String> list = simulationResourceService.selectAllName();
        for (String name : list) {
            if (name.equals(resourceReq.getName())) {
                return new JsonResult(Constants.CODE_FAIL, "该名称已经存在", null);
            }
        }
        String url3 = simulationResource1.getPath();
        String url = Constants.RESOURCE_PATH + url3;
        File dir = new File(uploadPathBean.getUploadPath()+"/simulation_resource");
        String uuid = UUID.randomUUID().toString();
        String suffix = url3.substring(url3.lastIndexOf("."));
        String simName = uuid + suffix;
        try {
            URL httpUrl = new URL(url);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            FileUtils.copyURLToFile(httpUrl, new File(dir+"/"+simName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        simulationResource1.setId(uuid);
        simulationResource1.setInner(false);
        simulationResource1.setPath("simulation_resource/" + simName);
        simulationResource1.setName(resourceReq.getName());
        simulationResource1.setCreatorId(resourceReq.getAccountId());
        boolean insert = simulationResourceService.insert(simulationResource1);
        if (insert) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
        }
        return new JsonResult(Constants.CODE_FAIL, "FAIL", null);
    }


    /**
     * 删除仿真资源
     *
     * @param resourceReq
     * @return
     */
    @RequestMapping(value = "delete_simulation_resource", method = RequestMethod.POST)
    public JsonResult deleteSimulationResource(@RequestBody SimulationResourceReq resourceReq) {
        boolean delete = simulationResourceService.deleteByPrimaryKey(resourceReq.getId());
        if (delete) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
        }
        return new JsonResult(Constants.CODE_FAIL, "FAIL", null);
    }

    /**
     * 修改仿真资源
     *
     * @param resourceReq
     * @return
     */
    @RequestMapping(value = "modify_simulation_resource", method = RequestMethod.POST)
    public JsonResult modifySimulationResource(@RequestBody ResourceReq resourceReq) {
        SimulationResource simulationResource = simulationResourceService.selectByPrimaryKey(resourceReq.getId());
        ExperimentAnnex annex = annexService.selectById(resourceReq.getId());
        String path1 = null;
        if (annex != null) {
            path1 = annex.getPath();
        }
        if (simulationResource != null) {
            path1 = simulationResource.getPath();
        }
        String json = resourceReq.getJson();
        byte[] simBytes = json.getBytes();
        File path = new File(uploadPathBean.getUploadPath());
        File simPath = new File(path.getAbsolutePath(), path1);
        try {
            Files.write(simPath.toPath(), simBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult(Constants.CODE_FAIL, "保存失败", null);
        }
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 获取实验类型列表
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "experiment_type_list", method = RequestMethod.POST)
    public JsonResult getExperimentTypes(@RequestBody BaseReq req) {
        List<ExperimentTypes> experimentTypes = simulationResourceService.quertAllExperimentTypes();
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", experimentTypes);
    }

    /**
     * 获取2维/3维资源类型
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "get_scene_types", method = RequestMethod.POST)
    public JsonResult getSceneTypeList(@RequestBody SimReq req) {
        List<SceneType> sceneTypes = sceneTypeService.selectListByAlias(req.getAlias());
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", sceneTypes);
    }
}
