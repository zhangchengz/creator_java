package com.tlf.creator.service.user.product;

import com.tlf.creator.entity.user.product.Version;
import com.tlf.creator.po.VersionPO;

import java.util.List;

/**
 * @author zhangc
 * @date 2019/9/5
 */
public interface VersionService {

    List<Version> selectVersionByItem(String itemId);

    VersionPO selectNameById(String id);

    boolean insertVersion(Version version);

    boolean deleteVersion(String id);

    boolean updateVersion(String id,String bulletin);

}
