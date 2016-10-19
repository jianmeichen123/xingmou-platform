package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.AreaInfo;
import com.gi.xm.platform.view.AreaQueryInfo;

public interface AreaFacede {
    MessageInfo<Integer> deleteArea(Long id);
		
    MessageInfo<Long> createArea(AreaInfo areaInfo);
		
	MessageInfo<Integer> updateArea(AreaInfo areaInfo);
		
	MessageInfo<AreaInfo> getArea(Long id);

    /**
     * 获取全部领域
     * @return
     */
    MessageInfo<List<AreaInfo>> getAllArea();
			
    //MessageInfo<QueryResultInfo<AreaInfo>> queryArea(AreaQueryInfo areaQueryInfo);
	
	

}