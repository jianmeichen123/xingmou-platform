package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.DistrictInfo;

public interface DistrictFacede {

    /**
     *
     * @param type 海外or国内
     * @param level 地区等级
     * @return
     */
	MessageInfo<List<DistrictInfo>> getListByTypeLevel(Integer type, Integer level);

}