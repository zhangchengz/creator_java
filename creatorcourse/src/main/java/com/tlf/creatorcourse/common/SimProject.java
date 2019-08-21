package com.tlf.creatorcourse.common;

import java.io.Serializable;

public class SimProject implements Serializable {

    private String simId;
    private String projectId;

    public SimProject() {
    }

    public SimProject(String simId, String projectId) {
        this.simId = simId;
        this.projectId = projectId;
    }

    public String getSimId() {
        return simId;
    }

    public void setSimId(String simId) {
        this.simId = simId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
