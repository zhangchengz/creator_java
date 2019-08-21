package com.tlf.creatoraccount.pojo;

public class Online {
    private String id;

    private String accountId;

    private Double onlineTime;

    private Long login;

    private Long logout;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    public Double getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Double onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Long getLogin() {
        return login;
    }

    public void setLogin(Long login) {
        this.login = login;
    }

    public Long getLogout() {
        return logout;
    }

    public void setLogout(Long logout) {
        this.logout = logout;
    }
}