package com.tlf.creatorconsumer.api.course1;

import com.tlf.creatorconsumer.common.JsonResult;
import com.tlf.creatorconsumer.common.JsonRet;
import com.tlf.creatorconsumer.constants.Constants;
import com.tlf.creatorconsumer.req.BaseReq;
import com.tlf.creatorconsumer.req.SimReq;
import com.tlf.creatorconsumer.req.SimulationResourceReq;
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
public class SimulationResourceAPI1 {

    protected static final Logger logger = LoggerFactory.getLogger(SimulationResourceAPI1.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     * 获取仿真资源类型列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_scene_type_list")
    public ResultResp getCourseDescription(HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        BaseReq req = TokenUtil.getReq(request);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_scene_type_list", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 获取仿真资源列表
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_simulation_resource_list")
    public ResultResp getSimulationResourceList(@RequestBody SimReq req, HttpServletRequest request){
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
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_simulation_resource_list", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 添加场景资源
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/add_simulation_resource")
    public ResultResp addSimulationResource(@RequestBody SimulationResourceReq req, HttpServletRequest request){
        if(req==null||req.getName()==null||req.getTypeId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setCreatorId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "add_simulation_resource", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 克隆仿真资源
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/clone_simulation_resource")
    public ResultResp cloneSimulationResource(@RequestBody SimulationResourceReq req, HttpServletRequest request){
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
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "clone_simulation_resource", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     *  删除仿真资源
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete_simulation_resource")
    public ResultResp deleteSimulationResource(@RequestBody SimulationResourceReq req, HttpServletRequest request){
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
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "delete_simulation_resource", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 修改仿真资源
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/modify_simulation_resource")
    public ResultResp modifySimulationResource(@RequestBody SimulationResourceReq req, HttpServletRequest request){
        if(req==null||req.getJson()==null||req.getId()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "modify_simulation_resource", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 获取实验类型列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/experiment_type_list")
    public ResultResp getExperimentTypes( HttpServletRequest request){
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        BaseReq req = TokenUtil.getReq(request);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "experiment_type_list", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 获取2维/3维资源类型
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_scene_types")
    public ResultResp getSceneTypeList(@RequestBody SimReq req, HttpServletRequest request){
        if(req==null||req.getAlias()==null){
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_scene_types", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if(resp.getCode()==0){
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        }else{
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }
}
