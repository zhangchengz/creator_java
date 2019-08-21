package com.tlf.creatoraccount.service.impl;

import com.tlf.creatoraccount.dao.AccountMapper;
import com.tlf.creatoraccount.dao.OnlineMapper;
import com.tlf.creatoraccount.po.OnlinePO;
import com.tlf.creatoraccount.pojo.Accounts;
import com.tlf.creatoraccount.pojo.Online;
import com.tlf.creatoraccount.service.IOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OnlineServiceImpl implements IOnlineService {

    @Autowired
    private OnlineMapper onlineMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Online selectByAccount(String accountId) {
        Online online = onlineMapper.selectByAccount(accountId);
        return online;
    }

    @Override
    public List<OnlinePO> selectAllTime(String classId) {
        List<Online> onlines = onlineMapper.selectAllTime();
        List<Accounts> list = accountMapper.selectStudentByClass(classId);
        List<OnlinePO> list1 = new ArrayList<>();
        for(Accounts account:list){
            if(account!=null){
                OnlinePO onlinePO = new OnlinePO();
                onlinePO.setAccountId(account.getId());
                onlinePO.setAccountName(account.getName());
                for(Online online:onlines){
                    if(online!=null){
                        String accountId = online.getAccountId();
                        if(accountId!=null&&accountId.equals(account.getId())){
                            onlinePO.setOnlineTime(online.getOnlineTime());
                        }
                    }
                }
                list1.add(onlinePO);
            }
        }
        return list1;
    }

    @Override
    public boolean insert(Online record) {
        int insert = onlineMapper.insert(record);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateLoginByAccount(Long login, String accountId) {
        Online online = onlineMapper.selectByAccount(accountId);
        if (online == null) {
            String id = UUID.randomUUID().toString();
            Online online1 = new Online();
            online1.setId(id);
            online1.setAccountId(accountId);
            online1.setOnlineTime(0.0);
            online1.setLogin(login);
            onlineMapper.insert(online1);
            return true;
        } else {
            int i = onlineMapper.updateLoginByAccount(login, accountId);
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateOnlineByAccount(String accountId) {
        Online online = onlineMapper.selectByAccount(accountId);
        if (online != null) {
            Long login = online.getLogin();
            Long timeMillis = System.currentTimeMillis();
            Long time = timeMillis - login;
            Double onlineTime = time * 1.0 / 3600000;
            Double onlineTime1 = online.getOnlineTime() + onlineTime;
            int i = onlineMapper.updateOnlineByAccount(onlineTime1, accountId);
            if (i > 0) {
                return true;
            }
        }
        return false;
    }

}
