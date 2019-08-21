package com.tlf.creatorcourse.service.component;

import com.tlf.creatorcourse.exception.OperatingException;
import com.tlf.creatorcourse.po.ComponentPO;
import com.tlf.creatorcourse.entity.component.Component;
import com.tlf.creatorcourse.entity.component.ComponentGroup;

import java.util.List;

public interface IComponentService {

    List<ComponentPO> queryGroupAndComponent() throws OperatingException;

    void modifyComponentIntroduction(String introduction, String id) throws OperatingException;

    void modifyComponentName(String name, String id) throws OperatingException;

    void deleteComponentById(String id) throws OperatingException;

    Component queryComponentById(String id) throws OperatingException;

    void addComponent(Component component) throws OperatingException;

    List<ComponentPO> searchComponent(String name) throws OperatingException;

    boolean addComponentGroup(ComponentGroup componentGroup);

    List<ComponentGroup> selectAllComponentGroup() throws OperatingException;

    void updateComponentGroupName(String name, String id) throws OperatingException;

    boolean deleteComponentGroup(String groupId);

    List<Component> queryComponentByGroup(String groupId) throws OperatingException;

    void updateComponentParameter(String parameter, String id) throws OperatingException;

    boolean updateComponentModel(String type, String id);

}
