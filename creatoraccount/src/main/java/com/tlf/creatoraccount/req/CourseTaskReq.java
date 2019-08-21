package com.tlf.creatoraccount.req;

public class CourseTaskReq extends BaseReq {

    private String courseId;

    public CourseTaskReq() {
    }

    public CourseTaskReq(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
