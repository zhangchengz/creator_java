package com.tlf.creatoraccount.service.impl;

import com.tlf.creatoraccount.constants.Constants;
import com.tlf.creatoraccount.dao.*;
import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.po.*;
import com.tlf.creatoraccount.pojo.*;
import com.tlf.creatoraccount.service.IAccountService;
import com.tlf.creatoraccount.utils.JWTUtil;
import com.tlf.creatoraccount.utils.NetWork;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AccountAndRoleMapper aarMapper;

    @Autowired
    private NetWork netWork;

    @Autowired
    private CourseTeacherClassMapper ctcMapper;

    @Override
    public Map<String, Object> queryAccountByPhone(String phone, String pwd, HttpServletRequest request) throws OperatingException {
        // Accounts account = accountMapper.queryAccountByPhone(phone);
        Accounts account = accountMapper.queryAccountByPhoneOrNumber(phone, phone);
        Map<String, Object> map = new HashMap<>();
        if (account == null) {
            throw new OperatingException(Constants.CODE_FAIL, "USER DOES NOT EXIST OR PASSWORD IS INCORRECT");
        }
        String id = account.getId();
        map.put("accountId", id);
        String password = new SimpleHash("MD5", pwd, id.substring(id.length() - 6)).toHex();
        if (!account.getPwd().equals(password)) {
            throw new OperatingException(Constants.CODE_FAIL, "USER DOES NOT EXIST OR PASSWORD IS INCORRECT");
        }
        AccountsAndRoles accountsAndRoles = aarMapper.queryAccountAndRoleByAccountId(account.getId());
        if (accountsAndRoles != null) {
            Roles roles = roleMapper.queryRoleById(accountsAndRoles.getRolesId());
            if (roles != null) {
                if (roles.getName().equals("student")) {
                    Classes classes = classMapper.selectClassById(account.getClasses());
                    String name = null;
                    if (classes != null) {
                        name = classes.getName();
                    }
                    StudentPO studentPO = new StudentPO(account.getId(), account.getPhone(), account.getNumber(), account.getName(), account.getGender(), account.getAge(), account.getEmail(), name, roles.getName());
                    map.put("account", studentPO);
                } else if (roles.getName().equals("teacher")) {
                    if ("supervisor".equals(account.getClasses())) {
                        TeacherPO teacherPO = new TeacherPO(account.getId(), account.getPhone(), account.getName(), account.getGender(), account.getAge(), account.getEmail(), roles.getName(), account.getClasses());
                        map.put("account", teacherPO);
                    } else {
                        TeacherPO teacherPO = new TeacherPO(account.getId(), account.getPhone(), account.getName(), account.getGender(), account.getAge(), account.getEmail(), roles.getName(), null);
                        map.put("account", teacherPO);
                    }
                } else if (roles.getName().equals("admin")) {
                    AdminPO adminPO = new AdminPO(account.getId(), account.getName(), account.getPhone(), roles.getName());
                    map.put("account", adminPO);
                }
            }
            String remoteIp = netWork.getRemoteIp(request);
            String token = JWTUtil.sign(account.getId(), remoteIp, roles.getName());
            map.put("token", token);
        }
        return map;
    }

    @Override
    public void addAccount(Accounts account) {
        accountMapper.addAccount(account);
    }

    @Override
    public boolean changePassword(String id, String pwd) {
        if (id != null) {
            String password = new SimpleHash("MD5", pwd, id.substring(id.length() - 6)).toHex();
            int change = accountMapper.updatePassword(password, id);
            if (change > 0) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public boolean changePasswordSelf(String id, String pwd, String newPwd) throws OperatingException {
        Accounts account = accountMapper.queryPwdById(id);
        if (account != null) {
            String pwd1 = account.getPwd();
            String salt = id.substring(id.length() - 6);
            String password = new SimpleHash("MD5", pwd, salt).toHex();
            if (password.equals(pwd1)) {
                String newPassword = new SimpleHash("MD5", newPwd, salt).toHex();
                accountMapper.updatePassword(newPassword, id);
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public List<ClassPO> queryStudentByCourse(String courseId, String teacherId) throws OperatingException {
        List<CourseTeacherClass> courseTeacherClasses = ctcMapper.selectByCourseAndTeacher(courseId, teacherId);
        List<ClassPO> list = new ArrayList<>();
        for (CourseTeacherClass courseTeacherClass : courseTeacherClasses) {
            if (courseTeacherClass != null) {
                String classId = courseTeacherClass.getClassId();
                if (classId != null) {
                    String[] split = classId.split(",");
                    int length = split.length;
                    for (int i = 0; i < length; i++) {
                        Classes classes = classMapper.selectClassById(split[i]);
                        ClassPO classPO = new ClassPO();
                        if (classes != null) {
                            classPO.setId(classes.getId());
                            classPO.setName(classes.getName());
                        }
                        List<Accounts> list1 = accountMapper.selectStudentByClass(split[i]);
                        if (list1 != null) {
                            classPO.setAccounts(list1);
                        }
                        list.add(classPO);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<Classes> queryClassByCourse(String courseId, String teacherId) {
        List<CourseTeacherClass> courseTeacherClasses = ctcMapper.selectByCourseAndTeacher(courseId, teacherId);
        List<Classes> list = new ArrayList<>();
        for (CourseTeacherClass courseTeacherClass : courseTeacherClasses) {
            if (courseTeacherClass != null) {
                String classId = courseTeacherClass.getClassId();
                if (classId != null) {
                    String[] split = classId.split(",");
                    int length = split.length;
                    for (int i = 0; i < length; i++) {
                        Classes classes = classMapper.selectClassById(split[i]);
                        if (classes != null) {
                            list.add(classes);
                        }
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<Accounts> queryTeachers(Integer offset, Integer limit) throws OperatingException {
        List<Accounts> list = new ArrayList<>();
        Roles teacher = roleMapper.queryRoleByName("teacher");
        if (teacher != null) {
            List<AccountsAndRoles> accountsAndRoles = aarMapper.queryAccountAndRoleByRoleId(teacher.getId(), offset, limit);
            for (AccountsAndRoles accountsAndRole : accountsAndRoles) {
                if (accountsAndRole != null) {
                    Accounts accounts = accountMapper.queryAccountById(accountsAndRole.getAccountsId());
                    if (accounts != null) {
                        list.add(accounts);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<StudentPO> queryStudents(Integer offset, Integer limit) throws OperatingException {
        List<StudentPO> list = new ArrayList<>();
        Roles teacher = roleMapper.queryRoleByName("student");
        if (teacher != null) {
            List<AccountsAndRoles> accountsAndRoles = aarMapper.queryAccountAndRoleByRoleId(teacher.getId(), offset, limit);
            for (AccountsAndRoles accountsAndRole : accountsAndRoles) {
                if (accountsAndRole != null) {
                    Accounts accounts = accountMapper.queryAccountById(accountsAndRole.getAccountsId());
                    if (accounts != null) {
                        StudentPO studentPO = new StudentPO();
                        studentPO.setId(accounts.getId());
                        studentPO.setPhone(accounts.getPhone());
                        studentPO.setNumber(accounts.getNumber());
                        studentPO.setName(accounts.getName());
                        studentPO.setGender(accounts.getGender());
                        studentPO.setAge(accounts.getAge());
                        studentPO.setEmail(accounts.getEmail());
                        Classes classes = classMapper.selectClassById(accounts.getClasses());
                        if (classes != null) {
                            studentPO.setClasses(classes.getName());
                        }
                        list.add(studentPO);
                    }
                }
            }
        }
        return list;
    }

    @Override
    public void modifyAccount(Accounts account) throws OperatingException {
        accountMapper.updateAccount(account);
    }

    @Override
    public Integer queryTotal(String role) throws OperatingException {
        Roles role1 = roleMapper.queryRoleByName(role);
        if (role1 != null) {
            Integer number = aarMapper.selectTotal(role1.getId());
            return number;
        }
        return null;
    }

    @Override
    public void deleteAccount(String id) throws OperatingException {
        accountMapper.deleteAccount(id);
    }

    @Override
    public Accounts queryAccountById(String id) throws OperatingException {
        Accounts accounts = accountMapper.queryAccountById(id);
        return accounts;
    }

    @Override
    public List<Accounts> selectStudentNoClass() {
        List<Accounts> list = accountMapper.selectStudentNoClass();
        return list;
    }

    @Override
    public List<Accounts> selectAllNames() {
        return accountMapper.selectAllNames();
    }

    @Override
    public List<ClassStudentPO> selectStudentsByCourseId(String coursesId) {
        List<ClassStudentPO> list = new ArrayList<>();
        List<ClassStudentPO> classStudentPOS = accountMapper.selectStudentsByCourseId();
        List<CourseTeacherClass> courseTeacherClasses = ctcMapper.selectByCourseId(coursesId);

        for (ClassStudentPO classStudentPO : classStudentPOS) {
            if (classStudentPO != null) {
                for (CourseTeacherClass courseTeacherClass : courseTeacherClasses) {
                    if (courseTeacherClass != null) {
                        String classId = courseTeacherClass.getClassId();
                        if (classId != null) {
                            String[] split = classId.split(",");
                            int length = split.length;
                            for (int i = 0; i < length; i++) {
                                if (split[i].equals(classStudentPO.getClassesId())) {
                                    ClassStudentPO classStudentPO1 = new ClassStudentPO();
                                    classStudentPO1.setId(classStudentPO.getId());
                                    classStudentPO1.setName(classStudentPO.getName());
                                    classStudentPO1.setClassesId(classStudentPO.getClassesId());
                                    classStudentPO1.setClassName(classStudentPO.getClassName());
                                    classStudentPO1.setCoursesId(coursesId);
                                    list.add(classStudentPO1);
                                }
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<String> selectAllPhone() {
        List<String> list = accountMapper.selectAllPhone();
        return list;
    }

    @Override
    public List<String> selectPhoneApartSelf(String id) {
        List<String> list = accountMapper.selectPhoneApartSelf(id);
        return list;
    }

    @Override
    public List<String> selectAllNumber() {
        List<String> list = accountMapper.selectAllNumber();
        return list;
    }

    @Override
    public List selectAccounts(String role, Integer offset, Integer limit) {
        List<Accounts> list = accountMapper.selectAccounts(role, offset, limit);
        List<StudentPO> students = new ArrayList<>();
        if ("teacher".equals(role)) {
            return list;
        } else if ("student".equals(role)) {
            for (Accounts accounts : list) {
                if (accounts != null) {
                    StudentPO studentPO = new StudentPO();
                    studentPO.setId(accounts.getId());
                    studentPO.setPhone(accounts.getPhone());
                    studentPO.setNumber(accounts.getNumber());
                    studentPO.setName(accounts.getName());
                    studentPO.setGender(accounts.getGender());
                    studentPO.setAge(accounts.getAge());
                    studentPO.setEmail(accounts.getEmail());
                    Classes classes = classMapper.selectClassById(accounts.getClasses());
                    if (classes != null) {
                        studentPO.setClasses(classes.getName());
                    }
                    students.add(studentPO);
                }
            }
            return students;
        }
        return null;
    }

    @Override
    public Integer selectCounts(String role) {
        Integer integer = accountMapper.selectCounts(role);
        return integer;
    }
}
