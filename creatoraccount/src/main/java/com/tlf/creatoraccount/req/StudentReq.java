package com.tlf.creatoraccount.req;

public class StudentReq extends PageReq {

    private String id;
    private String name;
    private String number;
    private String gender;
    private Integer age;
    private String phone;
    private String email;

    public StudentReq() {
    }

    public StudentReq(String id, String name, String number, String gender, Integer age, String phone, String email) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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
}
