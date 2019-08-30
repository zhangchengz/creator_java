package com.tlf.creator.service.user.account;

import com.tlf.creator.entity.user.account.Roles;

public interface IRoleService {

    Roles queryRoles(String accountId);

    void addTeacher(String accountId);

    void addStudent(String accountId);

    void deleteAccount(String accountId);
}
