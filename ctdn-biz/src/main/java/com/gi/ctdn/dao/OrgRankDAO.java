package com.gi.ctdn.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.pojo.OrgRank;

public interface OrgRankDAO {
	
	
	List<OrgRank> selectAll();

	List<OrgRank> selectBytimes();


	List<OrgRank> selectByAllTimes();
}