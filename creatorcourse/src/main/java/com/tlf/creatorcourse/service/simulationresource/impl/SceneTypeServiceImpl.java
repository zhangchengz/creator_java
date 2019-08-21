package com.tlf.creatorcourse.service.simulationresource.impl;

import com.tlf.creatorcourse.dao.simulationresource.SceneTypeMapper;
import com.tlf.creatorcourse.entity.simulation.SceneType;
import com.tlf.creatorcourse.service.simulationresource.ISceneTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneTypeServiceImpl implements ISceneTypeService {

    @Autowired
    private SceneTypeMapper sceneTypeMapper;

    @Override
    public SceneType selectByPrimaryKey(String id) {
        return sceneTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateByPrimaryKey(SceneType sceneType) {
        Integer integer = sceneTypeMapper.updateByPrimaryKey(sceneType);
        if(integer>0){
            return true;
        }
        return false;
    }

    @Override
    public List<SceneType> selectList() {
        return sceneTypeMapper.selectList();
    }

    @Override
    public List<SceneType> selectListByAlias(String alias) {
        return sceneTypeMapper.selectListByAlias(alias);
    }

    @Override
    public boolean deleteByPrimaryKey(String id) {
        Integer integer = sceneTypeMapper.deleteByPrimaryKey(id);
        if(integer>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean insert(SceneType sceneType) {
        Integer integer = sceneTypeMapper.insert(sceneType);
        if(integer>0){
            return true;
        }
        return false;
    }
}
