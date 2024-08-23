package com.thinktech.component;

import com.thinktech.common.CustomException;
import com.thinktech.common.ResultCode;
import com.thinktech.common.ResultResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author hls
 * @project springboot-scaffold
 * @date 2024/7/25 14:07:06
 */
@ControllerAdvice
@Slf4j
public class WebExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResultResponse<?> customExceptionHandler(CustomException e){
        return ResultResponse.error(e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultResponse<?> exceptionHandler(Exception e){
        ByteArrayOutputStream bass = new ByteArrayOutputStream();
        e.printStackTrace(new PrintStream(bass));
        String exception = bass.toString();
        log.error("错误:{}", exception);
        return ResultResponse.error(new CustomException(ResultCode.INTERNAL_SERVER_ERROR));
    }
}
