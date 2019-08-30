package com.tlf.creator.service.curriculum.training.impl;

import com.tlf.creator.config.DS;
import com.tlf.creator.dao.curriculum.training.TrainingModuleMapper;
import com.tlf.creator.entity.curriculum.training.TrainingModule;
import com.tlf.creator.service.curriculum.training.TrainingModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingModuleServiceImpl implements TrainingModuleService {

    @Autowired
    private TrainingModuleMapper moduleMapper;

    @Override
    @DS
    public boolean deleteByPrimaryKey(String courseId,String id) {
        int delete = moduleMapper.deleteByPrimaryKey(id);
        if(delete>0){
            return true;
        }
        return false;
    }

    @Override
    @DS
    public boolean insert(String courseId,TrainingModule record) {
        int insert = moduleMapper.insert(record);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    @DS
    public List<TrainingModule> selectAllVisible(String courseId) {
        List<TrainingModule> trainingModules = moduleMapper.selectAllVisible();
        return trainingModules;
    }
}
