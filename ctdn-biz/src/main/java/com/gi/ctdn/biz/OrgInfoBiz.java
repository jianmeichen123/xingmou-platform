

package com.gi.ctdn.biz;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gi.ctdn.dao.*;
import com.gi.ctdn.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.MessageInfo;

@Service("orgInfoBiz")
public class OrgInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(OrgInfoBiz.class);

    @Autowired
	OrgInfoDAO orgInfoDAO;

    @Autowired
	OrgMediaInfoDAO orgMediaInfoDAO;

    @Autowired
	OrgMemberDAO orgMemberDAO;

    @Autowired
	ProjectContactDAO projectContactDAO;

    @Autowired
	EventInfoExtDAO eventInfoExtDAO;

    @Autowired
	NewsDao newsDao;

    public  MessageInfo<OrgListInfo> getBaseInfoByOrgCode(String orgCode){

    	MessageInfo<OrgListInfo> messageInfo = new MessageInfo<>();
    	try{
    		OrgListInfo orgListInfo = orgInfoDAO.selectById(orgCode);
    		if (orgListInfo != null){
    			List<News> orgNewsList = newsDao.selectNewsByOrgCode(orgCode);
				List<OrgMediaInfo> orgHistoryInfoList = orgMediaInfoDAO.selectByOrgIdForHistroy(orgCode);
				List<OrgMember> orgMemberList = orgMemberDAO.selectOrgMemberById(orgCode);
				List<EventInfoExt> eventInfoExtList = eventInfoExtDAO.selectByInvstoridType(orgCode);
				eventInfoExtList = sortList(eventInfoExtList,orgListInfo.getInvestOrg());
				List<ProjectContact> projectContactList = projectContactDAO.selectByOrgId(orgCode);
				orgListInfo.setOrgNewsList(orgNewsList);
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
		
//	public MessageInfo<List<OrgInfo>> getListByOrgId(String orgId){
//
//		MessageInfo<List<OrgInfo>> messageInfo = new MessageInfo<List<OrgInfo>>();
//		try {
//			List<OrgInfo> orgInfoList = orgInfoDAO.selectByOrgId(orgId);
//			messageInfo.setData(orgInfoList);
//		} catch (Exception e) {
//			LOGGER.error("getListByOrgId","查询OrgInfo失败", e);
//			messageInfo.setStatus(MessageStatus.ERROR_CODE);
//		}
//		return messageInfo;
//	}


    public List<OrgInfo> getListByCodes(List<String> orgCodes){

		List<OrgInfo> orgInfoList = new ArrayList<OrgInfo>();
		try {
			orgInfoList = orgInfoDAO.selectByCodes(orgCodes);
		} catch (Exception e) {
			LOGGER.error("getListByOrgCodes","查询全部OrgInfo失败", e);
		}
		return orgInfoList;
	}

	public List<EventInfoExt> sortList(List<EventInfoExt> eventInfoExtList,String orgName){
		if(eventInfoExtList.size()>0){
			JSONObject temp = null;
			JSONObject jsonObject = null;
			List<JSONObject> ls = null;
			for(EventInfoExt info:eventInfoExtList){
				String json = info.getInvestSideJson();
				if(json!=null){
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
		}
    	return eventInfoExtList;
	}
	public OrgListInfo getOrgListInfoById(String id){
    	return orgInfoDAO.selectById(id);
	}
}