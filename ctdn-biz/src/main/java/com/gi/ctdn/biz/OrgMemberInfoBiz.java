

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.OrgMemberInfoDAO;
import com.gi.ctdn.pojo.OrgMemberInfo;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orgMemberInfoBiz")
public class OrgMemberInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrgMemberInfoBiz.class);

    @Autowired
	OrgMemberInfoDAO orgMemberInfoDAO;


		
	public MessageInfo<List<OrgMemberInfo>> getListByOrgId(Integer orgId){

		MessageInfo<List<OrgMemberInfo>> messageInfo = new MessageInfo<List<OrgMemberInfo>>();
		try {
			List<OrgMemberInfo> orgMemberInfoList = orgMemberInfoDAO.selectByOrgId(orgId);
			messageInfo.setData(orgMemberInfoList);
		} catch (Exception e) {
			LOGGER.error("getListByOrgId","查询OrgMemberInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		


    public MessageInfo<List<OrgMemberInfo>> getAllOrgMemberInfo(){

		MessageInfo<List<OrgMemberInfo>> messageInfo = new MessageInfo<List<OrgMemberInfo>>();
		try {
			List<OrgMemberInfo> orgMemberInfoList = orgMemberInfoDAO.selectAll();
			messageInfo.setData( orgMemberInfoList);
		} catch (Exception e) {
			LOGGER.error("getAllOrgMemberInfo","查询全部OrgMemberInfo失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
}