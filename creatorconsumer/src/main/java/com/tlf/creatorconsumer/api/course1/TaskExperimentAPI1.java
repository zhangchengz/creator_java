package com.tlf.creatorconsumer.api.course1;

import com.tlf.creatorconsumer.common.JsonResult;
import com.tlf.creatorconsumer.common.JsonRet;
import com.tlf.creatorconsumer.constants.Constants;
import com.tlf.creatorconsumer.req.*;
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
import java.util.*;

@RestController
@RequestMapping("/api/public/course1")
public class TaskExperimentAPI1 {

    protected static final Logger logger = LoggerFactory.getLogger(TaskExperimentAPI1.class);

    @Autowired
    RestTemplate restTemplate;

    /**
     * 任务下发
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/add_task_experiment")
    public ResultResp addTaskExperiment(@RequestBody TaskExperimentReq req, HttpServletRequest request) {
        if (req == null || req.getStartTime() == null || req.getFinishTime() == null || req.getTaskTemplateId() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "add_task_experiment", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 老师获取已下发任务
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_task_experiment_by_master")
    public ResultResp getTaskExperimentByMaster(@RequestBody TaskExperimentReq req, HttpServletRequest request) {
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
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_task_experiment_by_master", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 任务停止
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/stop_task_experiment")
    public ResultResp stopTaskExperiment(@RequestBody TaskExperimentReq req, HttpServletRequest request) {
        if (req == null || req.getTaskExperimentId() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "stop_task_experiment", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 删除任务
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/delete_task_experiment")
    public ResultResp deleteTaskExperiment(@RequestBody TaskExperimentReq req, HttpServletRequest request) {
        if (req == null || req.getTaskExperimentId() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "delete_task_experiment", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 学生获取任务列表
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_task_experiment_by_submitter")
    public ResultResp getTaskExperimentByStudent(@RequestBody TaskExperimentReq req, HttpServletRequest request) {
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
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_task_experiment_by_submitter", requestEntity, JsonRet.class);
        ResponseEntity<JsonResult> rp = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "get_all_account", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        JsonResult body = rp.getBody();
        List<LinkedHashMap<String, String>> list = (List<LinkedHashMap<String, String>>) body.getObject();
        Map<String, String> map = new HashMap<>();
        for (LinkedHashMap<String, String> account : list) {
            String id = account.get("id");
            String name = account.get("name");
            map.put(id, name);
        }
        if (resp.getCode() == 0) {
            List<LinkedHashMap<String, String>> object = (List<LinkedHashMap<String, String>>) resp.getObject();
            for (LinkedHashMap<String, String> taskStudent : object) {
                String accountId1 = taskStudent.get("masterId");
                String s1 = map.get(accountId1);
                taskStudent.put("masterName", s1);
            }
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", resp.getLength(), object);
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 获取实验任务详情
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/get_task_experiment_details")
    public ResultResp getTaskDetails(@RequestBody TaskExperimentReq req, HttpServletRequest request) {
        if (req == null || req.getTaskExperimentId() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_task_experiment_details", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 学生其他附件添加仿真资源附件
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/add_simulation_annex")
    public ResultResp addSimulationAnnex(@RequestBody SimAnnexReq req, HttpServletRequest request) {
        if (req == null || req.getTaskExperimentId() == null || req.getName() == null || req.getType() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonRet> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "add_simulation_annex", requestEntity, JsonRet.class);
        logger.info("remote call " + s);
        JsonRet resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 保存实验快照
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/task_experiment_project")
    public ResultResp taskExperimentProject(@RequestBody ProjectReq req, HttpServletRequest request) {
        if (req == null || req.getTaskExperimentId() == null || req.getSceneId() == null || req.getSceneJson() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "task_experiment_project", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 学生完成任务页面上传接口
     *
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/task_upload")
    public ResultResp taskUpload(HttpServletRequest request) throws IOException {
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");
        String type = multipartRequest.getParameter("type");
        String taskExperimentId = multipartRequest.getParameter("taskExperimentId");
        byte[] bytes = file.getBytes();
        TaskUploadReq req = new TaskUploadReq();
        req.setFile(bytes);
        req.setName(file.getOriginalFilename());
        req.setType(type);
        req.setTaskExperimentId(taskExperimentId);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "task_upload", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 学生保存or提交任务
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/save_task_experiment")
    public ResultResp saveTaskExperiment(@RequestBody TaskReq req, HttpServletRequest request) {
        if (req == null || req.getTaskExperimentId() == null || req.getOperating() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "save_task_experiment", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 老师批阅任务列表
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/task_review_list")
    public ResultResp taskReviewList(@RequestBody TaskScoreReq req, HttpServletRequest request) {
        if (req == null || req.getTaskExperimentId() == null || req.getCourseId() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<List> res1 = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "task_review_list", requestEntity, List.class);
        logger.info("remote call " + res1);
        ResponseEntity<List> res2 = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "get_students_by_course", requestEntity, List.class);
        logger.info("remote call " + res2);
        ResponseEntity<List> res3 = restTemplate.postForEntity(Constants.CREATOR_ACCOUNT + "get_class_by_course", requestEntity, List.class);
        logger.info("remote call " + res3);
        List<LinkedHashMap<String, String>> list1 = res1.getBody();
        List<LinkedHashMap<String, String>> list2 = res2.getBody();
        List<LinkedHashMap<String, String>> list3 = res3.getBody();
        List<HashMap<String, Object>> classList = new LinkedList<>();
        for (LinkedHashMap<String, String> cac : list3) {
            String className = cac.get("name");
            String classesId = cac.get("classesId");
            HashMap<String, Object> hashMap = new HashMap<>();
            List<HashMap<String, Object>> studentList = new LinkedList<>();
            for (LinkedHashMap<String, String> sac : list2) {
                String classesId1 = sac.get("classesId");
                String accountId1 = sac.get("id");
                String studentName = sac.get("name");
                HashMap<String, Object> hashMap1 = new HashMap<>();
                for (LinkedHashMap<String, String> aac : list1) {
                    String studentId = aac.get("accountId");
                    String statu = aac.get("statu");
                    if (classesId.equals(classesId1) && classesId.equals(classesId1) && accountId1.equals(studentId)) {
                        hashMap.put("classId", classesId);
                        hashMap.put("className", className);
                        hashMap1.put("studentId", studentId);
                        hashMap1.put("studentName", studentName);
                        hashMap1.put("statu", statu);
                    }
                }
                if (hashMap1.size() != 0) {
                    studentList.add(hashMap1);
                }
            }
            if (studentList.size() != 0) {
                hashMap.put("students", studentList);
            }
            if (hashMap.size() != 0) {
                classList.add(hashMap);
            }
        }
        return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, classList);
    }

    /**
     * 老师批阅任务详情
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/task_review_details")
    public ResultResp taskReviewDetails(@RequestBody TaskScoreReq req, HttpServletRequest request) {
        if (req == null || req.getTaskExperimentId() == null || req.getStudentId() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String role = JWTUtil.getRole(token);
        req.setAccountId(req.getStudentId());
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_task_experiment_details", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 打分，写评语
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/task_review_score")
    public ResultResp taskReviewScore(@RequestBody TaskScoreReq req, HttpServletRequest request) {
        if (req == null || req.getTaskExperimentId() == null || req.getStudentId() == null) {
            return new ResultResp(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "task_review_score", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    @RequestMapping(value = "/get_product_name")
    public ResultResp getProductName(@RequestBody ProjectNameReq req, HttpServletRequest request) {
        if (req == null || StringUtils.isBlank(req.getId())) {
            return new ResultResp(Constants.CODE_FAIL, "id 不能为空", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "get_product_name", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }

    /**
     * 学生任务完成（重庆）
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "/task_completed")
    public ResultResp taskCompleted(@RequestBody TaskExperimentReq req, HttpServletRequest request) {
        if (req == null || StringUtils.isBlank(req.getTaskExperimentId())) {
            return new ResultResp(Constants.CODE_FAIL, "id 不能为空", null, null);
        }
        HttpHeaders requestHeaders = TokenUtil.getRequestHeaders(request);
        String token = request.getHeader("Cube-Token");
        String accountId = JWTUtil.getAccountId(token);
        String role = JWTUtil.getRole(token);
        req.setAccountId(accountId);
        req.setRole(role);
        HttpEntity<Object> requestEntity = new HttpEntity<>(req, requestHeaders);
        ResponseEntity<JsonResult> s = restTemplate.postForEntity(Constants.CREATOR_COURSE1 + "task_completed", requestEntity, JsonResult.class);
        logger.info("remote call " + s);
        JsonResult resp = s.getBody();
        if (resp.getCode() == 0) {
            return new ResultResp(Constants.CODE_SUCCESS, "SUCCESS", null, resp.getObject());
        } else {
            return new ResultResp(Constants.CODE_FAIL, resp.getMsg(), null, null);
        }
    }
}
