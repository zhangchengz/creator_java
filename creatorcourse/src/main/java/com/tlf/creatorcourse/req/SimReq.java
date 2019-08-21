package com.tlf.creatorcourse.req;

public class SimReq extends PageReq {

    private boolean inner;
    private String alias;

    public SimReq() {
    }

    public SimReq(boolean inner, String alias) {
        this.inner = inner;
        this.alias = alias;
    }

    public boolean isInner() {
        return inner;
    }

    public void setInner(boolean inner) {
        this.inner = inner;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
