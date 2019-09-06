package com.tlf.creator.controller.curriculum.task;

import com.tlf.creator.aspect.AuthToken;
import com.tlf.creator.common.JsonResult;
import com.tlf.creator.entity.curriculum.task.Task;
import com.tlf.creator.req.TaskReq;
import com.tlf.creator.service.curriculum.task.TaskService;
import com.tlf.creator.service.user.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 任务管理controller
 *
 * @author zhangc
 * @date 2019/9/6
 */
@RestController
@RequestMapping
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private IAccountService accountService;

    @PostMapping(value = "add_task_experiment")
    @AuthToken(role_name = "teacher")
    public JsonResult addTaskExperiment(TaskReq req, HttpServletRequest request){
        return null;
    }
}
