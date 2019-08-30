package com.tlf.creator.req;

public class GradeReq extends  BaseReq{

    private String classId;
    private String taskExperimentId;

    public GradeReq() {
    }

    public GradeReq(String classId, String taskExperimentId) {
        this.classId = classId;
        this.taskExperimentId = taskExperimentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getTaskExperimentId() {
        return taskExperimentId;
    }

    public void setTaskExperimentId(String taskExperimentId) {
        this.taskExperimentId = taskExperimentId;
    }
}
