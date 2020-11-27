package com.qf.travel.service.impl;

import com.qf.travel.entity.User;
import com.qf.travel.mapper.UserMapper;
import com.qf.travel.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    public int insert(User user){
        int insert = userMapper.insert(user);
        return insert;
    }
}
