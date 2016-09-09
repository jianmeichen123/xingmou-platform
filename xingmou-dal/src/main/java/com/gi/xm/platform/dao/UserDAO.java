package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.User;
import com.gi.xm.platform.query.UserQuery;

public interface UserDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(User user);

    User selectByPrimaryKey(Long id);

	User selectByPrimaryKeyForUpdate(Long id);
	
    List<User> selectAll();

	List<User> queryUser(UserQuery userQuery);
			
    int updateByPrimaryKey(User user);
	
			
	int changeStatus(
			@Param("id") Long id,
			@Param("status") String status,
			@Param("updateUserid") String updateUserid);
		

}