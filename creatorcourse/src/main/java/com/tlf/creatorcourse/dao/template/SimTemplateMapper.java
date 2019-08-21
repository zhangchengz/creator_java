package com.tlf.creatorcourse.dao.template;

import com.tlf.creatorcourse.entity.template.SimTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SimTemplateMapper {

    int deleteByPrimaryKey(String id);

    int insert(SimTemplate record);

    List<SimTemplate> selectByTemplateId(String templateId);

    SimTemplate selectByPrimaryKey(String id);

    int deleteByTemplateId(String templateId);

    int updateByPrimaryKey(SimTemplate record);
}