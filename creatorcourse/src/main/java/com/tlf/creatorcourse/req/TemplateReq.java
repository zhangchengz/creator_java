package com.tlf.creatorcourse.req;

import com.tlf.creatorcourse.entity.template.AnnexTemplate;
import com.tlf.creatorcourse.entity.template.ExperimentTemplates;
import com.tlf.creatorcourse.entity.template.SimTemplate;

import java.util.List;

public class TemplateReq {

    private ExperimentTemplates template;
    private List<SimTemplate> simTemplates;
    private List<AnnexTemplate> annexTemplates;

    public TemplateReq() {
    }

    public TemplateReq(ExperimentTemplates template, List<SimTemplate> simTemplates, List<AnnexTemplate> annexTemplates) {
        this.template = template;
        this.simTemplates = simTemplates;
        this.annexTemplates = annexTemplates;
    }

    public ExperimentTemplates getTemplate() {
        return template;
    }

    public void setTemplate(ExperimentTemplates template) {
        this.template = template;
    }

    public List<SimTemplate> getSimTemplates() {
        return simTemplates;
    }

    public void setSimTemplates(List<SimTemplate> simTemplates) {
        this.simTemplates = simTemplates;
    }

    public List<AnnexTemplate> getAnnexTemplates() {
        return annexTemplates;
    }

    public void setAnnexTemplates(List<AnnexTemplate> annexTemplates) {
        this.annexTemplates = annexTemplates;
    }
}
