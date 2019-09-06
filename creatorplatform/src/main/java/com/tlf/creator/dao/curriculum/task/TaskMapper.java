package com.tlf.creator.dao.curriculum.task;

import com.tlf.creator.entity.curriculum.task.Task;
import com.tlf.creator.vo.TaskVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapper类
 *
 * @author zhangc
 * @date 2019/9/6
 */
@Mapper
@Repository
public interface TaskMapper {

    int deleteByPrimaryKey(String id);

    int insert(Task record);

    Task selectByPrimaryKey(String id);

    List<TaskVO> selectTaskByTeacher(String masterId);

    int updateByPrimaryKey(Task record);
}