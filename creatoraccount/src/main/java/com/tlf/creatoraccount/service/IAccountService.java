package com.tlf.creatoraccount.service;

import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.po.ClassPO;
import com.tlf.creatoraccount.po.ClassStudentPO;
import com.tlf.creatoraccount.po.StudentPO;
import com.tlf.creatoraccount.pojo.Accounts;
import com.tlf.creatoraccount.pojo.Classes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IAccountService {

    Map<String, Object> queryAccountByPhone(String phone, String pwd, HttpServletRequest request) throws OperatingException;

    void addAccount(Accounts accounts) throws OperatingException;

    boolean changePasswordSelf(String id, String pwd, String newPwd);

    boolean changePassword(String id, String pwd);

    List<ClassPO> queryStudentByCourse(String courseId, String teacherId) throws OperatingException;

    List<Classes> queryClassByCourse(String courseId, String teacherId);

    List<Accounts> queryTeachers(Integer offset, Integer limit) throws OperatingException;

    List<StudentPO> queryStudents(Integer offset, Integer limit) throws OperatingException;

    void modifyAccount(Accounts account) throws OperatingException;

    Integer queryTotal(String role) throws OperatingException;

    void deleteAccount(String id) throws OperatingException;

    Accounts queryAccountById(String id) throws OperatingException;

    List<Accounts> selectStudentNoClass();

    List<Accounts> selectAllNames();

    List<ClassStudentPO> selectStudentsByCourseId(String coursesId);

    List<String> selectAllPhone();

    List<String> selectPhoneApartSelf(String id);

    List<String> selectAllNumber();

    List selectAccounts(String role, Integer offset, Integer limit);

    Integer selectCounts(String role);
}
