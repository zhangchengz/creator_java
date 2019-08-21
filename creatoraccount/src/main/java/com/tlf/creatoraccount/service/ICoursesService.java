package com.tlf.creatoraccount.service;

import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.po.CourseTeacherClassPO;
import com.tlf.creatoraccount.pojo.CourseTeacherClass;
import com.tlf.creatoraccount.pojo.Courses;

import java.util.List;

public interface ICoursesService {

    List<Courses> queryCourseById(String accountId)throws OperatingException;
    Courses queryCourseDescription(String id)throws OperatingException;
    void updateCourseDescriptionById(String description,String id)throws OperatingException;
    boolean insertCourse(CourseTeacherClass record)throws OperatingException;
    List<CourseTeacherClassPO> selectAllCourse(Integer offset, Integer limit)throws OperatingException;
    boolean  deleteCourse(String id)throws OperatingException;
    boolean updateCourseRelationship(CourseTeacherClass record);
    Integer queryTotalCourse()throws OperatingException;
    void modifyTeacherAndClass(Courses course,List<String> teachers,List<String> classId)throws OperatingException;
    void updateCourseObjectivesById(String objectives,String id)throws OperatingException;
    boolean deleteCourseAndTeacherByTeacher(String teacherId);
    List<Courses> queryCourse();
    CourseTeacherClass selectByPrimaryKey(String id);
    List<CourseTeacherClass> selectByCourse(String courseId);
    String selectCourseTeacher(String courseId,String teacherId);
    List<CourseTeacherClass> selectByCourseIdExcludeSelf(String courseId, String id);
}
