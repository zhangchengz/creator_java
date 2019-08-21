package com.tlf.creatorcourse.dao.taskexperiment;

import com.tlf.creatorcourse.entity.taskexperiment.TaskScore;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaskScoreMapper {

    int deleteByPrimaryKey(String id);

    int insert(TaskScore record);

    TaskScore selectByPrimaryKey(String id);

    TaskScore selectByAccountAndTask(String accountId, String taskExperimentId);

    List<TaskScore> selectByTask(String taskExperimentId);

    int updateByAccountAndTask(TaskScore record);

    int completedTask(String accountId, String taskExperimentId);
}