package com.tlf.creatoraccount.dao;

import com.tlf.creatoraccount.pojo.CourseAndTeacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseAndTeacherMapper {

    /*List<CourseAndTeacher> selectTeacherByCourse(String courseId);
    List<CourseAndTeacher> selectCourseByTeacher(String teacherId);
    void insertCourseAndTeacher(CourseAndTeacher courseAndTeacher);
    void deleteCourseAndTeacher(String courseId,String teacherId);
    void deleteCourseAndTeacherByCourse(String courseId);
    int deleteByTeacher(String teacherId);
    void updateTeacherByCourse(String teacherId,String teacher,String courseId);*/

}
