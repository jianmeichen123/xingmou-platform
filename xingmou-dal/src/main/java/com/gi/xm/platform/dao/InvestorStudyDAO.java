package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestorStudy;
import com.gi.xm.platform.query.InvestorStudyQuery;

public interface InvestorStudyDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(InvestorStudy investorStudy);

    InvestorStudy selectByPrimaryKey(Long id);

	InvestorStudy selectByPrimaryKeyForUpdate(Long id);
	
    List<InvestorStudy> selectAll();

	List<InvestorStudy> queryInvestorStudy(InvestorStudyQuery investorStudyQuery);
			
    int updateByPrimaryKey(InvestorStudy investorStudy);
	
		

}