package com.cubespace.relaying.po;

import java.io.Serializable;
import java.util.List;

/**
 * controller接收前端参数实体类
 *
 * @author zhangc
 * @date 2019/9/10
 */
public class UserPO implements Serializable {

    private String number;
    private String password;
    private String newPassword;
    private String id;
    private String token;
    private List<String> userIds;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}
