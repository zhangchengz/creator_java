package com.tlf.creator.service.curriculum.simulationresource;

import com.tlf.creator.entity.curriculum.simulation.SceneType;

import java.util.List;

public interface ISceneTypeService {

    SceneType selectByPrimaryKey(String courseId,String id);
    boolean updateByPrimaryKey(String courseId,SceneType sceneType);
    List<SceneType> selectList(String courseId);
    List<SceneType> selectListByAlias(String courseId,String alias);
    boolean deleteByPrimaryKey(String courseId,String id);
    boolean insert(String courseId,SceneType sceneType);
}
