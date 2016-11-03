package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.CurrencyInfo;
import com.gi.xm.platform.view.CurrencyQueryInfo;

public interface CurrencyFacede {

	MessageInfo<CurrencyInfo> getCurrency(Long id);
		
    MessageInfo<List<CurrencyInfo>> getAllCurrency();
			
    MessageInfo<QueryResultInfo<CurrencyInfo>> queryCurrency(CurrencyQueryInfo currencyQueryInfo);
	
	

}