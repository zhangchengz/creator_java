package com.tlf.creatorconsumer.api.course;

import com.tlf.creatorconsumer.common.JsonResult;
import com.tlf.creatorconsumer.constants.Constants;
import com.tlf.creatorconsumer.permission.AuthToken;
import com.tlf.creatorconsumer.req.DownloadReq;
import com.tlf.creatorconsumer.req.ResourceReq;
import com.tlf.creatorconsumer.req.UploadReq;
import com.tlf.creatorconsumer.resp.ResultResp;
import com.tlf.creatorconsumer.utils.JWTUtil;
import com.tlf.creatorconsumer.utils.TokenUtil;
import org.apache.commons.lang.StringUtils;
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
@RequestMapping("/api/public/course")
public class FileAPI {

    protected static final Logger logger = LoggerFactory.getLogger(FileAPI.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     * 上传资源
     *
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload_file")
    @AuthToken
    public ResultResp uploadFile(HttpServletRequest request) throws IOException {
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        String type = multipartRequest.getParameter("type");
        byte[] bytes = file.getBytes();
        UploadReq req = new UploadReq();
        req.setFile(bytes);
        req.setName(file.getOriginalFilename());
        req.setType(type);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "upload_file", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 根据id获取资源
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_resource_by_id")
    @AuthToken
    public ResultResp getResource(@RequestBody ResourceReq req, HttpServletRequest request) {
        if (req == null || req.getId() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "get_resource_by_id", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    @RequestMapping(value = "/test_upload_file")
    @AuthToken
    public ResultResp testUpload(HttpServletRequest request) throws IOException {
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        String type = multipartRequest.getParameter("type");
        byte[] bytes = file.getBytes();
        UploadReq req = new UploadReq();
        req.setFile(bytes);
        req.setName(file.getOriginalFilename());
        req.setType(type);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "test_upload_file", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    @RequestMapping(value = "/download")
    @AuthToken
    public Object download(HttpServletRequest request, @RequestBody DownloadReq req) {
        if (req == null || StringUtils.isBlank(req.getName()) || StringUtils.isBlank(req.getUrl())) {
            return new ResultResp(Constants.CODE_FAIL, "地址和文件名不能为空", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<byte[]> resp = restTemplate.postForEntity(Constants.CREATOR_COURSE + "download", requestEntity, byte[].class);
        return resp;
    }
}
