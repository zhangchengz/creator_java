package com.tlf.creator.dto;

import com.tlf.creator.entity.curriculum.training.TrainingFile;

import java.io.Serializable;
import java.util.List;

public class TeachMode implements Serializable {

    private List<Description> Descriptions;

    private List<TrainingFile> guide;

    private List<TrainingFile> annex;

    public TeachMode() {
    }

    public TeachMode(List<Description> Descriptions, List<TrainingFile> guide, List<TrainingFile> annex) {
        this.Descriptions = Descriptions;
        this.guide = guide;
        this.annex = annex;
    }

    public List<Description> getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(List<Description> Descriptions) {
        this.Descriptions = Descriptions;
    }

    public List<TrainingFile> getGuide() {
        return guide;
    }

    public void setGuide(List<TrainingFile> guide) {
        this.guide = guide;
    }

    public List<TrainingFile> getAnnex() {
        return annex;
    }

    public void setAnnex(List<TrainingFile> annex) {
        this.annex = annex;
    }
}
