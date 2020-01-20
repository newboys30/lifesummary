package com.biofish.lifesummary.dao;

import com.biofish.lifesummary.utils.SQLHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 封装Dao操作
 */
@Repository
public class DaoImpl implements DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SQLHelper sqlHelper;

    @Override
    public boolean insert(Object object) {
        String sql = sqlHelper.getInsertSql(object.getClass());
        Object[] params = new Object[]{};
        return false;
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
