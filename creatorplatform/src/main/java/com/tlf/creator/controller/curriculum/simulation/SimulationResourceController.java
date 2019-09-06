package com.tlf.creator.controller.curriculum.simulation;

import cn.hutool.core.io.FileUtil;
import com.tlf.creator.aspect.AuthToken;
import com.tlf.creator.common.Constants;
import com.tlf.creator.common.JsonResult;
import com.tlf.creator.config.UploadPathBean;
import com.tlf.creator.entity.curriculum.simulation.ExperimentTypes;
import com.tlf.creator.entity.curriculum.simulation.SceneType;
import com.tlf.creator.entity.curriculum.simulation.SimulationResource;
import com.tlf.creator.po.SimulationResourcePO;
import com.tlf.creator.req.ResourceReq;
import com.tlf.creator.req.SimReq;
import com.tlf.creator.req.SimulationResourceReq;
import com.tlf.creator.service.curriculum.simulationresource.ISceneTypeService;
import com.tlf.creator.service.curriculum.simulationresource.ISimulationResourceService;
import com.tlf.creator.utils.AccountUtil;
import com.tlf.creator.utils.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@CrossOrigin
public class SimulationResourceController {

    @Autowired
    private ISimulationResourceService simulationResourceService;

    @Autowired
    private ISceneTypeService sceneTypeService;

    @Autowired
    private UploadPathBean uploadPathBean;

    @Autowired
    private AccountUtil accountUtil;

    @Autowired
    private DBUtil dbUtil;

    /**
     * 获取资源类型列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "get_scene_type_list", method = RequestMethod.POST)
    public JsonResult getSceneTypeList(HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        List<SceneType> sceneTypes = sceneTypeService.selectList(courseId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, sceneTypes);
    }

    /**
     * 获取仿真资源列表
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "get_simulation_resource_list", method = RequestMethod.POST)
    public JsonResult getSimulationResourceList(@RequestBody SimReq req,HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        String accountId = accountUtil.getAccountId(request);
        req.setAccountId(accountId);
        if (req.isInner()) {
            List<SimulationResourcePO> simulationResourcePOS = simulationResourceService.selectListInner(courseId,req);
            Integer length = simulationResourceService.selectTotalInner(courseId);
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", length, simulationResourcePOS);
        } else {
            List<SimulationResourcePO> simulationResourcePOS = simulationResourceService.selectListNotInner(courseId,req);
            Integer length = simulationResourceService.selectTotalNotInner(courseId,req);
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", length, simulationResourcePOS);
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
    @AuthToken(role_name = "teacher")
    public JsonResult addSimulationResource(@RequestBody SimulationResourceReq resourceReq,HttpServletRequest request) throws IOException {
        String courseId = request.getHeader("Cube-Domain");
        List<String> list = simulationResourceService.selectAllName(courseId);
        String accountId = accountUtil.getAccountId(request);
        for (String name : list) {
            if (name.equals(resourceReq.getName())) {
                return new JsonResult(Constants.CODE_FAIL, "该名称已经存在", null, null);
            }
        }
        String courseAlias = dbUtil.getCourseAlias(courseId);
        File file = new File(uploadPathBean.getUploadPath() + courseAlias+File.separator + "simulation_resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        String uuid = UUID.randomUUID().toString();
        String simName = uuid + ".cc3d";
        Path simPath = Paths.get(file.getAbsolutePath() + File.separator + simName);
        simPath.toFile().createNewFile();
        SimulationResource simulationResource = new SimulationResource();
        simulationResource.setId(uuid);
        simulationResource.setInner(false);
        simulationResource.setPath( courseAlias+File.separator + "simulation_resource");
        simulationResource.setName(resourceReq.getName());
        simulationResource.setTypeId(resourceReq.getTypeId());
        simulationResource.setCreatorId(accountId);
        simulationResource.setExpTypeId(resourceReq.getExpTypeId());
        boolean insert = simulationResourceService.insert(courseId,simulationResource);
        if (insert) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
        }
        return new JsonResult(Constants.CODE_FAIL, "FAIL", null, null);
    }

    /**
     * 克隆资源
     *
     * @param resourceReq
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "clone_simulation_resource", method = RequestMethod.POST)
    @AuthToken(role_name = "teacher")
    public JsonResult cloneSimulationResource(@RequestBody SimulationResourceReq resourceReq,HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        String accountId = accountUtil.getAccountId(request);
        SimulationResource simulationResource1 = simulationResourceService.selectByPrimaryKey(courseId,resourceReq.getId());
        if (simulationResource1 == null) {
            return new JsonResult(Constants.CODE_FAIL, "要克隆的资源不存在", null, null);
        }
        List<String> list = simulationResourceService.selectAllName(courseId);
        for (String name : list) {
            if (name.equals(resourceReq.getName())) {
                return new JsonResult(Constants.CODE_FAIL, "该名称已经存在", null, null);
            }
        }
        String path = simulationResource1.getPath();
        File file = new File(uploadPathBean.getUploadPath() + path);
        if (!file.exists()) {
            return new JsonResult(Constants.CODE_FAIL,"场景不存在",null,null);
        }
        String simulationResourceId = UUID.randomUUID().toString();
        String suffix = FileUtil.extName(file);
        String sub = path.substring(0, path.lastIndexOf(".") - 36);
        File file1 = new File(uploadPathBean.getUploadPath() + sub + simulationResourceId + "." + suffix);
        FileUtil.copy(file, file1, false);
        simulationResource1.setId(simulationResourceId);
        simulationResource1.setInner(false);
        simulationResource1.setPath(sub + simulationResourceId + "." + suffix);
        simulationResource1.setName(resourceReq.getName());
        simulationResource1.setCreatorId(accountId);
        boolean insert = simulationResourceService.insert(courseId,simulationResource1);
        if (insert) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
        }
        return new JsonResult(Constants.CODE_FAIL, "FAIL", null, null);
    }


    /**
     * 删除仿真资源
     *
     * @param resourceReq
     * @return
     */
    @RequestMapping(value = "delete_simulation_resource", method = RequestMethod.POST)
    @AuthToken(role_name = "teacher")
    public JsonResult deleteSimulationResource(@RequestBody SimulationResourceReq resourceReq,HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        boolean delete = simulationResourceService.deleteByPrimaryKey(courseId,resourceReq.getId());
        if (delete) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
        }
        return new JsonResult(Constants.CODE_FAIL, "FAIL", null, null);
    }

    /**
     * 修改仿真资源
     *
     * @param resourceReq
     * @return
     */
    @RequestMapping(value = "modify_simulation_resource", method = RequestMethod.POST)
    @AuthToken(role_name = "teacher")
    public JsonResult modifySimulationResource(@RequestBody ResourceReq resourceReq,HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        SimulationResource simulationResource = simulationResourceService.selectByPrimaryKey(courseId,resourceReq.getId());
        String path1 = null;

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
            return new JsonResult(Constants.CODE_FAIL, "保存失败", null, null);
        }
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
    }

    /**
     * 获取实验类型列表
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "experiment_type_list", method = RequestMethod.POST)
    public JsonResult getExperimentTypes(HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        List<ExperimentTypes> experimentTypes = simulationResourceService.queryAllExperimentTypes(courseId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, experimentTypes);
    }

    /**
     * 获取2维/3维资源类型
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "get_scene_types", method = RequestMethod.POST)
    public JsonResult getSceneTypeList(@RequestBody SimReq req,HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        List<SceneType> sceneTypes = sceneTypeService.selectListByAlias(courseId,req.getAlias());
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, sceneTypes);
    }

}
