package com.tlf.creatorconsumer.resp;

import com.tlf.creatorconsumer.entity.Accounts;

public class AccountResp {

    private String token;
    private Accounts account;

    public AccountResp() {
    }

    public AccountResp(String token, Accounts account) {
        this.token = token;
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }
}
