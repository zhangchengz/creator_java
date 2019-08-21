package com.tlf.creatorcourse.service.simulationresource;

import com.tlf.creatorcourse.entity.simulation.ExperimentTypes;
import com.tlf.creatorcourse.entity.simulation.SimulationResource;
import com.tlf.creatorcourse.po.SimulationResourcePO;
import com.tlf.creatorcourse.req.SimReq;

import java.util.List;

public interface ISimulationResourceService {
    List<SimulationResourcePO> selectListInner(SimReq req);
    List<SimulationResourcePO> selectListNotInner(SimReq req);
    SimulationResource selectByPrimaryKey(String id);
    SimulationResourcePO selectById(String id);
    Integer selectTotalInner();
    Integer selectTotalNotInner(SimReq req);
    boolean deleteByPrimaryKey(String id);
    boolean updateByPrimaryKey(SimulationResource simulationResource);
    boolean insert(SimulationResource simulationResource);
    List<String> selectAllName();
    List<ExperimentTypes> quertAllExperimentTypes();
}
