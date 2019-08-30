package com.tlf.creator.dao.curriculum.training;

import com.tlf.creator.entity.curriculum.training.TrainingModule;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TrainingModuleMapper {

    int deleteByPrimaryKey(String id);

    int insert(TrainingModule record);

    List<TrainingModule> selectAllVisible();

    TrainingModule selectAllNotVisible();

    TrainingModule selectByPrimaryKey(String id);

    int updateByPrimaryKey(TrainingModule record);
}