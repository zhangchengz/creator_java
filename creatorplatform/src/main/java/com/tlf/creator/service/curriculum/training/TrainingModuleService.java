package com.tlf.creator.service.curriculum.training;

import com.tlf.creator.entity.curriculum.training.TrainingModule;

import java.util.List;

public interface TrainingModuleService {

    boolean deleteByPrimaryKey(String courseId,String id);

    boolean insert(String courseId,TrainingModule record);

    List<TrainingModule> selectAllVisible(String courseId);
}
