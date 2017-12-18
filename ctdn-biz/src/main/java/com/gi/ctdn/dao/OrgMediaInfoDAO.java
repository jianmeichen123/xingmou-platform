package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.OrgMediaInfo;

public interface OrgMediaInfoDAO {
	
			
	List<OrgMediaInfo> selectByOrgId(@Param("orgCode") String orgCode);

	List<OrgMediaInfo> selectByOrgIdForHistroy(@Param("orgCode") String orgCode);

	List<OrgMediaInfo> selectAll();

	List<OrgMediaInfo> selectMediaInfoByOrgCode(@Param("orgCode") String orgCode);
}