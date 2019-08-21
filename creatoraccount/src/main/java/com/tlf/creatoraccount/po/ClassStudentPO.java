package com.tlf.creatoraccount.po;

import java.io.Serializable;

public class ClassStudentPO implements Serializable {

    private String id;
    private String name;
    private String classesId;
    private String coursesId;
    private String className;

    public ClassStudentPO() {
    }

    public ClassStudentPO(String id, String name, String classesId, String coursesId, String className) {
        this.id = id;
        this.name = name;
        this.classesId = classesId;
        this.coursesId = coursesId;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassesId() {
        return classesId;
    }

    public void setClassesId(String classesId) {
        this.classesId = classesId;
    }

    public String getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(String coursesId) {
        this.coursesId = coursesId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
