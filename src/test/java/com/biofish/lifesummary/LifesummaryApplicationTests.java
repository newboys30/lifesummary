package com.biofish.lifesummary;

import com.biofish.lifesummary.pojo.T_User;
import com.biofish.lifesummary.pojo.base.PageModule;
import com.biofish.lifesummary.pojo.base.QueryModule;
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

    @Test
    void test(){
        PageModule pageModule = new PageModule();
        pageModule.setPageNum(1);
        pageModule.setPageSize(10);

        QueryModule queryModule = new QueryModule();
        queryModule.setClassname("t_user");
        Map params = new HashMap();
        params.put("username = ?", "bioFish");
        queryModule.setParams(params);

        pageModule.setQueryModule(queryModule);
        try {
            System.out.println(sqlHelper.getListSql(pageModule));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
