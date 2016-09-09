package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestorRounds;
import com.gi.xm.platform.query.InvestorRoundsQuery;

public interface InvestorRoundsDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(InvestorRounds investorRounds);

    InvestorRounds selectByPrimaryKey(Long id);

	InvestorRounds selectByPrimaryKeyForUpdate(Long id);
	
    List<InvestorRounds> selectAll();

	List<InvestorRounds> queryInvestorRounds(InvestorRoundsQuery investorRoundsQuery);
			
    int updateByPrimaryKey(InvestorRounds investorRounds);
	
		

}