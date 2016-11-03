package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.RoundInfo;
import com.gi.xm.platform.view.RoundQueryInfo;

public interface RoundFacede {

	MessageInfo<RoundInfo> getRound(Integer id);
		
    MessageInfo<List<RoundInfo>> getAllRound();
			
    MessageInfo<QueryResultInfo<RoundInfo>> queryRound(RoundQueryInfo roundQueryInfo);
	
	

}