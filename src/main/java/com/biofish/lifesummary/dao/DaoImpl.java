package com.biofish.lifesummary.dao;

import com.biofish.lifesummary.utils.ParamsUtil;
import com.biofish.lifesummary.utils.SQLHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * 封装Dao操作
 */
@Repository
public class DaoImpl implements DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SQLHelper sqlHelper;

    @Autowired
    private ParamsUtil paramsUtil;

    @Override
    public boolean insert(Object object) throws Exception{
        String sql = sqlHelper.getInsertSql(object);

        Map params = paramsUtil.getNotNullFromPojo(object);
        Collection collection = params.values();
        Object[] objects = new Object[collection.size()];
        int index = 0;
        Iterator it = collection.iterator();
        while (it.hasNext()){
            objects[index] = it.next();
            index++;
        }

        int value = jdbcTemplate.update(sql, objects);

        return value == 1 ? true:false;
    }

    @Override
    public boolean update(Object object) {
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public <T> T getOneById(int id, Class clazz) {
        return null;
    }

    @Override
    public List getList() {
        return null;

    }
}
