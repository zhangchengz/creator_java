package com.tlf.creator.controller.curriculum.training;

import com.tlf.creator.aspect.AuthToken;
import com.tlf.creator.common.Constants;
import com.tlf.creator.common.JsonResult;
import com.tlf.creator.entity.curriculum.training.Training;
import com.tlf.creator.entity.curriculum.training.TrainingModule;
import com.tlf.creator.entity.curriculum.training.TrainingType;
import com.tlf.creator.req.TrainingReq;
import com.tlf.creator.service.curriculum.training.TrainingModuleService;
import com.tlf.creator.service.curriculum.training.TrainingService;
import com.tlf.creator.service.curriculum.training.TrainingTypeService;
import com.tlf.creator.utils.AccountUtil;
import com.tlf.creator.vo.TrainingVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

/**
 * controller 课程实训相关
 *
 * @author zhangc
 * @date 2019/9/5
 */
@RestController
@RequestMapping
@CrossOrigin
public class TrainingController {

    @Autowired
    private AccountUtil accountUtil;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private TrainingModuleService moduleService;

    @Autowired
    private TrainingTypeService typeService;

    /**
     * 新增实训
     *
     * @param req
     * @param request
     * @return
     */
    @PostMapping(value = "add_training")
    @AuthToken(role_name = "teacher")
    public JsonResult addTraining(@RequestBody TrainingReq req, HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        String accountId = accountUtil.getAccountId(request);
        if (StringUtils.isBlank(req.getTrainingName())||StringUtils.isBlank(req.getTrainingTypeId())) {
            return new JsonResult(Constants.CODE_FAIL, "名称和实训类型不能为空不能为空", null, null);
        }
        Training training = new Training();
        String trainingId = UUID.randomUUID().toString();
        training.setId(trainingId);
        training.setCreatorId(accountId);
        training.setName(req.getTrainingName());
        training.setModuleId(req.getTrainingModuleId());
        training.setTypeId(req.getTrainingTypeId());
        training.setInnerr(false);
        boolean insert = trainingService.insert(courseId, training);
        if (insert) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
        } else {
            return new JsonResult(Constants.CODE_FAIL, "FAIL", null, null);
        }
    }

    /**
     * 获取实训列表
     *
     * @param req
     * @param request
     * @return
     */
    @PostMapping(value = "get_training_list")
    @AuthToken
    public JsonResult getTrainingList(@RequestBody TrainingReq req, HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        String accountId = accountUtil.getAccountId(request);
        req.setCreatorId(accountId);
        if (req.isInnerr()) {
            //课程实训
            int countInner = trainingService.selectCountInner(courseId, req);
            List<Training> trainings = trainingService.selectTrainingInner(courseId, req);
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", countInner, trainings);
        } else {
            //我的实训
            int countSelf = trainingService.selectCountSelf(courseId, req);
            List<Training> trainings = trainingService.selectTrainingByTeacher(courseId, req);
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", countSelf, trainings);
        }
    }

    /**
     * 获取实训详情
     *
     * @param req
     * @param request
     * @return
     */
    @PostMapping(value = "training_details")
    public JsonResult trainingDetails(@RequestBody TrainingReq req, HttpServletRequest request) {
        if (StringUtils.isBlank(req.getTrainingId())) {
            return new JsonResult(Constants.CODE_FAIL, "id不能为空", null, null);
        }
        String courseId = request.getHeader("Cube-Domain");
        TrainingVO trainingVO = trainingService.selectByPrimaryKey(courseId, req.getTrainingId());
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, trainingVO);
    }

    /**
     * 删除实训
     *
     * @param req
     * @param request
     * @return
     */
    @PostMapping(value = "delete_training")
    @AuthToken(role_name = "teacher")
    public JsonResult deleteTraining(@RequestBody TrainingReq req, HttpServletRequest request) {
        if (StringUtils.isBlank(req.getTrainingId())) {
            return new JsonResult(Constants.CODE_FAIL, "id不能为空", null, null);
        }
        String courseId = request.getHeader("Cube-Domain");
        boolean delete = trainingService.deleteByPrimaryKey(courseId, req.getTrainingId());
        if (delete) {
            return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
        } else {
            return new JsonResult(Constants.CODE_FAIL, "FAIL", null, null);
        }
    }

    /**
     * 编辑，修改实训内容
     *
     * @param req
     * @param request
     * @return
     */
    @PostMapping(value = "edit_training")
    @AuthToken(role_name = "teacher")
    public JsonResult editTraining(@RequestBody TrainingReq req, HttpServletRequest request) {
        if (StringUtils.isBlank(req.getTrainingId()) || req.getMode() == null) {
            return new JsonResult(Constants.CODE_FAIL, "id,模式不能为空", null, null);
        }
        String courseId = request.getHeader("Cube-Domain");
        trainingService.updateByPrimaryKey(courseId, req);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
    }

    /**
     * 获取实训模块列表
     *
     * @param request
     * @return
     */
    @PostMapping(value = "get_training_module")
    public JsonResult getTrainingModule(HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        List<TrainingModule> trainingModules = moduleService.selectAllVisible(courseId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, trainingModules);
    }

    /**
     * 获取实训类型列表
     *
     * @param request
     * @return
     */
    @PostMapping(value = "get_training_type")
    public JsonResult getTrainingType(HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        List<TrainingType> trainingTypes = trainingService.selectTrainingType(courseId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, trainingTypes);
    }

    /**
     * 添加实训模块
     * @param req
     * @param request
     * @return
     */
    @PostMapping(value = "add_training_module")
    @AuthToken(role_name = "teacher")
    public JsonResult addTrainingModule(@RequestBody TrainingReq req,HttpServletRequest request){
        if(StringUtils.isBlank(req.getTrainingModuleName())){
            return new JsonResult(Constants.CODE_FAIL,"名称不能为空",null,null);
        }
        String courseId = request.getHeader("Cube-Domain");
        TrainingModule trainingModule = new TrainingModule();
        String id = UUID.randomUUID().toString();
        trainingModule.setId(id);
        trainingModule.setName(req.getTrainingModuleName());
        boolean insert = moduleService.insert(courseId, trainingModule);
        if(insert){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,id);
        }else{
            return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
        }
    }

    /**
     * 删除实训模块
     * @param req
     * @param request
     * @return
     */
    @PostMapping(value = "delete_training_module")
    @AuthToken(role_name = "teacher")
    public JsonResult deleteTrainingModule(@RequestBody TrainingReq req,HttpServletRequest request){
        if(StringUtils.isBlank(req.getTrainingModuleId())){
            return new JsonResult(Constants.CODE_FAIL,"id不能为空",null,null);
        }
        String courseId = request.getHeader("Cube-Domain");
        boolean delete = moduleService.deleteByPrimaryKey(courseId, req.getTrainingModuleId());
        if(delete){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }else{
            return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
        }
    }

    @PostMapping(value = "modify_training_module")
    @AuthToken(role_name = "teacher")
    public JsonResult modifyTrainingModule(@RequestBody TrainingReq req,HttpServletRequest request){
        if(StringUtils.isBlank(req.getTrainingModuleId())||StringUtils.isBlank(req.getTrainingId())){
            return new JsonResult(Constants.CODE_FAIL,"id不能为空",null,null);
        }
        String courseId = request.getHeader("Cube-Domain");
        boolean b = trainingService.updateTrainingModule(courseId, req.getTrainingModuleId(), req.getTrainingId());
        if(b){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }else{
            return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
        }
    }

    @PostMapping(value = "add_training_type")
    @AuthToken(role_name = "teacher")
    public JsonResult addTrainingType(@RequestBody TrainingReq req,HttpServletRequest request){
        if(StringUtils.isBlank(req.getTrainingTypeName())){
            return new JsonResult(Constants.CODE_FAIL,"名称不能为空",null,null);
        }
        String courseId = request.getHeader("Cube-Domain");
        TrainingType trainingType = new TrainingType();
        String id = UUID.randomUUID().toString();
        trainingType.setId(id);
        trainingType.setName(req.getTrainingTypeName());
        boolean insert = typeService.insert(courseId, trainingType);
        if(insert){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }else{
            return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
        }
    }

    @PostMapping(value = "delete_training_type")
    @AuthToken(role_name = "teacher")
    public JsonResult deleteTrainingType(@RequestBody TrainingReq req,HttpServletRequest request){
        if(StringUtils.isBlank(req.getTrainingTypeId())){
            return new JsonResult(Constants.CODE_FAIL,"id不能为空",null,null);
        }
        String courseId = request.getHeader("Cube-Domain");
        boolean delete = typeService.deleteByPrimaryKey(courseId, req.getTrainingTypeId());
        if(delete){
            return new JsonResult(Constants.CODE_SUCCESS,"SUCCESS",null,null);
        }else{
            return new JsonResult(Constants.CODE_FAIL,"FAIL",null,null);
        }
    }

}
