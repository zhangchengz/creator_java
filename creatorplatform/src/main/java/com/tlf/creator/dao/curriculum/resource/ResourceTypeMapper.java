package com.tlf.creator.dao.curriculum.resource;

import com.tlf.creator.entity.curriculum.resource.ResourceTypes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ResourceTypeMapper {

    List<ResourceTypes> queryResourceTypes();
    ResourceTypes queryResourceTypeById(String id);
}
