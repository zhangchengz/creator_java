package com.tlf.creatoraccount.service;

import com.tlf.creatoraccount.po.OnlinePO;
import com.tlf.creatoraccount.pojo.Online;

import java.util.List;

public interface IOnlineService {

    Online selectByAccount(String accountId);

    List<OnlinePO> selectAllTime(String classId);

    boolean insert(Online record);

    boolean updateLoginByAccount(Long login, String accountId);

    boolean updateOnlineByAccount(String accountId);
}
