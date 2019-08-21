package com.tlf.creatorconsumer.api.course1;

import com.tlf.creatorconsumer.common.JsonResult;
import com.tlf.creatorconsumer.constants.Constants;
import com.tlf.creatorconsumer.req.BaseReq;
import com.tlf.creatorconsumer.req.ComponentReq;
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
@RequestMapping("/api/public/course1")
public class ComponentAPI1 {

    protected static final Logger logger = LoggerFactory.getLogger(ComponentAPI1.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     * 查询元件组
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_component_group")
    public ResultResp getComponentGroup(HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        BaseReq req = TokenUtil.getReq(request);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_component_group", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 查询元件详情
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_component_by_id")
    public ResultResp getComponentById(@RequestBody ComponentReq req, HttpServletRequest request){
        if(req==null||req.getComponentId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_component_by_id", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 获取所有的元件组和元件
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_group_and_component")
    public ResultResp getGroupAndComponent(HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        BaseReq req = TokenUtil.getReq(request);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_group_and_component", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 根据元件组获取元件
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_component_by_group")
    public ResultResp getComponentByGroup(@RequestBody ComponentReq req, HttpServletRequest request){
        if(req==null||req.getGroupId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_component_by_group", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 修改元件介绍
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/modify_component_introduction")
    public ResultResp modifyComponentIntroduction(@RequestBody ComponentReq req, HttpServletRequest request){
        if(req==null||req.getComponentId()==null||req.getIntroduction()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "modify_component_introduction", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 修改元件参数
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/modify_component_parameter")
    public ResultResp modifyComponentParameter(@RequestBody ComponentReq req, HttpServletRequest request){
        if(req==null||req.getComponentId()==null||req.getParameter()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "modify_component_parameter", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 元件重命名
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/rename_component")
    public ResultResp renameComponent(@RequestBody ComponentReq req, HttpServletRequest request){
        if(req==null||req.getComponentId()==null||req.getName()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "rename_component", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 元件删除
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete_component")
    public ResultResp deleteComponent(@RequestBody ComponentReq req, HttpServletRequest request){
        if(req==null||req.getComponentId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "delete_component", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 元件搜索
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/search_component")
    public ResultResp searchComponent(@RequestBody ComponentReq req, HttpServletRequest request){
        if(req==null||req.getName()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "search_component", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }
}
