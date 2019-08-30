package com.tlf.creator.dto;

import com.tlf.creator.entity.curriculum.training.TrainingFile;
import com.tlf.creator.po.TrainingSimPO;

import java.io.Serializable;
import java.util.List;

public class ExamMode implements Serializable {

    private List<Description> Descriptions;

    private List<TrainingFile> report;

    private List<TrainingSimPO> simExam;

    public ExamMode() {
    }

    public ExamMode(List<Description> descriptions, List<TrainingFile> report, List<TrainingSimPO> simExam) {
        Descriptions = descriptions;
        this.report = report;
        this.simExam = simExam;
    }

    public List<Description> getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(List<Description> Descriptions) {
        this.Descriptions = Descriptions;
    }

    public List<TrainingFile> getReport() {
        return report;
    }

    public void setReport(List<TrainingFile> report) {
        this.report = report;
    }

    public List<TrainingSimPO> getSimExam() {
        return simExam;
    }

    public void setSimExam(List<TrainingSimPO> simExam) {
        this.simExam = simExam;
    }
}
