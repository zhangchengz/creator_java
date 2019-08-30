package com.tlf.creator.service.user.account;

import com.tlf.creator.entity.user.account.Online;
import com.tlf.creator.po.OnlinePO;

import java.util.List;

public interface IOnlineService {

    Online selectByAccount(String accountId);

    List<OnlinePO> selectAllTime(String classId);

    boolean insert(Online record);

    boolean updateLoginByAccount(Long login, String accountId);

    boolean updateOnlineByAccount(String accountId);
}
