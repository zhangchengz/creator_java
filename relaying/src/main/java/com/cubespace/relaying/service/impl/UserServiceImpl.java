package com.cubespace.relaying.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.cubespace.relaying.common.Constants;
import com.cubespace.relaying.dao.UserMapper;
import com.cubespace.relaying.entity.User;
import com.cubespace.relaying.vo.StudentVO;
import com.cubespace.relaying.vo.UserVO;
import com.cubespace.relaying.service.UserService;
import com.cubespace.relaying.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * service层实现类
 *
 * @author zhangc
 * @date 2019/9/10
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVO login(String number, String password, String role) {
        User user = userMapper.selectByNumber(number);
        if (user == null) {
            return null;
        }
        String pwd = user.getPwd();
        String md5Password = SecureUtil.md5(password);
        if (!pwd.equals(md5Password)) {
            return null;
        }
        if (!role.equals(user.getRole())) {
            return null;
        }
        String token = JwtUtil.sign(user.getId());
        UserVO userVO = new UserVO(user.getId(), token, number);
        return userVO;
    }

    @Override
    public boolean changePwdSelf(String number, String password, String newPassword) {
        User user = userMapper.selectByNumber(number);
        if (user == null) {
            return false;
        }
        String pwd = user.getPwd();
        String md5Password = SecureUtil.md5(password);
        if (!pwd.equals(md5Password)) {
            return false;
        }
        String md5PasswordNew = SecureUtil.md5(newPassword);
        int i = userMapper.updatePwdById( md5PasswordNew,user.getId());
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean batchResetPwd(List<String> id) {
        String initialPassword = SecureUtil.md5(Constants.INITIAL_PASSWORD);
        for (String s : id) {
            userMapper.updatePwdById(initialPassword, s);
        }
        return true;
    }

    @Override
    public List<StudentVO> selectAllStudents() {
        List<User> list = userMapper.selectAllStudents();
        List<StudentVO> studentVOS = new ArrayList<>();
        if(list==null){
            return null;
        }
        int index = 1;
        for (User user : list) {
            if (user != null) {
                StudentVO studentVO = new StudentVO(index, user.getNumber(), user.getId());
                studentVOS.add(studentVO);
                index++;
            }
        }
        return studentVOS;
    }

    @Override
    public String getRoleById(String id) {
        User user = userMapper.selectById(id);
        if(user==null){
            return null;
        }else{
            String role = user.getRole();
            return role;
        }
    }

}
