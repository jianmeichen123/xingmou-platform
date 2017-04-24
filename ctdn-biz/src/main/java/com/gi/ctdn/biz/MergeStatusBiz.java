

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.MergeStatusDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.MergeStatus;

@Service("mergeStatusBiz")
public class MergeStatusBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(MergeStatusBiz.class);

    @Autowired
	MergeStatusDAO mergeStatusDAO;


	


    public MessageInfo<List<MergeStatus>> getAllMergeStatus(){

		MessageInfo<List<MergeStatus>> messageInfo = new MessageInfo<List<MergeStatus>>();
		try {
			List<MergeStatus> mergeStatusList = mergeStatusDAO.selectAll();
			messageInfo.setData( mergeStatusList);
		} catch (Exception e) {
			LOGGER.error("getAllMergeStatus","查询全部MergeStatus失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}