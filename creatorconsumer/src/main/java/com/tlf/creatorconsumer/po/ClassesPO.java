package com.tlf.creatorconsumer.po;



import com.tlf.creatorconsumer.entity.Accounts;
import com.tlf.creatorconsumer.entity.Classes;

import java.util.List;

public class ClassesPO extends Classes {

    private Integer length;
    private List<Accounts> students;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<Accounts> getStudents() {
        return students;
    }

    public void setStudents(List<Accounts> students) {
        this.students = students;
    }
}
