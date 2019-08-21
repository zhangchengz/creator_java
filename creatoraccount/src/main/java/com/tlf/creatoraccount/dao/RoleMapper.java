package com.tlf.creatoraccount.dao;

import com.tlf.creatoraccount.pojo.Roles;
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
