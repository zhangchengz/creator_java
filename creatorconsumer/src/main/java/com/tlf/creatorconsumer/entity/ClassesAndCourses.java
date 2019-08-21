package com.tlf.creatorconsumer.entity;


public class ClassesAndCourses {

  private String id;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;
  private String classesId;
  private String coursesId;

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

  public String getClassesId() {
    return classesId;
  }

  public void setClassesId(String classesId) {
    this.classesId = classesId;
  }

  public String getCoursesId() {
    return coursesId;
  }

  public void setCoursesId(String coursesId) {
    this.coursesId = coursesId;
  }

}
