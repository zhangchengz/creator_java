package com.tlf.creatorcourse.controller.template;

import com.tlf.creatorcourse.common.JsonResult;
import com.tlf.creatorcourse.common.JsonRet;
import com.tlf.creatorcourse.constants.Constants;
import com.tlf.creatorcourse.entity.coursestudy.Material;
import com.tlf.creatorcourse.entity.resource.Resource;
import com.tlf.creatorcourse.entity.template.AnnexTemplate;
import com.tlf.creatorcourse.entity.template.ExperimentTemplates;
import com.tlf.creatorcourse.entity.template.SimTemplate;
import com.tlf.creatorcourse.po.Report;
import com.tlf.creatorcourse.po.TempPO;
import com.tlf.creatorcourse.req.PageReq;
import com.tlf.creatorcourse.req.SimReq;
import com.tlf.creatorcourse.req.TempReq;
import com.tlf.creatorcourse.req.TemplateReq;
import com.tlf.creatorcourse.service.component.IComponentService;
import com.tlf.creatorcourse.service.material.IMaterialService;
import com.tlf.creatorcourse.service.resource.IResourceService;
import com.tlf.creatorcourse.service.tempalte.ITaskExperimentTemplateService;
import com.tlf.creatorcourse.utils.FileUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class TemplateController {

    @Autowired
    private ITaskExperimentTemplateService templateService;

    @Autowired
    private IMaterialService materialService;

    @Autowired
    private IComponentService componentService;

    @Autowired
    private IResourceService resourceService;

    @Autowired
    private FileUtil fileUtil;

    /**
     * 获取实验模板列表
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "get_template_list", method = RequestMethod.POST)
    public JsonRet getTemplateList(@RequestBody SimReq req) {
        if (req.isInner()) {
            List<ExperimentTemplates> taskExperimentTemplates = templateService.selectListInner(req);
            Integer integer = templateService.selectTotalInner();
            return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", integer, taskExperimentTemplates);
        } else {
            List<ExperimentTemplates> taskExperimentTemplates = templateService.selectListNotInner(req);
            Integer integer = templateService.selectTotalNotInner(req);
            return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", integer, taskExperimentTemplates);
        }
    }

    /**
     * 获取模板详情
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "get_template", method = RequestMethod.POST)
    public JsonResult getTemplateById(@RequestBody TempReq req) {
        String id = req.getId();
        TempPO tempPO = templateService.selectByPrimaryKey(id);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", tempPO);
    }

    /**
     * 新增模板
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "add_template", method = RequestMethod.POST)
    public JsonResult addTemplateById(@RequestBody TempReq req) throws IOException {
        List<String> names = templateService.selectAllNames(req.getAccountId());
        if (StringUtils.isBlank(req.getId())) { //新建模板
            for (String name : names) {
                if (name.equals(req.getName())) {
                    return new JsonResult(Constants.CODE_EXIST, "该名称已经存在", null);
                }
            }
            String templateId = UUID.randomUUID().toString();
            ExperimentTemplates experimentTemplates = new ExperimentTemplates();
            experimentTemplates.setId(templateId);
            experimentTemplates.setName(req.getName());
            experimentTemplates.setDescription(req.getDescription());
            experimentTemplates.setInnerr(false);
            experimentTemplates.setCreatorId(req.getAccountId());
            Report guide = req.getGuide();
            if (guide != null && StringUtils.isNotBlank(guide.getId())) {
                experimentTemplates.setGuideId(guide.getId());
                experimentTemplates.setGuideStem(guide.getStem());
            }
            Report report = req.getReport();
            if (report != null && StringUtils.isNotBlank(report.getId())) {
                experimentTemplates.setReportId(report.getId());
                experimentTemplates.setReportStem(report.getStem());
            }
            List<SimTemplate> simulations = req.getSimulations();
            List<SimTemplate> list = new ArrayList<>();
            if (simulations != null) {
                for (SimTemplate simulation : simulations) {
                    if (simulation != null) {
                        if (Constants.UPLOAD_RESOURCE.equals(simulation.getStem())) {
                            SimTemplate simTemplate = new SimTemplate();
                            simTemplate.setId(simulation.getId());
                            simTemplate.setTemplateId(templateId);
                            simTemplate.setName(simulation.getName());
                            String path = simulation.getPath();
                            if (path.contains("static/")) {
                                path = path.substring(path.indexOf("static/"));
                            }
                            simTemplate.setPath(path);
                            simTemplate.setStem(simTemplate.getStem());
                            simTemplate.setTypeId(simulation.getTypeId());
                            simTemplate.setCreatorId(req.getAccountId());
                            simTemplate.setExpTypeId(simulation.getExpTypeId());
                            list.add(simTemplate);
                        }
                        if (Constants.SIMULATION_RESOURCE.equals(simulation.getStem())) {
                            Resource resource = fileUtil.copyFile(simulation.getId(), simulation.getStem());
                            if (resource != null) {
                                SimTemplate simTemplate = new SimTemplate();
                                simTemplate.setId(resource.getId());
                                simTemplate.setTemplateId(templateId);
                                simTemplate.setName(resource.getName());
                                String path = resource.getPath();
                                if (path.contains("static/")) {
                                    path = path.substring(path.indexOf("static/"));
                                }
                                simTemplate.setPath(path);
                                simTemplate.setStem(simulation.getStem());
                                simTemplate.setTypeId(simulation.getTypeId());
                                simTemplate.setCreatorId(req.getAccountId());
                                simTemplate.setExpTypeId(simulation.getExpTypeId());
                                list.add(simTemplate);
                            }
                        }
                        if (Constants.COMPONENT_RESOURCE.equals(simulation.getStem())) {
                            experimentTemplates.setBenchId(simulation.getId());
                        }
                    }
                }
            }
            List<AnnexTemplate> annexes = req.getAnnexs();
            List<AnnexTemplate> list1 = new ArrayList<>();
            if (annexes != null) {
                for (AnnexTemplate annexTemplate : annexes) {
                    if (annexTemplate != null) {
                        if (Constants.SIMULATION_RESOURCE.equals(annexTemplate.getStem())) {
                            Resource resource = fileUtil.copyFile(annexTemplate.getId(), annexTemplate.getStem());
                            if (resource != null) {
                                AnnexTemplate simTemplate = new AnnexTemplate();
                                simTemplate.setId(resource.getId());
                                simTemplate.setTemplateId(templateId);
                                simTemplate.setName(resource.getName());
                                String path = resource.getPath();
                                if (path.contains("static/")) {
                                    path = path.substring(path.indexOf("static/"));
                                }
                                annexTemplate.setPath(path);
                                simTemplate.setStem(annexTemplate.getStem());
                                simTemplate.setTypeId(annexTemplate.getTypeId());
                                simTemplate.setCreatorId(req.getAccountId());
                                simTemplate.setExpTypeId(annexTemplate.getExpTypeId());
                                list1.add(simTemplate);
                            }
                        }
                        if (Constants.COURSE_RESOURCE.equals(annexTemplate.getStem())) {
                            AnnexTemplate simTemplate = new AnnexTemplate();
                            simTemplate.setId(annexTemplate.getId());
                        }
                        if (Constants.UPLOAD_RESOURCE.equals(annexTemplate.getStem())) {
                            AnnexTemplate simTemplate = new AnnexTemplate();
                            simTemplate.setId(annexTemplate.getId());
                            simTemplate.setTemplateId(templateId);
                            simTemplate.setName(annexTemplate.getName());
                            simTemplate.setPath(annexTemplate.getPath());
                            simTemplate.setStem(annexTemplate.getStem());
                            simTemplate.setTypeId(annexTemplate.getTypeId());
                            simTemplate.setCreatorId(req.getAccountId());
                            simTemplate.setExpTypeId(annexTemplate.getExpTypeId());
                            list1.add(simTemplate);
                        }
                    }

                }
            }
            TemplateReq templateReq = new TemplateReq(experimentTemplates, list, list1);
            boolean insert = templateService.insert(templateReq);
            if (insert) {
                return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
            }
            return new JsonResult(Constants.CODE_FAIL, "FAIL", null);
        } else {  //修改保存模板
            ExperimentTemplates experimentTemplates = templateService.selectById(req.getId());
            if (experimentTemplates != null) {
                if (!req.getName().equals(experimentTemplates.getName())) {
                    for (String name : names) {
                        if (name.equals(req.getName())) {
                            return new JsonResult(Constants.CODE_EXIST, "该名称已经存在", null);
                        }
                    }
                }
                experimentTemplates.setName(req.getName());
                experimentTemplates.setDescription(req.getDescription());
                //实验报告
                Report guide = req.getGuide();
                if (guide != null) {
                    if (StringUtils.isNotBlank(guide.getId()) && !guide.getId().equals(experimentTemplates.getGuideId())) {
                        if (Constants.COURSE_RESOURCE.equals(guide.getStem())) {
                            Resource resource = fileUtil.copyFile(guide.getId(), guide.getStem());
                            if (resource != null) {
                                experimentTemplates.setGuideId(resource.getId());
                            }
                            experimentTemplates.setGuideStem(guide.getStem());
                        }
                        if (Constants.UPLOAD_RESOURCE.equals(guide.getStem())) {
                            experimentTemplates.setGuideId(guide.getId());
                            experimentTemplates.setGuideStem(guide.getStem());
                        }
                    } else if (StringUtils.isBlank(guide.getId())) {
                        experimentTemplates.setGuideId(null);
                        experimentTemplates.setGuideStem(null);
                    }
                }
                //实验指导书
                Report report = req.getReport();
                if (report != null) {
                    if (StringUtils.isNotBlank(report.getId()) && !report.getId().equals(experimentTemplates.getReportId())) {
                        if (Constants.COURSE_RESOURCE.equals(report.getStem())) {
                            Resource resource = fileUtil.copyFile(report.getId(), report.getStem());
                            if (resource != null) {
                                experimentTemplates.setReportId(resource.getId());
                            }
                            experimentTemplates.setReportStem(report.getStem());
                        }
                        if (Constants.UPLOAD_RESOURCE.equals(report.getStem())) {
                            experimentTemplates.setReportId(report.getId());
                            experimentTemplates.setReportStem(report.getStem());
                        }
                    } else if (StringUtils.isBlank(report.getId())) {
                        experimentTemplates.setReportId(null);
                        experimentTemplates.setReportStem(null);
                    }
                }
                //仿真题附件
                List<SimTemplate> simulations = req.getSimulations();
                List<SimTemplate> list = new ArrayList<>();
                for (SimTemplate simulation : simulations) {
                    if (simulation != null) {
                        if (Constants.SIMULATION_RESOURCE.equals(simulation.getStem())) {
                            Resource resource = fileUtil.copyFile(simulation.getId(), simulation.getStem());
                            if (resource != null) {
                                SimTemplate simTemplate = new SimTemplate();
                                simTemplate.setId(resource.getId());
                                String path = resource.getPath();
                                if (path.contains("static/")) {
                                    path = path.substring(path.indexOf("static/") + 7);
                                }
                                simTemplate.setPath(path);
                                simTemplate.setName(resource.getName());
                                simTemplate.setTemplateId(req.getId());
                                simTemplate.setStem(simulation.getStem());
                                simTemplate.setExpTypeId(simulation.getExpTypeId());
                                simTemplate.setCreatorId(simulation.getCreatorId());
                                simTemplate.setTypeId(simulation.getTypeId());
                                list.add(simTemplate);
                            }
                        }
                        // 实验台
                        if (Constants.COMPONENT_RESOURCE.equals(simulation.getStem())) {
                            experimentTemplates.setBenchId(simulation.getId());
                        }
                        if (Constants.UPLOAD_RESOURCE.equals(simulation.getStem())) {
                            SimTemplate simTemplate = new SimTemplate();
                            simTemplate.setId(simulation.getId());
                            String path = simulation.getPath();
                            if (path.contains("static/")) {
                                path = path.substring(path.indexOf("static/") + 7);
                            }
                            simTemplate.setPath(path);
                            simTemplate.setName(simulation.getName());
                            simTemplate.setTemplateId(req.getId());
                            simTemplate.setStem(simulation.getStem());
                            simTemplate.setExpTypeId(simulation.getExpTypeId());
                            simTemplate.setCreatorId(simulation.getCreatorId());
                            simTemplate.setTypeId(simulation.getTypeId());
                            list.add(simTemplate);
                        }
                    }
                }
                //参考附件
                List<AnnexTemplate> annexs = req.getAnnexs();
                List<AnnexTemplate> list1 = new ArrayList<>();
                for (AnnexTemplate annex : annexs) {
                    if (annex != null) {
                        if (Constants.UPLOAD_RESOURCE.equals(annex.getStem())) {
                            AnnexTemplate annexTemplate = new AnnexTemplate();
                            annexTemplate.setId(annex.getId());
                            String path = annex.getPath();
                            if (path.contains("static/")) {
                                path = path.substring(path.indexOf("static/") + 7);
                            }
                            annexTemplate.setPath(path);
                            annexTemplate.setName(annex.getName());
                            annexTemplate.setTemplateId(req.getId());
                            annexTemplate.setStem(annex.getStem());
                            annexTemplate.setExpTypeId(annex.getExpTypeId());
                            annexTemplate.setCreatorId(annex.getCreatorId());
                            annexTemplate.setTypeId(annex.getTypeId());
                            list1.add(annexTemplate);
                        } else if (Constants.SIMULATION_RESOURCE.equals(annex.getStem())) {
                            Resource resource = fileUtil.copyFile(annex.getId(), annex.getStem());
                            if (resource != null) {
                                AnnexTemplate annexTemplate = new AnnexTemplate();

                                annexTemplate.setId(resource.getId());
                                String path = resource.getPath();
                                if (path.contains("static/")) {
                                    path = path.substring(path.indexOf("static/") + 7);
                                }
                                annexTemplate.setPath(path);
                                annexTemplate.setName(resource.getName());
                                annexTemplate.setTemplateId(req.getId());
                                annexTemplate.setStem(annex.getStem());
                                annexTemplate.setExpTypeId(annex.getExpTypeId());
                                annexTemplate.setCreatorId(annex.getCreatorId());
                                annexTemplate.setTypeId(annex.getTypeId());
                                list1.add(annexTemplate);
                            }
                        } else if (Constants.COURSE_RESOURCE.equals(annex.getStem())) {
                            AnnexTemplate annexTemplate = new AnnexTemplate();
                            annexTemplate.setId(annex.getId());
                            Material material = materialService.selectById(annex.getId());
                            String path = null;
                            if (material != null) {
                                path = material.getPath();
                            }
                            annexTemplate.setPath(path);
                            annexTemplate.setName(annex.getName());
                            annexTemplate.setTemplateId(req.getId());
                            annexTemplate.setStem(annex.getStem());
                            annexTemplate.setExpTypeId(annex.getExpTypeId());
                            annexTemplate.setCreatorId(annex.getCreatorId());
                            annexTemplate.setTypeId(annex.getTypeId());
                            list1.add(annexTemplate);
                        }
                    }
                }
                templateService.updateByPrimaryKey(experimentTemplates, list, list1);
            }
        }
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    @PostMapping("check_template_name")
    public JsonRet checkTemplateName(@RequestBody TempReq req) {
        List<String> names = templateService.selectAllNames(req.getAccountId());
        if (StringUtils.isBlank(req.getId())) {
            for (String name : names) {
                if (name.equals(req.getName())) {
                    return new JsonRet(Constants.CODE_FAIL, "该名称已经存在", null, false);
                }
            }
        } else {
            ExperimentTemplates experimentTemplates = templateService.selectById(req.getId());
            if (experimentTemplates != null) {
                if (!req.getName().equals(experimentTemplates.getName())) {
                    for (String name : names) {
                        if (name.equals(req.getName())) {
                            return new JsonRet(Constants.CODE_FAIL, "该名称已经存在", null, false);
                        }
                    }
                }
            }
        }
        return new JsonRet(Constants.CODE_SUCCESS, "该名称可以使用", null, true);
    }

    /**
     * 删除模板
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "delete_template", method = RequestMethod.POST)
    public JsonResult deleteTemplate(@RequestBody TempReq req) {
        String id = req.getId();
        boolean delete = templateService.deleteByPrimaryKey(id);
        if (delete) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
        }
        return new JsonResult(Constants.CODE_FAIL, "FAIL", null);
    }

    /**
     * 克隆
     *
     * @param req
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "clone_template", method = RequestMethod.POST)
    public JsonResult cloneTemplate(@RequestBody TempReq req) throws IOException {
        List<String> names = templateService.selectAllNames(req.getAccountId());
        for (String name : names) {
            if (name.equals(req.getName())) {
                return new JsonResult(Constants.CODE_FAIL, "该名称已经存在", null);
            }
        }
        ExperimentTemplates experimentTemplates = templateService.selectById(req.getId());
        if (experimentTemplates == null) {
            return new JsonResult(Constants.CODE_FAIL, "要克隆的模板不存在", null);
        }
        String templateId = UUID.randomUUID().toString();
        experimentTemplates.setId(templateId);
        experimentTemplates.setInnerr(false);
        experimentTemplates.setName(req.getName());
        experimentTemplates.setCreatorId(req.getAccountId());
        if (experimentTemplates.getReportId() != null && experimentTemplates.getReportStem() != null) {
            Resource resource = fileUtil.copyFile(experimentTemplates.getReportId(), experimentTemplates.getReportStem());
            if (resource != null) {
                experimentTemplates.setReportId(resource.getId());
            }
        }
        if (experimentTemplates.getGuideId() != null && experimentTemplates.getGuideStem() != null) {
            Resource resource = fileUtil.copyFile(experimentTemplates.getGuideId(), experimentTemplates.getGuideStem());
            if (resource != null) {
                experimentTemplates.setGuideId(resource.getId());
            }
        }
        List<AnnexTemplate> annexTemplates = templateService.selectAnnexByTemplateId(req.getId());
        List<AnnexTemplate> list = new ArrayList<>();
        for (AnnexTemplate annexTemplate : annexTemplates) {
            if (annexTemplate != null) {
                Resource resource = fileUtil.copyFile(annexTemplate.getId(), annexTemplate.getStem());
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
        List<SimTemplate> simTemplates = templateService.selectSimByTemplateId(req.getId());
        List<SimTemplate> list1 = new ArrayList<>();
        for (SimTemplate simTemplate : simTemplates) {
            if (simTemplate != null) {
                Resource resource = fileUtil.copyFile(simTemplate.getId(), simTemplate.getStem());
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
        boolean insert = templateService.insert(templateReq);
        if (insert) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
        }
        return new JsonResult(Constants.CODE_FAIL, "FAIL", null);
    }

    @PostMapping(value = "get_template_supervisor")
    public JsonRet getTemplateSupervisor(@RequestBody PageReq req) {
        List<ExperimentTemplates> experimentTemplates = templateService.selectAllTemplates(req.getOffset(), req.getLimit());
        Integer integer = templateService.selectCount();
        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", integer, experimentTemplates);
    }

    @PostMapping(value = "update_template_inner")
    public JsonRet modifyTemplateInner(@RequestBody TempReq req) {
        boolean b = templateService.updateTemplateInner(req.getId());
        if (b) {
            return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", null, null);
        } else {
            return new JsonRet(Constants.CODE_FAIL, "FAIL", null, null);
        }
    }

}
