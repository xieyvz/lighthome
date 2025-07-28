package com.xieyv.lighthome.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SystemUserType implements BaseEnum {

    ADMIN(0, "管理员"),
    COMMON(1, "普通用户");

    @EnumValue
    @JsonValue
    private final Integer code;

    private final String msg;


    SystemUserType(Integer code, String msg) {
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
