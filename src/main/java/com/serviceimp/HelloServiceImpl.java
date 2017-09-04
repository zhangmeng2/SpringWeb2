package com.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.ResultInfo;
import com.entity.User;
import com.mapper.UserMapper;
import com.service.HelloService;
@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    private UserMapper userMapper;
	public ResultInfo isExistAccount(User user) {
		ResultInfo resultInfo=new ResultInfo();
		List<User> accountCount=userMapper.selectAccount(user.getUserName());
		if(accountCount.size()>0){
			resultInfo.setResultCode(0);
			resultInfo.setMessage("this account has exist!");
		}else{
			userMapper.insertUser(user);
			resultInfo.setResultCode(1);
			resultInfo.setMessage("register successful!");
		}
		return resultInfo;
	}
	
	public User findUserByName(String userName){
		List<User> userList=userMapper.selectAccount(userName);
		return userList.get(0);
	}
}
