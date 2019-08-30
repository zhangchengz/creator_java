package com.tlf.creator.dao.user.clazz;

import com.tlf.creator.entity.user.clazz.Classes;
import com.tlf.creator.po.ClassCoursePO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassMapper {

    Classes selectClassById(String id);
    List<Classes> selectClasses(Integer offset, Integer limit);
    void insertClass(Classes classes);
    void deleteClass(String id);
    void updateClass(Classes classes);
    List<Classes> selectAllClassName();
    List<Classes> selectClassNameExcludeSelf(String id);
    Integer selectTotalClasses();
    List<ClassCoursePO> selectClassByCourse(String coursesId);
}
