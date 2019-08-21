package com.tlf.creatorcourse.service.resource.impl;

import com.tlf.creatorcourse.dao.resource.ResourceTypeMapper;
import com.tlf.creatorcourse.entity.resource.ResourceTypes;
import com.tlf.creatorcourse.service.resource.IResourceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceTypeServiceImpl implements IResourceTypeService {

    @Autowired
    private ResourceTypeMapper resourceTypeMapper;

    @Override
    public List<ResourceTypes> queryResourceTypes(){
        List<ResourceTypes> resourceTypes = resourceTypeMapper.queryResourceTypes();
        return resourceTypes;
    }

    @Override
    public ResourceTypes queryResourceTypeById(String id) {
        ResourceTypes resourceTypes = resourceTypeMapper.queryResourceTypeById(id);
        return null;
    }
}
