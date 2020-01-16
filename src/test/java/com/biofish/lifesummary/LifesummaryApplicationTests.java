package com.biofish.lifesummary;

import com.biofish.lifesummary.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LifesummaryApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserServiceImpl userService;

    @Test
    void testInsert(){
        userService.insertUser();
    }

}
