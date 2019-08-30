package com.tlf.creator;

import com.tlf.creator.dao.curriculum.coursestudy.MaterialMapper;
import com.tlf.creator.dao.curriculum.coursestudy.UnitMapper;
import com.tlf.creator.dao.curriculum.simulation.SceneTypeMapper;
import com.tlf.creator.dao.curriculum.training.TrainingMapper;
import com.tlf.creator.entity.curriculum.coursestudy.Chapter;
import com.tlf.creator.entity.curriculum.coursestudy.Material;
import com.tlf.creator.entity.curriculum.coursestudy.Unit;
import com.tlf.creator.entity.curriculum.simulation.SceneType;
import com.tlf.creator.entity.curriculum.training.Training;
import com.tlf.creator.req.TrainingReq;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatorcourseApplicationTests {

    @Autowired
    private SceneTypeMapper sceneTypeMapper;

    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private UnitMapper unitMapper;

    @Autowired
    private TrainingMapper trainingMapper;

    @Test
    public void contextLoads() {

    }

    @Test
    public void testCase1(){
        TrainingReq req = new TrainingReq();
        req.setInnerr(true);
        req.setTrainingModuleId(null);
        req.setTrainingTypeId(null);
        req.setTrainingSearch(null);
        req.setOffset(0);
        req.setLimit(10);
        List<Training> trainings = trainingMapper.selectTrainingInner(req);
        int countInner = trainingMapper.selectCountInner(req);
        System.out.println(countInner);
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
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<>();
        list2.add("C");
        list2.add("A");
        list2.add("B");
        // 并集
      //  list1.addAll(list2);
        // 去重复并集
        boolean b = list1.removeAll(list2);
        for(String a:list1){
            System.out.println("------------------------------------"+a);
        }
        System.out.println(b);

    }


}
