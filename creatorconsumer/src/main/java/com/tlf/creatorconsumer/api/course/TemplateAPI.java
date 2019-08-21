package com.tlf.creatorconsumer.api.course;

import com.tlf.creatorconsumer.common.JsonRet;
import com.tlf.creatorconsumer.constants.Constants;
import com.tlf.creatorconsumer.permission.AuthToken;
import com.tlf.creatorconsumer.req.PageReq;
import com.tlf.creatorconsumer.req.SimReq;
import com.tlf.creatorconsumer.req.TempReq;
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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/public/course")
public class TemplateAPI {

    protected static final Logger logger = LoggerFactory.getLogger(TemplateAPI.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取实验模板列表
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_template_list")
    @AuthToken
    public ResultResp getTemplateList(@RequestBody SimReq req, HttpServletRequest request) {
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
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "get_template_list", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 获取模板详情
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_template")
    @AuthToken
    public ResultResp getTemplateById(@RequestBody TempReq req, HttpServletRequest request) {
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
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "get_template", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    @RequestMapping(value = "/check_template_name")
    @AuthToken
    public ResultResp checkTemplateName(@RequestBody TempReq req, HttpServletRequest request) {
        if (req == null || StringUtils.isBlank(req.getName())) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "check_template_name", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        return new ResultResp(resp.getCode(), resp.getMsg(), resp.getLength(), resp.getObject());
    }

    /**
     * 新增实验模板
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/add_template")
    @AuthToken(role_name = "teacher")
    public ResultResp addTemplateById(@RequestBody TempReq req, HttpServletRequest request) {
        if (req == null || req.getName() == null || req.getName() == "") {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "add_template", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 删除模板
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete_template")
    @AuthToken(role_name = "teacher")
    public ResultResp deleteTemplateById(@RequestBody TempReq req, HttpServletRequest request) {
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
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "delete_template", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 克隆模板
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/clone_template")
    @AuthToken(role_name = "teacher")
    public ResultResp cloneTemplate(@RequestBody TempReq req, HttpServletRequest request) {
        if (req == null || req.getId() == null || req.getName() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "clone_template", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 教学主管获取模板列表
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_template_supervisor")
    @AuthToken(role_name = "teacher")
    public ResultResp getTemplateSupervisor(@RequestBody PageReq req, HttpServletRequest request) {
        if (req == null || req.getOffset() == null || req.getLimit() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "get_template_supervisor", requestEntity, JsonRet.class);
        ResponseEntity<JsonRet> s1 = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "get_teacher_list", requestEntity, JsonRet.class);
        JsonRet body = s.getBody();
        List<LinkedHashMap<String, Object>> list = (List<LinkedHashMap<String, Object>>) body.getObject();
        List<LinkedHashMap<String, String>> list1 = (List<LinkedHashMap<String, String>>) s1.getBody().getObject();
        List<LinkedHashMap<String, Object>> tempList = new LinkedList<>();
        for (LinkedHashMap<String, Object> temp : list) {
            if (temp != null) {
                LinkedHashMap<String, Object> template = new LinkedHashMap<>();
                Object id = temp.get("id");
                template.put("id", id);
                Object innerr = temp.get("innerr");
                template.put("innerr", innerr);
                Object name = temp.get("name");
                template.put("name", name);
                Object creatorId = temp.get("creatorId");
                template.put("creatorId", creatorId);
                template.put("creatorName", null);
                for (LinkedHashMap<String, String> teacher : list1) {
                    if (teacher != null) {
                        String id1 = teacher.get("id");
                        String name1 = teacher.get("name");
                        if (id1 != null && id1.equals(creatorId)) {
                            template.put("creatorName", name1);
                        }
                    }
                }
                tempList.add(template);
            }
        }
        return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", body.getLength(), tempList);
    }

    @RequestMapping(value = "/update_template_inner")
    @AuthToken(role_name = "teacher")
    public ResultResp modifyTemplateInner(@RequestBody TempReq req, HttpServletRequest request) {
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
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "update_template_inner", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        return new ResultResp(resp.getCode(), resp.getMsg(), resp.getLength(), resp.getObject());
    }

}
