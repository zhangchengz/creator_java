package com.tlf.creatoraccount.dao;

import com.tlf.creatoraccount.pojo.AccountsAndRoles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountAndRoleMapper {

   AccountsAndRoles queryAccountAndRoleByAccountId(String accountId);
   List<AccountsAndRoles> queryAccountAndRoleByRoleId(String rolesId,Integer offset,Integer limit);
   void insertAccountAndRole(AccountsAndRoles accountsAndRoles);
   void deleteAccountAndRole(String id);
   Integer selectTotal(String rolesId);
   void deleteAccount(String accountId);
}
