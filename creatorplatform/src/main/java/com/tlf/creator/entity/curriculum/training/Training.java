package com.tlf.creator.entity.curriculum.training;

import java.util.Date;

public class Training {
    private String id;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private String moduleId;

    private String typeId;

    private String name;

    private Boolean innerr;

    private String creatorId;

    private String teachDescription;

    private String practiceDescription;

    private String examDescription;

    public Training() {
    }

    public Training(String id, Date createdAt, Date updatedAt, Date deletedAt, String moduleId, String typeId, String name, Boolean innerr, String creatorId, String teachDescription, String practiceDescription, String examDescription) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.moduleId = moduleId;
        this.typeId = typeId;
        this.name = name;
        this.innerr = innerr;
        this.creatorId = creatorId;
        this.teachDescription = teachDescription;
        this.practiceDescription = practiceDescription;
        this.examDescription = examDescription;
    }

    public String getTeachDescription() {
        return teachDescription;
    }

    public void setTeachDescription(String teachDescription) {
        this.teachDescription = teachDescription;
    }

    public String getPracticeDescription() {
        return practiceDescription;
    }

    public void setPracticeDescription(String practiceDescription) {
        this.practiceDescription = practiceDescription;
    }

    public String getExamDescription() {
        return examDescription;
    }

    public void setExamDescription(String examDescription) {
        this.examDescription = examDescription;
    }

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

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId == null ? null : moduleId.trim();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
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
}