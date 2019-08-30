package com.tlf.creator.service.curriculum.training;

import com.tlf.creator.entity.curriculum.training.TrainingFile;

import java.util.List;

public interface TrainingFileService {

    boolean deleteByPrimaryKey(String courseId,String id);

    boolean insert(String courseId,TrainingFile record);

    TrainingFile selectByPrimaryKey(String courseId,String id);

    List<TrainingFile> selectByTrainingId(String courseId,String trainingId);

    List<TrainingFile> selectByModuleId(String courseId,String moduleId);

    List<TrainingFile> selectByTrainingInner(String courseId);

    List<TrainingFile> selectByTrainingSelf(String courseId,String creatorId);

    boolean updateByPrimaryKey(String courseId,TrainingFile record);


}
