package com.thinktech.component;

import com.thinktech.common.CustomException;
import com.thinktech.common.ResultCode;
import com.thinktech.common.ResultResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hls
 * @project springboot-scaffold
 * @date 2024/7/25 14:07:06
 */
@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResultResponse<?> customExceptionHandler(CustomException e){
        return ResultResponse.error(e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultResponse<?> exceptionHandler(Exception e){
        return ResultResponse.error(new CustomException(ResultCode.INTERNAL_SERVER_ERROR));
    }
}
