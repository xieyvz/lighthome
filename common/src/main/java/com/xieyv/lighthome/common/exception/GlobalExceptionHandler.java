package com.xieyv.lighthome.common.exception;

import com.xieyv.lighthome.common.result.Result;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  @author xieyv
 *  全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LogManager.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Void> handleException(Exception exception) {
        log.info(exception.getMessage());
        return Result.fail();
    }


    @ExceptionHandler(LhException.class)
    @ResponseBody
    public Result<?> handleException(LhException lhexception) {
        log.info(lhexception.getMessage());
        Integer code = lhexception.getCode();
        String message = lhexception.getMessage();
        return Result.fail(code, message);
    }
}
