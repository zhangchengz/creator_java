package com.tlf.creator.service.curriculum.simulationresource.impl;

import com.tlf.creator.aspect.DS;
import com.tlf.creator.dao.curriculum.simulation.SceneTypeMapper;
import com.tlf.creator.entity.curriculum.simulation.SceneType;
import com.tlf.creator.service.curriculum.simulationresource.ISceneTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneTypeServiceImpl implements ISceneTypeService {

    @Autowired
    private SceneTypeMapper sceneTypeMapper;

    @Override
    @DS
    public SceneType selectByPrimaryKey(String courseId,String id) {
        return sceneTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    @DS
    public boolean updateByPrimaryKey(String courseId,SceneType sceneType) {
        Integer integer = sceneTypeMapper.updateByPrimaryKey(sceneType);
        if(integer>0){
            return true;
        }
        return false;
    }

    @Override
    @DS
    public List<SceneType> selectList(String courseId) {
        return sceneTypeMapper.selectList();
    }

    @Override
    @DS
    public List<SceneType> selectListByAlias(String courseId,String alias) {
        return sceneTypeMapper.selectListByAlias(alias);
    }

    @Override
    @DS
    public boolean deleteByPrimaryKey(String courseId,String id) {
        Integer integer = sceneTypeMapper.deleteByPrimaryKey(id);
        if(integer>0){
            return true;
        }
        return false;
    }

    @Override
    @DS
    public boolean insert(String courseId,SceneType sceneType) {
        Integer integer = sceneTypeMapper.insert(sceneType);
        if(integer>0){
            return true;
        }
        return false;
    }
}
