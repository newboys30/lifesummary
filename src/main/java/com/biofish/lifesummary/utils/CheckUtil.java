package com.biofish.lifesummary.utils;

/**
 * @ClassName CheckUtil
 * @Description 校验工具
 * @Auther bioFish
 * @Date 2020/1/20 17:33
 * @Version v1.0
 **/
public class CheckUtil {
    /**
     * 空值校验
     * @param obj
     */
    public static boolean checkNullObject(Object obj){
        return null == obj || "".equals(obj);
    }

}
