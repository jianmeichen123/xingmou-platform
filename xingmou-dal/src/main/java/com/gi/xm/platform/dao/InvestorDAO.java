package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.Investor;
import com.gi.xm.platform.query.InvestorQuery;

public interface InvestorDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(Investor investor);

    Investor selectByPrimaryKey(Long id);

	Investor selectByPrimaryKeyForUpdate(Long id);
	
    List<Investor> selectAll();

	List<Investor> queryInvestor(InvestorQuery investorQuery);
			
    int updateByPrimaryKey(Investor investor);
	
		

}