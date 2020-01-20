package com.biofish.lifesummary.utils;

import com.biofish.lifesummary.pojo.annotation.Increment;

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
        checkNullObject(clazz);

        String tablename = clazz.getSimpleName();
        Field[] fields = clazz.getDeclaredFields();
        StringBuffer sql = new StringBuffer("INSERT INTO ").append(tablename).append(" (");

        //记录字段数量索引
        int index = 0;

        for (Field field : fields
             ) {
            if(field.isAnnotationPresent(Increment.class)){
                Increment increment = field.getAnnotation(Increment.class);
                if(!increment.isInrement()){
                    sql.append(field.getName()).append(",");
                    index++;
                }
            }else{
                sql.append(field.getName()).append(",");
                index++;
            }
        }

        sql.deleteCharAt(sql.length() - 1);
        sql.append(") VALUES (");
        for (int i = 0; i < index; i++) {
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
    public static String getUpdateSql(Class clazz) {
        checkNullObject(clazz);

        String tablename = clazz.getSimpleName();
        Field[] fields = clazz.getDeclaredFields();

        String primaryKey = getPrimaryKey(clazz);
        StringBuffer sql = new StringBuffer("UPDATE ").append(tablename).append(" set ");
        for(Field field : fields){
            if(!primaryKey.equals(field.getName())){
                sql.append(field.getName()).append("=").append("?,");
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" where ").append(primaryKey).append("=?");

        return sql.toString();
    }

    /**
     * 自动封装查询单个Sql
     * @param clazz
     * @return
     */
    public static String getSelectSqlById(Class clazz){
        checkNullObject(clazz);

        String tablename = clazz.getSimpleName();
        Field[] fields = clazz.getDeclaredFields();



        return null;
    }

    /**
     * 查询主键字段
     * @return 返回值为FieldName
     */
    private static String getPrimaryKey(Class clazz) {

        if(null == clazz){
            throw new NullPointerException("不可传入空对象！");
        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields
             ) {
            if(field.isAnnotationPresent(Increment.class)){
                return field.getName();
            }
        }
        return null;
    }

    private static void checkNullObject(Class clazz){
        if(null == clazz){
            throw new NullPointerException("不可传入空对象！");
        }
    }
}
