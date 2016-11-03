package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.IndustryInfo;
import com.gi.xm.platform.view.IndustryQueryInfo;

public interface IndustryFacede {

    MessageInfo<Integer> deleteIndustry(Integer id);
		
    MessageInfo<Integer> createIndustry(IndustryInfo industryInfo);
		
	MessageInfo<Integer> updateIndustry(IndustryInfo industryInfo);
		
	MessageInfo<IndustryInfo> getIndustry(Integer id);

    /**
     * 获取全部行业(仅项目和投资事件使用)
     * @return
     */
    MessageInfo<List<IndustryInfo>> getAllIndustry();
			
    MessageInfo<QueryResultInfo<IndustryInfo>> queryIndustry(IndustryQueryInfo industryQueryInfo);

    /**
     * 根据parentId查询行业集合
     * @param parentId
     * @return
     */
    MessageInfo<List<IndustryInfo>> getListByParentId(Integer parentId);

}