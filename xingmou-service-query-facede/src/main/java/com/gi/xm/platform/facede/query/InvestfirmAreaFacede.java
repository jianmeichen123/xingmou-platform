package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.InvestfirmAreaInfo;
import com.gi.xm.platform.view.InvestfirmAreaQueryInfo;

public interface InvestfirmAreaFacede {

	MessageInfo<InvestfirmAreaInfo> getInvestfirmArea(Long id);
		
    MessageInfo<List<InvestfirmAreaInfo>> getAllInvestfirmArea();
			
    MessageInfo<QueryResultInfo<InvestfirmAreaInfo>> queryInvestfirmArea(InvestfirmAreaQueryInfo investfirmAreaQueryInfo);
	
		
	MessageInfo<List<InvestfirmAreaInfo>> getListByInvestfrimId(Integer investfrimId);
		

}