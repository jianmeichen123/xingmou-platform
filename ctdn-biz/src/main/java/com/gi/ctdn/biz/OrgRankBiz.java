

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.OrgRankDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.OrgRank;

@Service("orgRankBiz")
public class OrgRankBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrgRankBiz.class);

    @Autowired
	OrgRankDAO orgRankDAO;


	


    public MessageInfo<List<OrgRank>> getAllOrgRank(){

		MessageInfo<List<OrgRank>> messageInfo = new MessageInfo<List<OrgRank>>();
		try {
			List<OrgRank> orgRankList = orgRankDAO.selectAll();
			messageInfo.setData( orgRankList);
		} catch (Exception e) {
			LOGGER.error("getAllOrgRank","查询全部OrgRank失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<OrgRank>> getByTimes(){

		MessageInfo<List<OrgRank>> messageInfo = new MessageInfo<List<OrgRank>>();
		try {
			List<OrgRank> orgRankList = orgRankDAO.selectBytimes();
			messageInfo.setData( orgRankList);
		} catch (Exception e) {
			LOGGER.error("getByTimes","查询OrgRankByTimes失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public MessageInfo<List<OrgRank>> getByAllTimes(){

		MessageInfo<List<OrgRank>> messageInfo = new MessageInfo<List<OrgRank>>();
		try {
			List<OrgRank> orgRankList = orgRankDAO.selectByAllTimes();
			messageInfo.setData( orgRankList);
		} catch (Exception e) {
			LOGGER.error("getByAllTimes","查询OrgRankByTimes失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}