package com.tlf.creator.dao.curriculum.training;

import com.tlf.creator.entity.curriculum.training.TrainingType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapper
 *
 * @author zhangc
 * @date 2019/9/5
 */
@Mapper
@Repository
public interface TrainingTypeMapper {

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增
     *
     * @param record
     * @return
     */
    int insert(TrainingType record);

    /**
     * 查询所有的类型
     *
     * @return
     */
    List<TrainingType> selectAllTypes();

    /**
     * 根据id查询类型
     *
     * @param id
     * @return
     */
    TrainingType selectByPrimaryKey(String id);

    /**
     * 根据id修改内容
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(TrainingType record);
}