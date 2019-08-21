package com.tlf.creatorconsumer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="cubespace")
public class CubeSpaceConfig {

    private String uploadTempPath;

    private Integer restReadTimeout;

    private Integer restConnectTimeout;

    public String getUploadTempPath() {
        return uploadTempPath;
    }

    public void setUploadTempPath(String uploadTempPath) {
        this.uploadTempPath = uploadTempPath;
    }

    public Integer getRestReadTimeout() {
        return restReadTimeout;
    }

    public void setRestReadTimeout(Integer restReadTimeout) {
        this.restReadTimeout = restReadTimeout;
    }

    public Integer getRestConnectTimeout() {
        return restConnectTimeout;
    }

    public void setRestConnectTimeout(Integer restConnectTimeout) {
        this.restConnectTimeout = restConnectTimeout;
    }
}
