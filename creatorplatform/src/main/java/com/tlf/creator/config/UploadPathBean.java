package com.tlf.creator.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="creator")
public class UploadPathBean {

    private String uploadPath;

    private String downloadPath;

    private String documentUpload;

    private String documentDownload;

    public String getDocumentUpload() {
        return documentUpload;
    }

    public void setDocumentUpload(String documentUpload) {
        this.documentUpload = documentUpload;
    }

    public String getDocumentDownload() {
        return documentDownload;
    }

    public void setDocumentDownload(String documentDownload) {
        this.documentDownload = documentDownload;
    }

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }
}
