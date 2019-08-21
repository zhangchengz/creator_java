package com.tlf.creatorcourse.service.tempalte;

import com.tlf.creatorcourse.entity.template.AnnexTemplate;
import com.tlf.creatorcourse.entity.template.ExperimentTemplates;
import com.tlf.creatorcourse.entity.template.SimTemplate;
import com.tlf.creatorcourse.po.TempPO;
import com.tlf.creatorcourse.req.PageReq;
import com.tlf.creatorcourse.req.TemplateReq;

import java.util.List;

public interface ITaskExperimentTemplateService {

    boolean deleteByPrimaryKey(String id);

    boolean insert(TemplateReq req);

    TempPO selectByPrimaryKey(String id);

    ExperimentTemplates selectById(String id);

    List<ExperimentTemplates> selectListInner(PageReq req);

    Integer selectTotalInner();

    List<ExperimentTemplates> selectListNotInner(PageReq req);

    Integer selectTotalNotInner(PageReq req);

    List<String> selectAllNames(String creatorId);

    boolean updateByPrimaryKey(ExperimentTemplates record, List<SimTemplate> simulations, List<AnnexTemplate> annexs);

    List<SimTemplate> selectSimByTemplateId(String templateId);

    SimTemplate selectSimById(String id);

    List<AnnexTemplate> selectAnnexByTemplateId(String templateId);

    boolean updateTemplateInner(String id);

    List<ExperimentTemplates> selectAllTemplates(Integer offset, Integer limit);

    Integer selectCount();
}
