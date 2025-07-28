package com.xieyv.lighthome.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum LeaseStatus implements BaseEnum {

    SIGNING(1, "签约待确认"),
    SIGNED(2, "已签约"),
    CANCELED(3, "已取消"),
    EXPIRED(4, "已到期"),
    WITHDRAWING(5, "退租待确认"),
    WITHDRAWN(6, "已退租"),
    RENEWING(7, "续约待确认");

    @EnumValue
    @JsonValue
    private final Integer code;

    private final String msg;

    LeaseStatus(Integer code, String msg) {
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
