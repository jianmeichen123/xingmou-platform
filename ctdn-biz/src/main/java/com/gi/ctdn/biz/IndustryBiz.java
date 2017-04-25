

package com.gi.ctdn.biz;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.dao.IndustryDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.pojo.Industry;

@Service("industryBiz")
public class IndustryBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(IndustryBiz.class);

    @Autowired
	IndustryDAO industryDAO;


	


    public MessageInfo<List<Industry>> getAllIndustry(){

		MessageInfo<List<Industry>> messageInfo = new MessageInfo<List<Industry>>();
		try {
			List<Industry> industryList = industryDAO.selectAll();
			List<Industry> firstLevelIndustrylist = new ArrayList<>();
			List<Industry> secondLevelIndustrylist = new ArrayList<>();
			List<Industry> thirdLevelIndustrylist = new ArrayList<>();
			if (industryList != null){
				//一级行业
				for (Industry industry : industryList
						) {
					Integer parentId = industry.getParentId();
					if (parentId != null){
						if (parentId == 0){
							firstLevelIndustrylist.add(industry);
						}
					}

				}
			}
			//二级行业
			if (firstLevelIndustrylist != null) {
				for (Industry industry : firstLevelIndustrylist
						) {
					Integer industryId = industry.getIndustryId();
					if (industryId != null) {
						for (Industry secondIndustry : industryList
								) {
							Integer parentId = secondIndustry.getParentId();
							if (industryId == parentId) {
								secondLevelIndustrylist.add(secondIndustry);
								industry.setIndustrylist(secondLevelIndustrylist);
							}
						}
					}
				}
			}
			//三级行业
			if (secondLevelIndustrylist != null) {
				for (Industry secondLevelIndustry : secondLevelIndustrylist
						) {
					Integer industryId = secondLevelIndustry.getIndustryId();
					if (industryId != null) {
						for (Industry thirdLevelIndustry : industryList
								) {
							Integer parentId = thirdLevelIndustry.getParentId();
							if (industryId == parentId) {
								thirdLevelIndustrylist.add(thirdLevelIndustry);
								secondLevelIndustry.setIndustrylist(thirdLevelIndustrylist);
							}
						}
					}
				}
			}
			messageInfo.setData( firstLevelIndustrylist);
		} catch (Exception e) {
			LOGGER.error("getAllIndustry","查询全部Industry失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	public List<Industry> getFirstIndustry(){
		List<Industry> firstIndustryList = new ArrayList<>();
		try {
			firstIndustryList = industryDAO.selectFirstIndustry();

		} catch (Exception e) {
			LOGGER.error("getFirstIndustry","查询第一级Industry失败", e);
		}
		return firstIndustryList;
	}

	public List<Industry> getNextIndustry(Integer industryId){

		List<Industry> nextIndustryList = new ArrayList<>();
		try {
			nextIndustryList = industryDAO.selectNextIndustry(industryId);
		} catch (Exception e) {
			LOGGER.error("getNextIndustry","查询第二级Industry失败", e);
		}
		return nextIndustryList;
	}
}