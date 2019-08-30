package com.tlf.creator.dao.curriculum.resource;

import com.tlf.creator.entity.curriculum.resource.Resources;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ResourceMapper {

    List<Resources> queryResources(Integer offset,Integer limit);
    void addResource(Resources resource);
    Resources queryResourceById(String id);
    List<Resources> queryResourceByTypeId(String resourceTypeId,Integer offset,Integer limit);
    Integer queryTotalResource();
    Integer queryTotalResourceByTypeId(String resourceTypeId);
    void updateResource(Resources resources);
}
