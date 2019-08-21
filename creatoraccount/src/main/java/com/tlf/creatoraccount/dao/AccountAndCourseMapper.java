package com.tlf.creatoraccount.dao;

import com.tlf.creatoraccount.pojo.AccountAndCourses;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AccountAndCourseMapper {

    List<AccountAndCourses> queryAccountAndCourseByAccountId(String accountId);
}
