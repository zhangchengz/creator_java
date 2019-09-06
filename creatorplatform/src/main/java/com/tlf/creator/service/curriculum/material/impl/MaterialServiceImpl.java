package com.tlf.creator.service.curriculum.material.impl;

import com.tlf.creator.common.Constants;
import com.tlf.creator.dao.curriculum.coursestudy.MaterialAndChapterMapper;
import com.tlf.creator.dao.curriculum.coursestudy.MaterialMapper;
import com.tlf.creator.exception.OperatingException;
import com.tlf.creator.entity.curriculum.coursestudy.Material;
import com.tlf.creator.entity.curriculum.coursestudy.MaterialAndChapter;
import com.tlf.creator.service.curriculum.material.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaterialServiceImpl implements IMaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private MaterialAndChapterMapper macMapper;

    @Transactional(value = "transactionManager")
    @Override
    public void addMaterial(Material material, MaterialAndChapter mac) {
        materialMapper.insertMaterial(material);
        macMapper.insertMaterialAndChapter(mac);
    }

    @Transactional(value = "transactionManager")
    @Override
    public void updateMaterialName(String name, String id) {
        materialMapper.updateMaterialNameById(name, id);
    }

    @Transactional(value = "transactionManager")
    @Override
    public void deleteMaterial(String id) {
        materialMapper.deleteMaterialById(id);
        macMapper.deleteMaterial(id);
    }

    @Override
    public List<Material> selectMaterialByChapterId(String chapterId, Integer offset, Integer limit) {
        List<MaterialAndChapter> materialAndChapters = macMapper.selectMaterialByChapterId(chapterId, offset, limit);
        if (materialAndChapters != null) {
            List<Material> list = new ArrayList<>();
            for (MaterialAndChapter mac : materialAndChapters) {
                Material material = materialMapper.selectMaterialById(mac.getMaterialId());
                if (material != null) {
                    material.setPath(Constants.RESOURCE_PATH + material.getPath());
                    list.add(material);
                }

            }
            return list;
        } else {
            return null;
        }
    }

    @Override
    public List<Material> selectMaterialByUnitId(String unitId, Integer offset, Integer limit) {
        List<MaterialAndChapter> materialAndChapters = macMapper.selectMaterialByUnitId(unitId, offset, limit);
        if (materialAndChapters != null) {
            List<Material> list = new ArrayList<>();
            for (MaterialAndChapter mac : materialAndChapters) {
                Material material = materialMapper.selectMaterialById(mac.getMaterialId());
                if (material != null) {
                    material.setPath(Constants.RESOURCE_PATH + material.getPath());
                    list.add(material);
                }

            }
            return list;
        } else {
            return null;
        }
    }

    @Override
    public List<Material> selectAllMaterials(Integer offset, Integer limit) throws OperatingException {
        List<Material> materials = materialMapper.selectAllMaterials(offset, limit);
        List<Material> list = new ArrayList<>();
        for (Material material : materials) {
            if (material != null) {
                material.setPath(Constants.RESOURCE_PATH + material.getPath());
                list.add(material);
            }

        }
        return list;
    }

    @Override
    public Integer selectMaterialAmount() throws OperatingException {
        Integer amount = materialMapper.selectMaterialAmount();
        return amount;
    }

    @Override
    public Integer selectMaterialAmountByChapterId(String chapterId) throws OperatingException {
        Integer amount = macMapper.selectMaterialAmountByChapterId(chapterId);
        return amount;
    }

    @Override
    public Integer selectMaterialAmountByUnitId(String unitId) throws OperatingException {
        Integer amount = macMapper.selectMaterialAmountByUnitId(unitId);
        return amount;
    }

    @Override
    public void updateMaterialPosition(String chapterId, String unitId, String materialId) {
        macMapper.updateMaterialPosition(chapterId, unitId, materialId);
    }

    @Override
    public Material selectById(String id) {
        Material material = materialMapper.selectMaterialById(id);
        return material;
    }
}
