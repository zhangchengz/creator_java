package com.tlf.creator.req;

import com.tlf.creator.entity.curriculum.simulation.SimulationResource;

public class SimulationResourceReq extends SimulationResource {


    private String json;

    private String accountId;

    private String role;

    public SimulationResourceReq() {
    }

    public SimulationResourceReq(String json, String accountId, String role) {
        this.json = json;
        this.accountId = accountId;
        this.role = role;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
