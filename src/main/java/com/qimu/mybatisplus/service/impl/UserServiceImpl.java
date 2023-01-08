package com.qimu.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qimu.mybatisplus.mapper.UserMapper;
import com.qimu.mybatisplus.pojo.User;
import com.qimu.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;
@DS("master")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
