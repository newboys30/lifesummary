package com.biofish.lifesummary.utils;

import java.lang.reflect.Field;

/**
 * sql帮助类
 */
public class SQLHelper {
    /**
     * 自动封装InsertSql
     * @param clazz
     * @return
     */
    public static String getInsertSql(Class clazz){
        String tablename = clazz.getSimpleName();
        Field[] fields = clazz.getFields();
        StringBuffer sql = new StringBuffer("INSERT INTO ").append(tablename).append(" (");
        for (Field field : fields
             ) {
            sql.append(field.getName()).append(",");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(") VALUES (");
        for (int i = 0; i < fields.length; i++) {
            sql.append("?,");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        return sql.toString();
    }

    /**
     * 自动封装updateSql
     * @param clazz
     * @return
     */
    public static String getUpdateSql(Class clazz){
        return null;
    }

    /**
     * 自动封装查询单个Sql
     * @param clazz
     * @return
     */
    public static String getSelectSql(Class clazz){
        return null;
    }
}
