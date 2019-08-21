package com.tlf.creatorcourse.dao.coursestudy;

import com.tlf.creatorcourse.entity.coursestudy.Unit;
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
