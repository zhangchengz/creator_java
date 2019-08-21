package com.tlf.creatorcourse.entity.template;

import java.util.Date;

public class ExperimentTemplates {
    private String id;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private String name;

    private Boolean innerr;

    private String creatorId;

    private String guideId;

    private String guideStem;

    private String reportId;

    private String reportStem;

    private String benchId;

    private String description;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getInnerr() {
        return innerr;
    }

    public void setInnerr(Boolean innerr) {
        this.innerr = innerr;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public String getGuideId() {
        return guideId;
    }

    public void setGuideId(String guideId) {
        this.guideId = guideId == null ? null : guideId.trim();
    }

    public String getGuideStem() {
        return guideStem;
    }

    public void setGuideStem(String guideStem) {
        this.guideStem = guideStem == null ? null : guideStem.trim();
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public String getReportStem() {
        return reportStem;
    }

    public void setReportStem(String reportStem) {
        this.reportStem = reportStem == null ? null : reportStem.trim();
    }

    public String getBenchId() {
        return benchId;
    }

    public void setBenchId(String benchId) {
        this.benchId = benchId == null ? null : benchId.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}