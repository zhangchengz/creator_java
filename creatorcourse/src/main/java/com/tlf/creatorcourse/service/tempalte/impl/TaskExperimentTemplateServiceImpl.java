package com.tlf.creatorcourse.service.tempalte.impl;

import com.tlf.creatorcourse.config.UploadPathBean;
import com.tlf.creatorcourse.constants.Constants;
import com.tlf.creatorcourse.dao.componentlibrary.ComponentMapper;
import com.tlf.creatorcourse.dao.coursestudy.MaterialMapper;
import com.tlf.creatorcourse.dao.resource.ResourceMapper;
import com.tlf.creatorcourse.dao.simulationresource.SceneTypeMapper;
import com.tlf.creatorcourse.dao.taskexperiment.ExperimentTypeMapper;
import com.tlf.creatorcourse.dao.template.AnnexTemplateMapper;
import com.tlf.creatorcourse.dao.template.ExperimentTemplatesMapper;
import com.tlf.creatorcourse.dao.template.SimTemplateMapper;
import com.tlf.creatorcourse.entity.component.Component;
import com.tlf.creatorcourse.entity.coursestudy.Material;
import com.tlf.creatorcourse.entity.simulation.ExperimentTypes;
import com.tlf.creatorcourse.entity.resource.Resources;
import com.tlf.creatorcourse.entity.simulation.SceneType;
import com.tlf.creatorcourse.entity.template.AnnexTemplate;
import com.tlf.creatorcourse.entity.template.ExperimentTemplates;
import com.tlf.creatorcourse.entity.template.SimTemplate;
import com.tlf.creatorcourse.po.AnnexPO;
import com.tlf.creatorcourse.po.TempPO;
import com.tlf.creatorcourse.req.PageReq;
import com.tlf.creatorcourse.req.TemplateReq;
import com.tlf.creatorcourse.service.tempalte.ITaskExperimentTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaskExperimentTemplateServiceImpl implements ITaskExperimentTemplateService {

    @Autowired
    private ExperimentTemplatesMapper templateMapper;

    @Autowired
    private SimTemplateMapper simTemplateMapper;

    @Autowired
    private AnnexTemplateMapper annexTemplateMapper;

    @Autowired
    private ComponentMapper componentMapper;

    @Autowired
    private SceneTypeMapper sceneTypeMapper;


    @Autowired
    private ExperimentTypeMapper experimentTypeMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private UploadPathBean uploadPathBean;

    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public boolean deleteByPrimaryKey(String id) {
        int i = templateMapper.deleteByPrimaryKey(id);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insert(TemplateReq req) {
        ExperimentTemplates template = req.getTemplate();
        List<AnnexTemplate> annexTemplates = req.getAnnexTemplates();
        List<SimTemplate> simTemplates = req.getSimTemplates();

        for (AnnexTemplate annexTemplate : annexTemplates) {
            int insert1 = annexTemplateMapper.insert(annexTemplate);
        }
        for (SimTemplate simTemplate : simTemplates) {
            int insert1 = simTemplateMapper.insert(simTemplate);
        }
        int insert = templateMapper.insert(template);
        if (insert > 0) {
            return true;
        }
        return false;
    }


    @Override
    public TempPO selectByPrimaryKey(String id) {
        ExperimentTemplates experimentTemplates = templateMapper.selectByPrimaryKey(id);
        if (experimentTemplates != null) {
            TempPO tempPO = new TempPO();
            tempPO.setName(experimentTemplates.getName());
            tempPO.setDescription(experimentTemplates.getDescription());
            if (Constants.UPLOAD_RESOURCE.equals(experimentTemplates.getGuideStem())) {
                Resources guide = resourceMapper.queryResourceById(experimentTemplates.getGuideId());
                if (guide != null) {
                    tempPO.setGuideId(experimentTemplates.getGuideId());
                    tempPO.setGuideStem(experimentTemplates.getGuideStem());
                    tempPO.setGuideName(guide.getName());
                    tempPO.setGuidePath(Constants.RESOURCE_PATH + guide.getPath());
                }
            } else if (Constants.COURSE_RESOURCE.equals(experimentTemplates.getGuideStem())) {
                Material material = materialMapper.selectMaterialById(experimentTemplates.getGuideId());
                if (material != null) {
                    tempPO.setGuideId(experimentTemplates.getGuideId());
                    tempPO.setGuideStem(experimentTemplates.getGuideStem());
                    tempPO.setGuideName(material.getName());
                    tempPO.setGuidePath(Constants.RESOURCE_PATH + material.getPath());
                }
            }
            if (Constants.UPLOAD_RESOURCE.equals(experimentTemplates.getReportStem())) {
                Resources report = resourceMapper.queryResourceById(experimentTemplates.getReportId());
                if (report != null) {
                    tempPO.setReportId(experimentTemplates.getReportId());
                    tempPO.setReportStem(experimentTemplates.getReportStem());
                    tempPO.setReportName(report.getName());
                    tempPO.setReportPath(Constants.RESOURCE_PATH + report.getPath());
                }
            } else if (Constants.COURSE_RESOURCE.equals(experimentTemplates.getReportStem())) {
                Material material = materialMapper.selectMaterialById(experimentTemplates.getReportId());
                if (material != null) {
                    tempPO.setReportId(experimentTemplates.getGuideId());
                    tempPO.setReportStem(experimentTemplates.getGuideStem());
                    tempPO.setReportName(material.getName());
                    tempPO.setReportPath(Constants.RESOURCE_PATH + material.getPath());
                }
            }
            List<AnnexPO> sims = new ArrayList<>();
            List<AnnexPO> annexs = new ArrayList<>();
            List<SimTemplate> simTemplates = simTemplateMapper.selectByTemplateId(experimentTemplates.getId());
            for (SimTemplate simTemplate : simTemplates) {
                if (simTemplate != null) {
                    AnnexPO annexPO = new AnnexPO();
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
                    sims.add(annexPO);
                }
            }
            Component component = componentMapper.selectComponentById(experimentTemplates.getBenchId());
            if (component != null) {
                AnnexPO annexPO = new AnnexPO();
                annexPO.setId(component.getId());
                annexPO.setName(component.getName());
                annexPO.setTypeName("实验台");
                annexPO.setType(component.getType());
                annexPO.setStem(Constants.COMPONENT_RESOURCE);
                annexPO.setSimType("bench");
                sims.add(annexPO);

            }
            tempPO.setSimulations(sims);
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
                    annexs.add(annexPO);
                }
            }
            tempPO.setSimulations(sims);
            tempPO.setAnnexs(annexs);
            return tempPO;
        }
        return null;
    }

    @Override
    public ExperimentTemplates selectById(String id) {
        return templateMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExperimentTemplates> selectListInner(PageReq req) {
        Integer offset = req.getOffset();
        Integer limit = req.getLimit();
        return templateMapper.selectListInner(offset, limit);
    }

    @Override
    public Integer selectTotalInner() {
        return templateMapper.selectCountInner();
    }

    @Override
    public List<ExperimentTemplates> selectListNotInner(PageReq req) {
        Integer offset = req.getOffset();
        Integer limit = req.getLimit();
        return templateMapper.selectListNotInner(req.getAccountId(), offset, limit);
    }

    @Override
    public Integer selectTotalNotInner(PageReq req) {
        return templateMapper.selectCountNotInner(req.getAccountId());
    }

    @Override
    public List<String> selectAllNames(String creatorId) {
        return templateMapper.selectAllNames(creatorId);
    }

    @Transactional
    @Override
    public boolean updateByPrimaryKey(ExperimentTemplates record, List<SimTemplate> simulations, List<AnnexTemplate> annexs) {
        templateMapper.updateByPrimaryKey(record);
        //删除文件
        List<SimTemplate> simTemplates = simTemplateMapper.selectByTemplateId(record.getId());
        for (SimTemplate simTemplate : simTemplates) {
            if (simTemplate != null) {
                File file1 = new File(uploadPathBean.getUploadPath() + simTemplate.getPath());
                if (file1.exists()) {
                    file1.delete();
                }
            }
        }
        simTemplateMapper.deleteByTemplateId(record.getId());
        //删除文件
        List<AnnexTemplate> annexTemplates = annexTemplateMapper.selectByTemplateId(record.getId());
        for (AnnexTemplate annexTemplate : annexTemplates) {
            if (annexTemplate != null) {
                File file1 = new File(uploadPathBean.getUploadPath() + annexTemplate.getPath());
                if (file1.exists()) {
                    file1.delete();
                }
            }
        }
        annexTemplateMapper.deleteByTemplateId(record.getId());
        for (SimTemplate simulation : simulations) {
            if (simulation != null) {
                simTemplateMapper.insert(simulation);
            }
        }
        for (AnnexTemplate annex : annexs) {
            if (annex != null) {
                annexTemplateMapper.insert(annex);
            }
        }
        return true;
    }

    @Override
    public List<SimTemplate> selectSimByTemplateId(String templateId) {
        return simTemplateMapper.selectByTemplateId(templateId);
    }

    @Override
    public SimTemplate selectSimById(String id) {
        SimTemplate simTemplate = simTemplateMapper.selectByPrimaryKey(id);
        return simTemplate;
    }

    @Override
    public List<AnnexTemplate> selectAnnexByTemplateId(String templateId) {
        return annexTemplateMapper.selectByTemplateId(templateId);
    }

    @Override
    public boolean updateTemplateInner(String id) {
        int i = templateMapper.updateTemplateInner(id);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<ExperimentTemplates> selectAllTemplates(Integer offset, Integer limit) {
        List<ExperimentTemplates> experimentTemplates = templateMapper.selectAllTemplates(offset, limit);
        return experimentTemplates;
    }

    @Override
    public Integer selectCount() {
        Integer integer = templateMapper.selectCount();
        return integer;
    }


}
