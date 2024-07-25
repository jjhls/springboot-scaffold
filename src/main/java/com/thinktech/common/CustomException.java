package com.thinktech.common;

import lombok.Getter;

/**
 * @author hls
 * @project springboot-scaffold
 * @date 2024/7/25 14:04:07
 */
@Getter
public class CustomException extends RuntimeException{
    private Integer code;
    private String msg;

    public CustomException(){
        super();
    }
    public CustomException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public CustomException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }
}
