package com.tlf.creatorcourse.service.taskexperiment.impl;

import com.tlf.creatorcourse.dao.taskexperiment.ExperimentTypeMapper;
import com.tlf.creatorcourse.po.TaskPO;
import com.tlf.creatorcourse.entity.simulation.ExperimentTypes;
import com.tlf.creatorcourse.service.taskexperiment.IExperimentTypeService;
import com.tlf.creatorcourse.service.taskexperiment.ITaskExperimentProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperimentTypeServiceImpl implements IExperimentTypeService {

    @Autowired
    private ExperimentTypeMapper typeMapper;

    @Override
    public List<TaskPO> queryExperimentTypes() {
        List<ExperimentTypes> experimentTypes = typeMapper.queryExperimentTypes();
        List<TaskPO> list = new ArrayList<>();
        for(ExperimentTypes type:experimentTypes){
            TaskPO taskPO = new TaskPO();
            if(type!=null){
                taskPO.setId(type.getId());
                taskPO.setName(type.getName());
            }
            list.add(taskPO);
        }
        return list;
    }

    @Override
    public void addExperimentType(ExperimentTypes type) {
        typeMapper.addExperimentType(type);
    }

    @Override
    public ExperimentTypes selectByPrimaryKey(String id) {
        return typeMapper.queryExperimentTypeById(id);
    }
}
