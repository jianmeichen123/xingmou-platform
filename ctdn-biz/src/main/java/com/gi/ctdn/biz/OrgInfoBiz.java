

package com.gi.ctdn.biz;

import java.util.List;

import com.gi.ctdn.dao.*;
import com.gi.ctdn.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

@Service("orgInfoBiz")
public class OrgInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrgInfoBiz.class);

    @Autowired
	OrgInfoDAO orgInfoDAO;

    @Autowired
	OrgMediaInfoDAO orgMediaInfoDAO;

    @Autowired
	OrgMemberInfoDAO orgMemberInfoDAO;

    @Autowired
	EventInfoDAO eventInfoDAO;

    @Autowired
	ProjectContactDAO projectContactDAO;

    public  MessageInfo<OrgListInfo> getBaseInfoByOrgId(Integer orgId){

    	MessageInfo<OrgListInfo> messageInfo = new MessageInfo<>();
    	try{
    		OrgListInfo orgListInfo = orgInfoDAO.selectById(orgId);
    		if (orgListInfo != null){
    			List<OrgMediaInfo> orgMediaInfoList = orgMediaInfoDAO.selectByOrgId(orgId);
    			List<OrgMemberInfo> orgMemberInfoList = orgMemberInfoDAO.selectByOrgId(orgId);
				List<EventInfo> eventInfoList = eventInfoDAO.selectBySourceId(orgId);

				orgListInfo.setOrgMediaInfoList(orgMediaInfoList);
				orgListInfo.setOrgMemberInfoList(orgMemberInfoList);
				orgListInfo.setEventInfoList(eventInfoList);
			}
			messageInfo.setData(orgListInfo);
		}catch (Exception e) {
			LOGGER.error("getBaseInfoByOrgId","查询OrgListInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		
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

	public OrgListInfo getOrgListInfoById(Integer id){
    	return orgInfoDAO.selectById(id);
	}
}