package com.tlf.creatorcourse.service.simulationresource;

import com.tlf.creatorcourse.entity.simulation.SceneType;

import java.util.List;

public interface ISceneTypeService {

    SceneType selectByPrimaryKey(String id);
    boolean updateByPrimaryKey(SceneType sceneType);
    List<SceneType> selectList();
    List<SceneType> selectListByAlias(String alias);
    boolean deleteByPrimaryKey(String id);
    boolean insert(SceneType sceneType);
}
