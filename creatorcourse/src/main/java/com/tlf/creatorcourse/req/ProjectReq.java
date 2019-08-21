package com.tlf.creatorcourse.req;

public class ProjectReq extends BaseReq{

    private String taskExperimentId;
    private String sceneId;
    private String sceneJson;
    private String simJson;

    public ProjectReq() {
    }

    public ProjectReq(String taskExperimentId, String sceneId, String sceneJson, String simJson) {
        this.taskExperimentId = taskExperimentId;
        this.sceneId = sceneId;
        this.sceneJson = sceneJson;
        this.simJson = simJson;
    }

    public String getTaskExperimentId() {
        return taskExperimentId;
    }

    public void setTaskExperimentId(String taskExperimentId) {
        this.taskExperimentId = taskExperimentId;
    }

    public String getSceneId() {
        return sceneId;
    }

    public void setSceneId(String sceneId) {
        this.sceneId = sceneId;
    }

    public String getSceneJson() {
        return sceneJson;
    }

    public void setSceneJson(String sceneJson) {
        this.sceneJson = sceneJson;
    }

    public String getSimJson() {
        return simJson;
    }

    public void setSimJson(String simJson) {
        this.simJson = simJson;
    }
}
