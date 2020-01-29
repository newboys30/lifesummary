package com.biofish.lifesummary.utils;

import com.biofish.lifesummary.annotation.Increment;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 将对象的值转换为Object数组
 */
@Component
public class ParamsUtil {
    /**
     * 从实体类中获取全部参数Map
     * @return
     */
    public Map<String,Object> getAllFromPojo(Object object) throws Exception{
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Object> params = new LinkedHashMap<>();
        for (Field field : fields) {
            field.setAccessible(true);
            Object obj = field.get(object);
            params.put(field.getName(),obj);
        }
        return params;
    }

    /**
     * 从实体类中获取非空参数Map
     * @return
     */
    public Map<String,Object> getNotNullFromPojo(Object object) throws Exception{
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Object> params = new LinkedHashMap<>();
        for (Field field : fields) {
            if(field.isAnnotationPresent(Increment.class)){
                Increment increment = field.getAnnotation(Increment.class);
                if(!increment.isInrement()){
                    field.setAccessible(true);
                    Object obj = field.get(object);
                    if(!CheckUtil.checkNullObject(obj)){
                        params.put(field.getName(),obj);
                    }
                }
            }else{
                field.setAccessible(true);
                Object obj = field.get(object);
                if(!CheckUtil.checkNullObject(obj)){
                    params.put(field.getName(),obj);
                }
            }
        }
        return params;
    }
}
