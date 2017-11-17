package com.gi.ctdn.dao;

import java.util.List;

import com.gi.ctdn.pojo.OrgListInfo;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.OrgInfo;

public interface OrgInfoDAO {
	
			
	List<OrgInfo> selectByOrgId(@Param("orgCode") String orgCode);

	List<OrgInfo> selectAll();

	OrgListInfo selectById(@Param("orgCode") String orgCode);
}