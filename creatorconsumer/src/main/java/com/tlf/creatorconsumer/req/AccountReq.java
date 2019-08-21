package com.tlf.creatorconsumer.req;

public class AccountReq extends BaseReq{

    private String phone;
    private String userId;
    private String password;
    private String newPassword;

    public AccountReq() {
    }

    public AccountReq(String phone, String userId, String password, String newPassword) {
        this.phone = phone;
        this.userId = userId;
        this.password = password;
        this.newPassword = newPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
