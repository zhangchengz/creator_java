package com.tlf.creatorcourse.dao.taskexperiment;

import com.tlf.creatorcourse.entity.simulation.ExperimentTypes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExperimentTypeMapper {

    List<ExperimentTypes> queryExperimentTypes();
    void addExperimentType(ExperimentTypes type);
    ExperimentTypes queryExperimentTypeById(String id);
    Integer selectTotal();
}
