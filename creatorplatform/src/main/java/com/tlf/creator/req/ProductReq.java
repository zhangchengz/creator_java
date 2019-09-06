package com.tlf.creator.req;

public class ProductReq {

    private String itemId;

    private String itemName;

    private String versionId;

    private String versionName;

    private String bulletin;

    private String documentId;

    public ProductReq() {
    }

    public ProductReq(String itemId, String itemName, String versionId, String versionName, String bulletin, String documentId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.versionId = versionId;
        this.versionName = versionName;
        this.bulletin = bulletin;
        this.documentId = documentId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
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

    public String getBulletin() {
        return bulletin;
    }

    public void setBulletin(String bulletin) {
        this.bulletin = bulletin;
    }
}
