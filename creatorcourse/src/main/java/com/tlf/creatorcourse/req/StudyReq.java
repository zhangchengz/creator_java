package com.tlf.creatorcourse.req;

public class StudyReq extends PageReq {
    private String chapterId;
    private String unitId;
    private String materialId;
    private byte[] file;
    private String fileName;
    private String chapterName;
    private String unitName;
    private String materialName;
    private Integer level;

    public StudyReq(String role, String accountId, Integer limit, Integer offset, String chapterId, String unitId, String materialId, byte[] file,String fileName, String chapterName, String unitName, String materialName, Integer level) {
        super(role, accountId, limit, offset);
        this.chapterId = chapterId;
        this.unitId = unitId;
        this.materialId = materialId;
        this.file = file;
        this.chapterName = chapterName;
        this.unitName = unitName;
        this.materialName = materialName;
        this.level = level;
        this.fileName=fileName;
    }

    public StudyReq() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getMaterialId() {
        return materialId;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}