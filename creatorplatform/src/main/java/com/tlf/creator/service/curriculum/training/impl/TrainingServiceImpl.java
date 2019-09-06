package com.tlf.creator.service.curriculum.training.impl;

import cn.hutool.core.io.FileUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tlf.creator.aspect.DS;
import com.tlf.creator.config.UploadPathBean;
import com.tlf.creator.dao.curriculum.simulation.SimulationResourceMapper;
import com.tlf.creator.dao.curriculum.training.*;
import com.tlf.creator.dto.Description;
import com.tlf.creator.dto.ExamMode;
import com.tlf.creator.dto.PracticeMode;
import com.tlf.creator.dto.TeachMode;
import com.tlf.creator.entity.curriculum.simulation.SimulationResource;
import com.tlf.creator.entity.curriculum.training.*;
import com.tlf.creator.po.TrainingSimPO;
import com.tlf.creator.req.TrainingReq;
import com.tlf.creator.service.curriculum.training.TrainingService;
import com.tlf.creator.utils.FileTypeEnum;
import com.tlf.creator.utils.ModeEnum;
import com.tlf.creator.vo.ModuleTrainVO;
import com.tlf.creator.vo.TrainingVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingFileMapper fileMapper;

    @Autowired
    private TrainingMapper trainingMapper;

    @Autowired
    private TrainingSimMapper trainingSimMapper;

    @Autowired
    private UploadPathBean uploadPathBean;

    @Autowired
    private SimulationResourceMapper simMapper;

    @Autowired
    private TrainingModuleMapper moduleMapper;

    @Autowired
    private TrainingTypeMapper typeMapper;

    @Override
    @DS
    @Transactional(value = "transactionManager")
    public boolean deleteByPrimaryKey(String courseId, String id) {
        List<TrainingFile> list = fileMapper.selectByTrainingId(id);
        for(TrainingFile trainingFile:list){
            if(trainingFile!=null){
                fileMapper.deleteByPrimaryKey(trainingFile.getId());
                File file = new File(uploadPathBean.getUploadPath()+trainingFile.getPath());
                if(file.exists()){
                    file.delete();
                }
            }
        }
        int delete = trainingMapper.deleteByPrimaryKey(id);
        if (delete > 0) {
            return true;
        }
        return false;
    }

    @Override
    @DS
    public List<Training> selectTrainingInner(String courseId, TrainingReq req) {
        List<Training> trainings = trainingMapper.selectTrainingInner(req);
        return trainings;
    }

    @Override
    @DS
    public int selectCountInner(String courseId, TrainingReq req) {
        int countInner = trainingMapper.selectCountInner(req);
        return countInner;
    }

    @Override
    @DS
    public List<Training> selectTrainingByTeacher(String courseId, TrainingReq req) {
        List<Training> trainings = trainingMapper.selectTrainingByTeacher(req);
        return trainings;
    }

    @Override
    @DS
    public int selectCountSelf(String courseId, TrainingReq req) {
        int countSelf = trainingMapper.selectCountSelf(req);
        return countSelf;
    }


    @Override
    @DS
    public boolean insert(String courseId, Training record) {
        TrainingModule trainingModule = moduleMapper.selectAllNotVisible();
        if(record!=null&&StringUtils.isBlank(record.getModuleId())){
            record.setModuleId(trainingModule.getId());
        }
        int insert = trainingMapper.insert(record);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    /**
     * 课程实训教练考模式详情
     *
     * @param courseId
     * @param id
     * @return
     */
    @Override
    @DS
    public TrainingVO selectByPrimaryKey(String courseId, String id) {
        Training training = trainingMapper.selectByPrimaryKey(id);
        if (training == null) {
            return null;
        }
        String trainingName = training.getName();
        // 课程实训教练考模式文件
        List<TrainingFile> trainingFiles = fileMapper.selectByTrainingId(id);
        List<TrainingFile> guide = new ArrayList<>();
        List<TrainingFile> annex = new ArrayList<>();
        List<TrainingFile> material = new ArrayList<>();
        List<TrainingFile> report = new ArrayList<>();
        for (TrainingFile trainingFile : trainingFiles) {
            if (trainingFile != null) {
                if (FileTypeEnum.GUIDE.toString().equals(trainingFile.getType())) {
                    trainingFile.setPath(uploadPathBean.getDownloadPath()+trainingFile.getPath());
                    guide.add(trainingFile);
                } else if (FileTypeEnum.ANNEX.toString().equals(trainingFile.getType())) {
                    trainingFile.setPath(uploadPathBean.getDownloadPath()+trainingFile.getPath());
                    annex.add(trainingFile);
                } else if (FileTypeEnum.MATERIAL.toString().equals(trainingFile.getType())) {
                    trainingFile.setPath(uploadPathBean.getDownloadPath()+trainingFile.getPath());
                    material.add(trainingFile);
                } else if (FileTypeEnum.REPORT.toString().equals(trainingFile.getType())) {
                    trainingFile.setPath(uploadPathBean.getDownloadPath()+trainingFile.getPath());
                    report.add(trainingFile);
                }
            }
        }
        //仿真实训场景
        List<TrainingSimPO> trainingSimPOS = trainingSimMapper.selectByTrainingId(id);
        List<TrainingSimPO> practiceSim = new ArrayList<>();
        List<TrainingSimPO> examSim = new ArrayList<>();
        for (TrainingSimPO trainingSimPO : trainingSimPOS) {
            if (trainingSimPO != null) {
                if (ModeEnum.PRACTICE.toString().equals(trainingSimPO.getMode())) {
                    trainingSimPO.setPath(uploadPathBean.getDownloadPath()+trainingSimPO.getPath());
                    practiceSim.add(trainingSimPO);
                } else if (ModeEnum.EXAM.toString().equals(trainingSimPO.getMode())) {
                    trainingSimPO.setPath(uploadPathBean.getDownloadPath()+trainingSimPO.getPath());
                    examSim.add(trainingSimPO);
                }
            }
        }
        //说明
        String teachDescription = training.getTeachDescription();
        String practiceDescription = training.getPracticeDescription();
        String examDescription = training.getExamDescription();
        List<Description> descriptionTeach = JSONObject.parseArray(teachDescription, Description.class);
        List<Description> descriptionPractice = JSONObject.parseArray(practiceDescription, Description.class);
        List<Description> descriptionExam = JSONObject.parseArray(examDescription, Description.class);

        TeachMode teachMode = new TeachMode(descriptionTeach, guide, annex);
        PracticeMode practiceMode = new PracticeMode(descriptionPractice, material, practiceSim);
        ExamMode examMode = new ExamMode(descriptionExam, report, examSim);
        TrainingVO trainingVO = new TrainingVO(id, trainingName, teachMode, practiceMode, examMode);
        return trainingVO;
    }

    @Override
    @DS
    public boolean updateByPrimaryKey(String courseId, TrainingReq req) {
        Training training = trainingMapper.selectByPrimaryKey(req.getTrainingId());
        List<TrainingFile> trainingFiles = fileMapper.selectByTrainingId(req.getTrainingId());
        if (training == null) {
            return false;
        }
        List<Description> description = req.getDescription();
        String descrip = null;
        if (description != null) {
            descrip = JSON.toJSON(description).toString();
        }
        if (req.getMode().equals(ModeEnum.TEACHING)) { //教学模式
            training.setTeachDescription(descrip);
            List<String> guideList = new ArrayList<>();
            List<String> annexList = new ArrayList<>();
            // 遍历
            for (TrainingFile trainingFile : trainingFiles) {
                if (trainingFile != null || StringUtils.isNotBlank(trainingFile.getId())) {
                    //取出指导书
                    if (FileTypeEnum.GUIDE.toString().equalsIgnoreCase(trainingFile.getType())) {
                        guideList.add(trainingFile.getId());
                    }
                    //取出参考附件
                    if (FileTypeEnum.ANNEX.toString().equalsIgnoreCase(trainingFile.getType())) {
                        annexList.add(trainingFile.getId());
                    }
                }
            }
            //如果传过来的指导书id为空，删除掉原有的指导书
            if (req.getGuide() == null || req.getGuide().isEmpty()||req.getGuide().size()==0) {
                for (String id : guideList) {
                    TrainingFile trainingFile = fileMapper.selectByPrimaryKey(id);
                    if (trainingFile != null) {
                        if (trainingFile.getQuote() == 0) {
                            String path = uploadPathBean.getUploadPath() + trainingFile.getPath();
                            File file = new File(path);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                    fileMapper.deleteByPrimaryKey(id);
                }
            } else {
                //对比数据库指导书和前端传值得差异
                List<String> guide = req.getGuide();
                List<String> guide1 = new ArrayList<>();
                guide1.addAll(guide);
                //保留前端指导书比数据库原有多的部分并修改为对应的指导书
                guide.removeAll(guideList);
                for (String id : guide) {
                    TrainingFile trainingFile = new TrainingFile();
                    trainingFile.setId(id);
                    trainingFile.setTrainingId(req.getTrainingId());
                    trainingFile.setTrainingPattern(ModeEnum.TEACHING.toString());
                    trainingFile.setType(FileTypeEnum.GUIDE.toString());
                    fileMapper.updateByPrimaryKey(trainingFile);
                }
                //差集产生数据库比前端传值多的部分，并删除
                boolean b = guideList.removeAll(guide1);
                if (b) {
                    for (String id : guideList) {
                        TrainingFile trainingFile = fileMapper.selectByPrimaryKey(id);
                        if (trainingFile != null) {
                            if (trainingFile.getQuote() == 0) {
                                String path = uploadPathBean.getUploadPath() + trainingFile.getPath();
                                File file = new File(path);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }
                        fileMapper.deleteByPrimaryKey(id);
                    }
                }
            }
            //如果传过来的参考附件id为空，删除掉原有的指导书
            if (req.getAnnex() == null || req.getAnnex().isEmpty()) {
                for (String id : annexList) {
                    TrainingFile trainingFile = fileMapper.selectByPrimaryKey(id);
                    if (trainingFile != null) {
                        if (trainingFile.getQuote() == 0) {
                            String path = uploadPathBean.getUploadPath() + trainingFile.getPath();
                            File file = new File(path);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                    fileMapper.deleteByPrimaryKey(id);
                }
            } else {
                List<String> annex = req.getAnnex();
                List<String> annex1 = new ArrayList<>();
                annex1.addAll(annex);
                System.out.println(annex1 == annex);
                //保留前端附件比数据库原有多的部分并修改为对应的附件
                annex.removeAll(annexList);
                for (String id : annex) {
                    TrainingFile trainingFile = new TrainingFile();
                    trainingFile.setId(id);
                    trainingFile.setTrainingId(req.getTrainingId());
                    trainingFile.setTrainingPattern(ModeEnum.TEACHING.toString());
                    trainingFile.setType(FileTypeEnum.ANNEX.toString());
                    fileMapper.updateByPrimaryKey(trainingFile);
                }
                //差集产生数据库比前端传值多的部分，并删除
                boolean b1 = annexList.removeAll(annex1);
                if (b1) {
                    for (String id : annexList) {
                        TrainingFile trainingFile = fileMapper.selectByPrimaryKey(id);
                        if (trainingFile != null) {
                            if (trainingFile.getQuote() == 0) {
                                String path = uploadPathBean.getUploadPath() + trainingFile.getPath();
                                File file = new File(path);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }
                        fileMapper.deleteByPrimaryKey(id);
                    }
                }
            }
        } else if (req.getMode().equals(ModeEnum.PRACTICE)) { //练习模式
            training.setPracticeDescription(descrip);
            List<String> materialList = new ArrayList<>();
            for (TrainingFile trainingFile : trainingFiles) {
                if (trainingFile != null || StringUtils.isNotBlank(trainingFile.getId())) {
                    if (FileTypeEnum.MATERIAL.toString().equalsIgnoreCase(trainingFile.getType())) {
                        materialList.add(trainingFile.getId());
                    }
                }
            }
            //取出前端传值的练习资料
            List<String> material = req.getMaterial();
            List<String> material1 = new ArrayList<>();
            material1.addAll(material);
            //如果内容为空，删除原有的内容
            if (material == null || material.isEmpty()) {
                for (String id : materialList) {
                    TrainingFile trainingFile = fileMapper.selectByPrimaryKey(id);
                    if (trainingFile != null) {
                        if (trainingFile.getQuote() == 0) {
                            String path = uploadPathBean.getUploadPath() + trainingFile.getPath();
                            File file = new File(path);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                    fileMapper.deleteByPrimaryKey(id);
                }
            } else {
                //差集产生比数据库多的内容，添加
                material.removeAll(materialList);
                for (String id : material) {
                    TrainingFile trainingFile = new TrainingFile();
                    trainingFile.setId(id);
                    trainingFile.setTrainingId(req.getTrainingId());
                    trainingFile.setTrainingPattern(ModeEnum.PRACTICE.toString());
                    trainingFile.setType(FileTypeEnum.MATERIAL.toString());
                    fileMapper.updateByPrimaryKey(trainingFile);
                }
                //差集产生数据库比前端传值多的部分，并删除
                boolean b = materialList.removeAll(material1);
                if (b) {
                    for (String id : materialList) {
                        TrainingFile trainingFile = fileMapper.selectByPrimaryKey(id);
                        if (trainingFile != null) {
                            if (trainingFile.getQuote() == 0) {
                                String path = uploadPathBean.getUploadPath() + trainingFile.getPath();
                                File file = new File(path);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }
                        fileMapper.deleteByPrimaryKey(id);
                    }
                }
            }
            //实训练习部分
            List<TrainingSimPO> trainingSimPOS = trainingSimMapper.selectByTrainingId(req.getTrainingId());
            List<String> practiceSimList = new ArrayList<>();
            List<String> practiceList = new ArrayList<>();
            for (TrainingSimPO trainingSimPO : trainingSimPOS) {
                if (trainingSimPO != null) {
                    if (ModeEnum.PRACTICE.toString().equalsIgnoreCase(trainingSimPO.getMode())) {
                        practiceSimList.add(trainingSimPO.getId());
                        practiceList.add(trainingSimPO.getSimId());
                    }
                }
            }
            List<String> practiceSim = req.getPracticeSim();
            List<String> practiceSim1 = new ArrayList<>();
            practiceSim1.addAll(practiceSim);
            //若传值为空，删除原有的实训练习
            if (practiceSim == null || practiceSim.isEmpty()) {
                for (String id : practiceSimList) {
                    trainingSimMapper.deleteByPrimaryKey(id);
                }
            } else {
                //数据库没有的值，新增
                practiceSim.removeAll(practiceList);
                for (String id : practiceSim) {
                    SimulationResource simulationResource = simMapper.selectByPrimaryKey(id);
                    if (simulationResource != null) {
                        String path = simulationResource.getPath();
                        File file = new File(uploadPathBean.getUploadPath() + path);
                        if (file.exists()) {
                            String simulationResourceId = UUID.randomUUID().toString();
                            String suffix = FileUtil.extName(file);
                            String sub = path.substring(0, path.lastIndexOf(".") - 36);
                            File file1 = new File(uploadPathBean.getUploadPath() + sub + simulationResourceId + "." + suffix);
                            FileUtil.copy(file, file1, false);
                            simulationResource.setId(simulationResourceId);
                            simulationResource.setInner(false);
                            simulationResource.setName(simulationResource.getName());
                            simulationResource.setPath(sub + simulationResourceId + "." + suffix);
                            simulationResource.setCreatorId(null);
                            simMapper.insert(simulationResource);
                            TrainingSim trainingSim = new TrainingSim();
                            trainingSim.setId(UUID.randomUUID().toString());
                            trainingSim.setSimId(simulationResourceId);
                            trainingSim.setTrainingId(req.getTrainingId());
                            trainingSim.setMode(ModeEnum.PRACTICE.toString());
                            trainingSimMapper.insert(trainingSim);
                        }
                    }
                }
                //数据库多余的值，删除
                practiceList.removeAll(practiceSim1);
                for (String id : practiceList) {
                    trainingSimMapper.deleteByTrainingAndSim(req.getTrainingId(), id);
                }
            }
        } else if (req.getMode().equals(ModeEnum.EXAM)) { //考核模式
            training.setExamDescription(descrip);
            List<String> reportList = new ArrayList<>();
            for (TrainingFile trainingFile : trainingFiles) {
                if (trainingFile != null || StringUtils.isNotBlank(trainingFile.getId())) {
                    if (FileTypeEnum.REPORT.toString().equalsIgnoreCase(trainingFile.getType())) {
                        reportList.add(trainingFile.getId());
                    }
                }
            }
            //取出前端传值的练习资料
            List<String> report = req.getReport();
            List<String> report1 = new ArrayList<>();
            report1.addAll(report);
            //如果内容为空，删除原有的内容
            if (report == null || report.isEmpty()) {
                for (String id : reportList) {
                    TrainingFile trainingFile = fileMapper.selectByPrimaryKey(id);
                    if (trainingFile != null) {
                        if (trainingFile.getQuote() == 0) {
                            String path = uploadPathBean.getUploadPath() + trainingFile.getPath();
                            File file = new File(path);
                            if (file.exists()) {
                                file.delete();
                            }
                        }
                    }
                    fileMapper.deleteByPrimaryKey(id);
                }
            } else {
                //差集产生比数据库多的内容，添加
                report.removeAll(reportList);
                for (String id : report) {
                    TrainingFile trainingFile = new TrainingFile();
                    trainingFile.setId(id);
                    trainingFile.setTrainingId(req.getTrainingId());
                    trainingFile.setTrainingPattern(ModeEnum.EXAM.toString());
                    trainingFile.setType(FileTypeEnum.REPORT.toString());
                    fileMapper.updateByPrimaryKey(trainingFile);
                }
                //差集产生数据库比前端传值多的部分，并删除
                boolean b = reportList.removeAll(report1);
                if (b) {
                    for (String id : reportList) {
                        TrainingFile trainingFile = fileMapper.selectByPrimaryKey(id);
                        if (trainingFile != null) {
                            if (trainingFile.getQuote() == 0) {
                                String path = uploadPathBean.getUploadPath() + trainingFile.getPath();
                                File file = new File(path);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }
                        fileMapper.deleteByPrimaryKey(id);
                    }
                }
            }
            List<TrainingSimPO> trainingSimPOS = trainingSimMapper.selectByTrainingId(req.getTrainingId());
            List<String> examSimList = new ArrayList<>();
            List<String> examList = new ArrayList<>();
            for (TrainingSimPO trainingSimPO : trainingSimPOS) {
                if (trainingSimPO != null) {
                    if (ModeEnum.EXAM.toString().equalsIgnoreCase(trainingSimPO.getMode())) {
                        examSimList.add(trainingSimPO.getId());
                        examList.add(trainingSimPO.getSimId());
                    }
                }
            }
            List<String> examSim = req.getExamSim();
            List<String> examSim1 = new ArrayList<>();
            examSim1.addAll(examSim);
            //若传值为空，删除原有的实训练习
            if (examSim == null || examSim.isEmpty()) {
                for (String id : examSimList) {
                    trainingSimMapper.deleteByPrimaryKey(id);
                }
            } else {
                //数据库没有的值，新增
                examSim.removeAll(examList);
                for (String id : examSim) {
                    SimulationResource simulationResource = simMapper.selectByPrimaryKey(id);
                    if (simulationResource != null) {
                        String path = simulationResource.getPath();
                        File file = new File(uploadPathBean.getUploadPath() + path);
                        if (file.exists()) {
                            String simulationResourceId = UUID.randomUUID().toString();
                            String suffix = FileUtil.extName(file);
                            String sub = path.substring(0, path.lastIndexOf(".") - 36);
                            File file1 = new File(uploadPathBean.getUploadPath() + sub + simulationResourceId + "." + suffix);
                            FileUtil.copy(file, file1, false);
                            simulationResource.setId(simulationResourceId);
                            simulationResource.setInner(false);
                            simulationResource.setName(simulationResource.getName());
                            simulationResource.setPath(sub + simulationResourceId + "." + suffix);
                            simulationResource.setCreatorId(null);
                            simMapper.insert(simulationResource);
                            TrainingSim trainingSim = new TrainingSim();
                            trainingSim.setId(UUID.randomUUID().toString());
                            trainingSim.setSimId(simulationResourceId);
                            trainingSim.setTrainingId(req.getTrainingId());
                            trainingSim.setMode(ModeEnum.EXAM.toString());
                            trainingSimMapper.insert(trainingSim);
                        }
                    }
                }
                //数据库多余的值，删除
                examList.removeAll(examSim1);
                for (String id : examList) {
                    trainingSimMapper.deleteByTrainingAndSim(req.getTrainingId(), id);
                }
            }
        }
        trainingMapper.updateByPrimaryKey(training);
        trainingMapper.updateTime(req.getTrainingId());
        return true;
    }

    @Override
    @DS
    public List<ModuleTrainVO> selectModuleAndTraining(String courseId) {
        List<ModuleTrainVO> moduleTrainVOS = new ArrayList<>();
        List<TrainingModule> trainingModules = moduleMapper.selectAllVisible();
        for (TrainingModule trainingModule : trainingModules) {
            if (trainingModule != null) {
                List<Training> trainings = trainingMapper.selectByModule(trainingModule.getId());
                ModuleTrainVO moduleTrainVO = new ModuleTrainVO(trainingModule.getId(), trainingModule.getName(), trainings);
                moduleTrainVOS.add(moduleTrainVO);
            }
        }
        return moduleTrainVOS;
    }

    @Override
    @DS
    public List<Training> selectAllTrainingByTeacher(String courseId, String creatorId) {
        TrainingModule trainingModule = moduleMapper.selectAllNotVisible();
        if (trainingModule != null) {
            List<Training> trainings = trainingMapper.selectByModuleAndCreator(trainingModule.getId(), creatorId);
            return trainings;
        }
        return null;
    }

    @Override
    @DS
    public List<TrainingType> selectTrainingType(String courseId) {
        List<TrainingType> trainingTypes = typeMapper.selectAllTypes();
        return trainingTypes;
    }

    @Override
    @DS
    public boolean updateTrainingModule(String courseId, String moduleId, String id) {
        int i = trainingMapper.updateTrainingModule(moduleId, id);
        if(i>0){
            return true;
        }
        return false;
    }

}
