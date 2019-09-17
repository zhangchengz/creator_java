package com.cubespace.relaying.vo;

import java.io.Serializable;

/**
 * 返回用户信息实体类
 *
 * @author zhangc
 * @date 2019/9/10
 */
public class UserVO implements Serializable {

    private String id;
    private String token;
    private String number;

    public UserVO() {
    }

    public UserVO(String id, String token, String number) {
        this.id = id;
        this.token = token;
        this.number = number;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id='" + id + '\'' +
                ", token='" + token + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
