package com.tlf.creatoraccount.service;

import com.tlf.creatoraccount.exception.OperatingException;
import com.tlf.creatoraccount.po.ClassCoursePO;
import com.tlf.creatoraccount.po.ClassesPO;
import com.tlf.creatoraccount.pojo.Classes;

import java.util.List;

public interface IClassService {
    List queryClassAccounts(String accountId)throws OperatingException;
    Classes queryClassById(String id)throws OperatingException;
    List<ClassesPO> queryClasses(Integer offset,Integer limit)throws OperatingException;
    boolean insertClass(Classes classes,List<String> students)throws OperatingException;
    void deleteClass(String id)throws OperatingException;
    boolean updateClass(Classes classes,List<String> add,List<String> delete)throws OperatingException;
    Integer queryTotalClasses();
    List<ClassCoursePO> selectClassByCourse(String coursesId);
}
