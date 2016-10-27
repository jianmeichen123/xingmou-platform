

package com.gi.xm.doc.biz;

import java.util.List;

import com.gi.xm.doc.dao.IndustryReportsDAO;
import com.gi.xm.doc.pojo.IndustryReportsInfo;
import com.gi.xm.doc.query.IndustryReportsQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.gi.xm.platform.view.common.MessageInfo;

@Service("industryReportsBiz")
public class IndustryReportsBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(IndustryReportsBiz.class);

    @Autowired
	IndustryReportsDAO industryReportsDAO;



    public MessageInfo<Integer> createIndustryReports(IndustryReportsInfo industryReportsInfo){
		MessageInfo<Integer> messageInfo = new MessageInfo<Integer>();
		try {
			industryReportsDAO.insert( industryReportsInfo );
			messageInfo.setData(industryReportsInfo.getId());

		} catch (Exception e) {
			LOGGER.error("createIndustryReports","创建IndustryReports失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}

	


	public MessageInfo<QueryResultInfo<IndustryReportsInfo>> queryIndustryReports(IndustryReportsQueryInfo industryReportsQuery) {
		MessageInfo<QueryResultInfo<IndustryReportsInfo>> messageInfo = new MessageInfo<>();
		try {
			QueryResultInfo<IndustryReportsInfo> queryResult = new QueryResultInfo<IndustryReportsInfo>();
			PageHelper.startPage(industryReportsQuery.getPageIndex(), industryReportsQuery.getPageSize());
			List<IndustryReportsInfo> industryReportsList = industryReportsDAO.queryIndustryReports(industryReportsQuery);
			PageInfo<IndustryReportsInfo> pageInfo = new PageInfo<IndustryReportsInfo>(industryReportsList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(industryReportsList);
			messageInfo.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryIndustryReports", "分页查询IndustryReports失败", e);
			messageInfo.setStatus(10001);
		}
		return messageInfo;
	}


    public MessageInfo<IndustryReportsInfo> getIndustryReports( Integer id ){
        MessageInfo<IndustryReportsInfo> messageInfo = new MessageInfo<IndustryReportsInfo>();
        try {
            IndustryReportsInfo industryReportsInfo = industryReportsDAO.selectByPrimaryKey(id);
            messageInfo.setData(industryReportsInfo);
        } catch (Exception e) {
            LOGGER.error("getArea","根据主键查询Area失败", e);
            messageInfo.setStatus(10001);
        }
        return messageInfo;
    }

}