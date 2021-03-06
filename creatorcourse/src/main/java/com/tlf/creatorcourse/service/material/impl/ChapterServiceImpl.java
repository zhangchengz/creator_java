package com.tlf.creatorcourse.service.material.impl;

import com.tlf.creatorcourse.dao.coursestudy.ChapterMapper;
import com.tlf.creatorcourse.dao.coursestudy.UnitMapper;
import com.tlf.creatorcourse.exception.OperatingException;
import com.tlf.creatorcourse.po.ChapterPO;
import com.tlf.creatorcourse.entity.coursestudy.Chapter;
import com.tlf.creatorcourse.entity.coursestudy.Unit;
import com.tlf.creatorcourse.service.material.IChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterServiceImpl implements IChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private UnitMapper unitMapper;

    @Override
    public List<ChapterPO> selectChapterAndUnit() {
        List<Chapter> chapters = chapterMapper.selectAllChapters();
        List<ChapterPO> chapterPOS = new ArrayList<>();
        for(Chapter chapter:chapters){
            List<Unit> list = unitMapper.selectUnitByChapterId(chapter.getId());
            ChapterPO chapterPO = new ChapterPO();
            chapterPO.setId(chapter.getId());
            chapterPO.setName(chapter.getName());
            chapterPO.setLevel(chapter.getLevel());
            chapterPO.setUnits(list);
            chapterPOS.add(chapterPO);
        }
        return chapterPOS;
    }

    @Override
    public List<Chapter> selectChapters() throws OperatingException {
        List<Chapter> chapters = chapterMapper.selectAllChapters();
        return chapters;
    }

    @Override
    public void insertChapter(Chapter chapter) {
        Integer level = chapter.getLevel();
        Chapter chapter1 = chapterMapper.selectChapterByLevel(level);
        if(chapter1!=null){
            chapterMapper.addLevel(level);
        }
        chapterMapper.insertChapter(chapter);
    }

    @Override
    public void updateChapterNameById(String name, String id) {
        chapterMapper.updateChapterNameById(name, id);
    }

    @Transactional
    @Override
    public void deleteChapterById(String id) {
        Chapter chapter = chapterMapper.selectChapterById(id);
        if(chapter!=null){
            Integer level = chapter.getLevel();
            chapterMapper.reduceLevel(level);
            chapterMapper.deleteChapterById(id);
        }
    }
}
