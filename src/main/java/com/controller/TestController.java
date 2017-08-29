package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.HelloService;

@Controller
@RequestMapping("/spittles")
public class TestController {
	@Autowired
	private HelloService helloService;
	@RequestMapping("/index")
    public String index() {
    	System.out.println("hello world!");
    	return "welcome";
    }
	
	@RequestMapping("/register")
	public String register(String userName,String password){
		boolean registerInfo=helloService.isExistAccount(userName, password);
		if(registerInfo){
			//注册成功
		}else{
			//注册失败
		}
		return "register";
	}
}