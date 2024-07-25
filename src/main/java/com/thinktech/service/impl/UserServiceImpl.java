package com.thinktech.service.impl;

import com.thinktech.entity.User;
import com.thinktech.mapper.UserMapper;
import com.thinktech.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hls
 * @since 2024-07-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
