package com.tlf.creatorcourse.dao.simulationresource;

import com.tlf.creatorcourse.entity.simulation.SimulationResource;
import com.tlf.creatorcourse.po.SimulationResourcePO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SimulationResourceMapper {

    List<SimulationResourcePO> selectListInner(Integer offset,Integer limit);
    List<SimulationResourcePO> selectListNotInner(String creatorId,Integer offset,Integer limit);
    SimulationResource selectByPrimaryKey(String id);
    SimulationResourcePO selectById(String id);
    Integer deleteByPrimaryKey(String id);
    Integer updateByPrimaryKey(SimulationResource simulationResource);
    Integer insert(SimulationResource simulationResource);
    Integer selectTotalInner();
    Integer selectTotalNotInner(String creatorId);
    List<String> selectAllName();
}
