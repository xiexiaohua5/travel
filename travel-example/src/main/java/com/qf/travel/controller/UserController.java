package com.qf.travel.controller;

import com.qf.travel.entity.User;
import com.qf.travel.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/travel")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/add")
    public int add(User user){
        int insert = userService.insert(user);
        return insert;
    }
}
