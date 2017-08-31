package com.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ResultInfo;
import com.mapper.UserMapper;
import com.service.HelloService;
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private UserMapper userMapper;
	public ResultInfo isExistAccount(String userName, String password) {
		ResultInfo resultInfo=new ResultInfo();
		int accountCount=userMapper.selectAccount(userName, password);
		if(accountCount>0){
			resultInfo.setResultCode(0);
			resultInfo.setMessage("this account has exist!");
		}else{
			userMapper.insertUser(userName, password);
			resultInfo.setResultCode(1);
			resultInfo.setMessage("register successful!");
		}
		return resultInfo;
	}
}
