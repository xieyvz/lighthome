package com.xieyv.lighthome.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;


public enum LeaseSourceType implements BaseEnum {

    NEW(1, "新签"),
    RENEW(2, "续约");

    @JsonValue
    @EnumValue
    private final Integer code;

    private final String msg;

    LeaseSourceType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
