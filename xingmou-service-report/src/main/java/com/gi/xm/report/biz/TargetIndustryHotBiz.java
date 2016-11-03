

package com.gi.xm.report.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.common.Message;
import com.gi.xm.report.dao.TargetIndustryHotDAO;
import com.gi.xm.report.pojo.TargetIndustryHot;
import com.gi.xm.report.query.TargetIndustryHotQueryInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("targetIndustryHotBiz")
public class TargetIndustryHotBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(TargetIndustryHotBiz.class);

    @Autowired
	TargetIndustryHotDAO targetIndustryHotDAO;



    public MessageInfo<Integer> createTargetIndustryHot(TargetIndustryHot targetIndustryHot){
		MessageInfo<Integer> messageInfo = new MessageInfo<Integer>();
		try {
						        							targetIndustryHotDAO.insert( targetIndustryHot );
			messageInfo.setData(targetIndustryHot.getId());

		} catch (Exception e) {
			LOGGER.error("createTargetIndustryHot","创建TargetIndustryHot失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

		
	public MessageInfo<List<TargetIndustryHot>> getListByIndustryLevel(Integer industryLevel){

		MessageInfo<List<TargetIndustryHot>> messageInfo = new MessageInfo<List<TargetIndustryHot>>();
		try {
			List<TargetIndustryHot> targetIndustryHotList = targetIndustryHotDAO.selectByIndustryLevel(industryLevel);
			messageInfo.setData(targetIndustryHotList);
		} catch (Exception e) {
			LOGGER.error("getListByIndustryLevel","查询TargetIndustryHot失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}
		


	public MessageInfo<QueryResultInfo<TargetIndustryHot>> queryTargetIndustryHot(TargetIndustryHotQueryInfo targetIndustryHotQuery) {
		MessageInfo<QueryResultInfo<TargetIndustryHot>> message = new MessageInfo<QueryResultInfo<TargetIndustryHot>>();
		try {
			QueryResultInfo<TargetIndustryHot> queryResult = new QueryResultInfo<TargetIndustryHot>();
			PageHelper.startPage(targetIndustryHotQuery.getPageIndex(), targetIndustryHotQuery.getPageSize());
			List<TargetIndustryHot> targetIndustryHotList = targetIndustryHotDAO.queryTargetIndustryHot(targetIndustryHotQuery);
			PageInfo<TargetIndustryHot> pageInfo = new PageInfo<TargetIndustryHot>(targetIndustryHotList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(targetIndustryHotList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryTargetIndustryHot", "分页查询TargetIndustryHot失败", e);
			message.setStatus(10001);
		}
		return message;
	}

}