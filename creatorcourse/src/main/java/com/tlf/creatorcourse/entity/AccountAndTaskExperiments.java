package com.tlf.creatorcourse.entity;


public class AccountAndTaskExperiments {

  private String id;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;
  private String accountId;
  private String taskExperimentId;
  private boolean completed;


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


  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }


  public String getTaskExperimentId() {
    return taskExperimentId;
  }

  public void setTaskExperimentId(String taskExperimentId) {
    this.taskExperimentId = taskExperimentId;
  }


  public boolean getCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

}
