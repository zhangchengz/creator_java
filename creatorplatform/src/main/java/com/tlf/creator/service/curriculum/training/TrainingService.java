package com.tlf.creator.service.curriculum.training;

import com.tlf.creator.entity.curriculum.training.Training;
import com.tlf.creator.entity.curriculum.training.TrainingType;
import com.tlf.creator.req.TrainingReq;
import com.tlf.creator.vo.ModuleTrainVO;
import com.tlf.creator.vo.TrainingVO;

import java.util.List;

public interface TrainingService {

    boolean deleteByPrimaryKey(String courseId, String id);

    List<Training> selectTrainingInner(String courseId, TrainingReq req);

    int selectCountInner(String courseId, TrainingReq req);

    List<Training> selectTrainingByTeacher(String courseId, TrainingReq req);

    int selectCountSelf(String courseId, TrainingReq req);

    boolean insert(String courseId, Training record);

    TrainingVO selectByPrimaryKey(String courseId, String id);

    boolean updateByPrimaryKey(String courseId, TrainingReq req);

    List<ModuleTrainVO> selectModuleAndTraining(String courseId);

    List<Training> selectAllTrainingByTeacher(String courseId, String creatorId);

    List<TrainingType> selectTrainingType(String courseId);

}
