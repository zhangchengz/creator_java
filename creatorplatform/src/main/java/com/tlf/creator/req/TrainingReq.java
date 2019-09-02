package com.tlf.creator.req;

import com.tlf.creator.dto.Description;
import com.tlf.creator.utils.ModeEnum;

import java.util.List;

public class TrainingReq extends PageReq{

    private String trainingId;
    private String trainingName;
    private String trainingModuleId;
    private String trainingTypeId;
    private String trainingSearch;
    private String creatorId;
    private boolean innerr;
    private ModeEnum mode;
    private List<Description> description;
    private List<String> guide;
    private List<String> annex;
    private List<String> material;
    private List<String> practiceSim;
    private List<String> report;
    private List<String> examSim;
    private String trainingModuleName;


    public String getTrainingModuleName() {
        return trainingModuleName;
    }

    public void setTrainingModuleName(String trainingModuleName) {
        this.trainingModuleName = trainingModuleName;
    }

    public void setDescription(List<Description> description) {
        this.description = description;
    }

    public List<String> getGuide() {
        return guide;
    }

    public void setGuide(List<String> guide) {
        this.guide = guide;
    }

    public List<String> getAnnex() {
        return annex;
    }

    public void setAnnex(List<String> annex) {
        this.annex = annex;
    }

    public List<String> getMaterial() {
        return material;
    }

    public void setMaterial(List<String> material) {
        this.material = material;
    }

    public List<String> getPracticeSim() {
        return practiceSim;
    }

    public void setPracticeSim(List<String> practiceSim) {
        this.practiceSim = practiceSim;
    }

    public List<String> getReport() {
        return report;
    }

    public void setReport(List<String> report) {
        this.report = report;
    }

    public List<String> getExamSim() {
        return examSim;
    }

    public void setExamSim(List<String> examSim) {
        this.examSim = examSim;
    }

    public List<Description> getDescription() {
        return description;
    }

    public void setDescriptions(List<Description> description) {
        this.description = description;
    }

    public ModeEnum getMode() {
        return mode;
    }

    public void setMode(ModeEnum mode) {
        this.mode = mode;
    }

    public boolean isInnerr() {
        return innerr;
    }

    public void setInnerr(boolean innerr) {
        this.innerr = innerr;
    }

    public String getTrainingSearch() {
        return trainingSearch;
    }

    public void setTrainingSearch(String trainingSearch) {
        this.trainingSearch = trainingSearch;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingModuleId() {
        return trainingModuleId;
    }

    public void setTrainingModuleId(String trainingModuleId) {
        this.trainingModuleId = trainingModuleId;
    }

    public String getTrainingTypeId() {
        return trainingTypeId;
    }

    public void setTrainingTypeId(String trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
    }
}
