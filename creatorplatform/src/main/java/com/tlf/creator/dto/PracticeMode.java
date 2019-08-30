package com.tlf.creator.dto;

import com.tlf.creator.entity.curriculum.simulation.SimulationResource;
import com.tlf.creator.entity.curriculum.training.TrainingFile;
import com.tlf.creator.po.TrainingSimPO;

import java.io.Serializable;
import java.util.List;

public class PracticeMode implements Serializable {

    private List<Description> Descriptions;

    private List<TrainingFile> material;

    private List<TrainingSimPO> simPractice;

    public PracticeMode() {
    }

    public PracticeMode(List<Description> descriptions, List<TrainingFile> material, List<TrainingSimPO> simPractice) {
        Descriptions = descriptions;
        this.material = material;
        this.simPractice = simPractice;
    }

    public List<Description> getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(List<Description> Descriptions) {
        this.Descriptions = Descriptions;
    }

    public List<TrainingFile> getMaterial() {
        return material;
    }

    public void setMaterial(List<TrainingFile> material) {
        this.material = material;
    }

    public List<TrainingSimPO> getSimPractice() {
        return simPractice;
    }

    public void setSimPractice(List<TrainingSimPO> simPractice) {
        this.simPractice = simPractice;
    }
}
