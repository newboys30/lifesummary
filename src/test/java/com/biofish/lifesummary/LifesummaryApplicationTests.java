package com.biofish.lifesummary;

import com.biofish.lifesummary.pojo.T_User;
import com.biofish.lifesummary.utils.SQLHelper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LifesummaryApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
        System.out.println(SQLHelper.getUpdateSql(T_User.class));
    }

}
