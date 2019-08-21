package com.tlf.creatorcourse.service.taskexperiment.impl;

import com.tlf.creatorcourse.config.UploadPathBean;
import com.tlf.creatorcourse.dao.taskexperiment.ExperimentReportMapper;
import com.tlf.creatorcourse.entity.taskexperiment.ExperimentReport;
import com.tlf.creatorcourse.service.taskexperiment.ITaskExperimentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class TaskExperimentReportServiceImpl implements ITaskExperimentReportService {

    @Autowired
    private ExperimentReportMapper reportMapper;

    @Autowired
    private UploadPathBean uploadPathBean;

    @Override
    public ExperimentReport selectByExperimentAndAccountId(String taskExperimentId, String accountId) {
        return reportMapper.selectByExperimentAndAccountId(taskExperimentId, accountId);
    }

    @Override
    public ExperimentReport selectById(String id) {
        return reportMapper.selectById(id);
    }

    @Override
    public boolean insertExperimentReport(ExperimentReport report) {
        int insert = reportMapper.insert(report);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReport(String accountId, String taskExperimentId) {
        ExperimentReport experimentReport = reportMapper.selectByExperimentAndAccountId(taskExperimentId, accountId);
        if (experimentReport != null) {
            File file = new File(uploadPathBean.getUploadPath() + experimentReport.getPath());
            if (file.exists()) {
                file.delete();
            }
        }
        int delete = reportMapper.deleteReport(accountId, taskExperimentId);
        if (delete > 0) {
            return true;
        }
        return false;
    }
}
