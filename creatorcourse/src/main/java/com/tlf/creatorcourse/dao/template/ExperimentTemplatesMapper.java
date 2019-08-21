package com.tlf.creatorcourse.dao.template;

import com.tlf.creatorcourse.entity.template.ExperimentTemplates;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExperimentTemplatesMapper {

    List<ExperimentTemplates> selectListInner(Integer offset,Integer limit);

    List<ExperimentTemplates> selectListNotInner(String creatorId,Integer offset,Integer limit);

    Integer selectCountInner();

    Integer selectCountNotInner(String creatorId);

    List<String> selectAllNames(String creatorId);

    int deleteByPrimaryKey(String id);

    int insert(ExperimentTemplates record);

    ExperimentTemplates selectByPrimaryKey(String id);

    int updateByPrimaryKey(ExperimentTemplates record);

    int updateTemplateInner(String id);

    List<ExperimentTemplates> selectAllTemplates(Integer offset,Integer limit);

    Integer selectCount();

}