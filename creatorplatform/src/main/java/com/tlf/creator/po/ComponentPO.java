package com.tlf.creator.po;

import com.tlf.creator.entity.curriculum.component.Component;

import java.util.List;

public class ComponentPO {

    private String id;
    private String name;
    private String alias;
    private List<Component> components;

    public ComponentPO(String id, String name, String alias, List<Component> components) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.components = components;
    }

    public ComponentPO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }
}
