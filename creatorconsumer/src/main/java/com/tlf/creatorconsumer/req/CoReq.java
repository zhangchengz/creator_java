package com.tlf.creatorconsumer.req;

public class CoReq extends BaseReq {

    private String courseId;

    public CoReq() {
    }

    public CoReq(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}
