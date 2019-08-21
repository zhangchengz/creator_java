package com.tlf.creatoraccount.controller;

import com.alibaba.fastjson.JSONObject;
import com.tlf.creatoraccount.common.JsonResult;
import com.tlf.creatoraccount.common.JsonRet;
import com.tlf.creatoraccount.constants.Constants;
import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.pojo.Accounts;
import com.tlf.creatoraccount.req.TeacherReq;
import com.tlf.creatoraccount.service.IAccountService;
import com.tlf.creatoraccount.service.ICoursesService;
import com.tlf.creatoraccount.service.IRoleService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * @throws OperatingException
     */
    @RequestMapping(value = "get_teacher_list", method = RequestMethod.POST)
    public JsonRet getTeachers(@RequestBody TeacherReq req) throws OperatingException {
        Integer offset = req.getOffset();
        Integer limit = req.getLimit();
        //List<Accounts> list = accountService.queryTeachers(offset, limit);
        //Integer length = accountService.queryTotal("teacher");
        List teacher = accountService.selectAccounts("teacher", offset, limit);
        Integer length = accountService.selectCounts("teacher");
        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", length, teacher);
    }

    /**
     * 添加老师
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "add_teacher", method = RequestMethod.POST)
    public JsonResult addTeacher(@RequestBody TeacherReq req) throws OperatingException {
        List<String> list = accountService.selectAllPhone();
        String phone = req.getPhone();
        for (String phone1 : list) {
            if (phone.equals(phone1)) {
                //检查手机号是否已存在
                return new JsonResult(Constants.CODE_EXIST, "该号码已经存在，请重新输入", null);
            }
        }
        String name = req.getName();
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
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 修改教师属性
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_teacher_information", method = RequestMethod.POST)
    public JsonResult modifyTeacherInformation(@RequestBody TeacherReq req) throws OperatingException {
        List<String> list = accountService.selectPhoneApartSelf(req.getId());
        String phone = req.getPhone();
        for (String phone1 : list) {
            if (phone.equals(phone1)) {
                //检查手机号是否已存在
                return new JsonResult(Constants.CODE_EXIST, "该号码已经存在，请重新输入", null);
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
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 删除教师
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "delete_teacher", method = RequestMethod.POST)
    public JsonResult deleteTeacher(@RequestBody TeacherReq req) throws OperatingException {
        String id = req.getId();
        Accounts accounts = accountService.queryAccountById(id);
        if (accounts == null) {
            return new JsonResult(Constants.CODE_FAIL, "TEACHER DOES NOT EXISTS", null);
        }
        accountService.deleteAccount(id);
        roleService.deleteAccount(id);
        coursesService.deleteCourseAndTeacherByTeacher(id);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }


}
