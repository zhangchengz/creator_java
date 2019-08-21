package com.tlf.creatoraccount.controller;

import com.tlf.creatoraccount.common.JsonResult;
import com.tlf.creatoraccount.common.JsonRet;
import com.tlf.creatoraccount.constants.Constants;
import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.po.ClassCoursePO;
import com.tlf.creatoraccount.po.ClassesPO;
import com.tlf.creatoraccount.pojo.Classes;
import com.tlf.creatoraccount.req.ClassReq;
import com.tlf.creatoraccount.req.CourseTaskReq;
import com.tlf.creatoraccount.req.PageReq;
import com.tlf.creatoraccount.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@CrossOrigin
public class ClassesController {

    @Autowired
    private IClassService classService;

    /**
     * 获取班级列表
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_class_list",method = RequestMethod.POST)
    public JsonRet getClassList(@RequestBody PageReq req) throws OperatingException {
        Integer limit = req.getLimit();
        Integer offset = req.getOffset();
        List<ClassesPO> list = classService.queryClasses(offset,limit);
        Integer integer = classService.queryTotalClasses();
        return new JsonRet(Constants.CODE_SUCCESS,"SUCCESS",integer,list);
    }

    /**
     * 添加班级
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "add_class",method = RequestMethod.POST)
    public JsonResult addClass(@RequestBody ClassReq req) throws OperatingException {
        String name = req.getName();
        String major = req.getMajor();
        String startYear = req.getStartYear();
        Classes classes = new Classes();
        String id = UUID.randomUUID().toString();
        classes.setId(id);
        classes.setMajor(major);
        classes.setName(name);
        classes.setStartYear(startYear);
        List<String> students = req.getStudents();
        boolean insert = classService.insertClass(classes, students);
        if(!insert){
            return new JsonResult(Constants.CODE_EXIST,"班级名称已经存在",null);
        }
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null);
    }

    /**
     * 删除班级
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "delete_class",method = RequestMethod.POST)
    public JsonResult deleteClass(@RequestBody ClassReq req) throws OperatingException {
        String id = req.getId();
        classService.deleteClass(id);
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null);
    }

    /**
     * 修改班级信息
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_class_information",method = RequestMethod.POST)
    public JsonResult modifyClassInformation(@RequestBody ClassReq req) throws OperatingException {
        String id = req.getId();
        String name = req.getName();
        String major = req.getMajor();
        String startYear = req.getStartYear();
        List<String> addStudents = req.getAddStudents();
        List<String> deleteStudents = req.getDeleteStudents();
        Classes classes = classService.queryClassById(id);
        classes.setMajor(major);
        classes.setStartYear(startYear);
        classes.setName(name);
        boolean update = classService.updateClass(classes, addStudents, deleteStudents);
        if(!update){
            return new JsonResult(Constants.CODE_EXIST,"班级名称已经存在",null);
        }
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null);
    }

    /**
     * 根据课程获取班级列表
     * @param req
     * @return
     */
    @RequestMapping(value = "get_class_by_course",method = RequestMethod.POST)
    public List<ClassCoursePO> getClassByCourse(@RequestBody CourseTaskReq req){
        return classService.selectClassByCourse(req.getCourseId());
    }
}
