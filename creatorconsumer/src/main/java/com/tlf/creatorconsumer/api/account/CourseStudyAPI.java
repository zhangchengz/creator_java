package com.tlf.creatorconsumer.api.account;

import com.tlf.creatorconsumer.common.JsonResult;
import com.tlf.creatorconsumer.constants.Constants;
import com.tlf.creatorconsumer.permission.AuthToken;
import com.tlf.creatorconsumer.req.CourseReq;
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
public class CourseStudyAPI {

    protected static final Logger logger = LoggerFactory.getLogger(CourseStudyAPI.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取课程介绍及授课目标
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/get_course_description")
    @AuthToken
    public ResultResp getCourseDescription(@RequestBody CourseReq req, HttpServletRequest request) {
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "get_course_information", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 修改课程介绍
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/modify_course_description")
    @AuthToken(role_name = "teacher")
    public ResultResp modifyCourseDescription(@RequestBody CourseReq req, HttpServletRequest request) {
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "modify_course_description", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 修改授课目标
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "/modify_course_objectives")
    @AuthToken(role_name = "teacher")
    public ResultResp modifyCourseObjectives(@RequestBody CourseReq req, HttpServletRequest request) {
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "modify_course_objectives", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }
}
