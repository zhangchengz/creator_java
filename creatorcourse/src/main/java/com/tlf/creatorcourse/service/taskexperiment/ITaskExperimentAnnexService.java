package com.tlf.creatorcourse.service.taskexperiment;

import com.tlf.creatorcourse.entity.taskexperiment.ExperimentAnnex;

import java.util.List;

public interface ITaskExperimentAnnexService {

    boolean addSimulationAnnex(ExperimentAnnex experimentAnnex);
    boolean deleteById(String id);
    ExperimentAnnex selectById(String id);
    List<ExperimentAnnex> selectList(String taskExperimentId,String accountId);
}
