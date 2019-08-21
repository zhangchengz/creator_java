package com.tlf.creatorcourse.service.resource;

import com.tlf.creatorcourse.entity.resource.Resources;

import java.util.List;
import java.util.Map;

public interface IResourceService {

    List<Resources> queryResources(Integer offset, Integer limit);
    void addResource(Resources resource);
    Resources queryResourceById(String id);
    Map<String,String> queryFileById(String id);
    List<Resources> queryResourceByTypeId(String resourceTypeId,Integer offset,Integer limit);
    Integer queryTotalResource();
    Integer queryTotalResourceByTypeId(String resourceTypeId);
    void updateResource(Resources resources);
}
