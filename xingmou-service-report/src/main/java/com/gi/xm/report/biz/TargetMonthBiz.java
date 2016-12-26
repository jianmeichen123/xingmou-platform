

package com.gi.xm.report.biz;

import java.util.List;

import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.common.Message;
import com.gi.xm.report.query.TargetMonthQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.report.dao.TargetMonthDAO;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.report.pojo.TargetMonth;

@Service("targetMonthBiz")
public class TargetMonthBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(TargetMonthBiz.class);

    @Autowired
	TargetMonthDAO targetMonthDAO;



    public MessageInfo<List<TargetMonth>> queryTargetMonthList(TargetMonthQuery targetMonthQuery) {
        MessageInfo<List<TargetMonth>> message = new MessageInfo<List<TargetMonth>>();
        try {
            List<TargetMonth> targetMonthList = targetMonthDAO.queryTargetMonth(targetMonthQuery);
            message.setData(targetMonthList);
        } catch (Exception e) {
            LOGGER.error("queryTargetMonth", "分页查询TargetMonth失败", e);
            message.setStatus(10001);
        }
        return message;
    }


    public MessageInfo<QueryResultInfo<TargetMonth>> queryTargetMonth(TargetMonthQuery targetMonthQuery) {
        MessageInfo<QueryResultInfo<TargetMonth>> message = new MessageInfo<QueryResultInfo<TargetMonth>>();
		try {
            QueryResultInfo<TargetMonth> queryResult = new QueryResultInfo<TargetMonth>();
			PageHelper.startPage(targetMonthQuery.getPageIndex(), targetMonthQuery.getPageSize());
			List<TargetMonth> targetMonthList = targetMonthDAO.queryTargetMonth(targetMonthQuery);
			PageInfo<TargetMonth> pageInfo = new PageInfo<TargetMonth>(targetMonthList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(targetMonthList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryTargetMonth", "分页查询TargetMonth失败", e);
			message.setStatus(10001);
		}
		return message;
	}

}