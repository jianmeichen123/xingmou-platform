package com.gi.ctdn.dao.me;

import com.gi.ctdn.pojo.me.UserIndustry;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserIndustryDAO {

	int deleteByUserCode (@Param("userCode") String userCode);
	
	List<UserIndustry>  getUserIndustry(@Param("userCode") String userCode);

	int insert(@Param("focusList") List<UserIndustry> focusList);

	String selectDefaultIds (@Param("departmentId")Long departmentId );
}