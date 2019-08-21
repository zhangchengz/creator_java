package com.tlf.creatorcourse.service.taskexperiment.impl;

import com.tlf.creatorcourse.dao.taskexperiment.TaskScoreMapper;
import com.tlf.creatorcourse.entity.taskexperiment.TaskScore;
import com.tlf.creatorcourse.service.taskexperiment.ITaskScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskScoreServiceImpl implements ITaskScoreService {

    @Autowired
    private TaskScoreMapper scoreMapper;

    @Override
    public boolean insert(TaskScore record) {
        int insert = scoreMapper.insert(record);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByAccountAndTask(TaskScore record) {
        int update = scoreMapper.updateByAccountAndTask(record);
        if (update > 0) {
            return true;
        }
        return false;
    }

    @Override
    public TaskScore selectByAccountAndTask(String accountId, String taskExperimentId) {
        return scoreMapper.selectByAccountAndTask(accountId,taskExperimentId);
    }

    @Override
    public boolean completedTask(String accountId, String taskExperimentId) {
        int i = scoreMapper.completedTask(accountId, taskExperimentId);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<TaskScore> selectByTask(String taskExperimentId) {
        List<TaskScore> taskScores = scoreMapper.selectByTask(taskExperimentId);
        return taskScores;
    }
}
