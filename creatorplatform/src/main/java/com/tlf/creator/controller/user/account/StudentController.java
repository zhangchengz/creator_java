package com.tlf.creator.controller.user.account;

import com.tlf.creator.common.JsonResult;
import com.tlf.creator.common.Constants;
import com.tlf.creator.entity.user.account.Accounts;
import com.tlf.creator.permission.AuthToken;
import com.tlf.creator.req.StudentReq;
import com.tlf.creator.service.user.account.IAccountService;
import com.tlf.creator.service.user.account.IRoleService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequestMapping
@RestController
public class StudentController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IRoleService roleService;

    /**
     * 查询学生列表
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "get_student_list", method = RequestMethod.POST)
    public JsonResult getStudentList(@RequestBody StudentReq req) {
        Integer limit = req.getLimit();
        Integer offset = req.getOffset();
        if(limit==null||offset==null){
            return new JsonResult(Constants.CODE_FAIL, "请输入正确的查询参数", null, null);
        }
        Integer length = accountService.selectCounts("student");
        List student = accountService.selectAccounts("student", offset, limit);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", length, student);
    }

    /**
     * 添加学生
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "add_student", method = RequestMethod.POST)
    @AuthToken(role_name = "admin")
    public JsonResult addStudent(@RequestBody StudentReq req) {
        List<String> numbers = accountService.selectAllNumber();
        String number = req.getNumber();
        String phone = req.getPhone();
        String name = req.getName();
        if(StringUtils.isBlank(number)||StringUtils.isBlank(phone)||StringUtils.isBlank(name)){
            return new JsonResult(Constants.CODE_FAIL, "学号、手机号、姓名均不能为空", null, null);
        }
        for (String stuNumber : numbers) {
            if (number.equals(stuNumber)) {
                //检查学号是否已经存在
                return new JsonResult(Constants.CODE_EXIST, "该学号已经存在，请重新输入", null, null);
            }
        }
        List<String> list = accountService.selectAllPhone();

        for (String phone1 : list) {
            if (phone.equals(phone1)) {
                //检查手机号是否已存在
                return new JsonResult(Constants.CODE_EXIST, "该手机号码已经存在，请重新输入", null, null);
            }
        }
        Integer age = req.getAge();
        String gender = req.getGender();
        String email = req.getEmail();
        Accounts account = new Accounts();
        String id = UUID.randomUUID().toString();
        account.setId(id);
        account.setNumber(number);
        account.setName(name);
        account.setPhone(phone);
        String pwd = new SimpleHash("MD5", Constants.INITIAL_PASSWORD, id.substring(id.length() - 6)).toHex();
        account.setPwd(pwd);
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
        roleService.addStudent(id);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
    }

    /**
     * 修改学生属性
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "modify_student_information", method = RequestMethod.POST)
    @AuthToken(role_name = "admin")
    public JsonResult modifyStudentInformation(@RequestBody StudentReq req) {
        List<String> list = accountService.selectPhoneApartSelf(req.getId());
        String phone = req.getPhone();
        for (String phone1 : list) {
            if (phone.equals(phone1)) {
                //检查手机号是否已存在
                return new JsonResult(Constants.CODE_EXIST, "该号码已经存在，请重新输入", null, null);
            }
        }
        String id = req.getId();
        String email = req.getEmail();
        String name = req.getName();
        String gender = req.getGender();
        Integer age = req.getAge();
        Accounts accounts = accountService.queryAccountById(id);
        accounts.setName(name);
        accounts.setPhone(phone);
        if (accounts == null) {
            return new JsonResult(Constants.CODE_FAIL, "ID IS WRONG", null, null);
        }
        accounts.setGender(gender);
        accounts.setAge(age);
        accounts.setEmail(email);
        accountService.modifyAccount(accounts);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
    }

    /**
     * 删除学生
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "delete_student", method = RequestMethod.POST)
    @AuthToken(role_name = "admin")
    public JsonResult deleteStudent(@RequestBody StudentReq req) {
        String id = req.getId();
        if (StringUtils.isBlank(id)) {
            return new JsonResult(Constants.CODE_FAIL, "ID CAN NOT BE NULL", null, null);
        }
        Accounts accounts = accountService.queryAccountById(id);
        if (accounts == null) {
            return new JsonResult(Constants.CODE_FAIL, "STUDENT DOES NOT EXISTS", null, null);
        }
        accountService.deleteAccount(id);
        roleService.deleteAccount(id);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
    }

    /**
     * 获取没有班级的学生列表
     *
     * @return
     */
    @RequestMapping(value = "get_students_no_class", method = RequestMethod.POST)
    public JsonResult getStudentNoClassList() {
        List<Accounts> list = accountService.selectStudentNoClass();
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, list);
    }

}
