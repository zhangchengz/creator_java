package com.tlf.creator.service.curriculum.component.impl;

import com.tlf.creator.aspect.DS;
import com.tlf.creator.common.Constants;
import com.tlf.creator.dao.curriculum.componentlibrary.ComponentGroupMapper;
import com.tlf.creator.dao.curriculum.componentlibrary.ComponentMapper;
import com.tlf.creator.exception.OperatingException;
import com.tlf.creator.po.ComponentPO;
import com.tlf.creator.entity.curriculum.component.Component;
import com.tlf.creator.entity.curriculum.component.ComponentGroup;
import com.tlf.creator.service.curriculum.component.IComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ComponentServiceImpl implements IComponentService {

    @Autowired
    private ComponentMapper componentMapper;

    @Autowired
    private ComponentGroupMapper groupMapper;

    @Override
    @DS
    public List<ComponentPO> queryGroupAndComponent(String courseId){
        List<ComponentPO> list = new ArrayList<>();
        List<ComponentGroup> componentGroups = groupMapper.selectAllComponentGroup();
        if (componentGroups != null) {
            for (ComponentGroup group : componentGroups) {
                ComponentPO componentPO = new ComponentPO();
                componentPO.setId(group.getId());
                componentPO.setName(group.getName());
                componentPO.setAlias(group.getAlias());
                if (group != null) {
                    List<Component> components = componentMapper.selectComponentByGroupId(group.getId());
                    List<Component> list1 = new ArrayList<>();
                    for(Component component:components){
                        if(component!=null){
                            component.setIcon(Constants.RESOURCE_PATH+component.getIcon());
                            component.setSchematic(Constants.RESOURCE_PATH+component.getSchematic());
                        }
                        list1.add(component);
                    }
                    componentPO.setComponents(list1);
                }
                list.add(componentPO);
            }
        }
        return list;
    }

    @Override
    @DS
    public void modifyComponentIntroduction(String courseId,String introduction, String id) throws OperatingException {
        Component component = componentMapper.selectComponentById(id);
        if(component==null){
            throw new OperatingException(Constants.CODE_FAIL,"COMPONENT DOES NOT EXISTS");
        }
        componentMapper.updateComponentIntroduction(introduction, id);
    }

//    @Override
//    public void modifyComponentName(String courseId,String name, String id) {
//        componentMapper.updateComponentName(name, id);
//    }

    @Override
    @DS
    public void deleteComponentById(String courseId,String id)  {
        componentMapper.deleteComponent(id);
    }

    @Override
    @DS
    public Component queryComponentById(String courseId,String id) {
        Component component = componentMapper.selectComponentById(id);
        if(component!=null){
            component.setIcon(Constants.RESOURCE_PATH+component.getIcon());
            component.setSchematic(Constants.RESOURCE_PATH+component.getSchematic());
        }
        return component;
    }

    @Override
    @DS
    public void addComponent(String courseId,Component component) {
        componentMapper.insertComponent(component);
    }

    @Override
    @DS
    public List<ComponentPO> searchComponent(String courseId,String name) throws OperatingException {
        List<Component> components = componentMapper.searchComponentByName(name);
        List<ComponentPO> list = new ArrayList<>();
        if (components != null) {
            Set<String> set = new HashSet<>();
            for (Component component : components) {
                if (component != null) {
                    String groupId = component.getGroupId();
                    set.add(groupId);
                }
            }
            for (String str : set) {
                ComponentGroup group = groupMapper.selectGroupById(str);
                if (group == null) {
                    throw new OperatingException(Constants.CODE_FAIL, "出错了");
                }
                ComponentPO componentPO = new ComponentPO();
                componentPO.setId(group.getId());
                componentPO.setName(group.getName());
                componentPO.setAlias(group.getAlias());
                List<Component> list1 = new ArrayList<>();
                for (Component component : components) {
                    if (component != null) {
                        if (group.getId().equals(component.getGroupId())) {
                            component.setSchematic(Constants.RESOURCE_PATH+component.getSchematic());
                            component.setIcon(Constants.RESOURCE_PATH+component.getIcon());
                            list1.add(component);
                        }
                    }
                }
                componentPO.setComponents(list1);
                list.add(componentPO);
            }
        }
        return list;
    }

    @Override
    @DS
    public boolean addComponentGroup(String courseId,ComponentGroup componentGroup) {
        int i = groupMapper.insertComponentGroup(componentGroup);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    @DS
    public List<ComponentGroup> selectAllComponentGroup(String courseId) {
        List<ComponentGroup> componentGroups = groupMapper.selectAllComponentGroup();
        return componentGroups;
    }

//    @Override
//    public void updateComponentGroupName(String name, String id) {
//        groupMapper.updateComponentGroupName(name, id);
//    }

    @Override
    @DS
    public boolean deleteComponentGroup(String courseId,String id) {
        int i = groupMapper.deleteComponentGroup(id);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    @DS
    public List<Component> queryComponentByGroup(String courseId,String groupId) {
        List<Component> components = componentMapper.selectComponentByGroupId(groupId);
        return components;
    }

//    @Override
//    public void updateComponentParameter(String parameter, String id) throws OperatingException {
//        Component component = componentMapper.selectComponentById(id);
//        if(component==null){
//            throw new OperatingException(Constants.CODE_FAIL,"COMPONENT DOES NOT EXISTS");
//        }
//        componentMapper.updateComponentParameter(parameter, id);
//    }

    @Override
    @DS
    public boolean updateComponentModel(String courseId,String type, String id) {
        int i = componentMapper.updateComponentModel(type, id);
        if(i>0){
            return true;
        }
        return false;
    }
}
