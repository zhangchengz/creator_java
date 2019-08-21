package com.tlf.creatorcourse.po;

import java.io.Serializable;
import java.util.List;

public class TaskExperimentPO implements Serializable {

    private String taskExperimentId;
    private String name;
    private String description;
    private String reportId;
    private String reportName;
    private String reportPath;
    private String guideName;
    private String guidePath;
    private String reportTemName;
    private String reportTemPath;
    private Double score;
    private String comment;
    private List<AnnexPO> referAnnexs;
    private List<SimPO> simAnnexs;
    private List<AnnexPO> otherAnnexs;

    public TaskExperimentPO() {
    }

    public TaskExperimentPO(String taskExperimentId, String name, String description, String reportId, String reportName, String reportPath, String guideName, String guidePath, String reportTemName, String reportTemPath, Double score, String comment, List<AnnexPO> referAnnexs, List<SimPO> simAnnexs, List<AnnexPO> otherAnnexs) {
        this.taskExperimentId = taskExperimentId;
        this.name = name;
        this.description = description;
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportPath = reportPath;
        this.guideName = guideName;
        this.guidePath = guidePath;
        this.reportTemName = reportTemName;
        this.reportTemPath = reportTemPath;
        this.score = score;
        this.comment = comment;
        this.referAnnexs = referAnnexs;
        this.simAnnexs = simAnnexs;
        this.otherAnnexs = otherAnnexs;
    }

    public String getTaskExperimentId() {
        return taskExperimentId;
    }

    public void setTaskExperimentId(String taskExperimentId) {
        this.taskExperimentId = taskExperimentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getGuidePath() {
        return guidePath;
    }

    public void setGuidePath(String guidePath) {
        this.guidePath = guidePath;
    }

    public String getReportTemName() {
        return reportTemName;
    }

    public void setReportTemName(String reportTemName) {
        this.reportTemName = reportTemName;
    }

    public String getReportTemPath() {
        return reportTemPath;
    }

    public void setReportTemPath(String reportTemPath) {
        this.reportTemPath = reportTemPath;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<AnnexPO> getReferAnnexs() {
        return referAnnexs;
    }

    public void setReferAnnexs(List<AnnexPO> referAnnexs) {
        this.referAnnexs = referAnnexs;
    }

    public List<SimPO> getSimAnnexs() {
        return simAnnexs;
    }

    public void setSimAnnexs(List<SimPO> simAnnexs) {
        this.simAnnexs = simAnnexs;
    }

    public List<AnnexPO> getOtherAnnexs() {
        return otherAnnexs;
    }

    public void setOtherAnnexs(List<AnnexPO> otherAnnexs) {
        this.otherAnnexs = otherAnnexs;
    }
}
