package com.cubespace.relaying.common;

/**
 * 统一返回对象
 *
 * @author zhangc
 * @date 2019/9/10
 */
public class JsonResult {

    private int code;
    private String msg;
    private Object object;

    public JsonResult() {
    }

    public JsonResult(int code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

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
}
