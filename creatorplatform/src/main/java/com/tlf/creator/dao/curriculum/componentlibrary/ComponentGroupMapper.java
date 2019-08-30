package com.tlf.creator.dao.curriculum.componentlibrary;

import com.tlf.creator.entity.curriculum.component.ComponentGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ComponentGroupMapper {

    int insertComponentGroup(ComponentGroup componentGroup);
    List<ComponentGroup> selectAllComponentGroup();
    int updateComponentGroupName(String name,String id);
    int deleteComponentGroup(String id);
    ComponentGroup selectGroupById(String id);
}
