package com.tlf.creatorconsumer.req;

public class TaskUploadReq extends UploadReq {

    private String taskExperimentId;

    public TaskUploadReq() {
    }

    public TaskUploadReq(String taskExperimentId) {
        this.taskExperimentId = taskExperimentId;
    }

    public String getTaskExperimentId() {
        return taskExperimentId;
    }

    public void setTaskExperimentId(String taskExperimentId) {
        this.taskExperimentId = taskExperimentId;
    }
}
