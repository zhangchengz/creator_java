package com.tlf.creator.entity.curriculum.simulation;

import java.util.Date;

public class SimulationResource {
    private String id;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private String name;

    private Boolean inner;

    private String typeId;

    private String creatorId;

    private String path;

    private String expTypeId;

    public String getExpTypeId() {
        return expTypeId;
    }

    public void setExpTypeId(String expTypeId) {
        this.expTypeId = expTypeId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getInner() {
        return inner;
    }

    public void setInner(Boolean inner) {
        this.inner = inner;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public SimulationResource(String id, Date createdAt, Date updatedAt, Date deletedAt, String name, Boolean inner, String typeId, String creatorId, String path, String expTypeId) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
        this.name = name;
        this.inner = inner;
        this.typeId = typeId;
        this.creatorId = creatorId;
        this.path = path;
        this.expTypeId = expTypeId;
    }

    public SimulationResource() {
    }

}