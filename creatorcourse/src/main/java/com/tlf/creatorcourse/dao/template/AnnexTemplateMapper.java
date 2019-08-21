package com.tlf.creatorcourse.dao.template;

import com.tlf.creatorcourse.entity.template.AnnexTemplate;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AnnexTemplateMapper {

    int deleteByPrimaryKey(String id);

    int insert(AnnexTemplate record);

    List<AnnexTemplate> selectByTemplateId(String templateId);

    int deleteByTemplateId(String templateId);

    int updateByPrimaryKey(AnnexTemplate record);
}