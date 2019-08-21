package com.tlf.creatorcourse.req;

import java.util.List;

public class TaskReq extends BaseReq {

    private String taskExperimentId;
    private String operating;
    private String reportId;
    private List<String> otherAnnexs;

    public TaskReq() {
    }

    public TaskReq(String taskExperimentId, String operating, String reportId, List<String> otherAnnexs) {
        this.taskExperimentId = taskExperimentId;
        this.operating = operating;
        this.reportId = reportId;
        this.otherAnnexs = otherAnnexs;
    }

    public String getTaskExperimentId() {
        return taskExperimentId;
    }

    public void setTaskExperimentId(String taskExperimentId) {
        this.taskExperimentId = taskExperimentId;
    }

    public String getOperating() {
        return operating;
    }

    public void setOperating(String operating) {
        this.operating = operating;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public List<String> getOtherAnnexs() {
        return otherAnnexs;
    }

    public void setOtherAnnexs(List<String> otherAnnexs) {
        this.otherAnnexs = otherAnnexs;
    }
}
