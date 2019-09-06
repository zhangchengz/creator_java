package com.tlf.creator.service.curriculum.task.impl;

import com.tlf.creator.aspect.DS;
import com.tlf.creator.dao.curriculum.task.AccountTaskMapper;
import com.tlf.creator.dao.curriculum.task.TaskMapper;
import com.tlf.creator.dao.curriculum.training.TrainingMapper;
import com.tlf.creator.entity.curriculum.task.AccountTask;
import com.tlf.creator.entity.curriculum.task.Task;
import com.tlf.creator.entity.curriculum.training.Training;
import com.tlf.creator.req.TrainingReq;
import com.tlf.creator.service.curriculum.task.TaskService;
import com.tlf.creator.vo.AccountTaskVO;
import com.tlf.creator.vo.TaskStudentVO;
import com.tlf.creator.vo.TaskVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现类
 *
 * @author zhangc
 * @date 2019/9/6
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Autowired
    private AccountTaskMapper accountTaskMapper;

    @Autowired
    private TrainingMapper trainingMapper;

    @Override
    @DS
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public boolean addTask(String courseId, Task task, List<AccountTask> accountTasks) {
        int insert = taskMapper.insert(task);
        int bulkInsert = accountTaskMapper.bulkInsert(accountTasks);
        if (insert > 0 && bulkInsert > 0) {
            return true;
        }
        return false;
    }

    @Override
    @DS
    public List<TaskVO> selectTaskByTeacher(String courseId, String teacherId) {
        List<TaskVO> taskVOS = taskMapper.selectTaskByTeacher(teacherId);
        return taskVOS;
    }

    @Override
    @DS
    public List<TaskStudentVO> selectTaskInnerByAccount(String courseId, String accountId, TrainingReq req) {
        List<TaskStudentVO> list = new ArrayList<>();
        List<Training> trainings = trainingMapper.selectTrainingInner(req);
        List<AccountTaskVO> accountTaskVOS = accountTaskMapper.selectByAccount(accountId);
        for (Training training : trainings) {
            if (training != null) {
                TaskStudentVO taskStudentVO = new TaskStudentVO();
                taskStudentVO.setTrainingId(training.getId());
                taskStudentVO.setTeaching(true);
                taskStudentVO.setPractice(true);
                taskStudentVO.setName(training.getName());
                for (AccountTaskVO accountTaskVO : accountTaskVOS) {
                    if(accountTaskVO!=null){
                        if(training.getId().equals(accountTaskVO.getTrainingId())){
                            taskStudentVO.setTeaching(true);
                            taskStudentVO.setMasterId(accountTaskVO.getMasterId());
                            taskStudentVO.setCompleted(accountTaskVO.getCompleted());
                            taskStudentVO.setFinishTime(accountTaskVO.getFinishTime());
                            taskStudentVO.setStartTime(accountTaskVO.getStartTime());
                            taskStudentVO.setStatu(accountTaskVO.getStatu());
                        }
                    }
                }
                list.add(taskStudentVO);
            }
        }
        return list;
    }

}
