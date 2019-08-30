package com.tlf.creator.dao.curriculum.coursestudy;

import com.tlf.creator.entity.curriculum.coursestudy.Material;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MaterialMapper {

    void insertMaterial(Material material);
    Material selectMaterialById(String id);
    void updateMaterialNameById(String name,String id);
    void deleteMaterialById(String id);
    List<Material> selectAllMaterials(Integer offset,Integer limit);
    Integer selectMaterialAmount();
}
