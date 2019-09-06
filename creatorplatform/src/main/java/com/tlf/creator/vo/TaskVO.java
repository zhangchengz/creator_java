package com.tlf.creator.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 实验任务映射类
 *
 * @author zhangc
 * @date 2019/9/6
 */
public class TaskVO implements Serializable {

    private String id;
    private String trainingId;
    private String name;
    private Date startTime;
    private Date finishTime;
    private Integer total;
    private Integer complete;
    private Boolean teaching;
    private Boolean practice;
    private Boolean exam;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "TaskVO{" +
                "id='" + id + '\'' +
                ", trainingId='" + trainingId + '\'' +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", total=" + total +
                ", complete=" + complete +
                ", teaching=" + teaching +
                ", practice=" + practice +
                ", exam=" + exam +
                '}';
    }
}
