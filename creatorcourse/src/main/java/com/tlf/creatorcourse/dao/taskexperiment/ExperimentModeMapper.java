package com.tlf.creatorcourse.dao.taskexperiment;

import com.tlf.creatorcourse.entity.simulation.ExperimentModes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExperimentModeMapper {

    List<ExperimentModes> queryExperimentModes();
    ExperimentModes  queryExperimentModeById(String id);
}
