package com.icubespace.projects.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix="cubespace")
public class WhileUrlBean {

    private List<String> whileUrls;

    public List<String> getWhileUrls() {
        return whileUrls;
    }

    public void setWhileUrls(List<String> whileUrls) {
        this.whileUrls = whileUrls;
    }
}
