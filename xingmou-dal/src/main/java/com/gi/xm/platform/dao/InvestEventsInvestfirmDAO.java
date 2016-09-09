package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestEventsInvestfirm;
import com.gi.xm.platform.query.InvestEventsInvestfirmQuery;

public interface InvestEventsInvestfirmDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(InvestEventsInvestfirm investEventsInvestfirm);

    InvestEventsInvestfirm selectByPrimaryKey(Long id);

	InvestEventsInvestfirm selectByPrimaryKeyForUpdate(Long id);
	
    List<InvestEventsInvestfirm> selectAll();

	List<InvestEventsInvestfirm> queryInvestEventsInvestfirm(InvestEventsInvestfirmQuery investEventsInvestfirmQuery);
			
    int updateByPrimaryKey(InvestEventsInvestfirm investEventsInvestfirm);
	
		

}