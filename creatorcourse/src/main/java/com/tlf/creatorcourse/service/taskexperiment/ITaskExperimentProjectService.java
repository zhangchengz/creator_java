package com.tlf.creatorcourse.service.taskexperiment;

import com.tlf.creatorcourse.entity.taskexperiment.ExperimentProject;

public interface ITaskExperimentProjectService {

    ExperimentProject selectExperimentProjectById(String id);

    ExperimentProject selectExperimentProjectBySimId(String taskExperimentId, String accountId, String simId);

    boolean insertExperimentProject(ExperimentProject project);

    boolean updateProjectTime(String id);

}
