package com.tlf.creator.service.curriculum.material.impl;

import com.tlf.creator.dao.curriculum.coursestudy.UnitMapper;
import com.tlf.creator.exception.OperatingException;
import com.tlf.creator.entity.curriculum.coursestudy.Unit;
import com.tlf.creator.service.curriculum.material.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UnitServiceImpl implements IUnitService {

    @Autowired
    private UnitMapper unitMapper;

    @Override
    public List<Unit> selectUnitByChapterId(String chapterId) throws OperatingException {
        List<Unit> units = unitMapper.selectUnitByChapterId(chapterId);
        return units;
    }

    @Transactional
    @Override
    public void insertUnit(Unit unit) throws OperatingException {
        Integer level = unit.getLevel();
        String chapterId = unit.getChapterId();
        Unit unit1 = unitMapper.selectUnitByLevel(level,chapterId);
        if(unit1!=null){
            unitMapper.addLevel(level,chapterId);
        }
        unitMapper.insertUnit(unit);
    }

    @Transactional
    @Override
    public void updateUnitNameById(String name, String id) throws OperatingException {
        unitMapper.updateUnitNameById(name, id);
    }

    @Transactional
    @Override
    public void deleteUnitById(String id) throws OperatingException {
        Unit unit = unitMapper.selectUnitById(id);
        if(unit!=null){
            Integer level = unit.getLevel();
            String chapterId = unit.getChapterId();
            unitMapper.reduceLevel(level,chapterId);
            unitMapper.deleteUnitById(id);
        }
    }

}
