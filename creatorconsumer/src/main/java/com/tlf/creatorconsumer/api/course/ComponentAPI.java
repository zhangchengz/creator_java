package com.tlf.creatorconsumer.api.course;

import com.tlf.creatorconsumer.common.JsonResult;
import com.tlf.creatorconsumer.common.JsonRet;
import com.tlf.creatorconsumer.constants.Constants;
import com.tlf.creatorconsumer.permission.AuthToken;
import com.tlf.creatorconsumer.req.BaseReq;
import com.tlf.creatorconsumer.req.ComponentReq;
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
import java.util.UUID;

@RestController
@RequestMapping("/api/public/course")
public class ComponentAPI {

    protected static final Logger logger = LoggerFactory.getLogger(ComponentAPI.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     * 查询元件组
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_component_group")
    @AuthToken
    public ResultResp getComponentGroup(HttpServletRequest request) {
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        BaseReq req = TokenUtil.getReq(request);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "get_component_group", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 查询元件详情
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_component_by_id")
    @AuthToken
    public ResultResp getComponentById(@RequestBody ComponentReq req, HttpServletRequest request) {
        if (req == null || req.getComponentId() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "get_component_by_id", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 获取所有的元件组和元件
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_group_and_component")
    @AuthToken
    public ResultResp getGroupAndComponent(HttpServletRequest request) {
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        BaseReq req = TokenUtil.getReq(request);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "get_group_and_component", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 根据元件组获取元件
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_component_by_group")
    @AuthToken
    public ResultResp getComponentByGroup(@RequestBody ComponentReq req, HttpServletRequest request) {
        if (req == null || req.getGroupId() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "get_component_by_group", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 修改元件介绍
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/modify_component_introduction")
    @AuthToken(role_name = "teacher")
    public ResultResp modifyComponentIntroduction(@RequestBody ComponentReq req, HttpServletRequest request) {
        if (req == null || req.getComponentId() == null || req.getIntroduction() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "modify_component_introduction", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 修改元件参数
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/modify_component_parameter")
    @AuthToken(role_name = "teacher")
    public ResultResp modifyComponentParameter(@RequestBody ComponentReq req, HttpServletRequest request) {
        if (req == null || req.getComponentId() == null || req.getParameter() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "modify_component_parameter", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 元件重命名
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/rename_component")
    @AuthToken(role_name = "teacher")
    public ResultResp renameComponent(@RequestBody ComponentReq req, HttpServletRequest request) {
        if (req == null || req.getComponentId() == null || req.getName() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "rename_component", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 元件删除
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete_component")
    @AuthToken(role_name = "teacher")
    public ResultResp deleteComponent(@RequestBody ComponentReq req, HttpServletRequest request) {
        if (req == null || req.getComponentId() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "delete_component", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 元件搜索
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/search_component")
    @AuthToken
    public ResultResp searchComponent(@RequestBody ComponentReq req, HttpServletRequest request) {
        if (req == null || req.getName() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "search_component", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 添加元件
     * @param request
     * @return
     */
    @RequestMapping(value = "/add_component")
    @AuthToken(role_name = "teacher")
    public ResultResp addComponent(HttpServletRequest request) {
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile schematic = multipartRequest.getFile("schematic");
        MultipartFile icon = multipartRequest.getFile("icon");
        byte[] schematicBytes = new byte[0];
        byte[] iconBytes = new byte[0];
        try {
            if (schematic != null) {
                schematicBytes = schematic.getBytes();
            }
            if (icon != null) {
                iconBytes = icon.getBytes();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = multipartRequest.getParameter("name");
        String groupId = multipartRequest.getParameter("groupId");
        String introduction = multipartRequest.getParameter("introduction");
        String parameter = multipartRequest.getParameter("parameter");
        String vendor = multipartRequest.getParameter("vendor");
        String id = UUID.randomUUID().toString();
        ComponentReq req = new ComponentReq();
        req.setId(id);
        req.setName(name);
        req.setGroupId(groupId);
        req.setIntroduction(introduction);
        req.setParameter(parameter);
        req.setVendor(vendor);
        req.setIcon(iconBytes);
        req.setSchematic(schematicBytes);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "add_component", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        return new ResultResp(resp.getCode(), resp.getMsg(), resp.getLength(), resp.getObject());
    }

    /**
     * 添加元件组
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/add_component_group")
    @AuthToken(role_name = "teacher")
    public ResultResp addComponentGroup(@RequestBody ComponentReq req, HttpServletRequest request) {
        if (req == null || req.getGroupName() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "add_component_group", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        return new ResultResp(resp.getCode(), resp.getMsg(), resp.getLength(), resp.getObject());
    }

    /**
     * 删除元件组
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete_component_group")
    @AuthToken(role_name = "teacher")
    public ResultResp deleteComponentGroup(@RequestBody ComponentReq req, HttpServletRequest request) {
        if (req == null || req.getGroupId() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "delete_component_group", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        return new ResultResp(resp.getCode(), resp.getMsg(), resp.getLength(), resp.getObject());
    }

    /**
     * 修改元件模型
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/modify_component_model")
    @AuthToken(role_name = "teacher")
    public ResultResp modifyComponentModel(@RequestBody ComponentReq req, HttpServletRequest request) {
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
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE + "modify_component_model", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        return new ResultResp(resp.getCode(), resp.getMsg(), resp.getLength(), resp.getObject());
    }

}
