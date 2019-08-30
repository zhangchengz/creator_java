package com.tlf.creator.controller.curriculum.resource;

import com.tlf.creator.common.JsonResult;
import com.tlf.creator.config.UploadPathBean;
import com.tlf.creator.common.Constants;
import com.tlf.creator.entity.curriculum.resource.ResourceTypes;
import com.tlf.creator.entity.curriculum.resource.Resources;
import com.tlf.creator.entity.curriculum.training.TrainingFile;
import com.tlf.creator.exception.OperatingException;
import com.tlf.creator.permission.AuthToken;
import com.tlf.creator.po.ResourcePO;
import com.tlf.creator.req.DownloadReq;
import com.tlf.creator.req.ResourceReq;
import com.tlf.creator.req.UploadReq;
import com.tlf.creator.service.curriculum.resource.IResourceService;
import com.tlf.creator.service.curriculum.resource.IResourceTypeService;
import com.tlf.creator.service.curriculum.training.TrainingFileService;
import com.tlf.creator.utils.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
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
    private DBUtil DBUtil;

    @Autowired
    private UploadPathBean uploadPathBean;

    @Autowired
    private TrainingFileService trainingFileService;

    /**
     * 获取资源类型列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "resource_type_list", method = RequestMethod.GET)
    public JsonResult getResourceTypeList(HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        List<ResourceTypes> resourceTypes = resourceTypeService.queryResourceTypes(courseId);
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
    @AuthToken
    public JsonResult getResource(@RequestBody ResourceReq req, HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        String id = req.getId();
        Map<String, String> map = resourceService.queryFileById(courseId, id);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, map);
    }

    /**
     * 课程实训老师添加文件
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping(value = "add_training_resource")
    @AuthToken
    public JsonResult addResource(HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        MultipartFile file = params.getFile("file");
        String type = params.getParameter("type");
        if (file == null || file.isEmpty()) {
            return new JsonResult(Constants.CODE_FAIL, "文件为空", null, null);
        }
        String fileName = file.getOriginalFilename();
        long length = file.getSize();
        double size;
        String fileSize = null;
        if (length > 1024 * 1024 * 1024) {
            size = length * 1.00 / 1024 / 1024 / 1024;
            BigDecimal b = new BigDecimal(size);
            double dou = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            fileSize = dou + " GB";
        } else if (length < 1024 * 1024 * 1024 && length > 1024 * 1024) {
            size = length * 1.00 / 1024 / 1024;
            BigDecimal b = new BigDecimal(size);
            double dou = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            fileSize = dou + " MB";
        } else if (length < 1024 * 1024 && length > 1024) {
            size = length * 1.00 / 1024;
            BigDecimal b = new BigDecimal(size);
            double dou = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            fileSize = dou + " KB";
        } else if (length < 1024) {
            size = length;
            fileSize = size + " B";
        }
        String id = UUID.randomUUID().toString();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] bytes = new byte[0];
        String courseAilas = DBUtil.getCourseAlias(courseId);
        String path = uploadPathBean.getUploadPath() + File.separator + courseAilas+File.separator+type;
        File file1 = new File(path);
        if(!file1.exists()){
            file1.mkdirs();
        }
        Path simPath = Paths.get(path+File.separator+id+"."+suffix);
        try {
            bytes = file.getBytes();
            Files.write(simPath, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult(Constants.CODE_FAIL,"出错了，请重试",null,null);
        }
        TrainingFile trainingFile = new TrainingFile();
        trainingFile.setId(id);
        trainingFile.setName(fileName);
        trainingFile.setSize(fileSize);
        trainingFile.setSuffix(suffix);
        trainingFile.setType(type);
        trainingFile.setPath(courseAilas+File.separator+type+File.separator+id+"."+suffix);
        boolean insert = trainingFileService.insert(courseId, trainingFile);
        if(insert){
            return new JsonResult(Constants.CODE_SUCCESS, "success", null, id);
        }
        return new JsonResult(Constants.CODE_FAIL,"出错了，请重试",null,null);
    }

    /**
     * 添加资源（生产环境）
     *
     * @return
     * @throws FileNotFoundException
     */
//    @RequestMapping(value = "add_resource", method = RequestMethod.POST)
//    public JsonResult testUpload(HttpServletRequest request) throws IOException, OperatingException {
//        String courseId = request.getHeader("Cube-Domain");
//        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
//        MultipartFile file = params.getFile("file");
//        String resourceTypeName = params.getParameter("resourceTypeName");
//        String resourceTypeId = params.getParameter("resourceTypeId");
//        if (file == null || file.isEmpty()) {
//            throw new OperatingException(Constants.CODE_FAIL, "文件为空");
//        }
//        File path = new File(ResourceUtils.getURL("classpath:").getPath());
//        File upload = new File(path.getAbsolutePath(), "static/" + resourceTypeName);
//        if (!upload.exists()) {
//            upload.mkdirs();
//        }
//        String filename = file.getOriginalFilename();
//        String suffixName = filename.substring(filename.lastIndexOf("."), filename.length());
//        String fileId = UUID.randomUUID().toString();
//        File file1 = new File(upload + "/" + fileId + suffixName);
//        file.transferTo(file1);
//        Resources resource = new Resources();
//        String id = UUID.randomUUID().toString();
//        resource.setId(id);
//        resource.setName(filename);
//        resource.setPath(resourceTypeName + "/" + fileId + suffixName);
//        resource.setResourceTypeId(resourceTypeId);
//        resource.setCreatorId(accountUtil.getAccountId(request));
//        resourceService.addResource(courseId,resource);
//        Resources resources = resourceService.queryResourceById(courseId,id);
//        JsonResult jsonResult = new JsonResult();
//        jsonResult.setCode(Constants.CODE_SUCCESS);
//        jsonResult.setMsg("SUCCESS");
//        jsonResult.setObject(resources);
//        return jsonResult;
//    }
    @RequestMapping(value = "test_upload_file", method = RequestMethod.POST)
    @AuthToken
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
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, simPath.toString());
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
    @AuthToken(role_name = "teacher")
    public JsonResult uploadFile(@RequestBody UploadReq req) {
        File file = new File(uploadPathBean.getUploadPath() + "/" + req.getType());
        if (!file.exists()) {
            file.mkdirs();
        }
        if (req.getFile() == null) {
            return new JsonResult(Constants.CODE_FAIL, "文件为空", null, "null");
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
            return new JsonResult(Constants.CODE_FAIL, "上传失败，请重试", null, null);
        }
        resources.setId(fileId);
        resources.setPath(req.getType() + "/" + name);
        resources.setName(filename);
        //   resourceService.addResource(resources);
        resourcePO.setId(fileId);
        resourcePO.setPath(req.getType() + "/" + name);
        resourcePO.setName(filename);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, resourcePO);
    }


    /**
     * 下载文件的接口
     *
     * @param req
     * @throws IOException
     * @throws OperatingException
     */
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    @AuthToken
    public ResponseEntity<byte[]> download(@RequestBody DownloadReq req) {
        HttpHeaders headers = new HttpHeaders();
        ResponseEntity<byte[]> entity = null;
        InputStream in = null;
        try {
            String url = req.getUrl();
            if (url.contains("static/")) {
                url = url.substring(url.indexOf("static/") + 7);
            }
            in = new FileInputStream(new File(uploadPathBean.getUploadPath() + url));
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

}
