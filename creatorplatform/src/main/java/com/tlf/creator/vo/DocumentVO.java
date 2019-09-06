package com.tlf.creator.vo;

import com.tlf.creator.entity.user.product.Document;

import java.io.Serializable;
import java.util.List;

public class DocumentVO implements Serializable {

    private String bulletin;

    private List<Document> documents;

    public DocumentVO() {
    }

    public DocumentVO(String bulletin, List<Document> documents) {
        this.bulletin = bulletin;
        this.documents = documents;
    }

    public String getBulletin() {
        return bulletin;
    }

    public void setBulletin(String bulletin) {
        this.bulletin = bulletin;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
