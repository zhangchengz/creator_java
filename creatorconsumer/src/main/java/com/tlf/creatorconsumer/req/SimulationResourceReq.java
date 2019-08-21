package com.tlf.creatorconsumer.req;

public class SimulationResourceReq extends PageReq{

    private String id;
    private String name;
    private String typeId;
    private String expTypeId;
    private String json;
    private String creatorId;
    private String role;

    public SimulationResourceReq() {
    }

    public SimulationResourceReq(String id, String name, String typeId, String expTypeId, String json, String creatorId, String role) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.expTypeId = expTypeId;
        this.json = json;
        this.creatorId = creatorId;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getExpTypeId() {
        return expTypeId;
    }

    public void setExpTypeId(String expTypeId) {
        this.expTypeId = expTypeId;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }
}
