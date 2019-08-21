package com.tlf.creatorconsumer.api.account;

import com.tlf.creatorconsumer.common.JsonResult;
import com.tlf.creatorconsumer.constants.Constants;
import com.tlf.creatorconsumer.permission.AuthToken;
import com.tlf.creatorconsumer.req.AccountReq;
import com.tlf.creatorconsumer.req.CoReq;
import com.tlf.creatorconsumer.req.CourseReq;
import com.tlf.creatorconsumer.req.GradeReq;
import com.tlf.creatorconsumer.resp.AccountResp;
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

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/api/public/account")
public class UserAPI {

    protected static final Logger logger = LoggerFactory.getLogger(UserAPI.class);

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/login")
    public ResultResp login(@RequestBody AccountReq req) {
        ResponseEntity< Map> s = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "login", req, Map.class);
        logger.info("remote call " + s);
        Map resp = s.getBody();
        return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp);
    }

    @RequestMapping(value = "/user_info")
    @AuthToken
    public ResultResp login(HttpServletRequest request) {
        HttpEntity<Object> requestEntity = TokenUtil.getHttpEntity(request);
        ResponseEntity<JsonResult> js = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "user_info", requestEntity, JsonResult.class);
        logger.info("remote call " + js);
        JsonResult resp = js.getBody();
        return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
    }

    @RequestMapping(value = "/get_course_list")
    @AuthToken
    public ResultResp getCourseList(HttpServletRequest request) {
        HttpEntity<Object> requestEntity = TokenUtil.getHttpEntity(request);
        ResponseEntity<List> jr = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "get_course_list_by_account", requestEntity, List.class);
        logger.info("remote call " + jr);
        List resp = jr.getBody();
        return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp);
    }

    @RequestMapping(value = "/get_class_and_student")
    @AuthToken
    public ResultResp getClassAndStudent(@RequestBody CoReq req, HttpServletRequest request) {
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> jr = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "get_class_and_student", requestEntity, JsonResult.class);
        logger.info("remote call " + jr);
        JsonResult resp = jr.getBody();
        return new ResultResp(resp.getCode(), resp.getMsg(), null, resp.getObject());
    }

    @RequestMapping(value = "/change_password")
    @AuthToken(role_name = "admin")
    public ResultResp changePassword(@RequestBody AccountReq req, HttpServletRequest request) {
        if (req == null || StringUtils.isBlank(req.getUserId()) || StringUtils.isBlank(req.getPassword())) {
            return new ResultResp(Constants.CODE_FAIL, "id或密码不能为空", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> jr = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "change_password", requestEntity, JsonResult.class);
        logger.info("remote call " + jr);
        JsonResult resp = jr.getBody();
        return new ResultResp(resp.getCode(), resp.getMsg(), null, resp.getObject());
    }

    @RequestMapping(value = "/change_password_self")
    @AuthToken
    public ResultResp changePasswordSelf(@RequestBody AccountReq req, HttpServletRequest request) {
        if (req == null || StringUtils.isBlank(req.getPassword()) || StringUtils.isBlank(req.getNewPassword())) {
            return new ResultResp(Constants.CODE_FAIL, "密码不能为空", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> jr = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "change_password_self", requestEntity, JsonResult.class);
        logger.info("remote call " + jr);
        JsonResult resp = jr.getBody();
        return new ResultResp(resp.getCode(), resp.getMsg(), null, resp.getObject());
    }

    @RequestMapping(value = "/get_class")
    @AuthToken
    public ResultResp getClass(HttpServletRequest request) {
        HttpEntity<Object> requestEntity = TokenUtil.getHttpEntity(request);
        ResponseEntity<JsonResult> jr = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "get_class", requestEntity, JsonResult.class);
        logger.info("remote call " + jr);
        JsonResult resp = jr.getBody();
        return new ResultResp(resp.getCode(), resp.getMsg(), null, resp.getObject());
    }

    @RequestMapping(value = "/get_class_by_teacher")
    @AuthToken
    public ResultResp getClassByTeacher(@RequestBody CourseReq req, HttpServletRequest request) {
        if (req == null || StringUtils.isBlank(req.getCourseId())) {
            return new ResultResp(Constants.CODE_FAIL, "课程不能为空", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> jr = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "get_class_by_teacher", requestEntity, JsonResult.class);
        logger.info("remote call " + jr);
        JsonResult resp = jr.getBody();
        return new ResultResp(resp.getCode(), resp.getMsg(), null, resp.getObject());
    }

    /**
     * 退出登录计时
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/loginTime")
    @AuthToken
    public ResultResp logout(HttpServletRequest request) {
        HttpEntity<Object> requestEntity = TokenUtil.getHttpEntity(request);
        ResponseEntity<JsonResult> jr = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "logout", requestEntity, JsonResult.class);
        logger.info("remote call " + jr);
        JsonResult resp = jr.getBody();
        return new ResultResp(resp.getCode(), resp.getMsg(), null, resp.getObject());
    }

    /**
     * 老师获取学生成绩，在线时长，任务完成情况
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_grade")
    @AuthToken(role_name = "teacher")
    public ResultResp getGrade(@RequestBody GradeReq req, HttpServletRequest request) {
        if (req == null || StringUtils.isBlank(req.getClassId()) || StringUtils.isBlank(req.getTaskExperimentId())) {
            return new ResultResp(Constants.CODE_FAIL, "班级和任务id不能为空", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<List> res1 = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "get_time_by_class", requestEntity, List.class);
        ResponseEntity<List> res2 = restTemplate.postForEntity(Constants.CREATOR_COURSE + "get_grade", requestEntity, List.class);
        List<LinkedHashMap<String, Object>> times = res1.getBody();
        List<LinkedHashMap<String, Object>> grades = res2.getBody();
        List<HashMap<String, Object>> gradeList = new LinkedList<>();
        for (LinkedHashMap<String, Object> time : times) {
            if (time != null) {
                HashMap<String, Object> map = new HashMap<>();
                Object accountId1 = time.get("accountId");
                Object accountName = time.get("accountName");
                Object onlineTime = time.get("onlineTime");
                map.put("accountName", accountName);
                map.put("accountId", accountId1);
                map.put("onlineTime", onlineTime);
                map.put("score", null);
                map.put("completed", null);
                for (LinkedHashMap<String, Object> grade : grades) {
                    if (grade != null) {
                        Object accountId2 = grade.get("accountId");
                        Object score = grade.get("score");
                        boolean completed = (boolean) grade.get("completed");
                        if (accountId1 != null && accountId1.equals(accountId2)) {
                            map.put("score", score);
                            map.put("completed", completed);
                        }

                    }
                }
                if (map != null) {
                    gradeList.add(map);
                }
            }
        }
        return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, gradeList);
    }

}
