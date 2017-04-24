

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.MergeTypeDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.MergeType;

@Service("mergeTypeBiz")
public class MergeTypeBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(MergeTypeBiz.class);

    @Autowired
	MergeTypeDAO mergeTypeDAO;


	


    public MessageInfo<List<MergeType>> getAllMergeType(){

		MessageInfo<List<MergeType>> messageInfo = new MessageInfo<List<MergeType>>();
		try {
			List<MergeType> mergeTypeList = mergeTypeDAO.selectAll();
			messageInfo.setData( mergeTypeList);
		} catch (Exception e) {
			LOGGER.error("getAllMergeType","查询全部MergeType失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}