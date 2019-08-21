package com.tlf.creatorcourse.req;

public class ResourceReq extends BaseReq {

    private String id;
    private String json;

    public ResourceReq() {
    }

    public ResourceReq(String id, String json) {
        this.id = id;
        this.json = json;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
