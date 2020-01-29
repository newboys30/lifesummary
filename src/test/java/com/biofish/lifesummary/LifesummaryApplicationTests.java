package com.biofish.lifesummary;

import com.biofish.lifesummary.pojo.base.PageModule;
import com.biofish.lifesummary.pojo.base.QueryModule;
import com.biofish.lifesummary.pojo.t_user;
import com.biofish.lifesummary.utils.ParamsUtil;
import com.biofish.lifesummary.utils.SQLHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class LifesummaryApplicationTests {

    @Autowired
    private SQLHelper sqlHelper;
    @Autowired
    private ParamsUtil paramsUtil;

    @Test
    void test(){
        t_user t_user = new t_user();
        t_user.setUsername("abc");
        t_user.setNickname("ffdd");
        try {
            paramsUtil.getAllFromPojo(t_user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
