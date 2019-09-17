package com.cubespace.relaying.controller;

import com.cubespace.relaying.common.Constants;
import com.cubespace.relaying.common.JsonResult;
import com.cubespace.relaying.po.UserPO;
import com.cubespace.relaying.vo.StudentVO;
import com.cubespace.relaying.vo.UserVO;
import com.cubespace.relaying.service.UserService;
import com.cubespace.relaying.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * controller 管理员功能
 *
 * @author zhangc
 * @date 2019/9/12
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "login")
    public JsonResult login(@RequestBody UserPO userPo) {
        if (StringUtils.isBlank(userPo.getNumber()) || StringUtils.isBlank(userPo.getPassword())) {
            return new JsonResult(Constants.CODE_FAIL, "请输入账号密码", null);
        }
        UserVO userVO = userService.login(userPo.getNumber(), userPo.getPassword(), Constants.ROLE_ADMIN);
        if (userVO == null) {
            return new JsonResult(Constants.CODE_AUTH, "账号或密码错误", null);
        } else {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", userVO);
        }
    }

    @PostMapping(value = "get_student_list")
    public JsonResult getStudentList(@RequestBody UserPO userPo) {
        String id = userPo.getId();
        String token = userPo.getToken();
        if (StringUtils.isBlank(id) || StringUtils.isBlank(token)) {
            return new JsonResult(Constants.CODE_FAIL, "id和token不能为空", null);
        }
        boolean verify = JwtUtil.verify(token);
        if (!verify) {
            return new JsonResult(Constants.CODE_EXPIRED, "登录凭证已过期,请重新登录", null);
        } else {
            String accountId = JwtUtil.getAccountId(token);
            if (!id.equals(accountId)) {
                return new JsonResult(Constants.CODE_EXPIRED, "登录状态异常", null);
            } else {
                String role = userService.getRoleById(id);
                if (!Constants.ROLE_ADMIN.equals(role)) {
                    return new JsonResult(Constants.CODE_EXPIRED, "您没有此权限", null);
                } else {
                    List<StudentVO> studentVOS = userService.selectAllStudents();
                    return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", studentVOS);
                }
            }
        }
    }

    @PostMapping(value = "change_password_self")
    public JsonResult changePasswordSelf(@RequestBody UserPO userPo) {
        if (StringUtils.isBlank(userPo.getNumber()) || StringUtils.isBlank(userPo.getPassword()) || StringUtils.isBlank(userPo.getNewPassword())) {
            return new JsonResult(Constants.CODE_FAIL, "请输入账号密码", null);
        } else {
            boolean change = userService.changePwdSelf(userPo.getNumber(), userPo.getPassword(), userPo.getNewPassword());
            if (change) {
                return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
            } else {
                return new JsonResult(Constants.CODE_FAIL, "FAIL", null);
            }
        }
    }

    @PostMapping(value = "change_password_batch")
    public JsonResult changePasswordBatch(@RequestBody UserPO userPo) {
        String id = userPo.getId();
        String token = userPo.getToken();
        if (StringUtils.isBlank(id) || StringUtils.isBlank(token) || userPo.getUserIds() == null) {
            return new JsonResult(Constants.CODE_FAIL, "用户列表，id和token不能为空", null);
        }
        boolean verify = JwtUtil.verify(token);
        if (!verify) {
            return new JsonResult(Constants.CODE_EXPIRED, "登录凭证已过期,请重新登录", null);
        } else {
            String accountId = JwtUtil.getAccountId(token);
            if (!id.equals(accountId)) {
                return new JsonResult(Constants.CODE_EXPIRED, "登录状态异常", null);
            } else {
                String role = userService.getRoleById(id);
                if (!Constants.ROLE_ADMIN.equals(role)) {
                    return new JsonResult(Constants.CODE_EXPIRED, "您没有此权限", null);
                } else {
                    boolean change = userService.batchResetPwd(userPo.getUserIds());
                    return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
                }
            }
        }
    }

}
