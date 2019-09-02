package com.tlf.creator.dao.curriculum.training;

import com.tlf.creator.entity.curriculum.training.Training;
import com.tlf.creator.req.TrainingReq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TrainingMapper {

    int deleteByPrimaryKey(String id);

    List<Training> selectTrainingInner(TrainingReq req);

    int selectCountInner(TrainingReq req);

    int updateTime(String id);

    int updateTrainingModule(String moduleId,String id);

    List<Training> selectTrainingByTeacher(TrainingReq req);

    List<Training> selectByModule(String moduleId);

    List<Training> selectByModuleAndCreator(String moduleId,String creatorId);

    int selectCountSelf(TrainingReq req);

    int insert(Training record);

    Training selectByPrimaryKey(String id);

    int updateByPrimaryKey(Training record);

}