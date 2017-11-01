

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.DistrictDAO;
import com.gi.ctdn.view.common.MessageInfo;

import com.gi.ctdn.pojo.District;

@Service("districtBiz")
public class DistrictBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(DistrictBiz.class);

    @Autowired
	DistrictDAO districtDAO;


	


    public MessageInfo<List<District>> getAllDistrict(){

		MessageInfo<List<District>> messageInfo = new MessageInfo<List<District>>();
		try {
			List<District> districtList = districtDAO.selectAll();
			messageInfo.setData( districtList);
		} catch (Exception e) {
			LOGGER.error("getAllDistrict","查询全部District失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}