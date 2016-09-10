package com.gi.xm.platform.facede;


import java.util.List;
import java.util.Date;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.view.DistrictInfo;
import com.gi.xm.platform.view.DistrictQueryInfo;

public interface DistrictFacede {

	MessageInfo<Integer> deleteDistrict(Integer id);
		
    MessageInfo<Integer> createDistrict(DistrictInfo districtInfo);
		
	MessageInfo<Integer> updateDistrict(DistrictInfo districtInfo);
		
	MessageInfo<DistrictInfo> getDistrict(Integer id);
		
    MessageInfo<List<DistrictInfo>> getAllDistrict();

    MessageInfo<QueryResultInfo<DistrictInfo>> queryDistrict(DistrictQueryInfo districtQueryInfo);

    /**
     *
     * @param type 海外or国内
     * @param level 地区等级
     * @return
     */
	MessageInfo<List<DistrictInfo>> getListByTypeLevel(Integer type, Integer level);
			
	MessageInfo<List<DistrictInfo>> getListByUpidDisplayorder(Integer upid, Integer displayorder);
		

}