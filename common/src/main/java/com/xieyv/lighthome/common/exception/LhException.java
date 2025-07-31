package com.xieyv.lighthome.common.exception;

import com.xieyv.lighthome.common.result.ResultCodeEnum;

public class LhException extends RuntimeException {

    private Integer code;

    public LhException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public LhException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
