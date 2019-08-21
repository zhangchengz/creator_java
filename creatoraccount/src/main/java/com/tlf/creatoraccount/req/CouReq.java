package com.tlf.creatoraccount.req;

import java.util.List;

public class CouReq extends PageReq {
    private String id;
    private String courseId;
    private List<String> classId;
    private String semester;
    private String teacherId;

    public CouReq() {
    }

    public CouReq(String id, String courseId, List<String> classId, String semester, String teacherId) {
        this.id = id;
        this.courseId = courseId;
        this.classId = classId;
        this.semester = semester;
        this.teacherId = teacherId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public List<String> getClassId() {
        return classId;
    }

    public void setClassId(List<String> classId) {
        this.classId = classId;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
