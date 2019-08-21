package com.tlf.creatorcourse.service.resource.impl;

import com.tlf.creatorcourse.constants.Constants;
import com.tlf.creatorcourse.dao.resource.ResourceMapper;
import com.tlf.creatorcourse.dao.simulationresource.SimulationResourceMapper;
import com.tlf.creatorcourse.dao.taskexperiment.ExperimentAnnexMapper;
import com.tlf.creatorcourse.dao.taskexperiment.ExperimentProjectMapper;
import com.tlf.creatorcourse.dao.template.SimTemplateMapper;
import com.tlf.creatorcourse.entity.simulation.SimulationResource;
import com.tlf.creatorcourse.entity.taskexperiment.ExperimentAnnex;
import com.tlf.creatorcourse.entity.taskexperiment.ExperimentProject;
import com.tlf.creatorcourse.entity.template.SimTemplate;
import com.tlf.creatorcourse.entity.resource.Resources;
import com.tlf.creatorcourse.service.resource.IResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResourceServiceImpl implements IResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private SimulationResourceMapper simMapper;

    @Autowired
    private SimTemplateMapper simTemplateMapper;

    @Autowired
    private ExperimentProjectMapper projectMapper;

    @Autowired
    private ExperimentAnnexMapper annexMapper;

    @Override
    public List<Resources> queryResources(Integer offset, Integer limit) {
        List<Resources> resources = resourceMapper.queryResources(offset, limit);
        return resources;
    }

    @Override
    public void addResource(Resources resource) {
        resourceMapper.addResource(resource);
    }

    @Override
    public Resources queryResourceById(String id) {
        Resources resource = resourceMapper.queryResourceById(id);
        if (resource != null) {
            resource.setPath(Constants.RESOURCE_PATH + resource.getPath());
            return resource;
        }
        return null;
    }

    @Override
    public Map<String, String> queryFileById(String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        Resources resource = resourceMapper.queryResourceById(id);
        SimulationResource simulationResource = simMapper.selectByPrimaryKey(id);
        SimTemplate simTemplate = simTemplateMapper.selectByPrimaryKey(id);
        ExperimentProject experimentProject = projectMapper.selectById(id);
        ExperimentAnnex annex = annexMapper.selectByPrimaryKey(id);
        if (resource != null) {
            map.put("path", Constants.RESOURCE_PATH + resource.getPath());
        } else if (simulationResource != null) {
            map.put("path", Constants.RESOURCE_PATH + simulationResource.getPath());
        } else if (simTemplate != null) {
            map.put("path", Constants.RESOURCE_PATH + simTemplate.getPath());
        } else if (experimentProject != null) {
            map.put("path", Constants.RESOURCE_PATH + experimentProject.getScenePath());
        } else if (annex != null) {
            map.put("path", Constants.RESOURCE_PATH + annex.getPath());
        }
        return map;
    }

    @Override
    public List<Resources> queryResourceByTypeId(String resourceTypeId, Integer offset, Integer limit) {
        List<Resources> resources = resourceMapper.queryResourceByTypeId(resourceTypeId, offset, limit);
        List<Resources> list = new ArrayList<>();
        for (Resources resource : resources) {
            if (resource != null) {
                resource.setPath(Constants.RESOURCE_PATH + resource.getPath());
            }
            list.add(resource);
        }
        return resources;
    }

    @Override
    public Integer queryTotalResource() {
        return resourceMapper.queryTotalResource();
    }

    @Override
    public Integer queryTotalResourceByTypeId(String resourceTypeId) {
        return resourceMapper.queryTotalResourceByTypeId(resourceTypeId);
    }

    @Override
    public void updateResource(Resources resources) {
        Resources resources1 = resourceMapper.queryResourceById(resources.getId());
        if (resources != null) {
            resourceMapper.updateResource(resources);
        }

    }
}
