package com.tlf.creatorcourse.po;


import com.tlf.creatorcourse.entity.resource.Resources;
import com.tlf.creatorcourse.entity.TaskExperimentProjects;

import java.util.List;

public class ReportPO {

    private String id;
    private String taskExperimentId;
    private String taskExperimentName;
    private String submitterId;
    private String remark;
    private Float score;
    private String comment;
    private String status;
    private Resources report;
    private List<Resources> annexs;
    private TaskExperimentProjects project;

    public ReportPO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTaskExperimentId() {
        return taskExperimentId;
    }

    public void setTaskExperimentId(String taskExperimentId) {
        this.taskExperimentId = taskExperimentId;
    }

    public String getTaskExperimentName() {
        return taskExperimentName;
    }

    public void setTaskExperimentName(String taskExperimentName) {
        this.taskExperimentName = taskExperimentName;
    }

    public String getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(String submitterId) {
        this.submitterId = submitterId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Resources getReport() {
        return report;
    }

    public void setReport(Resources report) {
        this.report = report;
    }

    public List<Resources> getAnnexs() {
        return annexs;
    }

    public void setAnnexs(List<Resources> annexs) {
        this.annexs = annexs;
    }

    public TaskExperimentProjects getProject() {
        return project;
    }

    public void setProject(TaskExperimentProjects project) {
        this.project = project;
    }

    public ReportPO(String id, String taskExperimentId, String taskExperimentName, String submitterId, String remark, Float score, String comment, String status, Resources report, List<Resources> annexs, TaskExperimentProjects project) {
        this.id = id;
        this.taskExperimentId = taskExperimentId;
        this.taskExperimentName = taskExperimentName;
        this.submitterId = submitterId;
        this.remark = remark;
        this.score = score;
        this.comment = comment;
        this.status = status;
        this.report = report;
        this.annexs = annexs;
        this.project = project;
    }
}
