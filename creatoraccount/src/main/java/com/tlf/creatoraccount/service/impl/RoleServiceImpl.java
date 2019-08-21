package com.tlf.creatoraccount.service.impl;

import com.tlf.creatoraccount.constants.Constants;
import com.tlf.creatoraccount.dao.AccountAndRoleMapper;
import com.tlf.creatoraccount.dao.RoleMapper;
import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.pojo.AccountsAndRoles;
import com.tlf.creatoraccount.pojo.Roles;
import com.tlf.creatoraccount.service.IRoleService;
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
    public void addTeacher(String accountId) throws OperatingException {
        AccountsAndRoles accountsAndRoles = new AccountsAndRoles();
        String id = UUID.randomUUID().toString();
        accountsAndRoles.setId(id);
        accountsAndRoles.setAccountsId(accountId);
        accountsAndRoles.setRolesId(Constants.ROLE_TEACHER_ID);
        accountAndRoleMapper.insertAccountAndRole(accountsAndRoles);
    }

    @Override
    public void addStudent(String accountId) throws OperatingException {
        AccountsAndRoles accountsAndRoles = new AccountsAndRoles();
        String id = UUID.randomUUID().toString();
        accountsAndRoles.setId(id);
        accountsAndRoles.setAccountsId(accountId);
        accountsAndRoles.setRolesId(Constants.ROLE_STUDENT_ID);
        accountAndRoleMapper.insertAccountAndRole(accountsAndRoles);
    }

    @Override
    public void deleteAccount(String accountId) throws OperatingException {
        AccountsAndRoles accountsAndRoles = accountAndRoleMapper.queryAccountAndRoleByAccountId(accountId);
        if(accountsAndRoles==null){
            throw new OperatingException(Constants.CODE_FAIL,"ACCOUNT DOES NOT EXISTS");
        }
        accountAndRoleMapper.deleteAccount(accountId);
    }


}
