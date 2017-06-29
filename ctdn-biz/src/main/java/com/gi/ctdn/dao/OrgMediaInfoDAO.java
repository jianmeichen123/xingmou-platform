package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.OrgMediaInfo;

public interface OrgMediaInfoDAO {
	
			
	List<OrgMediaInfo> selectByOrgId(@Param("orgId") Integer orgId);

	List<OrgMediaInfo> selectByOrgIdForHistroy(@Param("orgId") Integer orgId);

	List<OrgMediaInfo> selectAll();
}