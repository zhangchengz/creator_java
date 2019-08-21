package com.tlf.creatorcourse.service.resource;

import com.tlf.creatorcourse.exception.OperatingException;
import com.tlf.creatorcourse.entity.resource.ResourceTypes;

import java.util.List;

public interface IResourceTypeService {

    List<ResourceTypes> queryResourceTypes()throws OperatingException;
    ResourceTypes queryResourceTypeById(String id)throws OperatingException;
}
