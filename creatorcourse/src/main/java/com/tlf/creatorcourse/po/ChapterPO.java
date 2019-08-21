package com.tlf.creatorcourse.po;

import com.tlf.creatorcourse.entity.coursestudy.Unit;

import java.util.List;

public class ChapterPO {

    private String id;
    private String name;
    private Integer level;
    private List<Unit> units;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }
}
