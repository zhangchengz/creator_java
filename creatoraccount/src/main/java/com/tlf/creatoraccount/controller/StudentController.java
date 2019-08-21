package com.tlf.creatoraccount.controller;

import com.tlf.creatoraccount.common.JsonResult;
import com.tlf.creatoraccount.common.JsonRet;
import com.tlf.creatoraccount.constants.Constants;
import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.po.StudentPO;
import com.tlf.creatoraccount.pojo.Accounts;
import com.tlf.creatoraccount.req.StudentReq;
import com.tlf.creatoraccount.service.IAccountService;
import com.tlf.creatoraccount.service.IRoleService;
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
     * @throws OperatingException
     */
    @RequestMapping(value = "get_student_list", method = RequestMethod.POST)
    public JsonRet getStudentList(@RequestBody StudentReq req) throws OperatingException {
        Integer limit = req.getLimit();
        Integer offset = req.getOffset();
        //List<StudentPO> studentPOS = accountService.queryStudents(offset, limit);
        //Integer length = accountService.queryTotal("student");
        Integer length = accountService.selectCounts("student");
        List student = accountService.selectAccounts("student", offset, limit);
        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", length, student);
    }

    /**
     * 添加学生
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "add_student", method = RequestMethod.POST)
    public JsonResult addStudent(@RequestBody StudentReq req) throws OperatingException {
        List<String> numbers = accountService.selectAllNumber();
        String number = req.getNumber();
        for (String stuNumber : numbers) {
            if (number.equals(stuNumber)) {
                //检查学号是否已经存在
                return new JsonResult(Constants.CODE_EXIST, "该学号已经存在，请重新输入", null);
            }
        }
        List<String> list = accountService.selectAllPhone();
        String phone = req.getPhone();
        for (String phone1 : list) {
            if (phone.equals(phone1)) {
                //检查手机号是否已存在
                return new JsonResult(Constants.CODE_EXIST, "该手机号码已经存在，请重新输入", null);
            }
        }
        String name = req.getName();

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
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 修改学生属性
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_student_information", method = RequestMethod.POST)
    public JsonResult modifyStudentInformation(@RequestBody StudentReq req) throws OperatingException {
        List<String> list = accountService.selectPhoneApartSelf(req.getId());
        String phone = req.getPhone();
        for (String phone1 : list) {
            if (phone.equals(phone1)) {
                //检查手机号是否已存在
                return new JsonResult(Constants.CODE_EXIST, "该号码已经存在，请重新输入", null);
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
            return new JsonResult(Constants.CODE_FAIL, "ID IS WRONG", null);
        }
        accounts.setGender(gender);
        accounts.setAge(age);
        accounts.setEmail(email);
        accountService.modifyAccount(accounts);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 删除学生
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "delete_student", method = RequestMethod.POST)
    public JsonResult deleteStudent(@RequestBody StudentReq req) throws OperatingException {
        String id = req.getId();
        if (id == null) {
            return new JsonResult(Constants.CODE_FAIL, "ID CAN NOT BE NULL", null);
        }
        Accounts accounts = accountService.queryAccountById(id);
        if (accounts == null) {
            return new JsonResult(Constants.CODE_FAIL, "STUDENT DOES NOT EXISTS", null);
        }
        accountService.deleteAccount(id);
        roleService.deleteAccount(id);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 获取没有班级的学生列表
     *
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_students_no_class", method = RequestMethod.POST)
    public JsonResult getStudentNoClassList() throws OperatingException {
        List<Accounts> list = accountService.selectStudentNoClass();
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", list);
    }

}
