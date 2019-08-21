package com.tlf.creatorcourse.service.taskexperiment;

import com.tlf.creatorcourse.entity.taskexperiment.AccountAndTaskExperiments;
import com.tlf.creatorcourse.entity.taskexperiment.TaskScore;
import com.tlf.creatorcourse.po.*;
import com.tlf.creatorcourse.entity.simulation.ExperimentTypes;
import com.tlf.creatorcourse.entity.resource.Resources;
import com.tlf.creatorcourse.entity.taskexperiment.TaskExperiments;

import java.util.List;

public interface ITaskExperimentService {

    List<TaskMasterPO> selectTaskExperimentsByMasterId(Boolean completed, String masterId, Integer offset, Integer limit);

    Integer selectCountByMaster(Boolean completed, String masterId);

    TaskExperiments selectTaskExperimentsById(String id);

    boolean addTaskExperiments(TaskExperiments taskExperiment, List<AccountAndTaskExperiments> list, List<TaskScore> scoreList);

    boolean stopTaskExperiments(String id);

    boolean deleteTaskExperiments(String id);

    boolean updateComplete(String id);

    List<TaskStudentPO> selectByStudent(String accountId, Integer offset, Integer limit);

    Integer selectCountByStudent(String accountId);

    TaskExperimentPO selectExperimentDetails(String taskExperimentId, String accountId);

    void stopTaskAutomatic();
}
