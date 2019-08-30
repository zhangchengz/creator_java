package com.tlf.creator.service.curriculum.simulationresource;

import com.tlf.creator.entity.curriculum.simulation.ExperimentTypes;
import com.tlf.creator.entity.curriculum.simulation.SimulationResource;
import com.tlf.creator.po.SimulationResourcePO;
import com.tlf.creator.req.SimReq;

import java.util.List;

public interface ISimulationResourceService {
    List<SimulationResourcePO> selectListInner(String courseId, SimReq req);

    List<SimulationResourcePO> selectListNotInner(String courseId, SimReq req);

    SimulationResource selectByPrimaryKey(String courseId, String id);

    SimulationResourcePO selectById(String courseId, String id);

    Integer selectTotalInner(String courseId);

    Integer selectTotalNotInner(String courseId, SimReq req);

    boolean deleteByPrimaryKey(String courseId, String id);

    boolean updateByPrimaryKey(String courseId, SimulationResource simulationResource);

    boolean insert(String courseId, SimulationResource simulationResource);

    List<String> selectAllName(String courseId);

    List<ExperimentTypes> queryAllExperimentTypes(String courseId);
}
