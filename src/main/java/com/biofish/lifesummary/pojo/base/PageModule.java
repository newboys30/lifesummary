package com.biofish.lifesummary.pojo.base;

import lombok.Data;

import java.util.List;

/**
 * 分页函数
 */
@Data
public class PageModule {
    /**
     * 数据条数
     */
    private int pageSize;
    /**
     * 页码数
     */
    private int pageNum;
    /**
     * 返回值集合
     */
    private List pageData;
    /**
     * 查询条件
     */
    private QueryModule queryModule;
}
