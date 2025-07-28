package com.xieyv.lighthome.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ReleaseStatus implements BaseEnum {

    RELEASED(1, "已发布"),
    NOT_RELEASED(0, "未发布");


    @EnumValue
    @JsonValue
    private final Integer code;

    private final String msg;


    ReleaseStatus(Integer code, String msg) {
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
