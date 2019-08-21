package com.tlf.creatorcourse.dao.simulationresource;

import com.tlf.creatorcourse.entity.simulation.SceneType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SceneTypeMapper {

    SceneType selectByPrimaryKey(String id);
    Integer updateByPrimaryKey(SceneType sceneType);
    List<SceneType> selectList();
    List<SceneType> selectListByAlias(String alias);
    Integer deleteByPrimaryKey(String id);
    Integer insert(SceneType sceneType);
}
