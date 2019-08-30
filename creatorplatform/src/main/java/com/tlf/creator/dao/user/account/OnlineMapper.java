package com.tlf.creator.dao.user.account;

import com.tlf.creator.entity.user.account.Online;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OnlineMapper {

    Online selectByAccount(String accountId);

    List<Online> selectAllTime();

    int insert(Online record);

    int updateLoginByAccount(Long login, String accountId);

    int updateOnlineByAccount(Double onlineTime, String accountId);

}