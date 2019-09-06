package com.tlf.creator.service.curriculum.resource.impl;

import com.tlf.creator.aspect.DS;
import com.tlf.creator.dao.curriculum.resource.ResourceTypeMapper;
import com.tlf.creator.entity.curriculum.resource.ResourceTypes;
import com.tlf.creator.service.curriculum.resource.IResourceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceTypeServiceImpl implements IResourceTypeService {

    @Autowired
    private ResourceTypeMapper resourceTypeMapper;

    @Override
    @DS
    public List<ResourceTypes> queryResourceTypes(String courseId){
        List<ResourceTypes> resourceTypes = resourceTypeMapper.queryResourceTypes();
        return resourceTypes;
    }

}
