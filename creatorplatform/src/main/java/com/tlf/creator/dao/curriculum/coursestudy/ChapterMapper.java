package com.tlf.creator.dao.curriculum.coursestudy;

import com.tlf.creator.po.ChapterPO;
import com.tlf.creator.entity.curriculum.coursestudy.Chapter;
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
