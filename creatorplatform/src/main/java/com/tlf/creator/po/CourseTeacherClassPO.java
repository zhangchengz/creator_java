package com.tlf.creator.po;

import com.tlf.creator.entity.user.clazz.Classes;

import java.util.List;

public class CourseTeacherClassPO extends CourseTeacherPO {

    private List<Classes> classes;

    public CourseTeacherClassPO() {
    }

    public CourseTeacherClassPO(List<Classes> classes) {
        this.classes = classes;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }
}
