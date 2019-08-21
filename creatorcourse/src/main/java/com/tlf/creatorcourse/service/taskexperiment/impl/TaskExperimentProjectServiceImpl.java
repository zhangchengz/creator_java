package com.tlf.creatorcourse.service.taskexperiment.impl;

import com.tlf.creatorcourse.dao.taskexperiment.ExperimentProjectMapper;
import com.tlf.creatorcourse.entity.taskexperiment.ExperimentProject;
import com.tlf.creatorcourse.service.taskexperiment.ITaskExperimentProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskExperimentProjectServiceImpl implements ITaskExperimentProjectService {

    @Autowired
    private ExperimentProjectMapper projectMapper;

    @Override
    public ExperimentProject selectExperimentProjectById(String id) {
        return projectMapper.selectById(id);
    }

    @Override
    public ExperimentProject selectExperimentProjectBySimId(String taskExperimentId, String accountId, String simId) {
        return projectMapper.selectBySimId(simId,taskExperimentId,accountId);
    }

    @Override
    public boolean insertExperimentProject(ExperimentProject project) {
        int insert = projectMapper.insert(project);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateProjectTime(String id) {
        int update = projectMapper.updateProjectTime(id);
        if(update>0){
            return true;
        }
        return false;
    }
}
