package com.biofish.lifesummary.dao;

import java.util.List;

/**
 * DAO接口
 */
public interface BaseDAO {
    boolean insert(Object object);
    boolean update(Object object);
    boolean deleteById(int id);
    Class getOneById(int id, Class clazz);
    List getList();
}
