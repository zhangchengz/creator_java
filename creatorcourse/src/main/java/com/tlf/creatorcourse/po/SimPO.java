package com.tlf.creatorcourse.po;

public class SimPO extends AnnexPO {

    private String projectId;
    private String projectName;
    private String scenePath;
    private String simPath;

    public SimPO() {
    }

    public SimPO(String projectId, String projectName, String scenePath, String simPath) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.scenePath = scenePath;
        this.simPath = simPath;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getScenePath() {
        return scenePath;
    }

    public void setScenePath(String scenePath) {
        this.scenePath = scenePath;
    }

    public String getSimPath() {
        return simPath;
    }

    public void setSimPath(String simPath) {
        this.simPath = simPath;
    }
}
