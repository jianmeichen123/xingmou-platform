package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.DataInfo;
import com.gi.xm.platform.view.DataQueryInfo;

public interface DataFacede {

	MessageInfo<DataInfo> getData(Integer id);
		
    MessageInfo<List<DataInfo>> getAllData();
			
    MessageInfo<QueryResultInfo<DataInfo>> queryData(DataQueryInfo dataQueryInfo);
	
	

}