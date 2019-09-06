package com.tlf.creator.dao.curriculum.task;

import com.tlf.creator.entity.curriculum.task.AccountTask;
import com.tlf.creator.vo.AccountTaskVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountTaskMapper {

    int deleteByPrimaryKey(String id);

    int insert(AccountTask record);

    int bulkInsert(List<AccountTask> list);

    AccountTask selectByPrimaryKey(String id);

    List<AccountTaskVO> selectByAccount(String accountId);

    int updateByPrimaryKey(AccountTask record);
}