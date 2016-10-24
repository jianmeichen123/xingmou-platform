package com.gi.xm.platform.facede.query;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.IndustryInfo;
import com.gi.xm.platform.view.IndustryQueryInfo;

public interface IndustryFacede {


	MessageInfo<IndustryInfo> getIndustry(Integer id);
		
    MessageInfo<List<IndustryInfo>> getAllIndustry();
			
    MessageInfo<QueryResultInfo<IndustryInfo>> queryIndustry(IndustryQueryInfo industryQueryInfo);

    /**
     * 根据parentId查询行业集合
     * @param parentId
     * @return
     */
    MessageInfo<List<IndustryInfo>> getListByParentId(Integer parentId);

}