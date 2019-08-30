package com.tlf.creator.dao.curriculum.training;

import com.tlf.creator.entity.curriculum.training.TrainingFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TrainingFileMapper {

    int deleteByPrimaryKey(String id);

    int insert(TrainingFile record);

    TrainingFile selectByPrimaryKey(String id);

    List<TrainingFile> selectByTrainingId(String trainingId);

    int updateByPrimaryKey(TrainingFile record);

    int updateQuote(String id);

    List<TrainingFile> selectFileByTrainingInner();

    List<TrainingFile> selectFileByTrainingSelf(String creatorId);
}