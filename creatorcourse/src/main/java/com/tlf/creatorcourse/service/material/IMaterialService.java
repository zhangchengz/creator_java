package com.tlf.creatorcourse.service.material;

import com.tlf.creatorcourse.exception.OperatingException;
import com.tlf.creatorcourse.entity.coursestudy.Material;
import com.tlf.creatorcourse.entity.coursestudy.MaterialAndChapter;

import java.util.List;

public interface IMaterialService {

    void addMaterial(Material material, MaterialAndChapter mac) throws OperatingException;

    void updateMaterialName(String name, String id) throws OperatingException;

    void deleteMaterial(String id) throws OperatingException;

    List<Material> selectMaterialByChapterId(String chapterId, Integer offset, Integer limit) throws OperatingException;

    List<Material> selectMaterialByUnitId(String unitId, Integer offset, Integer limit) throws OperatingException;

    List<Material> selectAllMaterials(Integer offset, Integer limit) throws OperatingException;

    Integer selectMaterialAmount() throws OperatingException;

    Integer selectMaterialAmountByChapterId(String chapterId) throws OperatingException;

    Integer selectMaterialAmountByUnitId(String unitId) throws OperatingException;

    void updateMaterialPosition(String chapterId, String unitId, String materialId) throws OperatingException;

    Material selectById(String id);
}
