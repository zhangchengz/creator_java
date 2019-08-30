package com.tlf.creator.service.curriculum.material;

import com.tlf.creator.exception.OperatingException;
import com.tlf.creator.po.ChapterPO;
import com.tlf.creator.entity.curriculum.coursestudy.Chapter;

import java.util.List;

public interface IChapterService {

    List<ChapterPO> selectChapterAndUnit()throws OperatingException;
    List<Chapter> selectChapters()throws OperatingException;
    void insertChapter(Chapter chapter)throws OperatingException;
    void updateChapterNameById(String name,String id)throws OperatingException;
    void deleteChapterById(String id)throws OperatingException;
}
