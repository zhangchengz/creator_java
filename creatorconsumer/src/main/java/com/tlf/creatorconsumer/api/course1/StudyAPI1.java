package com.tlf.creatorconsumer.api.course1;

import com.tlf.creatorconsumer.common.JsonResult;
import com.tlf.creatorconsumer.common.JsonRet;
import com.tlf.creatorconsumer.constants.Constants;
import com.tlf.creatorconsumer.req.BaseReq;
import com.tlf.creatorconsumer.req.StudyReq;
import com.tlf.creatorconsumer.resp.ResultResp;
import com.tlf.creatorconsumer.utils.JWTUtil;
import com.tlf.creatorconsumer.utils.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api/public/course1")
public class StudyAPI1 {

    protected static final Logger logger = LoggerFactory.getLogger(StudyAPI1.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取章节列表
     * @return
     */
    @RequestMapping(value = "/get_chapter_and_unit_list")
    public ResultResp getChapterAndUnit( HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        BaseReq req = TokenUtil.getReq(request);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_chapter_and_unit_list", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    @RequestMapping(value = "/get_chapters")
    public ResultResp getChapters( HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        BaseReq req = TokenUtil.getReq(request);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_chapters", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 根据章id获取节列表
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_unit_list")
    public ResultResp getUnitByChapterId(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getChapterId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_unit_list", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 资料上传
     * @param
     * @param request
     * @return
     */
    @RequestMapping(value = "/upload_material")
    public ResultResp uploadMaterial(HttpServletRequest request) throws IOException {
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");

        byte[] bytes = file.getBytes();
        StudyReq req = new StudyReq();
        String chapterId = multipartRequest.getParameter("chapterId");
        String unitId = multipartRequest.getParameter("unitId");
        req.setFile(bytes);
        req.setFileName(file.getOriginalFilename());
        req.setChapterId(chapterId);
        req.setUnitId(unitId);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "upload_material", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 获取所有的资料
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_all_materials")
    public ResultResp getAllMaterials(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getOffset()==null||req.getLimit()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_all_materials", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 获取指定章下的资料
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_materials_by_chapter")
    public ResultResp getMaterialsByChapter(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getOffset()==null||req.getLimit()==null||req.getChapterId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_materials_by_chapter", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 获取指定节下的资料
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_materials_by_unit")
    public ResultResp getMaterialsByUnit(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getOffset()==null||req.getLimit()==null||req.getUnitId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_materials_by_unit", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 添加章
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/add_chapter")
    public ResultResp addChapter(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getChapterName()==null||req.getLevel()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "add_chapter", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 添加节
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/add_unit")
    public ResultResp addUnit(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getUnitName()==null||req.getLevel()==null||req.getChapterId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "add_unit", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 修改章名称
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/modify_chapter_name")
    public ResultResp modifyChapterName(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getChapterName()==null||req.getChapterId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "modify_chapter_name", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     *  修改节名称
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/modify_unit_name")
    public ResultResp modifyUnitName(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getUnitName()==null||req.getUnitId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "modify_unit_name", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 删除章
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete_chapter")
    public ResultResp deleteChapter(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getChapterId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "delete_chapter", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 删除节
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete_unit")
    public ResultResp deleteUnit(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getUnitId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "delete_unit", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 文件重命名
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/modify_material_name")
    public ResultResp modifyMaterialName(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getMaterialId()==null||req.getMaterialName()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "modify_material_name", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 文件删除
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete_material")
    public ResultResp deleteMaterial(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getMaterialId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "delete_material", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /***
     * 文件移动位置
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/modify_material_chapter_and_unit")
    public ResultResp modifyMaterialPosition(@RequestBody StudyReq req, HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        if(req==null||req.getMaterialId()==null||req.getChapterId()==null||req.getUnitId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "modify_material_chapter_and_unit", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

}
