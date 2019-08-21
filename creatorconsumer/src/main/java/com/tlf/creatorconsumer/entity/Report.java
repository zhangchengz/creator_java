package com.tlf.creatorconsumer.entity;

public class Report {
    private String id;
    private String stem;

    public Report(String id, String stem) {
        this.id = id;
        this.stem = stem;
    }

    public Report() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }
}
