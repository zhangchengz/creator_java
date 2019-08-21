package com.tlf.creatorcourse.po;

import com.tlf.creatorcourse.entity.resource.Resources;
import com.tlf.creatorcourse.entity.TaskExperimentReports;

public class TaskReportPO extends TaskExperimentReports {

    private Resources report;

    private Resources annex;

    public TaskReportPO(Resources report, Resources annex) {
        this.report = report;
        this.annex = annex;
    }

    public TaskReportPO() {
    }

    public Resources getReport() {
        return report;
    }

    public void setReport(Resources report) {
        this.report = report;
    }

    public Resources getAnnex() {
        return annex;
    }

    public void setAnnex(Resources annex) {
        this.annex = annex;
    }
}
