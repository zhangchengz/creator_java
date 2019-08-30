package com.tlf.creator.po;

public class TaskPO {

    String name;
    String id;

    public TaskPO(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public TaskPO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
