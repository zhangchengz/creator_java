package com.tlf.creator.entity.curriculum.resource;


import java.sql.Timestamp;

public class Resources {

  private String id;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;
  private java.sql.Timestamp deletedAt;
  private String creatorId;
  private String resourceTypeId;
  private String name;
  private String path;


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


  public String getCreatorId() {
    return creatorId;
  }

  public void setCreatorId(String creatorId) {
    this.creatorId = creatorId;
  }


  public String getResourceTypeId() {
    return resourceTypeId;
  }

  public void setResourceTypeId(String resourceTypeId) {
    this.resourceTypeId = resourceTypeId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Resources(String id, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt, String creatorId, String resourceTypeId, String name, String path) {
    this.id = id;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
    this.creatorId = creatorId;
    this.resourceTypeId = resourceTypeId;
    this.name = name;
    this.path = path;
  }

  public Resources() {
  }
}
