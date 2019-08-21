package com.tlf.creatorcourse.service.taskexperiment.impl;

import com.tlf.creatorcourse.dao.taskexperiment.AccountAndTaskExperimentsMapper;
import com.tlf.creatorcourse.entity.taskexperiment.AccountAndTaskExperiments;
import com.tlf.creatorcourse.service.taskexperiment.IAccountExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountExperimentServiceImpl implements IAccountExperimentService {

    @Autowired
    private AccountAndTaskExperimentsMapper accountAndTaskExperimentsMapper;

    @Override
    public AccountAndTaskExperiments selectByAccountAndTaskExperiment(String accountId, String taskExperimentId) {
        return accountAndTaskExperimentsMapper.selectByAccountAndTaskExperiment(accountId, taskExperimentId);
    }

    @Override
    public List<AccountAndTaskExperiments> selectAccountByTask(String taskExperimentId) {
       return accountAndTaskExperimentsMapper.selectByTaskId(taskExperimentId);
    }

    @Override
    public boolean updateStatu(String statu, String accountId, String taskExperimentId) {
        int update = accountAndTaskExperimentsMapper.updateStatu(statu, accountId, taskExperimentId);
        if(update>0){
            return true;
        }
        return false;
    }
}
