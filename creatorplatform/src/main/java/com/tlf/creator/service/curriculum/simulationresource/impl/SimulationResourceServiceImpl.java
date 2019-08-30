package com.tlf.creator.service.curriculum.simulationresource.impl;

import com.tlf.creator.config.DS;
import com.tlf.creator.dao.curriculum.simulation.ExperimentTypeMapper;
import com.tlf.creator.dao.curriculum.simulation.SimulationResourceMapper;
import com.tlf.creator.entity.curriculum.simulation.ExperimentTypes;
import com.tlf.creator.entity.curriculum.simulation.SimulationResource;
import com.tlf.creator.po.SimulationResourcePO;
import com.tlf.creator.req.SimReq;
import com.tlf.creator.service.curriculum.simulationresource.ISimulationResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimulationResourceServiceImpl implements ISimulationResourceService {

    @Autowired
    private SimulationResourceMapper simulationResourceMapper;

    @Autowired
    private ExperimentTypeMapper experimentTypeMapper;

    @Override
    @DS
    public List<SimulationResourcePO> selectListInner(String courseId,SimReq req) {
        Integer offset = req.getOffset();
        Integer limit = req.getLimit();
        List<SimulationResourcePO> simulationResourcePOS = simulationResourceMapper.selectListInner(offset, limit);
        List<SimulationResourcePO> list = new ArrayList<>();
        for (SimulationResourcePO resourcePO : simulationResourcePOS) {
            if (resourcePO != null) {
                ExperimentTypes experimentTypes = experimentTypeMapper.queryExperimentTypeById(resourcePO.getExpTypeId());
                if (experimentTypes != null) {
                    resourcePO.setExpTypeName(experimentTypes.getName());

                }
                list.add(resourcePO);
            }
        }
        return list;
    }

    @Override
    @DS
    public List<SimulationResourcePO> selectListNotInner(String courseId,SimReq req) {
        Integer offset = req.getOffset();
        Integer limit = req.getLimit();
        List<SimulationResourcePO> simulationResourcePOS = simulationResourceMapper.selectListNotInner(req.getAccountId(),offset, limit);
        List<SimulationResourcePO> list = new ArrayList<>();
        for (SimulationResourcePO resourcePO : simulationResourcePOS) {
            if (resourcePO != null) {
                ExperimentTypes experimentTypes = experimentTypeMapper.queryExperimentTypeById(resourcePO.getExpTypeId());
                if (experimentTypes != null) {
                    resourcePO.setExpTypeName(experimentTypes.getName());
                }
                list.add(resourcePO);
            }
        }
        return list;
    }

    @Override
    @DS
    public SimulationResource selectByPrimaryKey(String courseId,String id) {
        return simulationResourceMapper.selectByPrimaryKey(id);
    }

    @Override
    @DS
    public SimulationResourcePO selectById(String courseId,String id) {
        SimulationResourcePO resourcePO = simulationResourceMapper.selectById(id);
        if (resourcePO != null) {
            ExperimentTypes experimentTypes = experimentTypeMapper.queryExperimentTypeById(resourcePO.getExpTypeId());
            if (experimentTypes != null) {
                resourcePO.setExpTypeName(experimentTypes.getName());
                return resourcePO;
            }
        }
        return null;
    }

    @Override
    @DS
    public Integer selectTotalInner(String courseId) {
        return simulationResourceMapper.selectTotalInner();
    }

    @Override
    @DS
    public Integer selectTotalNotInner(String courseId,SimReq req) {
        return simulationResourceMapper.selectTotalNotInner(req.getAccountId());
    }

    @Override
    @DS
    public boolean deleteByPrimaryKey(String courseId,String id) {
        Integer integer = simulationResourceMapper.deleteByPrimaryKey(id);
        if (integer > 0) {
            return true;
        }
        return false;
    }

    @Override
    @DS
    public boolean updateByPrimaryKey(String courseId,SimulationResource simulationResource) {
        Integer integer = simulationResourceMapper.updateByPrimaryKey(simulationResource);
        if (integer > 0) {
            return true;
        }
        return false;
    }

    @Override
    @DS
    public boolean insert(String courseId,SimulationResource simulationResource) {
        Integer integer = simulationResourceMapper.insert(simulationResource);
        if (integer > 0) {
            return true;
        }
        return false;
    }

    @Override
    @DS
    public List<String> selectAllName(String courseId) {
        return simulationResourceMapper.selectAllName();
    }

    @Override
    @DS
    public List<ExperimentTypes> queryAllExperimentTypes(String courseId) {
        return experimentTypeMapper.queryExperimentTypes();
    }
}
