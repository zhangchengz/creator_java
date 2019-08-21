package com.tlf.creatorcourse.po;

import com.tlf.creatorcourse.entity.taskexperiment.TaskExperiments;

public class TaskMasterPO extends TaskExperiments {

    private String name;
    private String description;

    public TaskMasterPO() {
    }

    public TaskMasterPO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
