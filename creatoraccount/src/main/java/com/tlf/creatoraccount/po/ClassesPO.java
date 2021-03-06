package com.tlf.creatoraccount.po;

import com.tlf.creatoraccount.pojo.Accounts;
import com.tlf.creatoraccount.pojo.Classes;

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
