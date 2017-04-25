

package com.gi.ctdn.biz;

import java.util.ArrayList;
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

	public MessageInfo<List<ListingType>> getListingType(){

		MessageInfo<List<ListingType>> messageInfo = new MessageInfo<List<ListingType>>();
		try {
			List<ListingType> listingTypeList = listingTypeDAO.selectListingType();
			List<ListingType> firstListingTypeList = new ArrayList<>();
			List<ListingType> secondListingTypeList = new ArrayList<>();
			if (messageInfo != null){
				listingTypeList = messageInfo.getData();
				if (listingTypeList != null){
					for (ListingType listingType : listingTypeList
							) {
						Integer typeId = listingType.getTypeId();
						if (typeId == 0 || typeId == 1 || typeId == 2){
							firstListingTypeList.add(listingType);
						}
					}
				}
				if (firstListingTypeList != null){
					for (ListingType firstlistingType : firstListingTypeList
							) {
						Integer typeId = firstlistingType.getTypeId();
						if (typeId != null) {
							for (ListingType listingType : listingTypeList
									) {
								Integer parentId = listingType.getParentId();
								if (typeId == parentId) {
									secondListingTypeList.add(listingType);
									listingType.setListingTypeList(secondListingTypeList);
								}
							}
						}
					}
				}
			}
			messageInfo.setData( firstListingTypeList);
		} catch (Exception e) {
			LOGGER.error("getListingType","查询一级ListingType失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public List<ListingType> getSecondListingType(Integer typeId){

		List<ListingType> listingTypeList = new ArrayList<>();
		try{
			listingTypeList = listingTypeDAO.selectSecondListingType(typeId);
		}catch (Exception e) {
			LOGGER.error("getSecondListingType","查询2级ListingType失败", e);
		}
		return listingTypeList;
	}
}