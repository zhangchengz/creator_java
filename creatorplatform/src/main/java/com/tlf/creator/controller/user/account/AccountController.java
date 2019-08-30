package com.tlf.creator.controller.user.account;

import com.tlf.creator.common.JsonResult;
import com.tlf.creator.common.Constants;
import com.tlf.creator.entity.user.account.Accounts;
import com.tlf.creator.entity.user.clazz.Classes;
import com.tlf.creator.entity.user.course.Courses;
import com.tlf.creator.permission.AuthToken;
import com.tlf.creator.po.ClassPO;
import com.tlf.creator.po.OnlinePO;
import com.tlf.creator.req.*;
import com.tlf.creator.service.user.account.IAccountService;
import com.tlf.creator.service.user.account.IOnlineService;
import com.tlf.creator.service.user.clazz.IClassService;
import com.tlf.creator.service.user.course.ICoursesService;
import com.tlf.creator.utils.AccountUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private AccountUtil accountUtil;

    /**
     * 登录接口
     *
     * @param req
     * @param request
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public JsonResult login(@RequestBody LoginReq req, HttpServletRequest request)  {
        String phone = req.getPhone();
        String password = req.getPassword();
        if(StringUtils.isBlank(phone)||StringUtils.isBlank(password)){
            return new JsonResult(Constants.CODE_FAIL,"用户名或密码不能为空",null,null);
        }
        Map<String, Object> map = accountService.queryAccountByPhone(phone, password, request);
        Object account = map.get("accountId");
        if(account!=null){
            Long millis = System.currentTimeMillis();
            onlineService.updateLoginByAccount(millis,account.toString());
        }
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,map);
    }

    /**
     * 用户信息
     * @param request
     * @return
     */
    @PostMapping(value = "user_info")
    @AuthToken
    public JsonResult userInfo(HttpServletRequest request){
        String accountId = accountUtil.getAccountId(request);
        Accounts accounts = accountService.queryAccountById(accountId);
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,accounts);
    }

    /**
     * 用户修改密码
     * @param req
     * @return
     */
    @PostMapping(value="change_password_self")
    @AuthToken
    public JsonResult changePasswordSelf(@RequestBody AccountReq req,HttpServletRequest request){
        String accountId = accountUtil.getAccountId(request);
        if(StringUtils.isBlank(accountId)||StringUtils.isBlank(req.getPassword())||StringUtils.isBlank(req.getNewPassword())){
            return new JsonResult(Constants.CODE_FAIL,"原密码或新密码不能为空",null,null);
        }
        boolean change = accountService.changePasswordSelf(accountId, req.getPassword(), req.getNewPassword());
        if(change){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }else {
            return new JsonResult(Constants.CODE_FAIL,"原密码错误",null,null);
        }
    }
    

    /**
     * 管理员修改密码
     *
     * @param req
     * @return
     */
    @RequestMapping(value = "change_password", method = RequestMethod.POST)
    @AuthToken(role_name = "admin")
    public JsonResult changePassword(@RequestBody AccountReq req)  {
        if(StringUtils.isBlank(req.getUserId())||StringUtils.isBlank(req.getPassword())){
            return new JsonResult(Constants.CODE_FAIL, "用户不存在或者密码为空",null, null);
        }
        boolean change = accountService.changePassword(req.getUserId(), req.getPassword());
        if (change) {
            return new JsonResult(Constants.CODE_SUCCESS, "修改成功",null, null);
        } else {
            return new JsonResult(Constants.CODE_FAIL, "修改失败，请重试",null, null);
        }
    }

    /**
     * 获取用户课程列表
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "get_course_list", method = RequestMethod.POST)
    @AuthToken
    public JsonResult getCourseListByAccount(HttpServletRequest request)  {
        String accountId = accountUtil.getAccountId(request);
        if(StringUtils.isBlank(accountId)){
            return new JsonResult(Constants.CODE_FAIL,"登录失效",null,null);
        }
        List<Courses> courses = coursesService.queryCourseById(accountId);
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,courses);
    }

    /**
     * 获取与用户同班级的信息
     *
     * @return
     */
    @RequestMapping(value = "get_account_and_class", method = RequestMethod.GET)
    public JsonResult getAccountClass(HttpServletRequest request)  {
        String accountId = accountUtil.getAccountId(request);
        if(StringUtils.isBlank(accountId)){
            return new JsonResult(Constants.CODE_FAIL,"登录失效",null,null);
        }
        List list = classService.queryClassAccounts(accountId);
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,list);
    }

    /**
     * 根据课程获取学生
     *
     * @return
     */
    @RequestMapping(value = "get_class_and_student", method = RequestMethod.POST)
    @AuthToken
    public JsonResult getClassAndStudent(@RequestBody CourseTaskReq req,HttpServletRequest request)  {
        String courseId = req.getCourseId();
        String accountId = accountUtil.getAccountId(request);
        if(StringUtils.isBlank(courseId)||StringUtils.isBlank(accountId)){
            return new JsonResult(Constants.CODE_FAIL,"登录失效",null,null);
        }
        List<ClassPO> classPOS = accountService.queryStudentByCourse(courseId,accountId);
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,classPOS);
    }

//    @RequestMapping(value = "get_all_account", method = RequestMethod.POST)
//    public JsonResult getNames(@RequestBody BaseReq req) {
//        List<Accounts> list = accountService.selectAllNames();
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null,list);
//    }
//
//    @RequestMapping(value = "get_students_by_course", method = RequestMethod.POST)
//    public List<ClassStudentPO> getStudentsByCourse(@RequestBody CourseTaskReq req) {
//        List<ClassStudentPO> classStudentPOS = accountService.selectStudentsByCourseId(req.getCourseId());
//        return classStudentPOS;
//    }

    @PostMapping(value = "get_class_by_teacher")
    @AuthToken
    public JsonResult modifyInfo(@RequestBody CourseTaskReq req,HttpServletRequest request){
        String accountId = accountUtil.getAccountId(request);
        String courseId = req.getCourseId();
        if(StringUtils.isBlank(courseId)||StringUtils.isBlank(accountId)){
            return new JsonResult(Constants.CODE_FAIL,"登录失效",null,null);
        }
        List<Classes> classesList = accountService.queryClassByCourse(courseId, accountId);
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,classesList);
    }

    @PostMapping(value = "loginTime")
    @AuthToken
    public JsonResult logout(HttpServletRequest request){
        String accountId = accountUtil.getAccountId(request);
        if(StringUtils.isBlank(accountId)){
            return new JsonResult(Constants.CODE_FAIL,"登录失效",null,null);
        }
        boolean b = onlineService.updateOnlineByAccount(accountId);
        if(b){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }
        return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
    }

    @PostMapping(value = "get_time_by_class")
    public JsonResult getTime(@RequestBody GradeReq req){
        List<OnlinePO> onlinePOS = onlineService.selectAllTime(req.getClassId());
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,onlinePOS);
    }

}
