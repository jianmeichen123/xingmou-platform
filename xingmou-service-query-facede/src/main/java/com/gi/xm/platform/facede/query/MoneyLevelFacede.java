package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.MoneyLevelInfo;
import com.gi.xm.platform.view.MoneyLevelQueryInfo;

public interface MoneyLevelFacede {

	MessageInfo<MoneyLevelInfo> getMoneyLevel(Integer id);
		
    MessageInfo<List<MoneyLevelInfo>> getAllMoneyLevel();
			
    MessageInfo<QueryResultInfo<MoneyLevelInfo>> queryMoneyLevel(MoneyLevelQueryInfo moneyLevelQueryInfo);
	
	

}