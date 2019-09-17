package com.cubespace.relaying.dao;

import com.cubespace.relaying.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * dao层mapper
 *
 * @author zhangc
 * @date 2019/9/10
 */
@Repository
@Mapper
public interface UserMapper {

    /**
     * 根据账号查询用户信息
     *
     * @param number
     * @return
     */
    User selectByNumber(String number);

    /**
     * g根据id查询用户信息
     *
     * @param id
     * @return
     */
    User selectById(String id);

    /**
     * 修改用户密码
     * @param pwd
     * @param id
     * @return
     */
    int updatePwdById(String pwd,String id);

    /**
     * 查询学生列表
     * @return 学生id
     */
    List<User> selectAllStudents();
}
