package com.tlf.creator.service.user.clazz;

import com.tlf.creator.entity.user.clazz.Classes;
import com.tlf.creator.po.ClassCoursePO;
import com.tlf.creator.po.ClassesPO;

import java.util.List;

public interface IClassService {
    List queryClassAccounts(String accountId);

    Classes queryClassById(String id);

    List<ClassesPO> queryClasses(Integer offset, Integer limit);

    boolean insertClass(Classes classes, List<String> students);

    void deleteClass(String id);

    boolean updateClass(Classes classes, List<String> add, List<String> delete);

    Integer queryTotalClasses();

    List<ClassCoursePO> selectClassByCourse(String coursesId);
}
