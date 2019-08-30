package com.tlf.creator.po;

import java.io.Serializable;

public class OnlinePO implements Serializable {

    private String accountId;

    private String accountName;

    private Double onlineTime;

    public OnlinePO() {
    }

    public OnlinePO(String accountId, String accountName, Double onlineTime) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.onlineTime = onlineTime;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Double onlineTime) {
        this.onlineTime = onlineTime;
    }
}
