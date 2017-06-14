package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

import com.gi.ctdn.pojo.OrgListInfo;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.OrgInfo;

public interface OrgInfoDAO {
	
			
	List<OrgInfo> selectByOrgId(@Param("orgId") Integer orgId);

	List<OrgInfo> selectAll();

	OrgListInfo selectById(@Param("orgId") Integer orgId);
}