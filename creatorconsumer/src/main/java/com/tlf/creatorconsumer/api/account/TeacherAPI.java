package com.tlf.creatorconsumer.api.account;

import com.tlf.creatorconsumer.common.JsonResult;
import com.tlf.creatorconsumer.common.JsonRet;
import com.tlf.creatorconsumer.constants.Constants;
import com.tlf.creatorconsumer.permission.AuthToken;
import com.tlf.creatorconsumer.req.StudentReq;
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

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/public/account")
public class TeacherAPI {

    protected static final Logger logger = LoggerFactory.getLogger(TeacherAPI.class);

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/get_teacher_list")
    @AuthToken
    public ResultResp getTeachers(@RequestBody StudentReq req, HttpServletRequest request) {
        if (req == null || req.getLimit() == null || req.getOffset() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "get_teacher_list", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    @RequestMapping(value = "/add_teacher")
    @AuthToken(role_name = "admin")
    public ResultResp addTeacher(@RequestBody StudentReq req, HttpServletRequest request) {
        if (req == null || req.getName() == null || req.getPhone() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "add_teacher", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    @RequestMapping(value = "/modify_teacher_information")
    @AuthToken(role_name = "admin")
    public ResultResp modifyTeacherInformation(@RequestBody StudentReq req, HttpServletRequest request) {
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
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "modify_teacher_information", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    @RequestMapping(value = "/delete_teacher")
    @AuthToken(role_name = "admin")
    public ResultResp deleteTeacher(@RequestBody StudentReq req, HttpServletRequest request) {
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
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "delete_teacher", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }
}
