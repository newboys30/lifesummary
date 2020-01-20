package com.biofish.lifesummary;

import com.biofish.lifesummary.pojo.T_User;
import com.biofish.lifesummary.utils.SQLHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LifesummaryApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private SQLHelper sqlHelper;

    @Test
    void test(){
        System.out.println(sqlHelper.getSelectSqlById(new T_User()));
    }

}
