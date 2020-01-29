package com.biofish.lifesummary.utils;

import com.biofish.lifesummary.annotation.Increment;
import com.biofish.lifesummary.pojo.base.PageModule;
import com.biofish.lifesummary.pojo.base.QueryModule;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

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
     * @param pageModule
     * @return
     */
    public String getListSql(PageModule pageModule) throws Exception {
        int pageNum = pageModule.getPageNum() == 0? 1:pageModule.getPageNum();
        int pageSize = pageModule.getPageSize();
        QueryModule queryModule = pageModule.getQueryModule();
        if(CheckUtil.checkNullObject(queryModule)){
            throw new NullPointerException("查询参数为空");
        }

        String classname = queryModule.getClassname();
        Map param = queryModule.getParams();
        StringBuffer sql = new StringBuffer("SELECT * FROM ").append(classname);

        if(!param.isEmpty()){
            sql.append(" WHERE ");
            Iterator it = param.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry entry = (Map.Entry) it.next();
                if(!CheckUtil.checkNullObject(entry.getValue())){
                    sql.append(entry.getKey().toString()).append(" and ");
                }
            }
            sql.delete(sql.length() - 5, sql.length());
        }
        sql.append(" limit ").append((pageNum -1) * pageSize).append(",").append(pageNum * pageSize);
        return sql.toString();
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
