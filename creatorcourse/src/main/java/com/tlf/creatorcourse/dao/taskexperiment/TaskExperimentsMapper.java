package com.tlf.creatorcourse.dao.taskexperiment;

import com.tlf.creatorcourse.entity.taskexperiment.TaskExperiments;
import com.tlf.creatorcourse.po.TaskMasterPO;
import com.tlf.creatorcourse.po.TaskStudentPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TaskExperimentsMapper {

    int deleteByPrimaryKey(String id);

    int insert(TaskExperiments record);

    int updateComplete(String id);

    List<TaskMasterPO> selectByMaster(Boolean completed, String masterId, Integer offset, Integer limit);

    List<TaskStudentPO> selectByStudent(String accountId, Integer offset, Integer limit);

    Integer selectCountByMaster(Boolean completed, String masterId);

    Integer selectCountByStudent(String accountId);

    Integer stopTaskExperiment(String id);

    Integer deleteTaskExperiment(String id);

    TaskExperiments selectByPrimaryKey(String id);

    int updateByPrimaryKey(TaskExperiments record);

    int timedTaskExperiment(String eventName, String startTime, String taskId);

    int timedTaskExperiment1(String eventName, String startTime, String taskId);

    List<String> selectExpiredTask();
}