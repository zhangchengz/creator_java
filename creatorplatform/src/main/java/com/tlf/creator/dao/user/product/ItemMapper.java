package com.tlf.creator.dao.user.product;

import com.tlf.creator.entity.user.product.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ItemMapper {

    int deleteByPrimaryKey(String id);

    List<Item> selectList();

    int insert(Item record);

    Item selectByPrimaryKey(String id);

    int updateByPrimaryKey(Item record);
}