package com.tlf.creatorcourse.service.taskexperiment;

import com.tlf.creatorcourse.entity.taskexperiment.ExperimentReport;

public interface ITaskExperimentReportService {

    ExperimentReport selectByExperimentAndAccountId(String taskExperimentId, String accountId);

    ExperimentReport selectById(String id);

    boolean insertExperimentReport(ExperimentReport report);

    boolean deleteReport(String accountId, String taskExperimentId);
}
