package com.tlf.creatorcourse.dao.taskexperiment;

import com.tlf.creatorcourse.entity.taskexperiment.ExperimentReport;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ExperimentReportMapper {

    int deleteByPrimaryKey(String id);

    int insert(ExperimentReport record);

    ExperimentReport selectByExperimentAndAccountId(String taskExperimentId, String accountId);

    int deleteReport(String accountId, String taskExperimentId);

    ExperimentReport selectById(String id);

    int updateByPrimaryKey(ExperimentReport record);
}