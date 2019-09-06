package com.tlf.creator.po;

import java.io.Serializable;

/**
 * PO
 *
 * @author zhangc
 * @date 2019/9/5
 */
public class VersionPO implements Serializable {

    private String ItemName;
    private String versionName;

    public VersionPO() {
    }

    public VersionPO(String itemName, String versionName) {
        ItemName = itemName;
        this.versionName = versionName;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
}
