package com.zz.constant;

import lombok.Data;

/**
 * Api接口返回枚举类
 */

public enum ApiConstants {
    HTTP_RES_CODE_200(200, "ok"),
    HTTP_RES_CODE_500(500, "系统发生错误，请稍后重试");
    private Integer code;
    private String value;

    ApiConstants(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}