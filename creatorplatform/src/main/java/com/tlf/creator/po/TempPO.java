package com.tlf.creator.po;

import java.io.Serializable;
import java.util.List;

public class TempPO implements Serializable {

    private String name;
    private String description;
    private String guideId;
    private String guideName;
    private String guidePath;
    private String guideStem;
    private String reportId;
    private String reportName;
    private String reportPath;
    private String reportStem;
    private List<AnnexPO> simulations;
    private List<AnnexPO> annexs;

    public TempPO() {
    }

    public TempPO(String name, String description, String guideId, String guideName, String guidePath, String guideStem, String reportId, String reportName, String reportPath, String reportStem, List<AnnexPO> simulations, List<AnnexPO> annexs) {
        this.name = name;
        this.description = description;
        this.guideId = guideId;
        this.guideName = guideName;
        this.guidePath = guidePath;
        this.guideStem = guideStem;
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportPath = reportPath;
        this.reportStem = reportStem;
        this.simulations = simulations;
        this.annexs = annexs;
    }

    public String getGuideStem() {
        return guideStem;
    }

    public void setGuideStem(String guideStem) {
        this.guideStem = guideStem;
    }

    public String getReportStem() {
        return reportStem;
    }

    public void setReportStem(String reportStem) {
        this.reportStem = reportStem;
    }

    public String getGuideId() {
        return guideId;
    }

    public void setGuideId(String guideId) {
        this.guideId = guideId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
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

    public List<AnnexPO> getSimulations() {
        return simulations;
    }

    public void setSimulations(List<AnnexPO> simulations) {
        this.simulations = simulations;
    }

    public List<AnnexPO> getAnnexs() {
        return annexs;
    }

    public void setAnnexs(List<AnnexPO> annexs) {
        this.annexs = annexs;
    }
}
