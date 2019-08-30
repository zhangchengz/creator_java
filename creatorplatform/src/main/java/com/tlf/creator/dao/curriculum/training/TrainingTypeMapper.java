package com.tlf.creator.dao.curriculum.training;

import com.tlf.creator.entity.curriculum.training.TrainingType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TrainingTypeMapper {

    int deleteByPrimaryKey(String id);

    int insert(TrainingType record);

    List<TrainingType> selectAllTypes();

    TrainingType selectByPrimaryKey(String id);

    int updateByPrimaryKey(TrainingType record);
}