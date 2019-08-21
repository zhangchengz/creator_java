package com.tlf.creatorcourse.service.taskexperiment;

import com.tlf.creatorcourse.entity.taskexperiment.TaskScore;

import java.util.List;

public interface ITaskScoreService {

    boolean insert(TaskScore record);

    boolean updateByAccountAndTask(TaskScore record);

    TaskScore selectByAccountAndTask(String accountId, String taskExperimentId);

    boolean completedTask(String accountId, String taskExperimentId);

    List<TaskScore> selectByTask(String taskExperimentId);

}
