

package com.gi.ctdn.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.OrgMediaInfoDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.OrgMediaInfo;

@Service("orgMediaInfoBiz")
public class OrgMediaInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrgMediaInfoBiz.class);

    @Autowired
	OrgMediaInfoDAO orgMediaInfoDAO;


		
	public MessageInfo<List<OrgMediaInfo>> getListByOrgId(Integer orgId){

		MessageInfo<List<OrgMediaInfo>> messageInfo = new MessageInfo<List<OrgMediaInfo>>();
		try {
			List<OrgMediaInfo> orgMediaInfoList = orgMediaInfoDAO.selectByOrgId(orgId);
			messageInfo.setData(orgMediaInfoList);
		} catch (Exception e) {
			LOGGER.error("getListByOrgId","查询OrgMediaInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<OrgMediaInfo>> getAllOrgMediaInfo(){

		MessageInfo<List<OrgMediaInfo>> messageInfo = new MessageInfo<List<OrgMediaInfo>>();
		try {
			List<OrgMediaInfo> orgMediaInfoList = orgMediaInfoDAO.selectAll();
			messageInfo.setData( orgMediaInfoList);
		} catch (Exception e) {
			LOGGER.error("getAllOrgMediaInfo","查询全部OrgMediaInfo失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}