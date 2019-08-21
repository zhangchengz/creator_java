package com.tlf.creatorcourse.entity;

import java.sql.Timestamp;

public class TaskExperiments {

  private String id;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;
  private String templateId;
  private boolean innerr;
  private String masterId;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp finishTime;
  private Integer total;
  private Integer complete;
  private String annexId;
  private boolean completed;

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Timestamp getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
  }

  public String getTemplateId() {
    return templateId;
  }

  public void setTemplateId(String templateId) {
    this.templateId = templateId;
  }

  public boolean isInnerr() {
    return innerr;
  }

  public void setInnerr(boolean innerr) {
    this.innerr = innerr;
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

  public String getAnnexId() {
    return annexId;
  }

  public void setAnnexId(String annexId) {
    this.annexId = annexId;
  }
}
