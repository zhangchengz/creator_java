package com.cubespace.relaying;

import com.cubespace.relaying.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelayingApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {


    }

}
