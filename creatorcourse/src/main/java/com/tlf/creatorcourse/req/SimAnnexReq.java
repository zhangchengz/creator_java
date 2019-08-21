package com.tlf.creatorcourse.req;

public class SimAnnexReq extends BaseReq{

    private String taskExperimentId;
    private String annexId;
    private String name;
    private String type;
    private String expType;
    private String json;

    public String getTaskExperimentId() {
        return taskExperimentId;
    }

    public void setTaskExperimentId(String taskExperimentId) {
        this.taskExperimentId = taskExperimentId;
    }

    public String getAnnexId() {
        return annexId;
    }

    public void setAnnexId(String annexId) {
        this.annexId = annexId;
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

    public String getExpType() {
        return expType;
    }

    public void setExpType(String expType) {
        this.expType = expType;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
