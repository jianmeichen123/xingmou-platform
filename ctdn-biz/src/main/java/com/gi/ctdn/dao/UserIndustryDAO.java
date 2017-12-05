package com.gi.ctdn.dao;

import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.me.UserIndustry;

public interface UserIndustryDAO {
	
	
	UserIndustry getUserIndustry(@Param("userId") Integer userId);

	int updateUserIndustry(UserIndustry userIndustry);
}