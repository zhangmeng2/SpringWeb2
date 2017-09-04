package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public interface UserMapper{
	public List<User> selectAccount(@Param("userName")String userName);
	
	public int insertUser(User user);
}