package com.thinktech.common;

import lombok.Data;

/**
 * @author hls
 * @project springboot-scaffold
 * @date 2024/7/25 13:58:21
 */
@Data
public class ResultResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    public static ResultResponse<?> error(CustomException e) {
        ResultResponse<?> resultResponse = new ResultResponse<>();
        resultResponse.setCode(e.getCode());
        resultResponse.setMsg(e.getMsg());
        return resultResponse;
    }

    public static ResultResponse<?> success() {
        ResultResponse<?> resultResponse = new ResultResponse<>();
        resultResponse.setCode(ResultCode.SUCCESS.getCode());
        resultResponse.setMsg(ResultCode.SUCCESS.getMsg());
        return resultResponse;
    }

    public static <T> ResultResponse<T> success(T data) {
        ResultResponse<T> resultResponse = new ResultResponse<>();
        resultResponse.setCode(ResultCode.SUCCESS.getCode());
        resultResponse.setMsg(ResultCode.SUCCESS.getMsg());
        resultResponse.setData(data);
        return resultResponse;
    }
}
