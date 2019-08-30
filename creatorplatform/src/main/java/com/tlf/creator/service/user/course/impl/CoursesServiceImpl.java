package com.tlf.creator.service.user.course.impl;

import com.tlf.creator.common.Constants;
import com.tlf.creator.dao.user.account.AccountAndRoleMapper;
import com.tlf.creator.dao.user.account.AccountMapper;
import com.tlf.creator.dao.user.account.RoleMapper;
import com.tlf.creator.dao.user.clazz.ClassMapper;
import com.tlf.creator.dao.user.course.CourseMapper;
import com.tlf.creator.dao.user.course.CourseTeacherClassMapper;
import com.tlf.creator.entity.user.account.Accounts;
import com.tlf.creator.entity.user.account.AccountsAndRoles;
import com.tlf.creator.entity.user.account.Roles;
import com.tlf.creator.entity.user.clazz.Classes;
import com.tlf.creator.entity.user.course.CourseTeacherClass;
import com.tlf.creator.entity.user.course.Courses;
import com.tlf.creator.po.CourseTeacherClassPO;
import com.tlf.creator.po.CourseTeacherPO;
import com.tlf.creator.service.user.course.ICoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoursesServiceImpl implements ICoursesService {

    @Autowired
    private CourseMapper courseMapper;


    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private AccountAndRoleMapper anrMapper;


    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private CourseTeacherClassMapper ctcMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<Courses> queryCourseById(String accountId) {
        AccountsAndRoles accountsAndRoles = anrMapper.queryAccountAndRoleByAccountId(accountId);
        List<Courses> list = new ArrayList<>();
        if (accountsAndRoles != null) {
            Roles roles = roleMapper.queryRoleById(accountsAndRoles.getRolesId());
            if (roles != null) {
                if (roles.getName().equals("teacher")) {
                    List<CourseTeacherClass> courseTeacherClasses = ctcMapper.selectCourseByTeacher(accountId);
                    for (CourseTeacherClass courseTeacherClass : courseTeacherClasses) {
                        if (courseTeacherClass != null) {
                            Courses courses = courseMapper.selectCourseById(courseTeacherClass.getCourseId());
                            if (courses != null) {
                                list.add(courses);
                            }
                        }
                    }
                } else if (roles.getName().equals("student")) {
                    Accounts accounts = accountMapper.queryAccountById(accountId);
                    if (accounts != null) {
                        String classId = accounts.getClasses();
                        if (classId != null) {
                            List<CourseTeacherClass> courseTeacherClasses = ctcMapper.selectAll();
                            for (CourseTeacherClass courseTeacherClass : courseTeacherClasses) {
                                if (courseTeacherClass != null) {
                                    String classId1 = courseTeacherClass.getClassId();
                                    if (classId1 != null) {
                                        String[] split = classId1.split(",");
                                        int length = split.length;
                                        for (int i = 0; i < length; i++) {
                                            if (classId.equals(split[i])) {
                                                Courses courses = courseMapper.selectCourseById(courseTeacherClass.getCourseId());
                                                if (courses != null) {
                                                    list.add(courses);
                                                }
                                            }
                                        }
                                    }
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
    public Courses queryCourseDescription(String id) {
        Courses courses = courseMapper.selectCourseById(id);
        if (courses != null) {
            courses.setIcon(Constants.RESOURCE_PATH + courses.getIcon());
        }
        return courses;
    }

    @Override
    public void updateCourseDescriptionById(String description, String id) {
        courseMapper.updateCourseDescriptionById(description, id);
    }

    @Transactional
    @Override
    public boolean insertCourse(CourseTeacherClass course) {
        int insert = ctcMapper.insert(course);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<CourseTeacherClassPO> selectAllCourse(Integer offset, Integer limit) {
        List<CourseTeacherPO> courseTeacherPOS = ctcMapper.selectCourseTeacherAndClass(offset, limit);
        List<CourseTeacherClassPO> list = new ArrayList<>();
        for (CourseTeacherPO courseTeacherPO : courseTeacherPOS) {
            if (courseTeacherPO != null) {
                CourseTeacherClassPO courseTeacherClassPO = new CourseTeacherClassPO();
                courseTeacherClassPO.setId(courseTeacherPO.getId());
                courseTeacherClassPO.setCourse(courseTeacherPO.getCourse());
                courseTeacherClassPO.setName(courseTeacherPO.getName());
                courseTeacherClassPO.setTeacherId(courseTeacherPO.getTeacherId());
                courseTeacherClassPO.setCourseId(courseTeacherPO.getCourseId());
                courseTeacherClassPO.setSemester(courseTeacherPO.getSemester());
                String classIds = courseTeacherPO.getClassId();
                courseTeacherClassPO.setClassId(classIds);
                String[] classId = classIds.split(",");
                List<Classes> classesList = new ArrayList<>();
                int length = classId.length;
                for (int i = 0; i < length; i++) {
                    Classes classes = classMapper.selectClassById(classId[i]);
                    if (classes != null) {
                        classesList.add(classes);
                        courseTeacherClassPO.setClasses(classesList);
                    }
                }
                list.add(courseTeacherClassPO);
            }
        }
        return list;
    }

    @Transactional
    @Override
    public boolean deleteCourse(String id) {
        int delete = ctcMapper.deleteByPrimaryKey(id);
        if (delete > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCourseRelationship(CourseTeacherClass record) {
        int update = ctcMapper.updateByPrimaryKey(record);
        if (update > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Integer queryTotalCourse() {
        Integer integer = ctcMapper.selectCount();
        return integer;
    }

    @Transactional
    @Override
    public void modifyTeacherAndClass(Courses course, List<String> teachers, List<String> classId) {

    }

    @Override
    public void updateCourseObjectivesById(String objectives, String id) {
        courseMapper.updateCourseObjectivesById(objectives, id);
    }

    @Override
    public boolean deleteCourseAndTeacherByTeacher(String teacherId) {
       /* int delete = courseAndTeacherMapper.deleteByTeacher(teacherId);
        if(delete>0){
            return  true;
        }*/
        return false;
    }

    @Override
    public List<Courses> queryCourse() {
        List<Courses> list = courseMapper.selectCourse();
        return list;
    }

    @Override
    public CourseTeacherClass selectByPrimaryKey(String id) {
        CourseTeacherClass courseTeacherClass = ctcMapper.selectByPrimaryKey(id);
        return courseTeacherClass;
    }

    @Override
    public List<CourseTeacherClass> selectByCourse(String courseId) {
        List<CourseTeacherClass> courseTeacherClasses = ctcMapper.selectByCourseId(courseId);
        return courseTeacherClasses;
    }

    @Override
    public String selectCourseTeacher(String courseId, String teacherId) {
        String id = ctcMapper.selectCourseTeacher(courseId, teacherId);
        return id;
    }

    @Override
    public List<CourseTeacherClass> selectByCourseIdExcludeSelf(String courseId, String id) {
        List<CourseTeacherClass> courseTeacherClasses = ctcMapper.selectByCourseIdExcludeSelf(courseId, id);
        return courseTeacherClasses;
    }

}
