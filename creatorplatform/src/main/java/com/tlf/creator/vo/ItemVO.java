package com.tlf.creator.vo;

import java.io.Serializable;
import java.util.List;

public class ItemVO implements Serializable {

    private String itemId;

    private String itemName;

    private List<VersionVO> versions;

    public ItemVO() {
    }

    public ItemVO(String itemId, String itemName, List<VersionVO> versions) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.versions = versions;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public List<VersionVO> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionVO> versions) {
        this.versions = versions;
    }
}
