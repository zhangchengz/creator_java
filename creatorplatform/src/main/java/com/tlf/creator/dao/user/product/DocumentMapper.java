package com.tlf.creator.dao.user.product;

import com.tlf.creator.entity.user.product.Document;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * dao for document
 *
 * @author zhangc
 * @date 2019/9/5
 */
@Mapper
@Repository
public interface DocumentMapper {

    int deleteByPrimaryKey(String id);

    int insert(Document record);

    Document selectByPrimaryKey(String id);

    List<Document> selectByVersion(String versionId);
}