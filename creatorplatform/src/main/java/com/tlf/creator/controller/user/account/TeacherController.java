package com.tlf.creator.controller.user.account;

import com.tlf.creator.common.JsonResult;
import com.tlf.creator.common.Constants;
import com.tlf.creator.entity.user.account.Accounts;
import com.tlf.creator.permission.AuthToken;
import com.tlf.creator.req.TeacherReq;
import com.tlf.creator.service.user.account.IAccountService;
import com.tlf.creator.service.user.account.IRoleService;
import com.tlf.creator.service.user.course.ICoursesService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class TeacherController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private ICoursesService coursesService;

    /**
     * 查询老师列表
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "get_teacher_list", method = RequestMethod.POST)
    public JsonResult getTeachers(@RequestBody TeacherReq req)   {
        Integer offset = req.getOffset();
        Integer limit = req.getLimit();
        if(limit==null||offset==null){
            return new JsonResult(Constants.CODE_FAIL, "请输入正确的查询参数", null, null);
        }
        List teacher = accountService.selectAccounts("teacher", offset, limit);
        Integer length = accountService.selectCounts("teacher");
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", length, teacher);
    }

    /**
     * 添加老师
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "add_teacher", method = RequestMethod.POST)
    @AuthToken(role_name = "admin")
    public JsonResult addTeacher(@RequestBody TeacherReq req)  {
        String name = req.getName();
        List<String> list = accountService.selectAllPhone();
        String phone = req.getPhone();
        if(StringUtils.isBlank(phone)||StringUtils.isBlank(name)){
            return new JsonResult(Constants.CODE_FAIL, "手机号、姓名不能为空", null, null);
        }
        for (String phone1 : list) {
            if (phone.equals(phone1)) {
                //检查手机号是否已存在
                return new JsonResult(Constants.CODE_EXIST, "该号码已经存在，请重新输入", null,null);
            }
        }
        Integer age = req.getAge();
        String gender = req.getGender();
        String email = req.getEmail();
        Accounts account = new Accounts();
        String id = UUID.randomUUID().toString();
        account.setId(id);
        account.setName(name);
        account.setPhone(phone);
        String pwd = new SimpleHash("MD5", Constants.INITIAL_PASSWORD, id.substring(id.length() - 6)).toHex();
        account.setPwd(pwd);
        account.setClasses("teacher");
        if (gender != null) {
            account.setGender(gender);
        }
        if (age != null) {
            account.setAge(age);
        }
        if (email != null) {
            account.setEmail(email);
        }
        accountService.addAccount(account);
        roleService.addTeacher(id);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS",null, null);
    }

    /**
     * 修改教师属性
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "modify_teacher_information", method = RequestMethod.POST)
    @AuthToken(role_name = "admin")
    public JsonResult modifyTeacherInformation(@RequestBody TeacherReq req)  {
        if(StringUtils.isBlank(req.getId())){
            return new JsonResult(Constants.CODE_FAIL, "登录失效",null, null);
        }
        List<String> list = accountService.selectPhoneApartSelf(req.getId());
        String phone = req.getPhone();
        for (String phone1 : list) {
            if (phone.equals(phone1)) {
                //检查手机号是否已存在
                return new JsonResult(Constants.CODE_EXIST, "该号码已经存在，请重新输入",null, null);
            }
        }
        String name = req.getName();
        Integer age = req.getAge();
        String gender = req.getGender();
        String email = req.getEmail();
        String id = req.getId();
        Accounts accounts = accountService.queryAccountById(id);
        accounts.setName(name);
        accounts.setPhone(phone);
        accounts.setGender(gender);
        accounts.setAge(age);
        accounts.setEmail(email);
        accountService.modifyAccount(accounts);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS",null, null);
    }

    /**
     * 删除教师
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "delete_teacher", method = RequestMethod.POST)
    @AuthToken(role_name = "admin")
    public JsonResult deleteTeacher(@RequestBody TeacherReq req)   {
        String id = req.getId();
        Accounts accounts = accountService.queryAccountById(id);
        if (accounts == null) {
            return new JsonResult(Constants.CODE_FAIL, "TEACHER DOES NOT EXISTS", null,null);
        }
        accountService.deleteAccount(id);
        roleService.deleteAccount(id);
        coursesService.deleteCourseAndTeacherByTeacher(id);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null,null);
    }


}
