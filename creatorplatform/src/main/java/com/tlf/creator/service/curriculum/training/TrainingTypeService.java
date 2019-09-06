package com.tlf.creator.service.curriculum.training;

import com.tlf.creator.entity.curriculum.training.TrainingType;

/**
 * 接口类
 *
 * @author zhangc
 * @2019/9/5
 */
public interface TrainingTypeService {

    /**
     * 根据id删除一条记录
     *
     * @param id trainingTypeId
     * @param courseId courseId
     * @return success or fail
     */
    boolean deleteByPrimaryKey(String courseId,String id);

    /**
     * 新增一条记录
     *
     * @param record trainingType
     * @param courseId courseId
     * @return success or fail
     */
    boolean insert(String courseId,TrainingType record);
}
