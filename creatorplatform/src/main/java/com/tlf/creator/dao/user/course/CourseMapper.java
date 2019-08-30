package com.tlf.creator.dao.user.course;

import com.tlf.creator.entity.user.course.Courses;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CourseMapper {

    Courses selectCourseById(String id);
    void updateCourseDescriptionById(String description, String id);
    void insertCourse(Courses course);
    List<Courses> selectAllCourse(Integer offset, Integer limit);
    void deleteCourse(String id);
    Integer selectTotalCourse();
    void updateCourse(Courses course);
    void updateCourseObjectivesById(String objectives, String id);
    List<Courses> selectAllCourseName();
    List<Courses> selectCourse();
}
