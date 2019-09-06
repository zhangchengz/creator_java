package com.tlf.creator.service.curriculum.resource.impl;

import com.tlf.creator.common.Constants;
import com.tlf.creator.aspect.DS;
import com.tlf.creator.config.UploadPathBean;
import com.tlf.creator.dao.curriculum.resource.ResourceMapper;
import com.tlf.creator.dao.curriculum.simulation.SimulationResourceMapper;
import com.tlf.creator.entity.curriculum.resource.Resources;
import com.tlf.creator.entity.curriculum.simulation.SimulationResource;
import com.tlf.creator.service.curriculum.resource.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private SimulationResourceMapper simMapper;

    @Autowired
    private UploadPathBean uploadPathBean;

    @Override
    @DS
    public void addResource(String courseId, Resources resource) {
        resourceMapper.addResource(resource);
    }

    @Override
    @DS
    public Resources queryResourceById(String courseId, String id) {
        Resources resource = resourceMapper.queryResourceById(id);
        if (resource != null) {
            resource.setPath(Constants.RESOURCE_PATH + resource.getPath());
            return resource;
        }
        return null;
    }

    @Override
    @DS
    public Map<String, String> queryFileById(String courseId, String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        Resources resource = resourceMapper.queryResourceById(id);
        SimulationResource simulationResource = simMapper.selectByPrimaryKey(id);
        if (resource != null) {
            map.put("path", Constants.RESOURCE_PATH + resource.getPath());
        } else if (simulationResource != null) {
            map.put("path", uploadPathBean.getDownloadPath() + simulationResource.getPath());
        }
        return map;
    }

}
