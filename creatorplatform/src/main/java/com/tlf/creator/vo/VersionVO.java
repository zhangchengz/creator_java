package com.tlf.creator.vo;

import java.io.Serializable;

public class VersionVO implements Serializable {

    private String versionId;

    private String versionName;

    public VersionVO() {
    }

    public VersionVO(String versionId, String versionName) {
        this.versionId = versionId;
        this.versionName = versionName;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }
}
