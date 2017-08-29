package com.mapper;

import org.springframework.stereotype.Repository;

import com.entity.User;
@Repository
public interface UserMapper{
	public int selectAccount(String userName,String password);
	
	public int insertUser(String userName,String password);
}