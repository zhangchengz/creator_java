package com.tlf.creatorcourse.service.taskexperiment.impl;

import com.tlf.creatorcourse.constants.Constants;
import com.tlf.creatorcourse.dao.componentlibrary.ComponentMapper;
import com.tlf.creatorcourse.dao.resource.ResourceMapper;
import com.tlf.creatorcourse.dao.simulationresource.SceneTypeMapper;
import com.tlf.creatorcourse.dao.taskexperiment.*;
import com.tlf.creatorcourse.dao.template.AnnexTemplateMapper;
import com.tlf.creatorcourse.dao.template.ExperimentTemplatesMapper;
import com.tlf.creatorcourse.dao.template.SimTemplateMapper;
import com.tlf.creatorcourse.entity.component.Component;
import com.tlf.creatorcourse.entity.resource.Resources;
import com.tlf.creatorcourse.entity.simulation.ExperimentTypes;
import com.tlf.creatorcourse.entity.simulation.SceneType;
import com.tlf.creatorcourse.entity.taskexperiment.*;
import com.tlf.creatorcourse.entity.template.AnnexTemplate;
import com.tlf.creatorcourse.entity.template.ExperimentTemplates;
import com.tlf.creatorcourse.entity.template.SimTemplate;
import com.tlf.creatorcourse.po.*;
import com.tlf.creatorcourse.service.taskexperiment.ITaskExperimentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskExperimentServiceImpl implements ITaskExperimentService {

    private static final Logger log = LoggerFactory.getLogger(TaskExperimentServiceImpl.class);

    @Autowired
    private TaskExperimentsMapper taskExperimentsMapper;

    @Autowired
    private AccountAndTaskExperimentsMapper accountAndTaskExperimentsMapper;

    @Autowired
    private ExperimentTemplatesMapper templateMapper;

    @Autowired
    private AnnexTemplateMapper annexTemplateMapper;

    @Autowired
    private SimTemplateMapper simTemplateMapper;

    @Autowired
    private ExperimentAnnexMapper experimentAnnexMapper;

    @Autowired
    private ComponentMapper componentMapper;

    @Autowired
    private SceneTypeMapper sceneTypeMapper;

    @Autowired
    private TaskScoreMapper scoreMapper;

    @Autowired
    private ExperimentTypeMapper experimentTypeMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private ExperimentProjectMapper projectMapper;

    @Autowired
    private ExperimentReportMapper reportMapper;

    @Override
    public List<TaskMasterPO> selectTaskExperimentsByMasterId(Boolean completed, String masterId, Integer offset, Integer limit) {
        List<TaskMasterPO> taskMasterPOS = taskExperimentsMapper.selectByMaster(completed, masterId, offset, limit);
        return taskMasterPOS;
    }

    @Override
    public Integer selectCountByMaster(Boolean completed, String masterId) {
        return taskExperimentsMapper.selectCountByMaster(completed, masterId);
    }

    @Override
    public TaskExperiments selectTaskExperimentsById(String id) {
        return taskExperimentsMapper.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addTaskExperiments(TaskExperiments taskExperiment, List<AccountAndTaskExperiments> list, List<TaskScore> TaskScore) {
        int insert = taskExperimentsMapper.insert(taskExperiment);
        if (insert == 0) {
            return false;
        }
        for (AccountAndTaskExperiments accountAndTaskExperiment : list) {
            if (accountAndTaskExperiment != null) {
                int insert1 = accountAndTaskExperimentsMapper.insert(accountAndTaskExperiment);
                if (insert1 == 0) {
                    return false;
                }
            }
        }
        for (TaskScore taskScore : TaskScore) {
            if (taskScore != null) {
                scoreMapper.insert(taskScore);
            }
        }
        return true;
    }


    @Override
    public boolean stopTaskExperiments(String id) {
        Integer integer = taskExperimentsMapper.stopTaskExperiment(id);
        accountAndTaskExperimentsMapper.updateStatuStop(id);
        if (integer > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTaskExperiments(String id) {
        Integer integer = taskExperimentsMapper.deleteTaskExperiment(id);
        if (integer > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateComplete(String id) {
        int i = taskExperimentsMapper.updateComplete(id);
        if (i > 0) {
            return true;
        }
        return false;
    }



    @Override
    public List<TaskStudentPO> selectByStudent(String accountId, Integer offset, Integer limit) {
        List<TaskStudentPO> taskStudentPOS = taskExperimentsMapper.selectByStudent(accountId, offset, limit);
        return taskStudentPOS;
    }

    @Override
    public Integer selectCountByStudent(String accountId) {
        Integer integer = taskExperimentsMapper.selectCountByStudent(accountId);
        return integer;
    }

    @Override
    public TaskExperimentPO selectExperimentDetails(String taskExperimentId, String accountId) {
        TaskExperimentPO taskExperimentPO = new TaskExperimentPO();
        //  AccountAndTaskExperiments accountAndTaskExperiments = accountAndTaskExperimentsMapper.selectByTaskAndAccountId(accountId, taskExperimentId);
        TaskScore taskScore = scoreMapper.selectByAccountAndTask(accountId, taskExperimentId);
        if (taskScore != null) {
            taskExperimentPO.setScore(taskScore.getScore());
            taskExperimentPO.setComment(taskScore.getComment());
        }
        TaskExperiments taskExperiment = taskExperimentsMapper.selectByPrimaryKey(taskExperimentId);
        if (taskExperiment != null) {
            ExperimentTemplates experimentTemplates = templateMapper.selectByPrimaryKey(taskExperiment.getTemplateId());
            if (experimentTemplates != null) {
                taskExperimentPO.setTaskExperimentId(taskExperimentId);
                taskExperimentPO.setName(experimentTemplates.getName());
                taskExperimentPO.setDescription(experimentTemplates.getDescription());
                Resources guide = resourceMapper.queryResourceById(experimentTemplates.getGuideId());
                if (guide != null) {
                    taskExperimentPO.setGuideName(guide.getName());
                    taskExperimentPO.setGuidePath(Constants.RESOURCE_PATH + guide.getPath());
                }
                Resources report = resourceMapper.queryResourceById(experimentTemplates.getReportId());
                if (report != null) {
                    taskExperimentPO.setReportTemName(report.getName());
                    taskExperimentPO.setReportTemPath(Constants.RESOURCE_PATH + report.getPath());
                }
                //报告pdf
                ExperimentReport experimentReport = reportMapper.selectByExperimentAndAccountId(taskExperimentId, accountId);
                if (experimentReport != null) {
                    taskExperimentPO.setReportId(experimentReport.getId());
                    taskExperimentPO.setReportName(experimentReport.getName());
                    taskExperimentPO.setReportPath(Constants.RESOURCE_PATH + experimentReport.getPath());
                }
                List<SimPO> simAnnexs = new ArrayList<>();
                List<SimTemplate> simTemplates = simTemplateMapper.selectByTemplateId(experimentTemplates.getId());
                for (SimTemplate simTemplate : simTemplates) {
                    if (simTemplate != null) {
                        SimPO annexPO = new SimPO();
                        annexPO.setId(simTemplate.getId());
                        annexPO.setName(simTemplate.getName());
                        annexPO.setTypeId(simTemplate.getTypeId());
                        annexPO.setPath(Constants.RESOURCE_PATH + simTemplate.getPath());
                        annexPO.setStem(simTemplate.getStem());
                        ExperimentTypes experimentTypes = experimentTypeMapper.queryExperimentTypeById(simTemplate.getExpTypeId());
                        if (experimentTypes != null) {
                            annexPO.setExpType(experimentTypes.getName());
                        }
                        SceneType sceneType = sceneTypeMapper.selectByPrimaryKey(simTemplate.getTypeId());
                        if (sceneType != null) {
                            annexPO.setTypeName(sceneType.getName());
                            annexPO.setSimType(sceneType.getAlias());
                        }
                        ExperimentProject experimentProject = projectMapper.selectBySimId(simTemplate.getId(), taskExperimentId, accountId);
                        if (experimentProject != null) {
                            annexPO.setProjectId(experimentProject.getId());
                            annexPO.setProjectName(experimentProject.getUpdatedAt().toString());
                            annexPO.setScenePath(Constants.RESOURCE_PATH + experimentProject.getScenePath());
                            annexPO.setSimPath(Constants.RESOURCE_PATH + experimentProject.getSimPath());
                        }
                        simAnnexs.add(annexPO);
                    }
                }
                Component component = componentMapper.selectComponentById(experimentTemplates.getBenchId());
                if (component != null) {
                    SimPO annexPO = new SimPO();
                    annexPO.setId(component.getId());
                    annexPO.setName(component.getName());
                    annexPO.setTypeName("实验台");
                    annexPO.setType(component.getType());
                    annexPO.setStem(Constants.COMPONENT_RESOURCE);
                    annexPO.setSimType("bench");
                    simAnnexs.add(annexPO);
                }
                taskExperimentPO.setSimAnnexs(simAnnexs);
                List<AnnexPO> referAnnexs = new ArrayList<>();
                List<AnnexTemplate> annexTemplates = annexTemplateMapper.selectByTemplateId(experimentTemplates.getId());
                for (AnnexTemplate annexTemplate : annexTemplates) {
                    if (annexTemplate != null) {
                        AnnexPO annexPO = new AnnexPO();
                        String name = annexTemplate.getName();
                        annexPO.setId(annexTemplate.getId());
                        annexPO.setName(name);
                        annexPO.setTypeId(annexTemplate.getTypeId());
                        annexPO.setPath(Constants.RESOURCE_PATH + annexTemplate.getPath());
                        annexPO.setStem(annexTemplate.getStem());

                        SceneType sceneType = sceneTypeMapper.selectByPrimaryKey(annexTemplate.getTypeId());
                        if (sceneType != null) {
                            annexPO.setTypeName(sceneType.getName());
                            annexPO.setSimType(sceneType.getAlias());
                        } else {
                            String suffix = name.substring(name.lastIndexOf(".") + 1);
                            annexPO.setTypeName(suffix);
                            annexPO.setSimType("file");
                        }
                        ExperimentTypes experimentTypes = experimentTypeMapper.queryExperimentTypeById(annexTemplate.getExpTypeId());
                        if (experimentTypes != null) {
                            annexPO.setExpType(experimentTypes.getName());
                        }

                        referAnnexs.add(annexPO);
                    }
                }
                List<AnnexPO> otherAnnexs = new ArrayList<>();
                List<ExperimentAnnex> experimentAnnexes = experimentAnnexMapper.selectList(taskExperimentId, accountId);
                for (ExperimentAnnex annex : experimentAnnexes) {
                    if (annex != null) {
                        AnnexPO annexPO = new AnnexPO();
                        String name = annex.getName();
                        annexPO.setId(annex.getId());
                        annexPO.setName(name);
                        annexPO.setTypeId(annex.getType());
                        annexPO.setPath(Constants.RESOURCE_PATH + annex.getPath());
                        SceneType sceneType = sceneTypeMapper.selectByPrimaryKey(annex.getType());
                        if (sceneType != null) {
                            annexPO.setTypeName(sceneType.getName());
                            annexPO.setSimType(sceneType.getAlias());
                        } else {
                            String suffix = name.substring(name.lastIndexOf(".") + 1);
                            annexPO.setTypeName(suffix);
                            annexPO.setSimType("file");
                        }
                        ExperimentTypes experimentTypes = experimentTypeMapper.queryExperimentTypeById(annex.getExpType());
                        if (experimentTypes != null) {
                            annexPO.setExpType(experimentTypes.getName());
                        }
                        otherAnnexs.add(annexPO);
                    }
                }
                taskExperimentPO.setReferAnnexs(referAnnexs);
                taskExperimentPO.setSimAnnexs(simAnnexs);
                taskExperimentPO.setOtherAnnexs(otherAnnexs);
            }
        }
        return taskExperimentPO;
    }

    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    public void stopTaskAutomatic() {
        List<String> list = taskExperimentsMapper.selectExpiredTask();
        for (String id : list) {
            if (id != null) {
                int i = accountAndTaskExperimentsMapper.updateStatuStop(id);
                Integer integer = taskExperimentsMapper.stopTaskExperiment(id);
                log.info("停止任务："+id);
            }
        }
    }
}
