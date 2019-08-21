package com.tlf.creatorcourse.service.taskexperiment;

import com.tlf.creatorcourse.entity.simulation.ExperimentTypes;
import com.tlf.creatorcourse.po.TaskPO;

import java.util.List;

public interface IExperimentTypeService {

    List<TaskPO> queryExperimentTypes();

    void addExperimentType(ExperimentTypes type);

    ExperimentTypes selectByPrimaryKey(String id);
}
