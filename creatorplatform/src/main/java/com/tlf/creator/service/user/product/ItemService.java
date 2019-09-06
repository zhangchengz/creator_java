package com.tlf.creator.service.user.product;

import com.tlf.creator.entity.user.product.Item;
import com.tlf.creator.vo.ItemVO;

import java.util.List;

public interface ItemService {

    List<Item> selectList();

    boolean insertItem(Item item);

    boolean deleteItem(String id);

    List<ItemVO> selectItemAndVersion();
}
