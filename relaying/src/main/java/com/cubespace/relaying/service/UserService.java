package com.cubespace.relaying.service;

import com.cubespace.relaying.vo.StudentVO;
import com.cubespace.relaying.vo.UserVO;

import java.util.List;

/**
 * service层
 *
 * @author zhangc
 * @date 2019/9/10
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param number   账号
     * @param password  密码
     * @param role  角色
     * @return
     */
    UserVO login(String number, String password,String role);

    /**
     * 用户修改密码
     * @param number  账号
     * @param password     原密码
     * @param newPassword  新密码
     * @return 成功修改数量
     */
    boolean changePwdSelf(String number,String password,String newPassword);

    /**
     * 管理员批量重置密码
     * @param id 需要重置的用户id
     * @return 成功修改数量
     */
    boolean batchResetPwd(List<String> id);

    /**
     * 查询学生列表
     * @return 学生id
     */
    List<StudentVO> selectAllStudents();

    /**
     * 根据id获取角色
     * @param id 用户id
     * @return 用户角色名
     */
    String getRoleById(String id);
}
