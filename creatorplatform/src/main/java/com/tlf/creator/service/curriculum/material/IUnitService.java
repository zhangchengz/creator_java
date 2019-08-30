package com.tlf.creator.service.curriculum.material;

import com.tlf.creator.exception.OperatingException;
import com.tlf.creator.entity.curriculum.coursestudy.Unit;

import java.util.List;

public interface IUnitService {
    List<Unit> selectUnitByChapterId(String chapterId)throws OperatingException;
    void insertUnit(Unit unit)throws OperatingException;
    void updateUnitNameById(String name,String id)throws OperatingException;
    void deleteUnitById(String id)throws OperatingException;
}
