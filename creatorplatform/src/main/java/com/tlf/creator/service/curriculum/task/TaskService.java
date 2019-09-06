package com.tlf.creator.service.curriculum.task;

import com.tlf.creator.entity.curriculum.task.AccountTask;
import com.tlf.creator.entity.curriculum.task.Task;
import com.tlf.creator.req.TrainingReq;
import com.tlf.creator.vo.TaskStudentVO;
import com.tlf.creator.vo.TaskVO;

import java.util.List;

public interface TaskService {

    boolean addTask(String courseId, Task task, List<AccountTask> accountTasks);

    List<TaskVO> selectTaskByTeacher(String courseId,String teacherId);

    List<TaskStudentVO> selectTaskInnerByAccount(String courseId, String accountId, TrainingReq req);
}
