package com.tlf.creatoraccount.dao;

import com.tlf.creatoraccount.po.CourseTeacherPO;
import com.tlf.creatoraccount.pojo.CourseTeacherClass;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseTeacherClassMapper {

    int deleteByPrimaryKey(String id);

    int insert(CourseTeacherClass record);

    CourseTeacherClass selectByPrimaryKey(String id);

    List<CourseTeacherPO> selectCourseTeacherAndClass(Integer offset, Integer limit);

    List<CourseTeacherClass> selectAll();

    List<CourseTeacherClass> selectCourseByTeacher(String teacherId);

    List<CourseTeacherClass> selectByCourseId(String courseId);

    List<CourseTeacherClass> selectByCourseIdExcludeSelf(String courseId, String id);

    Integer selectCount();

    int updateByPrimaryKey(CourseTeacherClass record);

    String selectCourseTeacher(String courseId, String teacherId);

    List<CourseTeacherClass> selectByCourseAndTeacher(String courseId, String teacherId);
}