package com.tlf.creator.service.user.product.impl;

import com.tlf.creator.dao.user.product.ItemMapper;
import com.tlf.creator.dao.user.product.VersionMapper;
import com.tlf.creator.entity.user.product.Item;
import com.tlf.creator.entity.user.product.Version;
import com.tlf.creator.service.user.product.ItemService;
import com.tlf.creator.vo.ItemVO;
import com.tlf.creator.vo.VersionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private VersionMapper versionMapper;

    @Override
    public List<Item> selectList() {
        List<Item> items = itemMapper.selectList();
        return items;
    }

    @Override
    public boolean insertItem(Item item) {
        int insert = itemMapper.insert(item);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteItem(String id) {
        int delete = itemMapper.deleteByPrimaryKey(id);
        if(delete>0){
            return true;
        }
        return false;
    }

    @Override
    public List<ItemVO> selectItemAndVersion() {
        List<ItemVO> list= new ArrayList<>();
        List<Item> items = itemMapper.selectList();
        for(Item item:items){
            if(item!=null){
                ItemVO itemVO = new ItemVO();
                itemVO.setItemId(item.getId());
                itemVO.setItemName(item.getName());
                List<Version> versions = versionMapper.selectByItem(item.getId());
                if(versions!=null){
                    List<VersionVO> list1 = new ArrayList<>();
                    for(Version version:versions){
                        if(version!=null){
                            VersionVO versionVO = new VersionVO(version.getId(), version.getName());
                            list1.add(versionVO);
                        }
                    }
                    itemVO.setVersions(list1);
                }
                list.add(itemVO);
            }
        }
        return list;
    }


}
