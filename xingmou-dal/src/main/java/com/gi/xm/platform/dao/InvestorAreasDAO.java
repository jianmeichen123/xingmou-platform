package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestorAreas;
import com.gi.xm.platform.query.InvestorAreasQuery;

public interface InvestorAreasDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(InvestorAreas investorAreas);

    InvestorAreas selectByPrimaryKey(Long id);

	InvestorAreas selectByPrimaryKeyForUpdate(Long id);
	
    List<InvestorAreas> selectAll();

	List<InvestorAreas> queryInvestorAreas(InvestorAreasQuery investorAreasQuery);
			
    int updateByPrimaryKey(InvestorAreas investorAreas);
	
		

}