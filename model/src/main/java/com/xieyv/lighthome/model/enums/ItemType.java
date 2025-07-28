package com.xieyv.lighthome.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;


public enum ItemType implements BaseEnum {

    COMMUNITY(1, "社区"),

    ROOM(2, "房间");


    @EnumValue
    @JsonValue
    private final Integer code;

    private final String msg;

    @Override
    public Integer getCode() {
        return this.code;
    }


    @Override
    public String getMsg() {
        return msg;
    }

    ItemType(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
