package com.tlf.creator.po;

public class AnnexPO {

    private String id;
    private String name;
    private String typeName;
    private String simType;
    private String typeId;
    private String type;
    private String path;
    private String stem;
    private String expType;

    public AnnexPO() {
    }

    public AnnexPO(String id, String name, String typeName, String simType, String typeId, String type, String path, String stem, String expType) {
        this.id = id;
        this.name = name;
        this.typeName = typeName;
        this.simType = simType;
        this.typeId = typeId;
        this.type = type;
        this.path = path;
        this.stem = stem;
        this.expType = expType;
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getExpType() {
        return expType;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
