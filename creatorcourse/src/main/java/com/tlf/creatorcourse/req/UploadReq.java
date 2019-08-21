package com.tlf.creatorcourse.req;

public class UploadReq extends BaseReq{

    private byte[] file;
    private String type;
    private String name;

    public UploadReq() {
    }

    public UploadReq(byte[] file, String type, String name) {
        this.file = file;
        this.type = type;
        this.name = name;
    }

    public UploadReq(String role, String accountId) {
        super(role, accountId);
    }

    public UploadReq(String role, String accountId, byte[] file, String type, String name) {
        super(role, accountId);
        this.file = file;
        this.type = type;
        this.name = name;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
