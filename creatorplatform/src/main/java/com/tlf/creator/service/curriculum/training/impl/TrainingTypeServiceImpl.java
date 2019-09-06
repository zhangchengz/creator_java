package com.tlf.creator.service.curriculum.training.impl;

import com.tlf.creator.aspect.DS;
import com.tlf.creator.dao.curriculum.training.TrainingTypeMapper;
import com.tlf.creator.entity.curriculum.training.TrainingType;
import com.tlf.creator.service.curriculum.training.TrainingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 接口实现类
 *
 * @author zhangc
 * @date 2019/9/5
 */
@Service
public class TrainingTypeServiceImpl implements TrainingTypeService {

    @Autowired
    private TrainingTypeMapper typeMapper;

    @Override
    @DS
    public boolean deleteByPrimaryKey(String courseId,String id) {
        int delete = typeMapper.deleteByPrimaryKey(id);
        if(delete>0){
            return true;
        }
        return false;
    }

    @Override
    @DS
    public boolean insert(String courseId,TrainingType record) {
        int insert = typeMapper.insert(record);
        if(insert>0){
            return true;
        }
        return false;
    }
}
