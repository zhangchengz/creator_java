package com.tlf.creator.dao.curriculum.coursestudy;

import com.tlf.creator.entity.curriculum.coursestudy.MaterialAndChapter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MaterialAndChapterMapper {

    void insertMaterialAndChapter(MaterialAndChapter mac);
    List<MaterialAndChapter> selectMaterialByChapterId(String chapterId,Integer offset,Integer limit);
    List<MaterialAndChapter> selectMaterialByUnitId(String unitId,Integer offset,Integer limit);
    Integer selectMaterialAmountByChapterId(String chapterId);
    Integer selectMaterialAmountByUnitId(String unitId);
    void deleteMaterial(String materialId);
    void updateMaterialPosition(String chapterId,String unitId,String materialId);
}
