package com.biofish.lifesummary.utils;

import com.biofish.lifesummary.pojo.annotation.Increment;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * 生成sql帮助类
 */
@Component
public class SQLHelper {

    /**
     * 自动封装InsertSql
     * @param obj
     * @return
     */
    public String getInsertSql(Object obj){
        if(CheckUtil.checkNullObject(obj)){
            throw new NullPointerException("传入对象不得为空");
        }

        Class clazz = obj.getClass();
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
     * @param obj
     * @return
     */
    public String getUpdateSql(Object obj) {
        if(CheckUtil.checkNullObject(obj)){
            throw new NullPointerException("传入对象不得为空");
        }

        Class clazz = obj.getClass();
        String primaryKey = getPrimaryKey(clazz);

        if(!StringUtils.isNotBlank(primaryKey)){
            throw new RuntimeException("pojo无主键无法生成Update语句");
        }

        String tablename = clazz.getSimpleName();
        Field[] fields = clazz.getDeclaredFields();

        StringBuffer sql = new StringBuffer("UPDATE ").append(tablename).append(" SET ");
        for(Field field : fields){
            if(!primaryKey.equals(field.getName())){
                sql.append(field.getName()).append("=").append("?,");
            }
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" WHERE ").append(primaryKey).append("=?");

        return sql.toString();
    }

    /**
     * 自动封装查询单个Sql
     * @param obj
     * @return
     */
    public String getSelectSqlById(Object obj){
        if(CheckUtil.checkNullObject(obj)){
            throw new NullPointerException("传入对象不得为空");
        }

        Class clazz = obj.getClass();
        String primaryKey = getPrimaryKey(clazz);
        if(!StringUtils.isNotBlank(primaryKey)){
            throw new RuntimeException("pojo无主键无法生成SelectById语句");
        }

        String tablename = clazz.getSimpleName();
        Field[] fields = clazz.getDeclaredFields();

        StringBuffer sql = new StringBuffer("SELECT ");
        for(Field field : fields){
            sql.append(field.getName()).append(",");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(" FROM ").append(tablename).append(" WHERE ").append(primaryKey).append("=?");

        return sql.toString();
    }

    /**
     * 列表查询SQL
     * @param obj
     * @return
     */
    public String getListSql(Object obj){
        Class clazz = obj.getClass();
        String tablename = clazz.getSimpleName();


        return tablename;
    }

    /**
     * 查询主键字段
     * @return 返回值为FieldName
     */
    private String getPrimaryKey(Class clazz) {

        if(CheckUtil.checkNullObject(clazz)){
            throw new NullPointerException("传入对象不得为空");
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



}
