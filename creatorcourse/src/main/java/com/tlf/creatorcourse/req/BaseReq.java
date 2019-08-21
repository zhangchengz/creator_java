package com.tlf.creatorcourse.req;

import java.io.Serializable;

public class BaseReq implements Serializable {
    private String role;
    private String accountId;

    public BaseReq() {
    }

    public BaseReq(String role, String accountId) {
        this.role = role;
        this.accountId = accountId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
