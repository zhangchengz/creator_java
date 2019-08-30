package com.tlf.creator.po;

import com.tlf.creator.entity.curriculum.resource.Resource;

public class ResourcePO extends Resource {

    private String typeName;
    private String typeId;
    private String expTypeId;
    private String expTypeName;
    private String simType;

    public ResourcePO() {
    }

    public ResourcePO(String typeName, String typeId, String expTypeId, String expTypeName, String simType) {
        this.typeName = typeName;
        this.typeId = typeId;
        this.expTypeId = expTypeId;
        this.expTypeName = expTypeName;
        this.simType = simType;
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public String getExpTypeName() {
        return expTypeName;
    }

    public void setExpTypeName(String expTypeName) {
        this.expTypeName = expTypeName;
    }
}
