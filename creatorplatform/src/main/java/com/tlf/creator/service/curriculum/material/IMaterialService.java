package com.tlf.creator.service.curriculum.material;

import com.tlf.creator.exception.OperatingException;
import com.tlf.creator.entity.curriculum.coursestudy.Material;
import com.tlf.creator.entity.curriculum.coursestudy.MaterialAndChapter;

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
