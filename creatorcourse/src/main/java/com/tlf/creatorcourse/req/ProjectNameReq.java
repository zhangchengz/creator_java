package com.tlf.creatorcourse.req;

public class ProjectNameReq extends BaseReq {
    private String id;

    public ProjectNameReq() {
    }

    public ProjectNameReq(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
