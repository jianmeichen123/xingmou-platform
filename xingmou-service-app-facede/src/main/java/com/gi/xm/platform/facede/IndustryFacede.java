package com.gi.xm.platform.facede;


import java.util.List;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.IndustryInfo;

public interface IndustryFacede {



    MessageInfo<List<IndustryInfo>> getAllIndustry();
			

    /**
     * 根据parentId查询行业集合
     * @param parentId
     * @return
     */
    MessageInfo<List<IndustryInfo>> getListByParentId(Integer parentId);

}