package com.tlf.creatoraccount.po;

import com.tlf.creatoraccount.pojo.Accounts;
import com.tlf.creatoraccount.pojo.Classes;

import java.util.List;

public class CoursePO {

    private String id;
    private String name;
    private List<Accounts> accounts;
    private List<Classes> classes;
    private String semester;

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

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
