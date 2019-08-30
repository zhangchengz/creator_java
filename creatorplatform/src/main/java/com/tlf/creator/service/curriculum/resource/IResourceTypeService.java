package com.tlf.creator.service.curriculum.resource;

import com.tlf.creator.entity.curriculum.resource.ResourceTypes;

import java.util.List;

public interface IResourceTypeService {

    List<ResourceTypes> queryResourceTypes(String courseId) ;
}
