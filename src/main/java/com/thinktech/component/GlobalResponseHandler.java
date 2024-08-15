package com.thinktech.component;

import com.alibaba.fastjson.JSON;
import com.thinktech.common.ResultResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author hls
 * @project springboot-scaffold
 * @date 2024/7/25 14:15:46
 */
@ControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ResultResponse<?>) {
            return body;
        }
        // 如果是空，则返回成功
        else if (body == null) {
            return ResultResponse.success();
        }
        // 如果是异常类型就直接返回
        else if (body instanceof Exception) {
            return body;
        }
        // 如果是String类型则直接返回String类型
        else if (body instanceof String) {
            //转json
            return JSON.toJSONString(ResultResponse.success(body));
        }
        // 返回封装后的数据
        else {
            return ResultResponse.success(body);
        }
    }
}
