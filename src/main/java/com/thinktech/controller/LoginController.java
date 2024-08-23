package com.thinktech.controller;

import cn.hutool.core.util.RandomUtil;
import com.thinktech.common.CustomException;
import com.thinktech.component.RedisUtil;
import com.thinktech.utils.Md5Util;
import com.thinktech.utils.RandImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author hls
 * @project springboot-scaffold
 * @date 2024/8/13 15:37:53
 */

@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    private static final String SALT = "feswekjksj234kjkk";

    @Autowired
    private RedisUtil redisUtil;

    /**
     * @Auther: hls
     * @Description: 生成验证码
     */
    @GetMapping("/randomImage")
    public String randomImage() {
        String base64;
        try {
            //生成验证码
            String source = "qwertyuiopasdfghjklzxcvbnmQWERTYUPLKJHGFDSAZXCVBNM0123456789";
            String code = RandomUtil.randomString(source,4);
            //加密key
            String origin = code + SALT;
            origin = Md5Util.md5Encode(origin, "utf-8");
            //字符串存到redis中
            redisUtil.set(origin, code, 60);
            log.info("验证码：{}， key: {}", code, origin);
            //生成base64图片
            base64 = RandImageUtil.generate(code);
        } catch (IOException e) {
            throw new CustomException(500, "验证码生成错误!");
        }
        return base64;
    }

}
