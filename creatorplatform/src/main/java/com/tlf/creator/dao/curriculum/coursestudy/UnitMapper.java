package com.tlf.creator.dao.curriculum.coursestudy;

import com.tlf.creator.entity.curriculum.coursestudy.Unit;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UnitMapper {

    List<Unit> selectUnitByChapterId(String chapterId);
    void insertUnit(Unit unit);
    void updateUnitNameById(String name,String id);
    void deleteUnitById(String id);
    void addLevel(Integer level,String chapterId);
    Unit selectUnitByLevel(Integer level,String chapterId);
    void reduceLevel(Integer level,String chapterId);
    Unit selectUnitById(String id);
}
