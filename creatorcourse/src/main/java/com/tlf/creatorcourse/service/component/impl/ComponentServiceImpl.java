package com.tlf.creatorcourse.service.component.impl;

import com.tlf.creatorcourse.constants.Constants;
import com.tlf.creatorcourse.dao.componentlibrary.ComponentGroupMapper;
import com.tlf.creatorcourse.dao.componentlibrary.ComponentMapper;
import com.tlf.creatorcourse.exception.OperatingException;
import com.tlf.creatorcourse.po.ComponentPO;
import com.tlf.creatorcourse.entity.component.Component;
import com.tlf.creatorcourse.entity.component.ComponentGroup;
import com.tlf.creatorcourse.service.component.IComponentService;
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
    public List<ComponentPO> queryGroupAndComponent(){
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
    public void modifyComponentIntroduction(String introduction, String id) throws OperatingException {
        Component component = componentMapper.selectComponentById(id);
        if(component==null){
            throw new OperatingException(Constants.CODE_FAIL,"COMPONENT DOES NOT EXISTS");
        }
        componentMapper.updateComponentIntroduction(introduction, id);
    }

    @Override
    public void modifyComponentName(String name, String id) {
        componentMapper.updateComponentName(name, id);
    }

    @Override
    public void deleteComponentById(String id)  {
        componentMapper.deleteComponent(id);
    }

    @Override
    public Component queryComponentById(String id) {
        Component component = componentMapper.selectComponentById(id);
        if(component!=null){
            component.setIcon(Constants.RESOURCE_PATH+component.getIcon());
            component.setSchematic(Constants.RESOURCE_PATH+component.getSchematic());
        }
        return component;
    }

    @Override
    public void addComponent(Component component) {
        componentMapper.insertComponent(component);
    }

    @Override
    public List<ComponentPO> searchComponent(String name) throws OperatingException {
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
    public boolean addComponentGroup(ComponentGroup componentGroup) {
        int i = groupMapper.insertComponentGroup(componentGroup);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<ComponentGroup> selectAllComponentGroup() {
        List<ComponentGroup> componentGroups = groupMapper.selectAllComponentGroup();
        return componentGroups;
    }

    @Override
    public void updateComponentGroupName(String name, String id) {
        groupMapper.updateComponentGroupName(name, id);
    }

    @Override
    public boolean deleteComponentGroup(String id) {
        int i = groupMapper.deleteComponentGroup(id);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Component> queryComponentByGroup(String groupId) {
        List<Component> components = componentMapper.selectComponentByGroupId(groupId);
        return components;
    }

    @Override
    public void updateComponentParameter(String parameter, String id) throws OperatingException {
        Component component = componentMapper.selectComponentById(id);
        if(component==null){
            throw new OperatingException(Constants.CODE_FAIL,"COMPONENT DOES NOT EXISTS");
        }
        componentMapper.updateComponentParameter(parameter, id);
    }

    @Override
    public boolean updateComponentModel(String type, String id) {
        int i = componentMapper.updateComponentModel(type, id);
        if(i>0){
            return true;
        }
        return false;
    }
}
