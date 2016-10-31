package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.DataInfo;

public interface DataFacede {
    MessageInfo<Integer> deleteData(Integer id);
		
    MessageInfo<Integer> createData(DataInfo dataInfo);
		
	MessageInfo<Integer> updateData(DataInfo dataInfo);
		
	MessageInfo<DataInfo> getData(Integer id);
		
    MessageInfo<List<DataInfo>> getAllData();
			
}