package com.tlf.creatoraccount.req;

import java.util.List;

public class ClassReq extends BaseReq{

    private String id;
    private String major;
    private String startYear;
    private String name;
    private List<String> students;
    private List<String> addStudents;
    private List<String> deleteStudents;

    public ClassReq() {
    }

    public ClassReq(String id, String major, String startYear, String name, List<String> students, List<String> addStudents, List<String> deleteStudents) {
        this.id = id;
        this.major = major;
        this.startYear = startYear;
        this.name = name;
        this.students = students;
        this.addStudents = addStudents;
        this.deleteStudents = deleteStudents;
    }

    public ClassReq(String role, String accountId) {
        super(role, accountId);
    }

    public ClassReq(String role, String accountId, String id, String major, String startYear, String name, List<String> students, List<String> addStudents, List<String> deleteStudents) {
        super(role, accountId);
        this.id = id;
        this.major = major;
        this.startYear = startYear;
        this.name = name;
        this.students = students;
        this.addStudents = addStudents;
        this.deleteStudents = deleteStudents;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public List<String> getAddStudents() {
        return addStudents;
    }

    public void setAddStudents(List<String> addStudents) {
        this.addStudents = addStudents;
    }

    public List<String> getDeleteStudents() {
        return deleteStudents;
    }

    public void setDeleteStudents(List<String> deleteStudents) {
        this.deleteStudents = deleteStudents;
    }
}
