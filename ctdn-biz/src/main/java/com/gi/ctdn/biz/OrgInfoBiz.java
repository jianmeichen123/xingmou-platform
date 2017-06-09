

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.OrgInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.OrgInfo;

@Service("orgInfoBiz")
public class OrgInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrgInfoBiz.class);

    @Autowired
	OrgInfoDAO orgInfoDAO;


		
	public MessageInfo<List<OrgInfo>> getListByOrgId(Integer orgId){

		MessageInfo<List<OrgInfo>> messageInfo = new MessageInfo<List<OrgInfo>>();
		try {
			List<OrgInfo> orgInfoList = orgInfoDAO.selectByOrgId(orgId);
			messageInfo.setData(orgInfoList);
		} catch (Exception e) {
			LOGGER.error("getListByOrgId","查询OrgInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

	public MessageInfo<List<OrgInfo>> getListByProjTitle(String projTitle){

		MessageInfo<List<OrgInfo>> messageInfo = new MessageInfo<List<OrgInfo>>();
		try {
			List<OrgInfo> orgInfoList = orgInfoDAO.selectByProjTitle(projTitle);
			messageInfo.setData(orgInfoList);
		} catch (Exception e) {
			LOGGER.error("getListByProjTitle","查询OrgInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

    public MessageInfo<List<OrgInfo>> getAllOrgInfo(){

		MessageInfo<List<OrgInfo>> messageInfo = new MessageInfo<List<OrgInfo>>();
		try {
			List<OrgInfo> orgInfoList = orgInfoDAO.selectAll();
			messageInfo.setData( orgInfoList);
		} catch (Exception e) {
			LOGGER.error("getAllOrgInfo","查询全部OrgInfo失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}