package com.tlf.creator.vo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author zhangc
 * @date 2019/9/6
 */
public class AccountTaskVO implements Serializable {

    private String accountTaskId;
    private String statu;
    private Date startTime;
    private Date finishTime;
    private String name;
    private String taskId;
    private String trainingId;
    private String masterId;
    private Boolean teaching;
    private Boolean practice;
    private Boolean exam;
    private Boolean completed;

    public String getAccountTaskId() {
        return accountTaskId;
    }

    public void setAccountTaskId(String accountTaskId) {
        this.accountTaskId = accountTaskId;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public Boolean getTeaching() {
        return teaching;
    }

    public void setTeaching(Boolean teaching) {
        this.teaching = teaching;
    }

    public Boolean getPractice() {
        return practice;
    }

    public void setPractice(Boolean practice) {
        this.practice = practice;
    }

    public Boolean getExam() {
        return exam;
    }

    public void setExam(Boolean exam) {
        this.exam = exam;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "AccountTaskVO{" +
                "accountTaskId='" + accountTaskId + '\'' +
                ", statu='" + statu + '\'' +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", name='" + name + '\'' +
                ", taskId='" + taskId + '\'' +
                ", trainingId='" + trainingId + '\'' +
                ", masterId='" + masterId + '\'' +
                ", teaching=" + teaching +
                ", practice=" + practice +
                ", exam=" + exam +
                ", completed=" + completed +
                '}';
    }
}
