package com.tlf.creatorconsumer.req;

public class CourseReq extends BaseReq {
    private String courseId;
    private String description;
    private String objectives;

    public CourseReq(String role, String accountId, String courseId, String description, String objectives) {
        super(role, accountId);
        this.courseId = courseId;
        this.description = description;
        this.objectives = objectives;
    }

    public CourseReq() {
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectives() {
        return objectives;
    }

    public void setObjectives(String objectives) {
        this.objectives = objectives;
    }
}
