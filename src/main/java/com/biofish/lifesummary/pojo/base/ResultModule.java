package com.biofish.lifesummary.pojo.base;

import lombok.Data;

/**
 * 返回值对象
 */
@Data
public class ResultModule {
    /**
     * 返回代码
     */
    private String code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public ResultModule() {}

    public ResultModule(String code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
