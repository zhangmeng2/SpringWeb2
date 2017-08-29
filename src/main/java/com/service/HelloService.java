package com.service;

import org.springframework.stereotype.Service;

import com.entity.ResultInfo;


public interface HelloService {
    public ResultInfo isExistAccount(String userName,String password);
}
