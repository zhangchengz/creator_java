package com.cubespace.relaying.vo;

public class StudentVO {

    private Integer index;
    private String number;
    private String id;

    public StudentVO() {
    }

    public StudentVO(Integer index, String number, String id) {
        this.index = index;
        this.number = number;
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
