package com.tlf.creatorconsumer.api.course1;

import com.tlf.creatorconsumer.common.JsonRet;
import com.tlf.creatorconsumer.constants.Constants;
import com.tlf.creatorconsumer.req.SimReq;
import com.tlf.creatorconsumer.req.TempReq;
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
public class TemplateAPI1 {

    protected static final Logger logger = LoggerFactory.getLogger(TemplateAPI1.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取实验模板列表
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_template_list")
    public ResultResp getTemplateList(@RequestBody SimReq req, HttpServletRequest request){
        if(req==null||req.getLimit()==null||req.getOffset()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_template_list", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 获取模板详情
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_template")
    public ResultResp getTemplateById(@RequestBody TempReq req, HttpServletRequest request){
        if(req==null||req.getId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_template", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 新增实验模板
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/add_template")
    public ResultResp addTemplateById(@RequestBody TempReq req, HttpServletRequest request){
        if(req==null||req.getName()==null||req.getName()==""){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "add_template", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 删除模板
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete_template")
    public ResultResp deleteTemplateById(@RequestBody TempReq req, HttpServletRequest request){
        if(req==null||req.getId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "delete_template", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 克隆模板
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/clone_template")
    public ResultResp cloneTemplate(@RequestBody TempReq req, HttpServletRequest request){
        if(req==null||req.getId()==null||req.getName()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "clone_template", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }


}
