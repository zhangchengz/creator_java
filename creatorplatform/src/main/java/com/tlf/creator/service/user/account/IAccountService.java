package com.tlf.creator.service.user.account;

import com.tlf.creator.entity.user.account.Accounts;
import com.tlf.creator.entity.user.clazz.Classes;
import com.tlf.creator.po.ClassPO;
import com.tlf.creator.po.ClassStudentPO;
import com.tlf.creator.po.StudentPO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface IAccountService {

    Map<String, Object> queryAccountByPhone(String phone, String pwd, HttpServletRequest request)  ;

    void addAccount(Accounts accounts)  ;

    boolean changePasswordSelf(String id, String pwd, String newPwd);

    boolean changePassword(String id, String pwd);

    List<ClassPO> queryStudentByCourse(String courseId, String teacherId)  ;

    List<Classes> queryClassByCourse(String courseId, String teacherId);

    List<Accounts> queryTeachers(Integer offset, Integer limit) ;

    List<StudentPO> queryStudents(Integer offset, Integer limit) ;

    void modifyAccount(Accounts account);

    Integer queryTotal(String role) ;

    void deleteAccount(String id) ;

    Accounts queryAccountById(String id) ;

    List<Accounts> selectStudentNoClass();

    List<Accounts> selectAllNames();

    List<ClassStudentPO> selectStudentsByCourseId(String coursesId);

    List<String> selectAllPhone();

    List<String> selectPhoneApartSelf(String id);

    List<String> selectAllNumber();

    List selectAccounts(String role, Integer offset, Integer limit);

    Integer selectCounts(String role);
}
