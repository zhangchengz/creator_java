package com.tlf.creator.service.user.account.impl;

import com.tlf.creator.common.Constants;
import com.tlf.creator.dao.user.account.AccountAndRoleMapper;
import com.tlf.creator.dao.user.account.RoleMapper;
import com.tlf.creator.entity.user.account.AccountsAndRoles;
import com.tlf.creator.entity.user.account.Roles;
import com.tlf.creator.service.user.account.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private AccountAndRoleMapper accountAndRoleMapper;

    @Autowired
    private RoleMapper roleMapper;



    @Override
    public Roles queryRoles(String accountId){
        AccountsAndRoles accountsAndRole = accountAndRoleMapper.queryAccountAndRoleByAccountId(accountId);
        Roles role = roleMapper.queryRoleById(accountsAndRole.getRolesId());
        return role;
    }

    @Override
    public void addTeacher(String accountId)  {
        AccountsAndRoles accountsAndRoles = new AccountsAndRoles();
        String id = UUID.randomUUID().toString();
        accountsAndRoles.setId(id);
        accountsAndRoles.setAccountsId(accountId);
        accountsAndRoles.setRolesId(Constants.ROLE_TEACHER_ID);
        accountAndRoleMapper.insertAccountAndRole(accountsAndRoles);
    }

    @Override
    public void addStudent(String accountId)   {
        AccountsAndRoles accountsAndRoles = new AccountsAndRoles();
        String id = UUID.randomUUID().toString();
        accountsAndRoles.setId(id);
        accountsAndRoles.setAccountsId(accountId);
        accountsAndRoles.setRolesId(Constants.ROLE_STUDENT_ID);
        accountAndRoleMapper.insertAccountAndRole(accountsAndRoles);
    }

    @Override
    public void deleteAccount(String accountId)   {
        AccountsAndRoles accountsAndRoles = accountAndRoleMapper.queryAccountAndRoleByAccountId(accountId);
        if(accountsAndRoles==null){
            return;
        }
        accountAndRoleMapper.deleteAccount(accountId);
    }


}
