package com.service;

import org.springframework.stereotype.Service;

import com.entity.ResultInfo;
import com.entity.User;


public interface HelloService {
    public ResultInfo isExistAccount(User user);
    
    //通过用户名查找用户
    public User findUserByName(String userName);
}
