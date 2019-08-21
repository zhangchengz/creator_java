package com.tlf.creatoraccount.controller;

import com.alibaba.fastjson.JSONObject;
import com.tlf.creatoraccount.common.JsonResult;
import com.tlf.creatoraccount.constants.Constants;
import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.po.ClassPO;
import com.tlf.creatoraccount.po.ClassStudentPO;
import com.tlf.creatoraccount.po.OnlinePO;
import com.tlf.creatoraccount.pojo.Accounts;
import com.tlf.creatoraccount.pojo.Classes;
import com.tlf.creatoraccount.pojo.Courses;
import com.tlf.creatoraccount.req.*;
import com.tlf.creatoraccount.service.*;
import com.tlf.creatoraccount.utils.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ICoursesService coursesService;

    @Autowired
    private IOnlineService onlineService;

    @Autowired
    private IClassService classService;

    /**
     * 登录接口
     *
     * @param json
     * @param request
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody String json, HttpServletRequest request) throws OperatingException {
        JSONObject jsonObject = JSONObject.parseObject(json);
        String phone = (String) jsonObject.get("phone");
        String password = (String) jsonObject.get("password");
        Map<String, Object> map = accountService.queryAccountByPhone(phone, password, request);
        Object account = map.get("accountId");
        if(account!=null){
            Long millis = System.currentTimeMillis();
            onlineService.updateLoginByAccount(millis,account.toString());
        }
        return map;
    }

    /**
     * 用户信息
     * @param req
     * @return
     */
    @PostMapping(value = "user_info")
    public JsonResult userInfo(@RequestBody BaseReq req){
        Accounts accounts = accountService.queryAccountById(req.getAccountId());
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",accounts);
    }

    /**
     * 用户修改密码
     * @param req
     * @return
     */
    @PostMapping(value="change_password_self")
    public JsonResult changePasswordSelf(@RequestBody AccountReq req){
        boolean change = accountService.changePasswordSelf(req.getAccountId(), req.getPassword(), req.getNewPassword());
        if(change){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null);
        }else {
            return new JsonResult(Constants.CODE_FAIL,"原密码错误",null);
        }
    }
    

    /**
     * 管理员修改密码
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "change_password", method = RequestMethod.POST)
    public JsonResult changePassword(@RequestBody AccountReq req) throws OperatingException {
        boolean change = accountService.changePassword(req.getUserId(), req.getPassword());
        if (change) {
            return new JsonResult(Constants.CODE_SUCCESS, "修改成功", null);
        } else {
            return new JsonResult(Constants.CODE_FAIL, "修改失败，请重试", null);
        }
    }

    /**
     * 获取用户课程列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "get_course_list_by_account", method = RequestMethod.POST)
    public List<Courses> getCourseListByAccount(@RequestBody BaseReq req) throws OperatingException {
        String accountId = req.getAccountId();
        List<Courses> courses = coursesService.queryCourseById(accountId);
        return courses;
    }

    /**
     * 获取与用户同班级的信息
     *
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_account_and_class", method = RequestMethod.GET)
    public List getAccountClass(@RequestBody BaseReq req) throws OperatingException {
        String accountId = req.getAccountId();
        List list = classService.queryClassAccounts(accountId);
        return list;
    }

    /**
     * 根据课程获取学生
     *
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_class_and_student", method = RequestMethod.POST)
    public JsonResult getClassAndStudent(@RequestBody CourseTaskReq req) throws OperatingException {
        String courseId = req.getCourseId();
        String accountId = req.getAccountId();
        List<ClassPO> classPOS = accountService.queryStudentByCourse(courseId,accountId);
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",classPOS);
    }

    @RequestMapping(value = "get_all_account", method = RequestMethod.POST)
    public JsonResult getNames(@RequestBody BaseReq req) {
        List<Accounts> list = accountService.selectAllNames();
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", list);
    }

    @RequestMapping(value = "get_students_by_course", method = RequestMethod.POST)
    public List<ClassStudentPO> getStudentsByCourse(@RequestBody CourseTaskReq req) {
        List<ClassStudentPO> classStudentPOS = accountService.selectStudentsByCourseId(req.getCourseId());
        return classStudentPOS;
    }

    @PostMapping(value = "get_class_by_teacher")
    public JsonResult modifyInfo(@RequestBody CourseTaskReq req){
        String courseId = req.getCourseId();
        String accountId = req.getAccountId();
        List<Classes> classesList = accountService.queryClassByCourse(courseId, accountId);
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",classesList);
    }

    @PostMapping(value = "logout")
    public JsonResult logout(@RequestBody BaseReq req){
        boolean b = onlineService.updateOnlineByAccount(req.getAccountId());
        if(b){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null);
        }
        return new JsonResult(Constants.CODE_FAIL,"FAIL",null);
    }

    @PostMapping(value = "get_time_by_class")
    public List<OnlinePO> getTime(@RequestBody GradeReq req){
        List<OnlinePO> onlinePOS = onlineService.selectAllTime(req.getClassId());
        return onlinePOS;
    }

}
