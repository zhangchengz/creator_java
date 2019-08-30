package com.tlf.creator.service.curriculum.resource;

import com.tlf.creator.entity.curriculum.resource.Resources;

import java.util.Map;

public interface IResourceService {

    void addResource(String courseId,Resources resource);
    Resources queryResourceById(String courseId,String id);
    Map<String,String> queryFileById(String courseId,String id);

}
