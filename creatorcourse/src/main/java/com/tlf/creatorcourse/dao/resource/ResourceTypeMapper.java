package com.tlf.creatorcourse.dao.resource;

import com.tlf.creatorcourse.entity.resource.ResourceTypes;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ResourceTypeMapper {

    List<ResourceTypes> queryResourceTypes();
    ResourceTypes queryResourceTypeById(String id);
}
