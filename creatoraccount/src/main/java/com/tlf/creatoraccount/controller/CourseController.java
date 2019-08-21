package com.tlf.creatoraccount.controller;

import com.tlf.creatoraccount.common.JsonResult;
import com.tlf.creatoraccount.common.JsonRet;
import com.tlf.creatoraccount.constants.Constants;
import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.po.CourseTeacherClassPO;
import com.tlf.creatoraccount.pojo.CourseTeacherClass;
import com.tlf.creatoraccount.pojo.Courses;
import com.tlf.creatoraccount.req.BaseReq;
import com.tlf.creatoraccount.req.CouReq;
import com.tlf.creatoraccount.service.ICoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class CourseController {

    @Autowired
    private ICoursesService coursesService;

    /**
     * 获取课程列表
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_course_list1", method = RequestMethod.POST)
    public JsonRet getCourseList(@RequestBody CouReq req) throws OperatingException {
        Integer limit = req.getLimit();
        Integer offset = req.getOffset();
        List<CourseTeacherClassPO> courseTeacherClassPOS = coursesService.selectAllCourse(offset, limit);
        Integer integer = coursesService.queryTotalCourse();
        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", integer, courseTeacherClassPOS);
    }

    /**
     * 添加课程
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "add_course", method = RequestMethod.POST)
    public JsonResult addCourse(@RequestBody CouReq req) throws OperatingException {
        List<String> classId = req.getClassId();
        String courseId = req.getCourseId();
        String semester = req.getSemester();
        String teacherId = req.getTeacherId();
        List<CourseTeacherClass> courseTeacherClasses = coursesService.selectByCourse(courseId);
        for (CourseTeacherClass ctc : courseTeacherClasses) {
            if (ctc != null) {
                String classId2 = ctc.getClassId();
                String[] split = classId2.split(",");
                int length = split.length;
                for (String classId1 : classId) {
                    if (classId1 != null) {
                        for (int i = 0; i < length; i++) {
                            if (classId1.equals(split[i])) {
                                return new JsonResult(Constants.CODE_FAIL, "该课程和班级的关系已经存在", null);
                            }
                        }
                    }
                }
            }
        }

        String s1 = coursesService.selectCourseTeacher(courseId, teacherId);
        if (s1 != null) {
            return new JsonResult(Constants.CODE_FAIL, "该课程和老师的关系已经存在", null);
        }
        CourseTeacherClass courseTeacherClass = new CourseTeacherClass();
        String id = UUID.randomUUID().toString();
        courseTeacherClass.setId(id);
        courseTeacherClass.setCourseId(courseId);
        courseTeacherClass.setSemester(semester);
        courseTeacherClass.setTeacherId(teacherId);
        if (classId != null) {
            String s = classId.toString().replace("[", "").replace("]", "").replace(" ", "");
            courseTeacherClass.setClassId(s);
        }

        boolean add = coursesService.insertCourse(courseTeacherClass);
        if (add) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
        } else {
            return new JsonResult(Constants.CODE_FAIL, "FAIL", null);
        }
    }

    /**
     * 删除课程
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "delete_course", method = RequestMethod.POST)
    public JsonResult deleteCourse(@RequestBody CouReq req) throws OperatingException {
        String id = req.getId();
        coursesService.deleteCourse(id);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 修改课程信息
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_course_information", method = RequestMethod.POST)
    public JsonResult modifyCourse(@RequestBody CouReq req) throws OperatingException {
        List<String> classId = req.getClassId();
        String semester = req.getSemester();
        String teacherId = req.getTeacherId();
        CourseTeacherClass courseTeacherClass = coursesService.selectByPrimaryKey(req.getId());
        if (courseTeacherClass == null) {
            return new JsonResult(Constants.CODE_FAIL, "不存在要修改的内容", null);
        }
        courseTeacherClass.setSemester(semester);
        courseTeacherClass.setTeacherId(teacherId);
        List<CourseTeacherClass> courseTeacherClasses = coursesService.selectByCourseIdExcludeSelf(req.getCourseId(), req.getId());
        for(CourseTeacherClass ctc:courseTeacherClasses){
            if(ctc!=null){
                String teacherId1 = ctc.getTeacherId();
                if(teacherId1!=null&&teacherId1.equals(teacherId)){
                    return new JsonResult(Constants.CODE_FAIL, "该课程和老师的关系已经存在", null);
                }
                String classId1 = ctc.getClassId();
                String[] split = classId1.split(",");
                int length = split.length;
                for (String classId2 : classId) {
                    if (classId2 != null) {
                        for (int i = 0; i < length; i++) {
                            if (classId2.equals(split[i])) {
                                return new JsonResult(Constants.CODE_FAIL, "该课程和班级的关系已经存在", null);
                            }
                        }
                    }
                }
            }
        }
        if (classId != null) {
            String s = classId.toString().replace("[", "").replace("]", "").replace(" ", "");
            courseTeacherClass.setClassId(s);
        }
        boolean update = coursesService.updateCourseRelationship(courseTeacherClass);
        if (update) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
        } else {
            return new JsonResult(Constants.CODE_FAIL, "FAIL", null);
        }
    }

    @PostMapping(value = "get_course")
    public JsonResult getCourse(@RequestBody BaseReq req) {
        List<Courses> list = coursesService.queryCourse();
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", list);
    }
}
