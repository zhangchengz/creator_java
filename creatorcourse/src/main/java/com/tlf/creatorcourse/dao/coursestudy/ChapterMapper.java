package com.tlf.creatorcourse.dao.coursestudy;

import com.tlf.creatorcourse.po.ChapterPO;
import com.tlf.creatorcourse.entity.coursestudy.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChapterMapper {

    List<Chapter> selectAllChapters();
    List<ChapterPO> selectAllChapterAndUnits();
    void insertChapter(Chapter chapter);
    void updateChapterNameById(String name,String id);
    void deleteChapterById(String id);
    void addLevel(Integer level);
    void reduceLevel(Integer level);
    Chapter selectChapterByLevel(Integer level);
    Chapter selectChapterById(String id);
}
