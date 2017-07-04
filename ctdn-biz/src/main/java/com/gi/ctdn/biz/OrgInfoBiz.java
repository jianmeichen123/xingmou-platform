

package com.gi.ctdn.biz;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
	OrgMemberDAO orgMemberDAO;

    @Autowired
	ProjectContactDAO projectContactDAO;

    @Autowired
	EventInfoExtDAO eventInfoExtDAO;

    public  MessageInfo<OrgListInfo> getBaseInfoByOrgId(Integer orgId){

    	MessageInfo<OrgListInfo> messageInfo = new MessageInfo<>();
    	try{
    		OrgListInfo orgListInfo = orgInfoDAO.selectById(orgId);
    		if (orgListInfo != null){
    			List<OrgMediaInfo> orgMediaInfoList = orgMediaInfoDAO.selectByOrgId(orgId);
				List<OrgMediaInfo> orgHistoryInfoList = orgMediaInfoDAO.selectByOrgIdForHistroy(orgId);
				List<OrgMember> orgMemberList = orgMemberDAO.selectOrgMemberById(orgId);
				List<EventInfoExt> eventInfoExtList = eventInfoExtDAO.selectByInvstoridType(orgId);
				eventInfoExtList = sortList(eventInfoExtList,orgListInfo.getOrgName());
				List<ProjectContact> projectContactList = projectContactDAO.selectByOrgId(orgId);
				orgListInfo.setOrgMediaInfoList(orgMediaInfoList);
				orgListInfo.setOrgHistoryInfoList(orgHistoryInfoList);
				orgListInfo.setOrgMemberList(orgMemberList);
				orgListInfo.setEventInfoExtList(eventInfoExtList);
				orgListInfo.setProjectContactList(projectContactList);
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

	public List<EventInfoExt> sortList(List<EventInfoExt> eventInfoExtList,String orgName){
		if(eventInfoExtList.size()>0){
			JSONObject temp = null;
			JSONObject jsonObject = null;
			List<JSONObject> ls = null;
			for(EventInfoExt info:eventInfoExtList){
				String json = info.getInvestSideJson();
				JSONObject obj = JSON.parseObject(json);
				ls =(List<JSONObject>) obj.get("investSideJson");
				if(ls.size()>0){
					//遍历集合中的json.找到后,与集合第一个交换位置
					for(int i = 0;i<ls.size();i++){
						jsonObject = ls.get(i);
						if(jsonObject.get("invstor").equals(orgName)){
							temp= ls.get(0);
							ls.set(0,jsonObject);
							ls.set(i,temp);
						}
					}
				}
				json = obj.toJSONString();
				info.setInvestSideJson(json);
			}
		}
    	return eventInfoExtList;
	}
	public OrgListInfo getOrgListInfoById(Integer id){
    	return orgInfoDAO.selectById(id);
	}
}