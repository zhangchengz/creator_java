package com.tlf.creatorcourse.entity;


public class TaskExperimentProjects {

  private String id;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;
  private String taskExperimentId;
  private String submitterId;
  private String scenePath;
  private String simPath;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public java.sql.Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(java.sql.Timestamp createdAt) {
    this.createdAt = createdAt;
  }


  public java.sql.Timestamp getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(java.sql.Timestamp updatedAt) {
    this.updatedAt = updatedAt;
  }


  public java.sql.Timestamp getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(java.sql.Timestamp deletedAt) {
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


  public String getScenePath() {
    return scenePath;
  }

  public void setScenePath(String scenePath) {
    this.scenePath = scenePath;
  }


  public String getSimPath() {
    return simPath;
  }

  public void setSimPath(String simPath) {
    this.simPath = simPath;
  }

}
