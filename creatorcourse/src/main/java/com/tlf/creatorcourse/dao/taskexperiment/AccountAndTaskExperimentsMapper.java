package com.tlf.creatorcourse.dao.taskexperiment;

import com.tlf.creatorcourse.entity.taskexperiment.AccountAndTaskExperiments;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountAndTaskExperimentsMapper {
    int deleteByPrimaryKey(String id);

    int insert(AccountAndTaskExperiments record);

    AccountAndTaskExperiments selectByPrimaryKey(String id);

    List<AccountAndTaskExperiments> selectByTaskId(String taskExperimentId);

    AccountAndTaskExperiments selectByTaskAndAccountId(String accountId, String taskExperimentId);

    int updateStatu(String statu,String accountId, String taskExperimentId);

    AccountAndTaskExperiments selectByAccountAndTaskExperiment(String accountId, String taskExperimentId);

    int updateByPrimaryKey(AccountAndTaskExperiments record);

    int updateStatuStop(String taskExperimentId);

}