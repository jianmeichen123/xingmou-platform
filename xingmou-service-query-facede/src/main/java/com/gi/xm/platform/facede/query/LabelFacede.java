package com.gi.xm.platform.facede.query;


import java.util.List;

import com.gi.xm.platform.view.LabelInfo;
import com.gi.xm.platform.view.common.MessageInfo;

public interface LabelFacede {
		
	
	/**
	 * 根据type 和 关联id查询label列表
	 * @param type
	 * @param relationId
	 * @return
	 */
	MessageInfo<List<LabelInfo>> getListByTypeRelationId(Integer type, Long relationId);
		

}