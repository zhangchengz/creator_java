package com.tlf.creator.service.user.course;

import com.tlf.creator.entity.user.course.CourseTeacherClass;
import com.tlf.creator.entity.user.course.Courses;
import com.tlf.creator.po.CourseTeacherClassPO;

import java.util.List;

public interface ICoursesService {

    List<Courses> queryCourseById(String accountId);

    Courses queryCourseDescription(String id);

    void updateCourseDescriptionById(String description, String id);

    boolean insertCourse(CourseTeacherClass record);

    List<CourseTeacherClassPO> selectAllCourse(Integer offset, Integer limit);

    boolean deleteCourse(String id);

    boolean updateCourseRelationship(CourseTeacherClass record);

    Integer queryTotalCourse();

    void modifyTeacherAndClass(Courses course, List<String> teachers, List<String> classId);

    void updateCourseObjectivesById(String objectives, String id);

    boolean deleteCourseAndTeacherByTeacher(String teacherId);

    List<Courses> queryCourse();

    CourseTeacherClass selectByPrimaryKey(String id);

    List<CourseTeacherClass> selectByCourse(String courseId);

    String selectCourseTeacher(String courseId, String teacherId);

    List<CourseTeacherClass> selectByCourseIdExcludeSelf(String courseId, String id);
}
