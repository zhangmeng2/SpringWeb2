package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.ResultInfo;
import com.entity.User;
import com.service.HelloService;

@Controller
@RequestMapping("/spittles")
public class TestController {
	@Autowired
	private HelloService helloService;
	@RequestMapping(method=RequestMethod.GET)
    public String index() {
    	System.out.println("hello world!");
    	return "welcome";
    }
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String Register(User user){
		ResultInfo registerInfo=helloService.isExistAccount(user);
		if(registerInfo.getResultCode()==1){
			//注册成功
			return "redirect:personinfo/"+user.getUserName();
		}else{
			//注册失败
			return "register";
		}
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegister(){
		return "register";		
	}
	@RequestMapping("/personinfo/{userName}")
	public String showPersonInfo(@PathVariable String userName,Model model){
	    model.addAttribute("userInfo",helloService.findUserByName(userName)); 
		return "personInfo";
	}
}