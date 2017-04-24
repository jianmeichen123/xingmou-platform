

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.ListingTypeDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.ListingType;

@Service("listingTypeBiz")
public class ListingTypeBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(ListingTypeBiz.class);

    @Autowired
	ListingTypeDAO listingTypeDAO;


	


    public MessageInfo<List<ListingType>> getAllListingType(){

		MessageInfo<List<ListingType>> messageInfo = new MessageInfo<List<ListingType>>();
		try {
			List<ListingType> listingTypeList = listingTypeDAO.selectAll();
			messageInfo.setData( listingTypeList);
		} catch (Exception e) {
			LOGGER.error("getAllListingType","查询全部ListingType失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}