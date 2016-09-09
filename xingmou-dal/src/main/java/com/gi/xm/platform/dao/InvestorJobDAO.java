package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestorJob;
import com.gi.xm.platform.query.InvestorJobQuery;

public interface InvestorJobDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(InvestorJob investorJob);

    InvestorJob selectByPrimaryKey(Long id);

	InvestorJob selectByPrimaryKeyForUpdate(Long id);
	
    List<InvestorJob> selectAll();

	List<InvestorJob> queryInvestorJob(InvestorJobQuery investorJobQuery);
			
    int updateByPrimaryKey(InvestorJob investorJob);
	
		

}