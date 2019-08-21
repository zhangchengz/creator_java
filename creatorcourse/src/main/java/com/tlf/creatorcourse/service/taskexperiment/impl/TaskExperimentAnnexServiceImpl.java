package com.tlf.creatorcourse.service.taskexperiment.impl;

import com.tlf.creatorcourse.config.UploadPathBean;
import com.tlf.creatorcourse.dao.taskexperiment.ExperimentAnnexMapper;
import com.tlf.creatorcourse.entity.taskexperiment.ExperimentAnnex;
import com.tlf.creatorcourse.service.taskexperiment.ITaskExperimentAnnexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class TaskExperimentAnnexServiceImpl implements ITaskExperimentAnnexService {

    @Autowired
    private ExperimentAnnexMapper annexMapper;

    @Autowired
    private UploadPathBean uploadPathBean;

    @Override
    public boolean addSimulationAnnex(ExperimentAnnex experimentAnnex) {
        int insert = annexMapper.insert(experimentAnnex);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        ExperimentAnnex experimentAnnex = annexMapper.selectByPrimaryKey(id);
        if (experimentAnnex != null) {
            File file = new File(uploadPathBean.getUploadPath() + experimentAnnex.getPath());
            if (file.exists()) {
                file.delete();
            }
        }
        int delete = annexMapper.deleteByPrimaryKey(id);
        if (delete > 0) {
            return true;
        }
        return false;
    }

    @Override
    public ExperimentAnnex selectById(String id) {
        return annexMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ExperimentAnnex> selectList(String taskExperimentId, String accountId) {
        return annexMapper.selectList(taskExperimentId, accountId);
    }

}
