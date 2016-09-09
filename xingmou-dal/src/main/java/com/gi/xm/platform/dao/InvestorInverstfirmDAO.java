package com.gi.xm.platform.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.platform.pojo.InvestorInverstfirm;
import com.gi.xm.platform.query.InvestorInverstfirmQuery;

public interface InvestorInverstfirmDAO {
	
	int deleteByPrimaryKey(Long id);
	
	
    int insert(InvestorInverstfirm investorInverstfirm);

    InvestorInverstfirm selectByPrimaryKey(Long id);

	InvestorInverstfirm selectByPrimaryKeyForUpdate(Long id);
	
    List<InvestorInverstfirm> selectAll();

	List<InvestorInverstfirm> queryInvestorInverstfirm(InvestorInverstfirmQuery investorInverstfirmQuery);
			
    int updateByPrimaryKey(InvestorInverstfirm investorInverstfirm);
	
		

}