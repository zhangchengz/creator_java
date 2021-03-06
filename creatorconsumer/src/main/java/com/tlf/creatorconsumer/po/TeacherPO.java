package com.tlf.creatorconsumer.po;

public class TeacherPO {

    private String id;
    private String phone;
    private String name;
    private String gender;
    private Integer age;
    private String email;
    private String role;

    public TeacherPO() {
    }

    public TeacherPO(String id, String phone, String name, String gender, Integer age, String email, String role) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.email = email;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
