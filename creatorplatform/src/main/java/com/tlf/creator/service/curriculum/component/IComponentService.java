package com.tlf.creator.service.curriculum.component;

import com.tlf.creator.exception.OperatingException;
import com.tlf.creator.po.ComponentPO;
import com.tlf.creator.entity.curriculum.component.Component;
import com.tlf.creator.entity.curriculum.component.ComponentGroup;

import java.util.List;

public interface IComponentService {

    List<ComponentPO> queryGroupAndComponent(String courseId) throws OperatingException;

    void modifyComponentIntroduction(String courseId,String introduction, String id) throws OperatingException;

    //void modifyComponentName(String courseId,String name, String id) throws OperatingException;

    void deleteComponentById(String courseId,String id) throws OperatingException;

    Component queryComponentById(String courseId,String id) throws OperatingException;

    void addComponent(String courseId,Component component) throws OperatingException;

    List<ComponentPO> searchComponent(String courseId,String name) throws OperatingException;

    boolean addComponentGroup(String courseId,ComponentGroup componentGroup);

    List<ComponentGroup> selectAllComponentGroup(String courseId) throws OperatingException;

 //   void updateComponentGroupName(String name, String id) throws OperatingException;

    boolean deleteComponentGroup(String courseId,String groupId);

    List<Component> queryComponentByGroup(String courseId,String groupId) throws OperatingException;

//    void updateComponentParameter(String parameter, String id) throws OperatingException;

    boolean updateComponentModel(String courseId,String type, String id);

}
