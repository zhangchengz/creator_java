package com.tlf.creatorcourse.po;

import java.sql.Timestamp;

public class ExperimentPO {
    private String id;
    private String name;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeAlias() {
        return typeAlias;
    }

    public void setTypeAlias(String typeAlias) {
        this.typeAlias = typeAlias;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getModeAlias() {
        return modeAlias;
    }

    public void setModeAlias(String modeAlias) {
        this.modeAlias = modeAlias;
    }

    private String typeAlias;
    private String mode;
    private String modeAlias;
    private Boolean inner;
    private String masterId;
    private Timestamp startTime;
    private Timestamp finishTime;
    private Integer total;
    private Integer complete;
    private String iconName;
    private String iconPath;
    private String status;

    public ExperimentPO(String id, String name, String type, String typeAlias, String mode, String modeAlias, Boolean inner, String masterId, Timestamp startTime, Timestamp finishTime, Integer total, Integer complete, String iconName, String iconPath, String status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.typeAlias = typeAlias;
        this.mode = mode;
        this.modeAlias = modeAlias;
        this.inner = inner;
        this.masterId = masterId;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.total = total;
        this.complete = complete;
        this.iconName = iconName;
        this.iconPath = iconPath;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public ExperimentPO() {
    }

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

    public Boolean getInner() {
        return inner;
    }

    public void setInner(Boolean inner) {
        this.inner = inner;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }
}
