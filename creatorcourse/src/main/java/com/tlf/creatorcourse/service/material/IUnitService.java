package com.tlf.creatorcourse.service.material;

import com.tlf.creatorcourse.exception.OperatingException;
import com.tlf.creatorcourse.entity.coursestudy.Unit;

import java.util.List;

public interface IUnitService {
    List<Unit> selectUnitByChapterId(String chapterId)throws OperatingException;
    void insertUnit(Unit unit)throws OperatingException;
    void updateUnitNameById(String name,String id)throws OperatingException;
    void deleteUnitById(String id)throws OperatingException;
}
