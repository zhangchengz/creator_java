package com.tlf.creator.controller.curriculum.coursestudy;

import com.tlf.creator.common.JsonResult;
import com.tlf.creator.config.UploadPathBean;
import com.tlf.creator.common.Constants;
import com.tlf.creator.entity.curriculum.training.Training;
import com.tlf.creator.entity.curriculum.training.TrainingFile;
import com.tlf.creator.entity.user.course.Courses;
import com.tlf.creator.exception.OperatingException;
import com.tlf.creator.permission.AuthToken;
import com.tlf.creator.req.CourseReq;
import com.tlf.creator.req.TrainingResourceReq;
import com.tlf.creator.service.curriculum.training.TrainingFileService;
import com.tlf.creator.service.curriculum.training.TrainingService;
import com.tlf.creator.service.user.course.ICoursesService;
import com.tlf.creator.service.curriculum.material.IChapterService;
import com.tlf.creator.service.curriculum.material.IMaterialService;
import com.tlf.creator.service.curriculum.material.IUnitService;
import com.tlf.creator.utils.AccountUtil;
import com.tlf.creator.vo.ModuleTrainVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping
public class CourseStudyController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private IUnitService unitService;

    @Autowired
    private IChapterService chapterService;

    @Autowired
    private IMaterialService materialService;

    @Autowired
    private UploadPathBean uploadPathBean;

    @Autowired
    private AccountUtil accountUtil;

    @Autowired
    private ICoursesService coursesService;

    @Autowired
    private TrainingService trainingService;

    @Autowired
    private TrainingFileService fileService;

    /**
     * 获取课程介绍
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_course_description", method = RequestMethod.POST)
    public JsonResult getCourseDescription(@RequestBody CourseReq req) {
        String courseId = req.getCourseId();
        if (courseId == null) {
            return new JsonResult(Constants.CODE_FAIL, "课程id为空", null, null);
        }
        Courses courses = coursesService.queryCourseDescription(courseId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, courses);
    }

    /**
     * 修改课程介绍
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_course_description", method = RequestMethod.POST)
    @AuthToken(role_name = "teacher")
    public JsonResult modifyCourseDescription(@RequestBody CourseReq req) {
        String courseId = req.getCourseId();
        String description = req.getDescription();
        if (courseId == null || description == null) {
            return new JsonResult(Constants.CODE_FAIL, "课程id为空或者课程介绍为空", null, null);
        }
        coursesService.updateCourseDescriptionById(description, courseId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
    }

    /**
     * 修改授课目标
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_course_objectives", method = RequestMethod.POST)
    @AuthToken(role_name = "teacher")
    public JsonResult modifyCourseObjectives(@RequestBody CourseReq req) {
        String courseId = req.getCourseId();
        String objectives = req.getObjectives();
        if (courseId == null || objectives == null) {
            return new JsonResult(Constants.CODE_FAIL, "MISSING PARAMETERS", null, null);
        }
        coursesService.updateCourseObjectivesById(objectives, courseId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, null);
    }

    /**
     * 实训资源部分课程实训列表
     *
     * @param request
     * @return
     */
    @PostMapping(value = "get_module_and_training_inner")
    public JsonResult getModuleAndTrainingInner(HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        List<ModuleTrainVO> moduleTrainVOS = trainingService.selectModuleAndTraining(courseId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, moduleTrainVOS);
    }

    /**
     * 实训资源部分我的实训列表
     *
     * @param request
     * @return
     */
    @PostMapping(value = "get_module_and_training_self")
    @AuthToken(role_name = "teacher")
    public JsonResult getModuleAndTrainingSelf(HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        String accountId = accountUtil.getAccountId(request);
        List<Training> trainings = trainingService.selectAllTrainingByTeacher(courseId, accountId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, trainings);
    }

    /**
     * 根据模块获取资源
     *
     * @return
     */
    @PostMapping(value = "get_resource_by_module")
    public JsonResult getResourceByModule(@RequestBody TrainingResourceReq req, HttpServletRequest request) {
        if (StringUtils.isBlank(req.getModuleId())) {
            return new JsonResult(Constants.CODE_FAIL, "模块id不能为空", null, null);
        }
        String courseId = request.getHeader("Cube-Domain");
        List<TrainingFile> list = fileService.selectByModuleId(courseId, req.getModuleId());
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, list);
    }

    /**
     * 根据实训获取资源
     *
     * @param req
     * @param request
     * @return
     */
    @PostMapping(value = "get_resource_by_training")
    public JsonResult getResourceByTraining(@RequestBody TrainingResourceReq req, HttpServletRequest request) {
        if (StringUtils.isBlank(req.getTrainingId())) {
            return new JsonResult(Constants.CODE_FAIL, "实训id不能为空", null, null);
        }
        String courseId = request.getHeader("Cube-Domain");
        List<TrainingFile> list = fileService.selectByTrainingId(courseId, req.getTrainingId());
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, list);
    }

    /**
     * 获取所有的课程实训资源
     *
     * @param request
     * @return
     */
    @PostMapping(value = "get_resource_training_inner")
    public JsonResult getResourceTrainingInner(HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        List<TrainingFile> list = fileService.selectByTrainingInner(courseId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, list);
    }

    /**
     * 我的课程实训资源
     *
     * @param request
     * @return
     */
    @PostMapping(value = "get_resource_training_self")
    @AuthToken
    public JsonResult getResourceTrainingSelf(HttpServletRequest request) {
        String courseId = request.getHeader("Cube-Domain");
        String accountId = accountUtil.getAccountId(request);
        List<TrainingFile> list = fileService.selectByTrainingSelf(courseId, accountId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null, list);
    }


//    /**
//     * 获取所有章节列表
//     *
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "get_chapter_and_unit_list", method = RequestMethod.POST)
//    @AuthToken
//    public JsonResult getChapterAndUnit(@RequestBody BaseReq req) throws OperatingException {
//        List<ChapterPO> chapters = chapterService.selectChapterAndUnit();
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS",null, chapters);
//    }
//
//    /**
//     * 获取所有章列表
//     *
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "get_chapters", method = RequestMethod.POST)
//    @AuthToken
//    public JsonResult getChapters(@RequestBody BaseReq req) throws OperatingException {
//        List<Chapter> chapters = chapterService.selectChapters();
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", chapters);
//    }
//
//    /**
//     * 根据章id获取节列表
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "get_unit_list", method = RequestMethod.POST)
//    public JsonResult getUnitByChapterId(@RequestBody StudyReq req) throws OperatingException {
//
//        List<Unit> units = unitService.selectUnitByChapterId(req.getChapterId());
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", units);
//    }
//
//    /**
//     * 资料上传
//     *
//     * @param req
//     * @return
//     * @throws IOException
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "upload_material", method = RequestMethod.POST)
//    public JsonResult uploadMaterial(@RequestBody StudyReq req) throws IOException, OperatingException {
//        File upload = new File(uploadPathBean.getUploadPath()+"/material");
//        if (!upload.exists()) {
//            upload.mkdirs();
//        }
//        String chapterId = req.getChapterId();
//        String unitId = req.getUnitId();
//        String filename = req.getFileName();
//        byte[] bytes = req.getFile();
////        String file = (String) file1
////        byte[] bytes = file.getBytes("UTF-8");
//        String suffixName = filename.substring(filename.lastIndexOf("."));
//        String fileId = UUID.randomUUID().toString();
//        String materialName = fileId + suffixName;
//        Path simPath = Paths.get(upload.getAbsolutePath() + "/" + materialName);
//        Files.write(simPath, bytes);
//        String materialId = UUID.randomUUID().toString();
//        String macId = UUID.randomUUID().toString();
//        Material material = new Material();
//        material.setId(materialId);
//        material.setName(filename);
//        material.setPath("material/" + fileId + suffixName);
//        logger.info(material.getPath());
//        MaterialAndChapter mac = new MaterialAndChapter();
//        mac.setId(macId);
//        mac.setMaterialId(materialId);
//        mac.setChapterId(chapterId);
//        mac.setUnitId(unitId);
//        materialService.addMaterial(material, mac);
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
//    }
//
//    /**
//     * 查询所有的资料
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "get_all_materials", method = RequestMethod.POST)
//    public JsonRet getAllMaterials(@RequestBody StudyReq req) throws OperatingException {
//        Integer limit = req.getLimit();
//        Integer offset = req.getOffset();
//        List<Material> materials = materialService.selectAllMaterials(offset, limit);
//        Integer amount = materialService.selectMaterialAmount();
//        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", amount, materials);
//    }
//
//    /**
//     * 获取指定章下的资料
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "get_materials_by_chapter", method = RequestMethod.POST)
//    public JsonRet getMaterialsByChapter(@RequestBody StudyReq req) throws OperatingException {
//        Integer offset = req.getOffset();
//        Integer limit = req.getLimit();
//        String chapterId = req.getChapterId();
//        List<Material> materials = materialService.selectMaterialByChapterId(chapterId, offset, limit);
//        Integer amount = materialService.selectMaterialAmountByChapterId(chapterId);
//        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", amount, materials);
//    }
//
//    /**
//     * 获取指定节下的资料
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "get_materials_by_unit", method = RequestMethod.POST)
//    public JsonRet getMaterialsByUnit(@RequestBody StudyReq req) throws OperatingException {
//        String unitId = req.getUnitId();
//        Integer offset = req.getOffset();
//        Integer limit = req.getLimit();
//        List<Material> materials = materialService.selectMaterialByUnitId(unitId, offset, limit);
//        Integer amount = materialService.selectMaterialAmountByUnitId(unitId);
//        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", amount, materials);
//    }
//
//    /**
//     * 添加章
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//
//    @RequestMapping(value = "add_chapter", method = RequestMethod.POST)
//    public JsonResult addChapter(@RequestBody StudyReq req) throws OperatingException {
//        String chapterName = req.getChapterName();
//        Integer level = req.getLevel();
//        Chapter chapter = new Chapter();
//        chapter.setId(UUID.randomUUID().toString());
//        chapter.setName(chapterName);
//        chapter.setLevel(level);
//        chapterService.insertChapter(chapter);
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
//    }
//
//    /**
//     * 添加节
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "add_unit", method = RequestMethod.POST)
//    public JsonResult addUnit(@RequestBody StudyReq req) throws OperatingException {
//        Integer level = req.getLevel();
//        String unitName = req.getUnitName();
//        String chapterId = req.getChapterId();
//        Unit unit = new Unit();
//        unit.setId(UUID.randomUUID().toString());
//        unit.setName(unitName);
//        unit.setChapterId(chapterId);
//        unit.setLevel(level);
//        unitService.insertUnit(unit);
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
//    }
//
//    /**
//     * 修改章名称
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "modify_chapter_name", method = RequestMethod.POST)
//    public JsonResult modifyChapterName(@RequestBody StudyReq req) throws OperatingException {
//        String chapterId = req.getChapterId();
//        String chapterName = req.getChapterName();
//        chapterService.updateChapterNameById(chapterName, chapterId);
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
//    }
//
//    /**
//     * 修改节名称
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "modify_unit_name", method = RequestMethod.POST)
//    public JsonResult modifyUnitName(@RequestBody StudyReq req) throws OperatingException {
//        String unitName = req.getUnitName();
//        String unitId = req.getUnitId();
//        unitService.updateUnitNameById(unitName, unitId);
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
//    }
//
//    /**
//     * 删除章
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "delete_chapter", method = RequestMethod.POST)
//    public JsonResult deleteChapter(@RequestBody StudyReq req) throws OperatingException {
//        String chapterId = req.getChapterId();
//        chapterService.deleteChapterById(chapterId);
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
//    }
//
//    /**
//     * 删除节
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "delete_unit", method = RequestMethod.POST)
//    public JsonResult deleteUnit(@RequestBody StudyReq req) throws OperatingException {
//        String unitId = req.getUnitId();
//        unitService.deleteUnitById(unitId);
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
//    }
//
//    /**
//     * 文件重命名
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "modify_material_name", method = RequestMethod.POST)
//    public JsonResult modifyMaterialName(@RequestBody StudyReq req) throws OperatingException {
//        String materialId = req.getMaterialId();
//        String materialName = req.getMaterialName();
//        materialService.updateMaterialName(materialName, materialId);
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
//    }
//
//    /**
//     * 删除文件
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "delete_material", method = RequestMethod.POST)
//    public JsonResult deleteMaterial(@RequestBody StudyReq req) throws OperatingException {
//        String materialId = req.getMaterialId();
//        materialService.deleteMaterial(materialId);
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
//    }
//
//    /**
//     * 修改资源章节位置
//     *
//     * @param req
//     * @return
//     * @throws OperatingException
//     */
//    @RequestMapping(value = "modify_material_chapter_and_unit", method = RequestMethod.POST)
//    public JsonResult modifyMaterialPosition(@RequestBody StudyReq req) throws OperatingException {
//        String materialId = req.getMaterialId();
//        String chapterId = req.getChapterId();
//        String unitId = req.getUnitId();
//        materialService.updateMaterialPosition(chapterId, unitId, materialId);
//        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
//    }


}