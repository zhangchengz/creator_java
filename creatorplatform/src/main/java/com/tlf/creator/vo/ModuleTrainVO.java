package com.tlf.creator.vo;

import com.tlf.creator.entity.curriculum.training.Training;

import java.io.Serializable;
import java.util.List;

public class ModuleTrainVO implements Serializable {

   private String moduleId;

   private String moduleName;

   private List<Training> trainings;

    public ModuleTrainVO() {
    }

    public ModuleTrainVO(String moduleId, String moduleName, List<Training> trainings) {
        this.moduleId = moduleId;
        this.moduleName = moduleName;
        this.trainings = trainings;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }
}
