package com.tlf.creatoraccount.dao;

import com.tlf.creatoraccount.pojo.ClassesAndCourses;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassAndCourseMapper {

    /*List<ClassesAndCourses> selectClassByCourseId(String coursesId);
    List<ClassesAndCourses> selectCourseByClassId(String classesId);
    void insertClassAndCourse(ClassesAndCourses cac);
    void deleteClassAndCourse(String coursesId,String classesId);
    void deleteClassAndCourseByCourse(String coursesId);
    void updateClassByCourseId(String classesId,String coursesId,String classId);
    void deleteCourseAndClassByClass(String classesId);*/
}
