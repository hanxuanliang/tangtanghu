package com.hxl.tangtang.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hxl.tangtang.mapper.UserMapper;
import com.hxl.tangtang.model.User;
import org.springframework.stereotype.Service;

/**
 * 用户 service
 *
 * @Author: hanxuanliang
 * @Date: 2020/3/22 17:20
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
