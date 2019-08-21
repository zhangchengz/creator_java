package com.tlf.creatorconsumer.req;

import java.util.List;

public class TaskExperimentReq extends PageReq {

    private String taskExperimentId;
    private String taskTemplateId;
    private String startTime;
    private String finishTime;
    private List<String> accountIds;
    private String status;
    private String remark;
    private Boolean completed;

    public TaskExperimentReq() {
    }

    public TaskExperimentReq(String role, String accountId, Integer limit, Integer offset, String taskExperimentId, String taskTemplateId, String startTime, String finishTime, List<String> accountIds, String status, String remark, Boolean completed) {
        super(role, accountId, limit, offset);
        this.taskExperimentId = taskExperimentId;
        this.taskTemplateId = taskTemplateId;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.accountIds = accountIds;
        this.status = status;
        this.remark = remark;
        this.completed = completed;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getTaskExperimentId() {
        return taskExperimentId;
    }

    public void setTaskExperimentId(String taskExperimentId) {
        this.taskExperimentId = taskExperimentId;
    }

    public String getTaskTemplateId() {
        return taskTemplateId;
    }

    public void setTaskTemplateId(String taskTemplateId) {
        this.taskTemplateId = taskTemplateId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public List<String> getAccountIds() {
        return accountIds;
    }

    public void setAccountIds(List<String> accountIds) {
        this.accountIds = accountIds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
