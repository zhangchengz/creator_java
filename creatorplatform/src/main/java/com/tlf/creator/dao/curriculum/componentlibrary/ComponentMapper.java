package com.tlf.creator.dao.curriculum.componentlibrary;

import com.tlf.creator.entity.curriculum.component.Component;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ComponentMapper {

    Component selectComponentById(String id);
    List<Component> selectComponentByGroupId(String groupId);
    int insertComponent(Component component);
    int updateComponentIntroduction(String introduction,String id);
    int updateComponentName(String name,String id);
    int deleteComponent(String id);
    List<Component> searchComponentByName(String name);
    int updateComponentParameter(String parameter,String id);
    int updateComponentModel(String type, String id);
}
