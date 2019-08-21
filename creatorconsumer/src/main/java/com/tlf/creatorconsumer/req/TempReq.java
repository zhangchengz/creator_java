package com.tlf.creatorconsumer.req;

import com.tlf.creatorconsumer.entity.AnnexTemplate;
import com.tlf.creatorconsumer.entity.Report;
import com.tlf.creatorconsumer.entity.SimTemplate;

import java.util.List;

public class TempReq extends BaseReq{

    private String id;
    private String name;
    private String description;
    private Report guide;
    private Report report;
    private List<SimTemplate> simulations;
    private List<AnnexTemplate> annexs;

    public TempReq() {
    }

    public TempReq(String role, String accountId) {
        super(role, accountId);
    }

    public TempReq(String role, String accountId, String id, String name, String description, Report guide, Report report, List<SimTemplate> simulations, List<AnnexTemplate> annexs) {
        super(role, accountId);
        this.id = id;
        this.name = name;
        this.description = description;
        this.guide = guide;
        this.report = report;
        this.simulations = simulations;
        this.annexs = annexs;
    }

    public TempReq(String id, String name, String description, Report guide, Report report, List<SimTemplate> simulations, List<AnnexTemplate> annexs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.guide = guide;
        this.report = report;
        this.simulations = simulations;
        this.annexs = annexs;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Report getGuide() {
        return guide;
    }

    public void setGuide(Report guide) {
        this.guide = guide;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public List<SimTemplate> getSimulations() {
        return simulations;
    }

    public void setSimulations(List<SimTemplate> simulations) {
        this.simulations = simulations;
    }

    public List<AnnexTemplate> getAnnexs() {
        return annexs;
    }

    public void setAnnexs(List<AnnexTemplate> annexs) {
        this.annexs = annexs;
    }
}
