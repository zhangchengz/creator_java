package com.tlf.creatorcourse.controller.experiment;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.tlf.creatorcourse.common.JsonResult;
import com.tlf.creatorcourse.common.JsonRet;
import com.tlf.creatorcourse.config.UploadPathBean;
import com.tlf.creatorcourse.constants.Constants;
import com.tlf.creatorcourse.entity.resource.Resource;
import com.tlf.creatorcourse.entity.simulation.ExperimentTypes;
import com.tlf.creatorcourse.entity.simulation.SceneType;
import com.tlf.creatorcourse.entity.taskexperiment.*;
import com.tlf.creatorcourse.entity.template.AnnexTemplate;
import com.tlf.creatorcourse.entity.template.ExperimentTemplates;
import com.tlf.creatorcourse.entity.template.SimTemplate;
import com.tlf.creatorcourse.exception.OperatingException;
import com.tlf.creatorcourse.po.*;
import com.tlf.creatorcourse.req.*;

import com.tlf.creatorcourse.service.simulationresource.ISceneTypeService;
import com.tlf.creatorcourse.service.taskexperiment.*;
import com.tlf.creatorcourse.service.tempalte.ITaskExperimentTemplateService;
import com.tlf.creatorcourse.utils.AccountUtil;
import com.tlf.creatorcourse.utils.FileUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.*;

@RestController
@RequestMapping
@CrossOrigin
public class TaskExperimentController {

    @Autowired
    private UploadPathBean uploadPathBean;

    @Autowired
    private ITaskExperimentService taskExperimentService;

    @Autowired
    private ITaskExperimentTemplateService templateService;

    @Autowired
    private ITaskScoreService scoreService;

    @Autowired
    private ITaskExperimentAnnexService annexService;

    @Autowired
    private ITaskExperimentProjectService projectService;

    @Autowired
    private ITaskExperimentReportService reportService;

    @Autowired
    private IAccountExperimentService accountExperimentService;

    @Autowired
    private ISceneTypeService sceneTypeService;

    @Autowired
    private IExperimentTypeService experimentTypeService;

    @Autowired
    private FileUtil fileUtil;


    /**
     * 下发任务
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "add_task_experiment", method = RequestMethod.POST)
    public JsonResult addTaskExperiment(@RequestBody TaskExperimentReq req) {
        ExperimentTemplates experimentTemplates = templateService.selectById(req.getTaskTemplateId());
        if (experimentTemplates == null) {
            return new JsonResult(Constants.CODE_FAIL, "模板不存在", null);
        }
        experimentTemplates.setCreatorId(null);
        String templateId = UUID.randomUUID().toString();
        experimentTemplates.setId(templateId);
        experimentTemplates.setInnerr(false);
        if (experimentTemplates.getReportId() != null && experimentTemplates.getReportStem() != null) {
            Resource resource = null;
            try {
                resource = fileUtil.copyFile(experimentTemplates.getReportId(), experimentTemplates.getReportStem());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (resource != null) {
                experimentTemplates.setReportId(resource.getId());
            }
        }
        if (experimentTemplates.getGuideId() != null && experimentTemplates.getGuideStem() != null) {
            Resource resource = null;
            try {
                resource = fileUtil.copyFile(experimentTemplates.getGuideId(), experimentTemplates.getGuideStem());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (resource != null) {
                experimentTemplates.setGuideId(resource.getId());
            }
        }
        List<AnnexTemplate> annexTemplates = templateService.selectAnnexByTemplateId(req.getTaskTemplateId());
        List<AnnexTemplate> list = new ArrayList<>();
        for (AnnexTemplate annexTemplate : annexTemplates) {
            if (annexTemplate != null) {
                Resource resource = null;
                try {
                    resource = fileUtil.copyFile(annexTemplate.getId(), annexTemplate.getStem());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (resource != null) {
                    AnnexTemplate annexTemplate1 = new AnnexTemplate();
                    annexTemplate1.setId(resource.getId());
                    annexTemplate1.setName(resource.getName());
                    annexTemplate1.setPath(resource.getPath());
                    annexTemplate1.setCreatorId(req.getAccountId());
                    annexTemplate1.setTemplateId(templateId);
                    annexTemplate1.setTypeId(annexTemplate.getTypeId());
                    annexTemplate1.setExpTypeId(annexTemplate.getExpTypeId());
                    list.add(annexTemplate1);
                }
            }
        }
        List<SimTemplate> simTemplates = templateService.selectSimByTemplateId(req.getTaskTemplateId());
        List<SimTemplate> list1 = new ArrayList<>();
        for (SimTemplate simTemplate : simTemplates) {
            if (simTemplate != null) {
                Resource resource = null;
                try {
                    resource = fileUtil.copyFile(simTemplate.getId(), simTemplate.getStem());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (resource != null) {
                    SimTemplate simTemplate1 = new SimTemplate();
                    simTemplate1.setId(resource.getId());
                    simTemplate1.setName(resource.getName());
                    simTemplate1.setPath(resource.getPath());
                    simTemplate1.setCreatorId(req.getAccountId());
                    simTemplate1.setTemplateId(templateId);
                    simTemplate1.setTypeId(simTemplate.getTypeId());
                    simTemplate1.setExpTypeId(simTemplate.getExpTypeId());
                    list1.add(simTemplate1);
                }
            }
        }
        TemplateReq templateReq = new TemplateReq(experimentTemplates, list1, list);
        templateService.insert(templateReq);
        String startTime1 = req.getStartTime();
        Timestamp startTime = Timestamp.valueOf(startTime1);
        //     String taskTemplateId = req.getTaskTemplateId();
        String remark = req.getRemark();
        String finishTime1 = req.getFinishTime();
        Timestamp finishTime = Timestamp.valueOf(finishTime1);
        String masterId = req.getAccountId();
        List<String> accountIds = req.getAccountIds();
        TaskExperiments taskExperiment = new TaskExperiments();
        String id = UUID.randomUUID().toString();
        taskExperiment.setId(id);
        taskExperiment.setTemplateId(templateId);
        taskExperiment.setInnerr(false);
        taskExperiment.setMasterId(masterId);
        taskExperiment.setStartTime(startTime);
        taskExperiment.setFinishTime(finishTime);
        taskExperiment.setTotal(accountIds.size());
        taskExperiment.setRemark(remark);
        taskExperiment.setComplete(0);
        taskExperiment.setCompleted(false);
        List<AccountAndTaskExperiments> list2 = new ArrayList<>();
        List<TaskScore> list3 = new ArrayList<>();
        for (String accountId : accountIds) {
            if (accountId != null) {
                AccountAndTaskExperiments accountAndTaskExperiment = new AccountAndTaskExperiments();
                accountAndTaskExperiment.setId(UUID.randomUUID().toString());
                accountAndTaskExperiment.setTaskExperimentId(id);
                accountAndTaskExperiment.setAccountId(accountId);
                accountAndTaskExperiment.setStatu("new");
                list2.add(accountAndTaskExperiment);
                TaskScore taskScore = new TaskScore();
                taskScore.setId(UUID.randomUUID().toString());
                taskScore.setTaskExperimentId(id);
                taskScore.setAccountId(accountId);
                taskScore.setCompleted(false);
                list3.add(taskScore);
            }
        }
        boolean add = taskExperimentService.addTaskExperiments(taskExperiment, list2,list3);
        if (add) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
        } else {
            return new JsonResult(Constants.CODE_FAIL, "FAIL", null);
        }
    }

    /**
     * 老师查看已下发的任务
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "get_task_experiment_by_master", method = RequestMethod.POST)
    public JsonRet getTaskExperimentByMaster(@RequestBody TaskExperimentReq req) {
        String masterId = req.getAccountId();
        Integer limit = req.getLimit();
        Integer offset = req.getOffset();
        Boolean completed = req.getCompleted();
        List<TaskMasterPO> taskMasterPOS = taskExperimentService.selectTaskExperimentsByMasterId(completed, masterId, offset, limit);
        Integer length = taskExperimentService.selectCountByMaster(completed, masterId);
        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", length, taskMasterPOS);
    }

    /**
     * 停止任务
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "stop_task_experiment", method = RequestMethod.POST)
    public JsonResult stopTaskExperiment(@RequestBody TaskExperimentReq req) {
        String taskExperimentId = req.getTaskExperimentId();
        boolean stop = taskExperimentService.stopTaskExperiments(taskExperimentId);
        if (stop) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
        } else {
            return new JsonResult(Constants.CODE_FAIL, "FAIL", null);
        }
    }

    /**
     * 删除任务
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "delete_task_experiment", method = RequestMethod.POST)
    public JsonResult deleteTaskExperiment(@RequestBody TaskExperimentReq req) {
        String taskExperimentId = req.getTaskExperimentId();
        boolean delete = taskExperimentService.deleteTaskExperiments(taskExperimentId);
        if (delete) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
        } else {
            return new JsonResult(Constants.CODE_FAIL, "FAIL", null);
        }
    }

    /**
     * 获取任务详情
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "get_task_experiment_details", method = RequestMethod.POST)
    public JsonResult getTaskDetails(@RequestBody TaskExperimentReq req) {
        TaskExperimentPO taskExperimentPO = taskExperimentService.selectExperimentDetails(req.getTaskExperimentId(), req.getAccountId());
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", taskExperimentPO);
    }

    /**
     * 学生获取任务列表
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "get_task_experiment_by_submitter", method = RequestMethod.POST)
    public JsonRet queryTaskExperiment(@RequestBody TaskExperimentReq req) {
        String accountId = req.getAccountId();
        Integer offset = req.getOffset();
        Integer limit = req.getLimit();
        List<TaskStudentPO> taskStudentPOS = taskExperimentService.selectByStudent(accountId, offset, limit);
        Integer length = taskExperimentService.selectCountByStudent(accountId);
        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", length, taskStudentPOS);
    }

    /**
     * 学生其他附件添加仿真资源附件
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "add_simulation_annex", method = RequestMethod.POST)
    public JsonRet addSimulationAnnex(@RequestBody SimAnnexReq req) {
        AccountAndTaskExperiments accountAndTaskExperiments = accountExperimentService.selectByAccountAndTaskExperiment(req.getAccountId(), req.getTaskExperimentId());
        if (accountAndTaskExperiments != null) {
            if ("submit".equals(accountAndTaskExperiments.getStatu())) {
                return new JsonRet(Constants.CODE_FAIL, "该任务已经提交，无法继续操作", null, null);
            }
        }
        ExperimentAnnex experimentAnnex = new ExperimentAnnex();
        String id = UUID.randomUUID().toString();
        experimentAnnex.setId(id);
        experimentAnnex.setTaskExperimentId(req.getTaskExperimentId());
        experimentAnnex.setAccountId(req.getAccountId());
        experimentAnnex.setName(req.getName());
        experimentAnnex.setType(req.getType());
        experimentAnnex.setExpType(req.getExpType());
        String simName;
        if (StringUtils.isBlank(req.getExpType())) {
            simName = id + ".cc2d";
        } else {
            simName = id + ".cc3d";
        }
        String path = "simulation_resource/" + simName;
        experimentAnnex.setPath(path);
        AnnexPO annexPO = new AnnexPO();
        annexPO.setId(id);
        annexPO.setName(req.getName());
        annexPO.setTypeId(req.getType());
        annexPO.setPath(Constants.RESOURCE_PATH + path);
        SceneType sceneType = sceneTypeService.selectByPrimaryKey(req.getType());
        if (sceneType != null) {
            annexPO.setSimType(sceneType.getAlias());
            annexPO.setTypeName(sceneType.getName());
        }
        ExperimentTypes experimentTypes = experimentTypeService.selectByPrimaryKey(req.getExpType());
        if (experimentTypes != null) {
            annexPO.setExpType(experimentTypes.getName());
        }
        File file = new File(uploadPathBean.getUploadPath() + "/" + "simulation_resource");
        if (!file.exists()) {
            file.mkdirs();
        }
        Path simPath = Paths.get(file.getAbsolutePath() + "/" + simName);
        try {
            simPath.toFile().createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonRet(Constants.CODE_FAIL, "创建失败，请重试！", null, null);
        }
        boolean insert = annexService.addSimulationAnnex(experimentAnnex);
        if (!insert) {
            return new JsonRet(Constants.CODE_FAIL, "创建失败，请重试！", null, null);
        }
        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", null, annexPO);
    }

    /**
     * 保存实验快照
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "task_experiment_project", method = RequestMethod.POST)
    public JsonResult taskExperimentProject(@RequestBody ProjectReq req) {
        AccountAndTaskExperiments accountAndTaskExperiments = accountExperimentService.selectByAccountAndTaskExperiment(req.getAccountId(), req.getTaskExperimentId());
        if (accountAndTaskExperiments != null) {
            if ("submit".equals(accountAndTaskExperiments.getStatu())) {
                return new JsonResult(Constants.CODE_FAIL, "该任务已经提交，无法继续操作", null);
            }
        }
        byte[] sceneBytes = req.getSceneJson().getBytes();
        byte[] simBytes = req.getSimJson().getBytes();
        File path = new File(uploadPathBean.getUploadPath());
        ExperimentProject experimentProject = projectService.selectExperimentProjectById(req.getSceneId());
        if (experimentProject != null) {
            String simPath = experimentProject.getSimPath();
            File simPath1 = new File(path.getAbsolutePath(), simPath);
            String scenePath = experimentProject.getScenePath();
            File scenePath1 = new File(path.getAbsolutePath(), scenePath);
            try {
                Files.write(simPath1.toPath(), simBytes);
                Files.write(scenePath1.toPath(), sceneBytes);
                projectService.updateProjectTime(experimentProject.getId());
            } catch (IOException e) {
                e.printStackTrace();
                return new JsonResult(Constants.CODE_FAIL, "保存失败", null);
            }
        } else {
            ExperimentProject experimentProject1 = projectService.selectExperimentProjectBySimId(req.getTaskExperimentId(), req.getAccountId(), req.getSceneId());
            if (experimentProject1 == null) {
                String projectId = UUID.randomUUID().toString();
                String id = UUID.randomUUID().toString();
                File simPath = new File(path.getAbsolutePath(), "sim/" + id + ".sim");
                File scenePath = new File(path.getAbsolutePath(), "scene/" + projectId + ".cc3d");
                try {
                    Files.write(simPath.toPath(), simBytes);
                    Files.write(scenePath.toPath(), sceneBytes);
                } catch (IOException e) {
                    e.printStackTrace();
                    return new JsonResult(Constants.CODE_FAIL, "保存失败", null);
                }
                ExperimentProject project = new ExperimentProject();
                project.setId(projectId);
                project.setTaskExperimentId(req.getTaskExperimentId());
                project.setSubmitterId(req.getAccountId());
                project.setSimId(req.getSceneId());
                project.setScenePath("scene/" + projectId + ".cc3d");
                project.setSimPath("sim/" + id + ".sim");
                boolean insert = projectService.insertExperimentProject(project);
                if (insert) {
                    return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
                } else {
                    return new JsonResult(Constants.CODE_FAIL, "保存失败", null);
                }
            } else {
                String simPath = experimentProject1.getSimPath();
                File simPath1 = new File(path.getAbsolutePath(), simPath);
                String scenePath = experimentProject1.getScenePath();
                File scenePath1 = new File(path.getAbsolutePath(), scenePath);
                try {
                    Files.write(simPath1.toPath(), simBytes);
                    Files.write(scenePath1.toPath(), sceneBytes);
                    projectService.updateProjectTime(experimentProject1.getId());
                } catch (IOException e) {
                    e.printStackTrace();
                    return new JsonResult(Constants.CODE_FAIL, "保存失败", null);
                }
            }
        }
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 学生完成任务页面上传接口
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "task_upload", method = RequestMethod.POST)
    public JsonResult taskUpload(@RequestBody TaskUploadReq req) {
        String name = req.getName();
        byte[] file = req.getFile();
        String type = req.getType();
        String id = UUID.randomUUID().toString();
        File path = new File(uploadPathBean.getUploadPath());
        String suffix = name.substring(name.lastIndexOf("."));
        File simPath = new File(path.getAbsolutePath(), type + "/" + id + suffix);
        try {
            Files.write(simPath.toPath(), file);
            if (type.equals("report")) {
                ExperimentReport experimentReport = reportService.selectByExperimentAndAccountId(req.getTaskExperimentId(), req.getAccountId());
                if (experimentReport != null) {
                    reportService.deleteReport(req.getAccountId(), req.getTaskExperimentId());
                }
                ExperimentReport report = new ExperimentReport();
                report.setId(id);
                report.setAccountId(req.getAccountId());
                report.setTaskExperimentId(req.getTaskExperimentId());
                report.setName(name);
                report.setPath(type + "/" + id + suffix);
                boolean insert = reportService.insertExperimentReport(report);
                if (!insert) {
                    return new JsonResult(Constants.CODE_FAIL, "上传失败", null);
                }
            } else if (type.equals("annex")) {
                ExperimentAnnex annex = new ExperimentAnnex();
                annex.setId(id);
                annex.setAccountId(req.getAccountId());
                annex.setTaskExperimentId(req.getTaskExperimentId());
                annex.setName(name);
                annex.setPath(type + "/" + id + suffix);
                annex.setType(name.substring(name.lastIndexOf(".") + 1));
                boolean insert = annexService.addSimulationAnnex(annex);
                if (!insert) {
                    return new JsonResult(Constants.CODE_FAIL, "上传失败", null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult(Constants.CODE_FAIL, "上传失败", null);
        }
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", id);
    }

    /**
     * 学生保存or提交
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "save_task_experiment", method = RequestMethod.POST)
    public JsonResult saveTaskExperiment(@RequestBody TaskReq req) {
        AccountAndTaskExperiments accountAndTaskExperiments = accountExperimentService.selectByAccountAndTaskExperiment(req.getAccountId(), req.getTaskExperimentId());
        if (accountAndTaskExperiments != null) {
            if ("submit".equals(accountAndTaskExperiments.getStatu())) {
                return new JsonResult(Constants.CODE_FAIL, "已提交，请勿重复操作", null);
            }
        }
        String reportId = req.getReportId();
        List<String> otherAnnexs1 = req.getOtherAnnexs();
        if (StringUtils.isBlank(reportId)) {
            reportService.deleteReport(req.getAccountId(), req.getTaskExperimentId());
        }
        List<ExperimentAnnex> experimentAnnexes = annexService.selectList(req.getTaskExperimentId(), req.getAccountId());
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for (ExperimentAnnex experimentAnnex : experimentAnnexes) {
            if (experimentAnnex != null) {
                list1.add(experimentAnnex.getId());
                list2.add(experimentAnnex.getId());
            }
        }
        list1.removeAll(otherAnnexs1);
        for (String id : list1) {
            annexService.deleteById(id);
        }
        if (req.getOperating().equals("save")) {
            accountExperimentService.updateStatu(req.getOperating(), req.getAccountId(), req.getTaskExperimentId());
        }
        if (req.getOperating().equals("submit")) {
            accountExperimentService.updateStatu(req.getOperating(), req.getAccountId(), req.getTaskExperimentId());
            taskExperimentService.updateComplete(req.getTaskExperimentId());
        }
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 老师批阅列表
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "task_review_list", method = RequestMethod.POST)
    public List<AccountAndTaskExperiments> taskReviewList(@RequestBody TaskScoreReq req) {
        List<AccountAndTaskExperiments> accountAndTaskExperiments = accountExperimentService.selectAccountByTask(req.getTaskExperimentId());
        return accountAndTaskExperiments;
    }

    /**
     * 打分，写评语
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "task_review_score", method = RequestMethod.POST)
    public JsonResult taskReviewScore(@RequestBody TaskScoreReq req) {
        TaskScore taskScore = new TaskScore();
        String id = UUID.randomUUID().toString();
        taskScore.setId(id);
        taskScore.setAccountId(req.getStudentId());
        taskScore.setComment(req.getComment());
        taskScore.setScore(req.getScore());
        taskScore.setTaskExperimentId(req.getTaskExperimentId());
        TaskScore taskScore1 = scoreService.selectByAccountAndTask(req.getStudentId(), req.getTaskExperimentId());

        if (taskScore1 == null) {
            boolean insert = scoreService.insert(taskScore);
            accountExperimentService.updateStatu("approved", req.getStudentId(), req.getTaskExperimentId());
            if (insert) {
                return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
            } else {
                return new JsonResult(Constants.CODE_FAIL, "FAILED", null);
            }
        } else {
            boolean update = scoreService.updateByAccountAndTask(taskScore);
            accountExperimentService.updateStatu("approved", req.getStudentId(), req.getTaskExperimentId());
            if (update) {
                return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
            } else {
                return new JsonResult(Constants.CODE_FAIL, "FAILED", null);
            }
        }
    }

    /**
     * 获取ProductName
     * @param req
     * @return
     */
    @PostMapping(value = "get_product_name")
    public JsonResult getProductName(@RequestBody ProjectNameReq req) {
        String id = req.getId();
        SimTemplate simTemplate = templateService.selectSimById(id);
        Map<String, String> map1 = new HashMap<>();
        if (simTemplate != null) {
            String path = Constants.RESOURCE_PATH + simTemplate.getPath();
            String result = "";
            BufferedReader in = null;
            try {
                URL realUrl = new URL(path);
                // 打开和URL之间的连接
                URLConnection connection = realUrl.openConnection();
                // 建立实际的连接
                connection.connect();
                // 获取所有响应头字段
                Map<String, List<String>> map = connection.getHeaderFields();
                // 定义 BufferedReader输入流来读取URL的响应
                in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
            } catch (Exception e) {
                System.out.println("发送GET请求出现异常！" + e);
                e.printStackTrace();
            }
            // 使用finally块来关闭输入流
            finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            //得到的json数据
            System.out.println(result);
            JSONObject jsonObject = JSONUtil.parseObj(result);
            Object projectName = jsonObject.get("ProductName");
            if (projectName != null) {
                String productName = projectName.toString();
                map1.put("productName", productName);
            }
        }
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", map1);
    }

    /**
     * 学生任务完成（重庆）
     * @param req
     * @return
     */
    @PostMapping(value = "task_completed")
    public JsonResult taskCompleted(@RequestBody TaskExperimentReq req){
        boolean b = scoreService.completedTask(req.getAccountId(), req.getTaskExperimentId());
        if(b){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null);
        }
        return new JsonResult(Constants.CODE_FAIL,"FAIL",null);
    }

    @PostMapping(value = "get_grade")
    public List<TaskScore> getGrade(@RequestBody GradeReq req){
        List<TaskScore> taskScores = scoreService.selectByTask(req.getTaskExperimentId());
        return taskScores;
    }

}
