package com.tlf.creator.controller.user.clazz;

import com.tlf.creator.common.JsonResult;
import com.tlf.creator.common.Constants;
import com.tlf.creator.entity.user.clazz.Classes;
import com.tlf.creator.aspect.AuthToken;
import com.tlf.creator.po.ClassCoursePO;
import com.tlf.creator.po.ClassesPO;
import com.tlf.creator.req.ClassReq;
import com.tlf.creator.req.CourseTaskReq;
import com.tlf.creator.req.PageReq;
import com.tlf.creator.service.user.clazz.IClassService;
import org.apache.commons.lang3.StringUtils;
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
     */
    @RequestMapping(value = "get_class_list",method = RequestMethod.POST)
    public JsonResult getClassList(@RequestBody PageReq req)   {
        Integer limit = req.getLimit();
        Integer offset = req.getOffset();
        if(limit==null||offset==null){
            return new JsonResult(Constants.CODE_FAIL, "请输入正确的查询参数", null, null);
        }
        List<ClassesPO> list = classService.queryClasses(offset,limit);
        Integer integer = classService.queryTotalClasses();
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",integer,list);
    }

    /**
     * 添加班级
     * @param req
     * @return
     */
    @RequestMapping(value = "add_class",method = RequestMethod.POST)
    @AuthToken(role_name = "admin")
    public JsonResult addClass(@RequestBody ClassReq req)   {
        String name = req.getName();
        if(StringUtils.isBlank(name)){
            return new JsonResult(Constants.CODE_FAIL,"班级名称不能为空",null,null);
        }
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
            return new JsonResult(Constants.CODE_EXIST,"班级名称已经存在",null,null);
        }
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
    }

    /**
     * 删除班级
     * @param req
     * @return
     */
    @RequestMapping(value = "delete_class",method = RequestMethod.POST)
    @AuthToken(role_name = "admin")
    public JsonResult deleteClass(@RequestBody ClassReq req)  {
        String id = req.getId();
        classService.deleteClass(id);
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
    }

    /**
     * 修改班级信息
     * @param req
     * @return
     */
    @RequestMapping(value = "modify_class_information",method = RequestMethod.POST)
    @AuthToken(role_name = "admin")
    public JsonResult modifyClassInformation(@RequestBody ClassReq req)  {
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
            return new JsonResult(Constants.CODE_EXIST,"班级名称已经存在",null,null);
        }
        return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
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
