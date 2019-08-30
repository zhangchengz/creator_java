package com.tlf.creator.req;

import java.io.Serializable;

public class TrainingResourceReq implements Serializable {

    private String moduleId;
    private String trainingId;

    public TrainingResourceReq(String moduleId, String trainingId) {
        this.moduleId = moduleId;
        this.trainingId = trainingId;
    }

    public TrainingResourceReq() {
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }
}
