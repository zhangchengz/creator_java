package com.tlf.creatoraccount.service;

import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.pojo.Roles;

public interface IRoleService {

    Roles queryRoles(String accountId)throws OperatingException;
    void addTeacher(String accountId)throws OperatingException;
    void addStudent(String accountId)throws OperatingException;
    void deleteAccount(String accountId)throws OperatingException;
}
