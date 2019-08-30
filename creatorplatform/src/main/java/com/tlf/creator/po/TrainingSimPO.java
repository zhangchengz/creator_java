package com.tlf.creator.po;

import java.io.Serializable;

public class TrainingSimPO implements Serializable {

    private String id;

    private String trainingId;

    private String simId;

    private String mode;

    private String typeName;

    private String alias;

    private String path;

    private String simName;

    public TrainingSimPO() {
    }

    public TrainingSimPO(String id, String trainingId, String simId, String mode, String typeName, String alias, String path, String simName) {
        this.id = id;
        this.trainingId = trainingId;
        this.simId = simId;
        this.mode = mode;
        this.typeName = typeName;
        this.alias = alias;
        this.path = path;
        this.simName = simName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public String getSimId() {
        return simId;
    }

    public void setSimId(String simId) {
        this.simId = simId;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSimName() {
        return simName;
    }

    public void setSimName(String simName) {
        this.simName = simName;
    }
}
