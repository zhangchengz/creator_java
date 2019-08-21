package com.tlf.creatorconsumer.entity;

public class TaskStudentPO extends TaskExperiments {

    private String accountId;
    private String statu;
    private String name;

    public TaskStudentPO() {
    }

    public TaskStudentPO(String accountId, String statu, String name) {
        this.accountId = accountId;
        this.statu = statu;
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
