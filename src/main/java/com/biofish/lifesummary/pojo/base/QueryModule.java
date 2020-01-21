package com.biofish.lifesummary.pojo.base;

import lombok.Data;

import java.util.Map;

/**
 * 查询条件
 */
@Data
public class QueryModule {
    private String classname;
    private Map params;
}
