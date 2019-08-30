package com.tlf.creator.po;

import java.io.Serializable;

public class ClassCoursePO implements Serializable {

    private String name;
    private String classesId;
    private String coursesId;

    public ClassCoursePO() {
    }

    public ClassCoursePO(String name, String classesId, String coursesId) {
        this.name = name;
        this.classesId = classesId;
        this.coursesId = coursesId;
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
}
