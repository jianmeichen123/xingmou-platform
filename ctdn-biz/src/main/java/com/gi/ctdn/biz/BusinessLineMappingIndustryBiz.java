package com.gi.ctdn.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.BusinessLineMappingIndustryDao;
import com.gi.ctdn.pojo.BusinessLineMappingIndustry;
import com.gi.ctdn.pojo.EchartsData;
import com.gi.ctdn.pojo.IndustryRoundMerger;
import com.gi.ctdn.view.common.MessageInfo;

@Service("businessLineMappingIndustryBiz")
public class BusinessLineMappingIndustryBiz {

	@Autowired
	private BusinessLineMappingIndustryDao  businessLineMappingIndustryDao;

	//高管-事业线
	public MessageInfo<List<BusinessLineMappingIndustry>> getBusinessLineMappingIndustry() {
		MessageInfo<List<BusinessLineMappingIndustry>> messageInfo = new MessageInfo<List<BusinessLineMappingIndustry>>();
		List<BusinessLineMappingIndustry> list =  businessLineMappingIndustryDao.selectAll();
		messageInfo.setData(list);
		return messageInfo;
	}
}
