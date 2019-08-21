package com.tlf.creatorcourse.service.simulationresource.impl;

import com.tlf.creatorcourse.dao.simulationresource.SimulationResourceMapper;
import com.tlf.creatorcourse.dao.taskexperiment.ExperimentTypeMapper;
import com.tlf.creatorcourse.entity.simulation.ExperimentTypes;
import com.tlf.creatorcourse.entity.simulation.SimulationResource;
import com.tlf.creatorcourse.po.SimulationResourcePO;
import com.tlf.creatorcourse.req.SimReq;
import com.tlf.creatorcourse.service.simulationresource.ISimulationResourceService;
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
    public List<SimulationResourcePO> selectListInner(SimReq req) {
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
    public List<SimulationResourcePO> selectListNotInner(SimReq req) {
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
    public SimulationResource selectByPrimaryKey(String id) {
        return simulationResourceMapper.selectByPrimaryKey(id);
    }

    @Override
    public SimulationResourcePO selectById(String id) {
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
    public Integer selectTotalInner() {
        return simulationResourceMapper.selectTotalInner();
    }

    @Override
    public Integer selectTotalNotInner(SimReq req) {
        return simulationResourceMapper.selectTotalNotInner(req.getAccountId());
    }

    @Override
    public boolean deleteByPrimaryKey(String id) {
        Integer integer = simulationResourceMapper.deleteByPrimaryKey(id);
        if (integer > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateByPrimaryKey(SimulationResource simulationResource) {
        Integer integer = simulationResourceMapper.updateByPrimaryKey(simulationResource);
        if (integer > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean insert(SimulationResource simulationResource) {
        Integer integer = simulationResourceMapper.insert(simulationResource);
        if (integer > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<String> selectAllName() {
        return simulationResourceMapper.selectAllName();
    }

    @Override
    public List<ExperimentTypes> quertAllExperimentTypes() {
        return experimentTypeMapper.queryExperimentTypes();
    }
}
