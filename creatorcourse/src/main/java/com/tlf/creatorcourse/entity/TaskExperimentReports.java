package com.tlf.creatorcourse.entity;


import java.sql.Timestamp;

public class TaskExperimentReports {

  private String id;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;
  private String taskExperimentId;
  private String submitterId;
  private String resourceId;
  private Float score;
  private String comment;
  private String remark;
  private String annexId;
  private String projectId;
  private String status;

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

  public String getTaskExperimentId() {
    return taskExperimentId;
  }

  public void setTaskExperimentId(String taskExperimentId) {
    this.taskExperimentId = taskExperimentId;
  }

  public String getSubmitterId() {
    return submitterId;
  }

  public void setSubmitterId(String submitterId) {
    this.submitterId = submitterId;
  }

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId;
  }

  public Float getScore() {
    return score;
  }

  public void setScore(Float score) {
    this.score = score;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getAnnexId() {
    return annexId;
  }

  public void setAnnexId(String annexId) {
    this.annexId = annexId;
  }

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
