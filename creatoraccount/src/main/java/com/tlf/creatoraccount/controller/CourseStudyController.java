package com.tlf.creatoraccount.controller;

import com.tlf.creatoraccount.common.JsonResult;
import com.tlf.creatoraccount.constants.Constants;
import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.pojo.Courses;
import com.tlf.creatoraccount.req.CourseReq;
import com.tlf.creatoraccount.service.ICoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CourseStudyController {

    @Autowired
    private ICoursesService coursesService;

    /**
     * 获取课程介绍
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_course_information",method = RequestMethod.POST)
    public JsonResult getCourseDescription(@RequestBody CourseReq req) throws OperatingException {
        String courseId = req.getCourseId();
        if (courseId==null){
            return new JsonResult(Constants.CODE_FAIL,"课程id为空",null);
        }
        Courses courses = coursesService.queryCourseDescription(courseId);
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",courses);
    }

    /**
     * 修改课程介绍
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_course_description",method = RequestMethod.POST)
    public JsonResult modifyCourseDescription(@RequestBody CourseReq req) throws OperatingException {
        String courseId = req.getCourseId();
        String description = req.getDescription();
        if (courseId==null||description==null){
            return new JsonResult(Constants.CODE_FAIL,"课程id为空或者课程介绍为空",null);
        }
        coursesService.updateCourseDescriptionById(description,courseId);
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null);
    }

    /**
     * 修改授课目标
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_course_objectives",method = RequestMethod.POST)
    public JsonResult modifyCourseObjectives(@RequestBody CourseReq req) throws OperatingException {
        String courseId = req.getCourseId();
        String objectives = req.getObjectives();
        if (courseId==null||objectives==null){
            return new JsonResult(Constants.CODE_FAIL,"MISSING PARAMETERS",null);
        }
        coursesService.updateCourseObjectivesById(objectives,courseId);
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null);
    }
}
