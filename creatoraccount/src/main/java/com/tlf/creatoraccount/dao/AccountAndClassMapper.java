package com.tlf.creatoraccount.dao;

import com.tlf.creatoraccount.pojo.AccountAndClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AccountAndClassMapper {

    AccountAndClass queryAccountAndClassByAccountId(String accountId);
    List<AccountAndClass> queryAccountAndClassByClassId(String classId);
    void insertAccountAndClass(AccountAndClass aac);
    void deleteAccountAndClass(String accountId,String classId);
}
