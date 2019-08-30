package com.tlf.creator.po;

import java.sql.Timestamp;

public class ProjectPO {

    private String name;
    private String id;
    private java.sql.Timestamp created_at;
    private java.sql.Timestamp updated_at;
    private java.sql.Timestamp deleted_at;
    private String task_experiment_id;
    private String submitter_id;
    private String scene_path;
    private String sim_path;

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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }

    public String getTask_experiment_id() {
        return task_experiment_id;
    }

    public void setTask_experiment_id(String task_experiment_id) {
        this.task_experiment_id = task_experiment_id;
    }

    public String getSubmitter_id() {
        return submitter_id;
    }

    public void setSubmitter_id(String submitter_id) {
        this.submitter_id = submitter_id;
    }

    public String getScene_path() {
        return scene_path;
    }

    public void setScene_path(String scene_path) {
        this.scene_path = scene_path;
    }

    public String getSim_path() {
        return sim_path;
    }

    public void setSim_path(String sim_path) {
        this.sim_path = sim_path;
    }
}
