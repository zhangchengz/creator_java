package com.tlf.creatorcourse;

import com.tlf.creatorcourse.dao.coursestudy.ChapterMapper;
import com.tlf.creatorcourse.dao.coursestudy.MaterialMapper;
import com.tlf.creatorcourse.dao.simulationresource.SceneTypeMapper;
import com.tlf.creatorcourse.dao.simulationresource.SimulationResourceMapper;
import com.tlf.creatorcourse.dao.coursestudy.UnitMapper;
import com.tlf.creatorcourse.dao.taskexperiment.TaskExperimentsMapper;
import com.tlf.creatorcourse.entity.coursestudy.Chapter;
import com.tlf.creatorcourse.entity.coursestudy.Material;
import com.tlf.creatorcourse.entity.coursestudy.Unit;
import com.tlf.creatorcourse.entity.simulation.SceneType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatorcourseApplicationTests {

    @Autowired
    private SceneTypeMapper sceneTypeMapper;


    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private UnitMapper unitMapper;

    @Autowired
    private TaskExperimentsMapper experimentsMapper;

    @Autowired
    private TaskExperimentsMapper taskMapper;
    @Test
    public void contextLoads() {

    }

    @Test
    public void testCase1(){
        Chapter chapter = new Chapter();
        String id = UUID.randomUUID().toString();
        chapter.setId(id);
        chapter.setName("第二章 chapterIII");
        List<Material> materials = materialMapper.selectAllMaterials(0, 100);
        System.out.println(materials);
    }

    @Test
    public void testCase2(){
        Unit unit = new Unit();
        String id = UUID.randomUUID().toString();
        unit.setId(id);
        unit.setName("第一节 unit①");
        unit.setChapterId("d933914d-8c02-4ac8-a33f-3c7aa4258660");
        unitMapper.insertUnit(unit);
    }

    @Test
    public void testCase3(){
        List<SceneType> sceneTypes = sceneTypeMapper.selectListByAlias("2d");
        System.out.println(sceneTypes);
    }

    @Test
    public void testCase4() {

    }


}
