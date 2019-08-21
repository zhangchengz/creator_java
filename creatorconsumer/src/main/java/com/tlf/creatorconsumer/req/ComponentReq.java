package com.tlf.creatorconsumer.req;

public class ComponentReq extends BaseReq {

    private String id;
    private String componentId; //元件id
    private String groupId;     //元件组id
    private String groupName;   //元件组名
    private String introduction;//元件介绍
    private String parameter;   //元件参数
    private String name;        //元件名称
    private String type;        //元件类型
    private String aliasChinese;//中文别名
    private String aliasEnglish;//英文别名
    private String vendor;      //厂商
    private byte[] icon;        //图标
    private String iconName;    //图标名
    private byte[] schematic;   //原理图
    private String schematicName; //原理图名

    public ComponentReq() {
    }

    public ComponentReq(String id, String componentId, String groupId, String groupName, String introduction, String parameter, String name, String type, String aliasChinese, String aliasEnglish, String vendor, byte[] icon, String iconName, byte[] schematic, String schematicName) {
        this.id = id;
        this.componentId = componentId;
        this.groupId = groupId;
        this.groupName = groupName;
        this.introduction = introduction;
        this.parameter = parameter;
        this.name = name;
        this.type = type;
        this.aliasChinese = aliasChinese;
        this.aliasEnglish = aliasEnglish;
        this.vendor = vendor;
        this.icon = icon;
        this.iconName = iconName;
        this.schematic = schematic;
        this.schematicName = schematicName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getSchematicName() {
        return schematicName;
    }

    public void setSchematicName(String schematicName) {
        this.schematicName = schematicName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAliasChinese() {
        return aliasChinese;
    }

    public void setAliasChinese(String aliasChinese) {
        this.aliasChinese = aliasChinese;
    }

    public String getAliasEnglish() {
        return aliasEnglish;
    }

    public void setAliasEnglish(String aliasEnglish) {
        this.aliasEnglish = aliasEnglish;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public byte[] getSchematic() {
        return schematic;
    }

    public void setSchematic(byte[] schematic) {
        this.schematic = schematic;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
