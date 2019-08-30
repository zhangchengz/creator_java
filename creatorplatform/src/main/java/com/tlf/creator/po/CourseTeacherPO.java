package com.tlf.creator.po;

import java.io.Serializable;

public class CourseTeacherPO implements Serializable {

    private String id;
    private String course;
    private String name;
    private String courseId;
    private String teacherId;
    private String classId;
    private String semester;

    public CourseTeacherPO() {
    }

    public CourseTeacherPO(String id, String course, String name, String courseId, String teacherId, String classId, String semester) {
        this.id = id;
        this.course = course;
        this.name = name;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.classId = classId;
        this.semester = semester;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }
}
