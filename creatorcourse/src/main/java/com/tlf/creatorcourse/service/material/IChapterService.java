package com.tlf.creatorcourse.service.material;

import com.tlf.creatorcourse.exception.OperatingException;
import com.tlf.creatorcourse.po.ChapterPO;
import com.tlf.creatorcourse.entity.coursestudy.Chapter;

import java.util.List;

public interface IChapterService {

    List<ChapterPO> selectChapterAndUnit()throws OperatingException;
    List<Chapter> selectChapters()throws OperatingException;
    void insertChapter(Chapter chapter)throws OperatingException;
    void updateChapterNameById(String name,String id)throws OperatingException;
    void deleteChapterById(String id)throws OperatingException;
}
