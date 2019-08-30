package com.tlf.creator.common;

public class JsonResult {

    private int code;

    private String msg;

    private Object length;

    private Object object;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getLength() {
        return length;
    }

    public void setLength(Object length) {
        this.length = length;
    }

    public JsonResult(int code, String msg, Object length, Object object) {
        this.code = code;
        this.msg = msg;
        this.length = length;
        this.object = object;
    }

    public JsonResult() {
    }
}
