package com.tlf.creatorcourse.dao.taskexperiment;

import com.tlf.creatorcourse.entity.taskexperiment.ExperimentAnnex;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExperimentAnnexMapper {

    int deleteByPrimaryKey(String id);

    int insert(ExperimentAnnex record);

    ExperimentAnnex selectByPrimaryKey(String id);

    List<ExperimentAnnex> selectList(String taskExperimentId,String accountId);

    int updateByPrimaryKey(ExperimentAnnex record);
}