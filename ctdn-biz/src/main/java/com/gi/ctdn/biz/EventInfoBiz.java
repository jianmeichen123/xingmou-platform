

package com.gi.ctdn.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.gi.ctdn.dao.EventDetailDAO;
import com.gi.ctdn.dao.OrgInfoDAO;
import com.gi.ctdn.dao.me.UserIndustryDAO;
import com.gi.ctdn.pojo.EventDetail;
import com.gi.ctdn.pojo.EventInfo;
import com.gi.ctdn.pojo.EventInfoList;
import com.gi.ctdn.pojo.me.UserIndustry;
import com.gi.ctdn.view.common.Pagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.EventInfoDAO;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.MessageInfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("eventInfoBiz")
public class EventInfoBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(EventInfoBiz.class);

    @Autowired
	EventInfoDAO eventInfoDAO;

    @Autowired
	OrgInfoDAO orgInfoDAO;

    @Autowired
	EventDetailDAO eventDetailDAO;
    
    @Autowired
    private UserIndustryDAO userIndustryDAO;


	public MessageInfo<List<EventInfo>> getListBySourceCode(EventInfo eventInfo){

		MessageInfo<List<EventInfo>> messageInfo = new MessageInfo<List<EventInfo>>();
		try {
			List<EventInfo> eventInfoList = eventInfoDAO.selectBySourceCode(eventInfo.getSourceCode());
			messageInfo.setData(eventInfoList);
		} catch (Exception e) {
			LOGGER.error("getListBySourceCode","查询EventInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
			
	public MessageInfo<EventInfoList> getByEventId(Integer eventId){
		MessageInfo<EventInfoList> messageInfo = new MessageInfo<>();

		try {
			EventInfoList eventInfoList = eventInfoDAO.selectByEventId(eventId);
			if(eventInfoList!=null){
				List<EventDetail> eventDetailList = eventDetailDAO.selectByEventId(eventId);
				eventInfoList.setEventDetailList(eventDetailList);
			}
			messageInfo.setData(eventInfoList);
		} catch (Exception e) {
			LOGGER.error("getByEventId","查询EventInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

	public MessageInfo<EventInfo> getListByName(EventInfo eventInfo) {

		MessageInfo<EventInfo> messageInfo;
		try {
			List<EventInfo> eventInfoList = eventInfoDAO.selectByName(eventInfo.getCompany());
			List<EventInfo> newList = new ArrayList<EventInfo>();
			if(eventInfoList.size()>0){
				JSONObject temp = null;
				JSONObject jsonObject = null;
				List<JSONObject> ls = null;
				for(EventInfo info:eventInfoList){
					boolean flag = false;
					String json = info.getInvestSideJson();
					JSONObject obj = JSON.parseObject(json);
					//{"investSideJson":[{"code":"","id":"8","invstor":"蓝驰创投","isClick":1,"isLeader":0,"type":"invst"}]}
					ls =(List<JSONObject>) obj.get("investSideJson");
					if(ls.size()>0){
						//遍历集合中的json.找到后,与集合第一个交换位置
						for(int i = 0;i<ls.size();i++){
							jsonObject = ls.get(i);
							if(jsonObject.containsValue(eventInfo.getCompany())){
								if(jsonObject.get("type").equals("com")){
									flag = true;
									temp= ls.get(0);
									ls.set(0,jsonObject);
									ls.set(i,temp);
								}
							}
						}
					}
					//如果有符合 名称匹配和类型匹配的数据,放入集合
					if(flag){
						json = obj.toJSONString();
						info.setInvestSideJson(json);
						newList.add(info);
					}
				}
			}
			//返回结果
			Pagination page = new Pagination();
			if(newList != null && ! newList.isEmpty()){
				if(newList.size() > eventInfo.getPageSize()){
					page.setTotal(Long.valueOf(newList.size()));
					int fromIndex = eventInfo.getPageNo();
					if(fromIndex >1){
						fromIndex = (fromIndex-1)*eventInfo.getPageSize()+1;
					}
					int toIndex = fromIndex+eventInfo.getPageSize();
					if(toIndex <= (newList.size())){
						newList = newList.subList(fromIndex,toIndex);
						page.setRecords(newList);
					}else{
						toIndex = fromIndex+(toIndex-newList.size()-1);
						newList = newList.subList(fromIndex,toIndex);
						page.setRecords(newList);
					}
				}else{
					page.setTotal(Long.valueOf(newList.size()));
					page.setRecords(newList);
				}
			}
			messageInfo = new MessageInfo( MessageStatus.OK_CODE, MessageStatus.OK_MESSAGE,page);
		} catch (Exception e) {
			LOGGER.error("getListByProjectCode","查询ProjectMediaInfo失败", e);
			messageInfo = new MessageInfo(MessageStatus.ERROR_CODE,e.getMessage());
		}
		return messageInfo;
	}


//	public MessageInfo<List<EventInfo>> getFromCtdnEventInfo( EventInfo info) {
//		MessageInfo<List<EventInfo>> messageInfo = new MessageInfo<List<EventInfo>>();
//		try {
//			UserIndustry userIndustry = userIndustryDAO.getUserIndustry(1l);
//			List<String> industryIds = null;
//			if(userIndustry!=null && userIndustry.getIndustryIds() !=null){
//				industryIds = Arrays.asList(userIndustry.getIndustryIds().split(","));
//			}
//			info.setIndustryIdList(industryIds);
//			List<EventInfo> eventInfo = eventInfoDAO.selectFromCtdn(info);
//			messageInfo.setData(eventInfo);
//		} catch (Exception e) {
//			LOGGER.info("getFromCtdnEventInfo","查询EventInfo失败", e);
//			messageInfo.setStatus(MessageStatus.ERROR_CODE);
//		}
//		return messageInfo;
//	}
	public MessageInfo<List<EventInfo>> getByInvestDate() {
		MessageInfo<List<EventInfo>> messageInfo = new MessageInfo<List<EventInfo>>();
		try {
			List<EventInfo> eventInfo = eventInfoDAO.selectByInvestDate();
			messageInfo.setData(eventInfo);
		} catch (Exception e) {
			LOGGER.error("getListByName","查询EventInfo失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
//
//	public MessageInfo<List<EventInfo>> getFromCtdnEventInfo1( EventInfo info) {
//		MessageInfo<List<EventInfo>> messageInfo = new MessageInfo<List<EventInfo>>();
//		try {
//			UserIndustry userIndustry = userIndustryDAO.getUserIndustry(1l);
//			List<String> industryIds = null;
//			if(userIndustry!=null && userIndustry.getIndustryIds() !=null){
//				industryIds = Arrays.asList(userIndustry.getIndustryIds().split(","));
//			}
//			info.setIndustryIdList(industryIds);
//			List<EventInfo> eventInfo = eventInfoDAO.selectFromCtdn(info);
//			messageInfo.setData(eventInfo);
//		} catch (Exception e) {
//			LOGGER.info("getFromCtdnEventInfo","查询EventInfo失败", e);
//			messageInfo.setStatus(MessageStatus.ERROR_CODE);
//		}
//		return messageInfo;
//	}
}