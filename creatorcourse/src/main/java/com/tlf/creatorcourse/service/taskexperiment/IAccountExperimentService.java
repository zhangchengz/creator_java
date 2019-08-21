package com.tlf.creatorcourse.service.taskexperiment;

import com.tlf.creatorcourse.entity.taskexperiment.AccountAndTaskExperiments;

import java.util.List;

public interface IAccountExperimentService {

    AccountAndTaskExperiments selectByAccountAndTaskExperiment(String accountId, String taskExperimentId);
    List<AccountAndTaskExperiments> selectAccountByTask(String taskExperimentId);
    boolean updateStatu(String statu,String accountId, String taskExperimentId);
}
