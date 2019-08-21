package com.tlf.creatorcourse.controller.resource;

import com.alibaba.fastjson.JSONObject;
import com.tlf.creatorcourse.common.JsonResult;
import com.tlf.creatorcourse.common.JsonRet;
import com.tlf.creatorcourse.config.UploadPathBean;
import com.tlf.creatorcourse.constants.Constants;
import com.tlf.creatorcourse.entity.resource.ResourceTypes;
import com.tlf.creatorcourse.entity.resource.Resources;
import com.tlf.creatorcourse.exception.OperatingException;
import com.tlf.creatorcourse.po.ResourcePO;
import com.tlf.creatorcourse.req.DownloadReq;
import com.tlf.creatorcourse.req.ResourceReq;
import com.tlf.creatorcourse.req.UploadReq;
import com.tlf.creatorcourse.service.resource.IResourceService;
import com.tlf.creatorcourse.service.resource.IResourceTypeService;
import com.tlf.creatorcourse.utils.AccountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping
@CrossOrigin
public class ResourceController {

    protected static final Logger logger = LoggerFactory.getLogger(ResourceController.class);

    @Autowired
    private IResourceTypeService resourceTypeService;

    @Autowired
    private IResourceService resourceService;

    @Autowired
    private AccountUtil accountUtil;

    @Autowired
    private UploadPathBean uploadPathBean;

    /**
     * 获取资源类型列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "resource_type_list", method = RequestMethod.GET)
    public JsonResult getResourceTypeList(HttpServletRequest request) throws OperatingException {
        List<ResourceTypes> resourceTypes = resourceTypeService.queryResourceTypes();
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(Constants.CODE_SUCCESS);
        jsonResult.setMsg("SUCCESS");
        jsonResult.setObject(resourceTypes);
        return jsonResult;
    }

    /**
     * 根据id获取资源
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_resource_by_id", method = RequestMethod.POST)
    public JsonResult getResource(@RequestBody ResourceReq req) {
        String id = req.getId();
        Map<String, String> map = resourceService.queryFileById(id);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", map);
    }

    /**
     * 添加资源（生产环境）
     *
     * @param request
     * @return
     * @throws FileNotFoundException
     */
    @RequestMapping(value = "add_resource", method = RequestMethod.POST)
    public JsonResult testUpload(HttpServletRequest request) throws FileNotFoundException, IOException, OperatingException {
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        MultipartFile file = params.getFile("file");
        String resourceTypeName = params.getParameter("resourceTypeName");
        String resourceTypeId = params.getParameter("resourceTypeId");
        if (file == null || file.isEmpty()) {
            throw new OperatingException(Constants.CODE_FAIL, "文件为空");
        }
        File path = new File(ResourceUtils.getURL("classpath:").getPath());
        File upload = new File(path.getAbsolutePath(), "static/" + resourceTypeName);
        if (!upload.exists()) {
            upload.mkdirs();
        }
        String filename = file.getOriginalFilename();
        String suffixName = filename.substring(filename.lastIndexOf("."), filename.length());
        String fileId = UUID.randomUUID().toString();
        File file1 = new File(upload + "/" + fileId + suffixName);
        file.transferTo(file1);
        Resources resource = new Resources();
        String id = UUID.randomUUID().toString();
        resource.setId(id);
        resource.setName(filename);
        resource.setPath(resourceTypeName + "/" + fileId + suffixName);
        resource.setResourceTypeId(resourceTypeId);
        resource.setCreatorId(accountUtil.getAccountId(request));
        resourceService.addResource(resource);
        Resources resources = resourceService.queryResourceById(id);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(Constants.CODE_SUCCESS);
        jsonResult.setMsg("SUCCESS");
        jsonResult.setObject(resources);
        return jsonResult;

    }

    @RequestMapping(value = "test_upload_file", method = RequestMethod.POST)
    public JsonResult testUpload(@RequestBody UploadReq req) throws IOException {
        File file = new File(uploadPathBean.getUploadPath() + "/" + req.getType());
        if (!file.exists()) {
            file.mkdirs();
        }
        String filename = req.getName();
        String suffixName = filename.substring(filename.lastIndexOf("."));
        String fileId = UUID.randomUUID().toString();
        byte[] bytes = req.getFile();
        String name = fileId + suffixName;
        Path simPath = Paths.get(file.getAbsolutePath() + "/" + name);
        Files.write(simPath, bytes);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", simPath.toString());
    }

    /**
     * 上传资源
     *
     * @param req
     * @return
     * @throws IOException
     * @throws OperatingException
     */
    @RequestMapping(value = "upload_file", method = RequestMethod.POST)
    public JsonResult uploadFile(@RequestBody UploadReq req) {
        File file = new File(uploadPathBean.getUploadPath() + "/" + req.getType());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (req.getFile() == null) {
            return new JsonResult(Constants.CODE_FAIL, "文件为空", "null");
        }
        ResourcePO resourcePO = new ResourcePO();
        Resources resources = new Resources();
        String filename = req.getName();
        String suffixName = filename.substring(filename.lastIndexOf("."));
        if (Constants.SIMULATION_RESOURCE.equals(req.getType())) {
            //前期写定，后面改为动态获取
            if (req.getName().endsWith(".cc3d")) { //3维场景
                resourcePO.setTypeId("2539d5f1-9663-11e9-b790-7085c206b232");
                resourcePO.setExpTypeId("abed17b5-fb4f-4164-8de2-a8145bd2ed58");
                resourcePO.setTypeName("三维工厂场景");
                resourcePO.setSimType("3d");
            } else if (req.getName().endsWith(".cc2d")) { //2维场景
                resourcePO.setTypeId("24941bc3-9663-11e9-b790-7085c206b232");
                resourcePO.setTypeName("二维布局图");
                resourcePO.setSimType("2d");
            }
        } else {
            resourcePO.setTypeName(suffixName);
        }
        String fileId = UUID.randomUUID().toString();
        byte[] bytes = req.getFile();
        String name = fileId + suffixName;
        Path simPath = Paths.get(file.getAbsolutePath() + "/" + name);
        try {
            Files.write(simPath, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult(Constants.CODE_FAIL, "上传失败，请重试", null);
        }
        resources.setId(fileId);
        resources.setPath(req.getType() + "/" + name);
        resources.setName(filename);
        resourceService.addResource(resources);
        resourcePO.setId(fileId);
        resourcePO.setPath(req.getType() + "/" + name);
        resourcePO.setName(filename);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", resourcePO);
    }

    /**
     * 获取资源列表
     *
     * @param json
     * @return
     */
    @RequestMapping(value = "resource_list", method = RequestMethod.GET)
    public JsonRet getResourceList(@RequestBody String json) {
        JsonRet jsonRet = new JsonRet();
        JSONObject jsonObject = JSONObject.parseObject(json);
        Integer offset = (Integer) jsonObject.get("offset");
        Integer limit = (Integer) jsonObject.get("limit");
        String resourceTypeId = jsonObject.get("resourceTypeId").toString();
        List<Resources> resources = resourceService.queryResourceByTypeId(resourceTypeId, offset, limit);
        Integer count = resourceService.queryTotalResourceByTypeId(resourceTypeId);
        jsonRet.setCode(Constants.CODE_SUCCESS);
        jsonRet.setMsg("SUCCESS");
        jsonRet.setLength(count);
        jsonRet.setObject(resources);
        return jsonRet;
    }

    /**
     * 下载文件的接口
     *
     * @param req
     * @throws IOException
     * @throws OperatingException
     */
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public ResponseEntity<byte[]> download(@RequestBody DownloadReq req) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> entity = null;
        InputStream in = null;
        try {
            String url = req.getUrl();
            if (url.contains("static/")) {
                url = url.substring(url.indexOf("static/")+7);
            }
            in=new FileInputStream(new File(uploadPathBean.getUploadPath()+url));
            // in=new FileInputStream(inputStream);
            byte[] bytes = new byte[in.available()];
            String imageName = req.getName();
            imageName = new String(imageName.getBytes("UTF-8"), "iso-8859-1");
            in.read(bytes);
            //   headers.add("Content-Type","application/json");
            headers.add("Content-Disposition", "attachment;filename=" + imageName);
            headers.add("Access-Control-Expose-Headers", "Content-Disposition");
            headers.add("downloadFileName", imageName);

            entity = new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);

        } catch (Exception e) {
            logger.error(e.toString());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error(e.toString());
                }
            }
        }
        return entity;
    }

    /**
     * 添加或修改模板场景
     *
     * @param json
     * @param request
     * @return
     * @throws IOException
     * @throws OperatingException
     */
    @RequestMapping(value = "add_template_scene", method = RequestMethod.POST)
    public JsonResult addTaskScene(@RequestBody String json, HttpServletRequest request) throws IOException, OperatingException {
        JSONObject jsonObject = JSONObject.parseObject(json);
        Object file = jsonObject.get("file");
        Object id = jsonObject.get("id");
        Object name = jsonObject.get("name");
        Object type = jsonObject.get("type");
        if (file != null) {
            if (id == null) {
                if (name == null || type == null) {
                    return new JsonResult(Constants.CODE_FAIL, "NAME OR TYPE CAN NOT BE NULL", null);
                }
                System.out.println("1111111111111111");
                Resources resource = new Resources();
                byte[] sceneBytes = file.toString().getBytes();
                String uuid = UUID.randomUUID().toString();
                File path = new File(ResourceUtils.getURL("classpath:").getPath());
                File upload1 = new File(path.getAbsolutePath(), "static/template_scene/");
                if (!upload1.exists()) {
                    upload1.mkdirs();
                }
                String suffix = null;
                if (type.toString().equals("基础实验")) {
                    suffix = ".cctb";
                }
                if (type.toString().equals("创新实验")) {
                    suffix = ".ccti";
                }
                if (type.toString().equals("综合实验")) {
                    suffix = ".cctc";
                }
                Path scenePath = Paths.get(upload1.getAbsolutePath() + "/" + uuid + name.toString() + suffix);
                Files.write(scenePath, sceneBytes);
                resource.setCreatorId(accountUtil.getAccountId(request));
                resource.setResourceTypeId(Constants.TEMPLATE_SCENE_ID);
                resource.setName(name.toString() + suffix);
                resource.setPath(Constants.TEMPLATE_SCENE + "/" + uuid + name.toString() + suffix);
                resource.setId(uuid);
                resourceService.addResource(resource);
                return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", uuid);

            } else {
                Resources resource = resourceService.queryResourceById(id.toString());
                System.out.println("000000000000000000");
                if (resource == null) {
                    return new JsonResult(Constants.CODE_FAIL, "SCENE DOES NOT EXISTS", null);
                }
                byte[] sceneBytes = file.toString().getBytes();
                String uuid = UUID.randomUUID().toString();
                File path = new File(ResourceUtils.getURL("classpath:").getPath());
                File upload1 = new File(path.getAbsolutePath(), "static/template_scene/");
                if (!upload1.exists()) {
                    upload1.mkdirs();
                }
                String name1 = resource.getName();
                String tem = "\\.";
                String[] split = name1.split(tem);
                System.out.println(split);
                String name2 = split[0];
                String suffix = "." + split[1];
                Path scenePath = Paths.get(upload1.getAbsolutePath() + "/" + uuid + name2.toString() + suffix);
                Files.write(scenePath, sceneBytes);
                resource.setCreatorId(accountUtil.getAccountId(request));
                resource.setResourceTypeId(Constants.TEMPLATE_SCENE_ID);
                resource.setName(name2.toString() + suffix);
                resource.setPath(Constants.TEMPLATE_SCENE + "/" + uuid + name2.toString() + suffix);
                resourceService.updateResource(resource);
                return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", id);
            }
        } else {
            return new JsonResult(Constants.CODE_FAIL, "FILE OR NAME OR TYPE CAN NOT BE NULL", null);
        }
    }

    /**
     * 获取场景资源列表
     *
     * @param json
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_template_scene_list", method = RequestMethod.POST)
    public JsonResult getTemplateSceneList(@RequestBody String json) throws OperatingException {
        JSONObject jsonObject = JSONObject.parseObject(json);
        Object offset1 = jsonObject.get("offset");
        Object limit1 = jsonObject.get("limit");
        if (offset1 == null || limit1 == null) {
            return new JsonResult(Constants.CODE_FAIL, "OFFSET OR LIMIT CAN NOT BE NULL", null);
        }
        Integer offset = (Integer) offset1;
        Integer limit = (Integer) limit1;
        List<Resources> resources = resourceService.queryResourceByTypeId(Constants.TEMPLATE_SCENE_ID, offset, limit);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", resources);
    }
}
