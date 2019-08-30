package com.tlf.creator.dao.user.account;

import com.tlf.creator.entity.user.account.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleMapper {

    Roles queryRoleById(String id);
    Roles queryRoleByName(String name);
    Integer selectTotal();
    void updateRole(String id);
}
