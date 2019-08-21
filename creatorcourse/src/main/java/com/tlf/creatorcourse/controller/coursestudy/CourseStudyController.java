package com.tlf.creatorcourse.controller.coursestudy;

import com.tlf.creatorcourse.common.JsonResult;
import com.tlf.creatorcourse.common.JsonRet;
import com.tlf.creatorcourse.config.UploadPathBean;
import com.tlf.creatorcourse.constants.Constants;
import com.tlf.creatorcourse.entity.coursestudy.Chapter;
import com.tlf.creatorcourse.entity.coursestudy.Material;
import com.tlf.creatorcourse.entity.coursestudy.MaterialAndChapter;
import com.tlf.creatorcourse.entity.coursestudy.Unit;
import com.tlf.creatorcourse.exception.OperatingException;
import com.tlf.creatorcourse.po.ChapterPO;
import com.tlf.creatorcourse.req.BaseReq;
import com.tlf.creatorcourse.req.StudyReq;
import com.tlf.creatorcourse.service.material.IChapterService;
import com.tlf.creatorcourse.service.material.IMaterialService;
import com.tlf.creatorcourse.service.material.IUnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
@CrossOrigin
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

    /**
     * 获取所有章节列表
     *
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_chapter_and_unit_list", method = RequestMethod.POST)
    public JsonResult getChapterAndUnit(@RequestBody BaseReq req) throws OperatingException {
        List<ChapterPO> chapters = chapterService.selectChapterAndUnit();
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", chapters);
    }

    /**
     * 获取所有章列表
     *
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_chapters", method = RequestMethod.POST)
    public JsonResult getChapters(@RequestBody BaseReq req) throws OperatingException {
        List<Chapter> chapters = chapterService.selectChapters();
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", chapters);
    }

    /**
     * 根据章id获取节列表
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_unit_list", method = RequestMethod.POST)
    public JsonResult getUnitByChapterId(@RequestBody StudyReq req) throws OperatingException {

        List<Unit> units = unitService.selectUnitByChapterId(req.getChapterId());
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", units);
    }

    /**
     * 资料上传
     *
     * @param req
     * @return
     * @throws IOException
     * @throws OperatingException
     */
    @RequestMapping(value = "upload_material", method = RequestMethod.POST)
    public JsonResult uploadMaterial(@RequestBody StudyReq req) throws IOException, OperatingException {
        File upload = new File(uploadPathBean.getUploadPath()+"/material");
        if (!upload.exists()) {
            upload.mkdirs();
        }
        String chapterId = req.getChapterId();
        String unitId = req.getUnitId();
        String filename = req.getFileName();
        byte[] bytes = req.getFile();
//        String file = (String) file1
//        byte[] bytes = file.getBytes("UTF-8");
        String suffixName = filename.substring(filename.lastIndexOf("."));
        String fileId = UUID.randomUUID().toString();
        String materialName = fileId + suffixName;
        Path simPath = Paths.get(upload.getAbsolutePath() + "/" + materialName);
        Files.write(simPath, bytes);
        String materialId = UUID.randomUUID().toString();
        String macId = UUID.randomUUID().toString();
        Material material = new Material();
        material.setId(materialId);
        material.setName(filename);
        material.setPath("material/" + fileId + suffixName);
        logger.info(material.getPath());
        MaterialAndChapter mac = new MaterialAndChapter();
        mac.setId(macId);
        mac.setMaterialId(materialId);
        mac.setChapterId(chapterId);
        mac.setUnitId(unitId);
        materialService.addMaterial(material, mac);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 查询所有的资料
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_all_materials", method = RequestMethod.POST)
    public JsonRet getAllMaterials(@RequestBody StudyReq req) throws OperatingException {
        Integer limit = req.getLimit();
        Integer offset = req.getOffset();
        List<Material> materials = materialService.selectAllMaterials(offset, limit);
        Integer amount = materialService.selectMaterialAmount();
        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", amount, materials);
    }

    /**
     * 获取指定章下的资料
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_materials_by_chapter", method = RequestMethod.POST)
    public JsonRet getMaterialsByChapter(@RequestBody StudyReq req) throws OperatingException {
        Integer offset = req.getOffset();
        Integer limit = req.getLimit();
        String chapterId = req.getChapterId();
        List<Material> materials = materialService.selectMaterialByChapterId(chapterId, offset, limit);
        Integer amount = materialService.selectMaterialAmountByChapterId(chapterId);
        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", amount, materials);
    }

    /**
     * 获取指定节下的资料
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "get_materials_by_unit", method = RequestMethod.POST)
    public JsonRet getMaterialsByUnit(@RequestBody StudyReq req) throws OperatingException {
        String unitId = req.getUnitId();
        Integer offset = req.getOffset();
        Integer limit = req.getLimit();
        List<Material> materials = materialService.selectMaterialByUnitId(unitId, offset, limit);
        Integer amount = materialService.selectMaterialAmountByUnitId(unitId);
        return new JsonRet(Constants.CODE_SUCCESS, "SUCCESS", amount, materials);
    }

    /**
     * 添加章
     *
     * @param req
     * @return
     * @throws OperatingException
     */

    @RequestMapping(value = "add_chapter", method = RequestMethod.POST)
    public JsonResult addChapter(@RequestBody StudyReq req) throws OperatingException {
        String chapterName = req.getChapterName();
        Integer level = req.getLevel();
        Chapter chapter = new Chapter();
        chapter.setId(UUID.randomUUID().toString());
        chapter.setName(chapterName);
        chapter.setLevel(level);
        chapterService.insertChapter(chapter);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 添加节
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "add_unit", method = RequestMethod.POST)
    public JsonResult addUnit(@RequestBody StudyReq req) throws OperatingException {
        Integer level = req.getLevel();
        String unitName = req.getUnitName();
        String chapterId = req.getChapterId();
        Unit unit = new Unit();
        unit.setId(UUID.randomUUID().toString());
        unit.setName(unitName);
        unit.setChapterId(chapterId);
        unit.setLevel(level);
        unitService.insertUnit(unit);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 修改章名称
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_chapter_name", method = RequestMethod.POST)
    public JsonResult modifyChapterName(@RequestBody StudyReq req) throws OperatingException {
        String chapterId = req.getChapterId();
        String chapterName = req.getChapterName();
        chapterService.updateChapterNameById(chapterName, chapterId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 修改节名称
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_unit_name", method = RequestMethod.POST)
    public JsonResult modifyUnitName(@RequestBody StudyReq req) throws OperatingException {
        String unitName = req.getUnitName();
        String unitId = req.getUnitId();
        unitService.updateUnitNameById(unitName, unitId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 删除章
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "delete_chapter", method = RequestMethod.POST)
    public JsonResult deleteChapter(@RequestBody StudyReq req) throws OperatingException {
        String chapterId = req.getChapterId();
        chapterService.deleteChapterById(chapterId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 删除节
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "delete_unit", method = RequestMethod.POST)
    public JsonResult deleteUnit(@RequestBody StudyReq req) throws OperatingException {
        String unitId = req.getUnitId();
        unitService.deleteUnitById(unitId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 文件重命名
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_material_name", method = RequestMethod.POST)
    public JsonResult modifyMaterialName(@RequestBody StudyReq req) throws OperatingException {
        String materialId = req.getMaterialId();
        String materialName = req.getMaterialName();
        materialService.updateMaterialName(materialName, materialId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 删除文件
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "delete_material", method = RequestMethod.POST)
    public JsonResult deleteMaterial(@RequestBody StudyReq req) throws OperatingException {
        String materialId = req.getMaterialId();
        materialService.deleteMaterial(materialId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

    /**
     * 修改资源章节位置
     *
     * @param req
     * @return
     * @throws OperatingException
     */
    @RequestMapping(value = "modify_material_chapter_and_unit", method = RequestMethod.POST)
    public JsonResult modifyMaterialPosition(@RequestBody StudyReq req) throws OperatingException {
        String materialId = req.getMaterialId();
        String chapterId = req.getChapterId();
        String unitId = req.getUnitId();
        materialService.updateMaterialPosition(chapterId, unitId, materialId);
        return new JsonResult(Constants.CODE_SUCCESS, "SUCCESS", null);
    }

}