package com.gi.ctdn.dao.me;

import com.gi.ctdn.pojo.me.UserIndustry;
import org.apache.ibatis.annotations.Param;

public interface UserIndustryDAO {
	
	
	UserIndustry getUserIndustry(@Param("userId") Integer userId);

	int updateUserIndustry(UserIndustry userIndustry);

	void insert(UserIndustry userIndustry);
}