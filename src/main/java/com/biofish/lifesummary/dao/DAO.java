package com.biofish.lifesummary.dao;

import java.util.List;

/**
 * DAO接口
 */
public interface DAO {
    boolean insert(Object object) throws Exception;
    boolean update(Object object);
    boolean deleteById(int id);
    <T> T getOneById(int id, Class clazz);
    List getList();
}
