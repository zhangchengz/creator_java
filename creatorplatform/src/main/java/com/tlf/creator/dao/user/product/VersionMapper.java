package com.tlf.creator.dao.user.product;

import com.tlf.creator.entity.user.product.Version;
import com.tlf.creator.po.VersionPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VersionMapper {

    int deleteByPrimaryKey(String id);

    int insert(Version record);

    List<Version> selectByItem(String itemId);

    VersionPO selectNameById(String id);

    Version selectByPrimaryKey(String id);

    int updateByPrimaryKey(Version record);
}