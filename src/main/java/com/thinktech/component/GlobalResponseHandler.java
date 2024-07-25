package com.thinktech.component;

import com.thinktech.common.ResultCode;
import com.thinktech.common.ResultResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * @author hls
 * @project springboot-scaffold
 * @date 2024/7/25 14:15:46
 */
@ControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        if(returnType.getMethod() == null){
            return false;
        }
        if(returnType.getMethod().getAnnotation(ResponseBody.class)!=null){
            return true;
        }
        return returnType.getMethod().getReturnType() == ResultResponse.class;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        ResponseBody responseBody = Objects.requireNonNull(returnType.getMethod()).getAnnotation(ResponseBody.class);
        if(responseBody!=null || selectedContentType.equalsTypeAndSubtype(MediaType.APPLICATION_JSON)){
            if(body instanceof ResultResponse<?> result){
                if(!Objects.equals(result.getCode(), ResultCode.INTERNAL_SERVER_ERROR.getCode())){
                    response.setStatusCode(HttpStatus.valueOf(result.getCode()));
                }
            }else{
                return ResultResponse.success(body);
            }
            return ResultResponse.success(body);
        }
        return body;
    }
}
