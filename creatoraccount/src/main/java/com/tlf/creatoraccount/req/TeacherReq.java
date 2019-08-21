package com.tlf.creatoraccount.req;

public class TeacherReq extends PageReq{
    private String id;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private Integer age;

    public TeacherReq() {
    }

    public TeacherReq(String id, String name, String gender, String phone, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.age = age;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
