package com.tlf.creatorconsumer.entity;

public class AnnexPO {

    private String id;
    private String name;
    private String type;
    private String path;
    private String stem;

    public AnnexPO() {
    }

    public AnnexPO(String id, String name, String type, String path, String stem) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.path = path;
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
