package com.tlf.creatorcourse.entity.taskexperiment;

import java.util.Date;

public class ExperimentProject {
    private String id;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private String taskExperimentId;

    private String submitterId;

    private String simId;

    private String scenePath;

    private String simPath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getTaskExperimentId() {
        return taskExperimentId;
    }

    public void setTaskExperimentId(String taskExperimentId) {
        this.taskExperimentId = taskExperimentId == null ? null : taskExperimentId.trim();
    }

    public String getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(String submitterId) {
        this.submitterId = submitterId == null ? null : submitterId.trim();
    }

    public String getSimId() {
        return simId;
    }

    public void setSimId(String simId) {
        this.simId = simId == null ? null : simId.trim();
    }

    public String getScenePath() {
        return scenePath;
    }

    public void setScenePath(String scenePath) {
        this.scenePath = scenePath == null ? null : scenePath.trim();
    }

    public String getSimPath() {
        return simPath;
    }

    public void setSimPath(String simPath) {
        this.simPath = simPath == null ? null : simPath.trim();
    }
}