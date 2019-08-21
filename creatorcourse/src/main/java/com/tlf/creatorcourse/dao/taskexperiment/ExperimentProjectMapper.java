package com.tlf.creatorcourse.dao.taskexperiment;

import com.tlf.creatorcourse.entity.taskexperiment.ExperimentProject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ExperimentProjectMapper {

    int deleteByPrimaryKey(String id);

    int insert(ExperimentProject record);

    ExperimentProject selectBySimId(String simId,String taskExperimentId,String submitterId);

    ExperimentProject selectById(String id);

    int updateProjectTime(String id);

    int updateByPrimaryKey(ExperimentProject record);
}