package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.LabelInfo;
import com.gi.xm.platform.view.LabelQueryInfo;

public interface LabelFacede {
		MessageInfo<Integer> deleteLabel(Long id);
		
    MessageInfo<Long> createLabel(LabelInfo labelInfo);
		
	MessageInfo<Integer> updateLabel(LabelInfo labelInfo);
		
	MessageInfo<LabelInfo> getLabel(Long id);
		
    MessageInfo<List<LabelInfo>> getAllLabel();
			
    MessageInfo<QueryResultInfo<LabelInfo>> queryLabel(LabelQueryInfo labelQueryInfo);
	
	

}