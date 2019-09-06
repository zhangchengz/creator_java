package com.tlf.creator.vo;

import java.io.Serializable;

/**
 * 学生课程实训列表数据实体类
 *
 * @author zhangc
 * @date 2019/9/6
 */
public class TaskStudentVO extends AccountTaskVO implements Serializable  {

   private String masterName;

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }
}
