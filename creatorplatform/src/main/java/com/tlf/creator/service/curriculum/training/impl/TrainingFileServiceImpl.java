package com.tlf.creator.service.curriculum.training.impl;

import com.tlf.creator.aspect.DS;
import com.tlf.creator.config.UploadPathBean;
import com.tlf.creator.dao.curriculum.training.TrainingFileMapper;
import com.tlf.creator.dao.curriculum.training.TrainingMapper;
import com.tlf.creator.entity.curriculum.training.Training;
import com.tlf.creator.entity.curriculum.training.TrainingFile;
import com.tlf.creator.service.curriculum.training.TrainingFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingFileServiceImpl implements TrainingFileService {

    @Autowired
    private TrainingFileMapper trainingFileMapper;

    @Autowired
    private UploadPathBean uploadPathBean;

    @Autowired
    private TrainingMapper trainingMapper;

    @Override
    @DS
    public boolean deleteByPrimaryKey(String courseId, String id) {
        TrainingFile trainingFile = trainingFileMapper.selectByPrimaryKey(id);
        if (trainingFile != null) {
            if (trainingFile.getQuote() == 0) {
                String path = uploadPathBean.getUploadPath() + trainingFile.getPath();
                File file = new File(path);
                if (file.exists()) {
                    file.delete();
                }
            }
        }
        int delete = trainingFileMapper.deleteByPrimaryKey(id);
        if (delete > 0) {
            return true;
        }
        return false;
    }

    @Override
    @DS
    public boolean insert(String courseId, TrainingFile record) {
        int insert = trainingFileMapper.insert(record);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    @DS
    public TrainingFile selectByPrimaryKey(String courseId, String id) {
        TrainingFile trainingFile = trainingFileMapper.selectByPrimaryKey(id);
        if (trainingFile != null) {
            trainingFile.setPath(uploadPathBean.getDownloadPath() + trainingFile.getPath());
        }
        return trainingFile;
    }

    @Override
    @DS
    public List<TrainingFile> selectByTrainingId(String courseId, String trainingId) {
        List<TrainingFile> trainingFiles = trainingFileMapper.selectByTrainingId(trainingId);
        for (TrainingFile file : trainingFiles) {
            if (file != null) {
                file.setPath(uploadPathBean.getDownloadPath() + file.getPath());
            }
        }
        return trainingFiles;
    }

    @Override
    @DS
    public List<TrainingFile> selectByModuleId(String courseId, String moduleId) {
        List<TrainingFile> list = new ArrayList<>();
        List<Training> trainings = trainingMapper.selectByModule(moduleId);
        for (Training training : trainings) {
            if (training != null) {
                List<TrainingFile> list1 = trainingFileMapper.selectByTrainingId(training.getId());
                for (TrainingFile file : list) {
                    if (file != null) {
                        file.setPath(uploadPathBean.getDownloadPath() + file.getPath());
                    }
                }
                list.addAll(list1);
            }
        }
        return list;
    }

    @Override
    @DS
    public List<TrainingFile> selectByTrainingInner(String courseId) {
        List<TrainingFile> list = trainingFileMapper.selectFileByTrainingInner();
        for (TrainingFile file : list) {
            if (file != null) {
                file.setPath(uploadPathBean.getDownloadPath() + file.getPath());
            }
        }
        return list;
    }

    @Override
    @DS
    public List<TrainingFile> selectByTrainingSelf(String courseId, String creatorId) {
        List<TrainingFile> list = trainingFileMapper.selectFileByTrainingSelf(creatorId);
        for (TrainingFile file : list) {
            if (file != null) {
                file.setPath(uploadPathBean.getDownloadPath() + file.getPath());
            }
        }
        return list;
    }

    @Override
    @DS
    public boolean updateByPrimaryKey(String courseId, TrainingFile record) {
        int update = trainingFileMapper.updateByPrimaryKey(record);
        if (update > 0) {
            return true;
        }
        return false;
    }
}
