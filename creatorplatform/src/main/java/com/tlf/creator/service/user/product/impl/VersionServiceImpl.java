package com.tlf.creator.service.user.product.impl;

import com.tlf.creator.dao.user.product.VersionMapper;
import com.tlf.creator.entity.user.product.Version;
import com.tlf.creator.po.VersionPO;
import com.tlf.creator.service.user.product.VersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VersionServiceImpl implements VersionService {

    @Autowired
    private VersionMapper versionMapper;

    @Override
    public List<Version> selectVersionByItem(String itemId) {
        List<Version> versions = versionMapper.selectByItem(itemId);
        return versions;
    }

    @Override
    public VersionPO selectNameById(String id) {
        VersionPO versionPO = versionMapper.selectNameById(id);
        return versionPO;
    }

    @Override
    public boolean insertVersion(Version version) {
        int insert = versionMapper.insert(version);
        if(insert>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteVersion(String id) {
        int delete = versionMapper.deleteByPrimaryKey(id);
        if(delete>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateVersion(String id, String bulletin) {
        Version version = versionMapper.selectByPrimaryKey(id);
        if(version==null){
            return false;
        }
        version.setBulletin(bulletin);
        int update = versionMapper.updateByPrimaryKey(version);
        if(update>0){
            return true;
        }
        return false;
    }


}
