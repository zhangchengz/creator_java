package com.tlf.creatorcourse.req;

public class TaskScoreReq extends BaseReq{

    private String courseId;
    private String studentId;
    private String taskExperimentId;
    private Double score;
    private String comment;

    public TaskScoreReq() {
    }

    public TaskScoreReq(String courseId, String studentId, String taskExperimentId, Double score, String comment) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.taskExperimentId = taskExperimentId;
        this.score = score;
        this.comment = comment;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getTaskExperimentId() {
        return taskExperimentId;
    }

    public void setTaskExperimentId(String taskExperimentId) {
        this.taskExperimentId = taskExperimentId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
