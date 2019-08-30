package com.tlf.creator.utils;

import com.tlf.creator.dao.user.course.CourseMapper;
import com.tlf.creator.entity.user.course.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtil {

    @Autowired
    private CourseMapper courseMapper;

    public String getCourseAlias(String courseId){
        Courses courses = courseMapper.selectCourseById(courseId);
        if(courses==null){
            return null;
        }
        return courses.getAlias();
    }

}
