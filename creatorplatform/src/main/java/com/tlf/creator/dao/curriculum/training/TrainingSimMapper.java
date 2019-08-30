package com.tlf.creator.dao.curriculum.training;

import com.tlf.creator.entity.curriculum.training.TrainingSim;
import com.tlf.creator.po.TrainingSimPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TrainingSimMapper {

    int deleteByPrimaryKey(String id);

    int insert(TrainingSim record);

    List<TrainingSimPO> selectByTrainingId(String trainingId);

    int deleteByTrainingAndSim(String trainingId,String simId);

    TrainingSim selectByPrimaryKey(String id);

    int bulkInsert(List<TrainingSim> trainingSimList);

    int updateByPrimaryKey(TrainingSim record);
}