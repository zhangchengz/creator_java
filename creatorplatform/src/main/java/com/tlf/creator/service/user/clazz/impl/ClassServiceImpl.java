package com.tlf.creator.service.user.clazz.impl;

import com.tlf.creator.dao.user.account.AccountMapper;
import com.tlf.creator.dao.user.clazz.ClassMapper;
import com.tlf.creator.dao.user.course.CourseTeacherClassMapper;
import com.tlf.creator.entity.user.account.Accounts;
import com.tlf.creator.entity.user.clazz.Classes;
import com.tlf.creator.entity.user.course.CourseTeacherClass;
import com.tlf.creator.po.ClassCoursePO;
import com.tlf.creator.po.ClassesPO;
import com.tlf.creator.service.user.clazz.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class ClassServiceImpl implements IClassService {

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private CourseTeacherClassMapper ctcMapper;

    @Override
    public List<Object> queryClassAccounts(String accountId) {

        return null;
    }

    @Override
    public Classes queryClassById(String id) {
        Classes classes = classMapper.selectClassById(id);
        return classes;
    }

    @Override
    public List<ClassesPO> queryClasses(Integer offset, Integer limit) {
        List<Classes> classes = classMapper.selectClasses(offset, limit);
        List<ClassesPO> list = new ArrayList<>();
        for (Classes classes1 : classes) {
            if (classes1 != null) {
                ClassesPO classesPO = new ClassesPO();
                List<Accounts> list1 = accountMapper.queryAccountByClass(classes1.getId());
                classesPO.setId(classes1.getId());
                classesPO.setName(classes1.getName());
                classesPO.setMajor(classes1.getMajor());
                classesPO.setStartYear(classes1.getStartYear());
                if (list1 != null) {
                    classesPO.setLength(list1.size());
                    classesPO.setStudents(list1);
                } else {
                    classesPO.setLength(0);
                }
                list.add(classesPO);
            }
        }
        return list;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertClass(Classes classes, List<String> students)  {
        List<Classes> classes1 = classMapper.selectAllClassName();
        for (Classes classes2 : classes1) {
            if ((classes2.getMajor() + classes2.getStartYear() + classes2.getName()).equals(classes.getMajor() + classes.getStartYear() + classes.getName())) {
                return false;
            }
        }
        classMapper.insertClass(classes);
        if (students != null) {
            for (String studentId : students) {
                if (studentId != null) {
                    accountMapper.updateAccountClass(classes.getId(), studentId);
                }
            }
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteClass(String id) {
        Classes classes = classMapper.selectClassById(id);
        if (classes == null) {
            return;
        }
       // classAndCourseMapper.deleteCourseAndClassByClass(id);
        accountMapper.deleteAccountClass(classes.getId());
        classMapper.deleteClass(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateClass(Classes classes, List<String> add, List<String> delete)  {
        List<Classes> classes1 = classMapper.selectClassNameExcludeSelf(classes.getId());
        for(Classes classes2 :classes1){
            if ((classes2.getMajor() + classes2.getStartYear() + classes2.getName()).equals(classes.getMajor() + classes.getStartYear() + classes.getName())) {
                return false;
            }
        }
        classMapper.updateClass(classes);
        for (String a : add) {
            if (a != null) {
                accountMapper.updateAccountClass(classes.getId(), a);
            }
        }
        for (String d : delete) {
            if (d != null) {
                accountMapper.deleteAccountClassById(d);
            }
        }
        return true;
    }

    @Override
    public Integer queryTotalClasses() {
        Integer integer = classMapper.selectTotalClasses();
        return integer;
    }

    @Override
    public List<ClassCoursePO> selectClassByCourse(String coursesId) {
        List<CourseTeacherClass> courseTeacherClasses = ctcMapper.selectByCourseId(coursesId);
        List<ClassCoursePO> list = new ArrayList<>();
        for(CourseTeacherClass courseTeacherClass:courseTeacherClasses){
            if(courseTeacherClass!=null){
                String classId = courseTeacherClass.getClassId();
                if(classId!=null){
                    String[] split = classId.split(",");
                    int length = split.length;
                    for(int i=0;i<length;i++){
                        Classes classes = classMapper.selectClassById(split[i]);
                        if(classes!=null){
                            ClassCoursePO classCoursePO = new ClassCoursePO();
                            classCoursePO.setName(classes.getName());
                            classCoursePO.setClassesId(classes.getId());
                            classCoursePO.setCoursesId(coursesId);
                            list.add(classCoursePO);
                        }
                    }
                }
            }
        }
        return list;
    }
}
