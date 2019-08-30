package com.tlf.creator.req;

public class LoginReq {

    private String phone;
    private String password;

    public LoginReq() {
    }

    public LoginReq(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
