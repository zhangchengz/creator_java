package com.tlf.creatorcourse.po;

import com.tlf.creatorcourse.entity.resource.Resources;
import com.tlf.creatorcourse.entity.template.ExperimentTemplates;

public class TemplatePO extends ExperimentTemplates {

    private Resources resource;

    public TemplatePO() {
    }

    public TemplatePO(Resources resource) {
        this.resource = resource;
    }

    public Resources getResource() {
        return resource;
    }

    public void setResource(Resources resource) {
        this.resource = resource;
    }
}
