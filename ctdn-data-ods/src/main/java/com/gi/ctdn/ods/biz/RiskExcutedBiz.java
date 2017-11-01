

package com.gi.ctdn.ods.biz;

import com.gi.ctdn.ods.dao.RiskExcutedDAO;
import com.gi.ctdn.ods.pojo.RiskExcuted;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import com.gi.ctdn.view.common.QueryResultInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("riskExcutedBiz")
public class RiskExcutedBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(RiskExcutedBiz.class);

    @Autowired
	RiskExcutedDAO riskExcutedDAO;

	public MessageInfo<QueryResultInfo<RiskExcuted>> queryByPage(RiskExcuted riskExcuted){

		MessageInfo<QueryResultInfo<RiskExcuted>> message = new MessageInfo<QueryResultInfo<RiskExcuted>>();
		try {
			QueryResultInfo<RiskExcuted> queryResult = new QueryResultInfo<RiskExcuted>();
			PageHelper.startPage(riskExcuted.getPageIndex(), riskExcuted.getPageSize());
			List<RiskExcuted> ls = riskExcutedDAO.queryByPage(riskExcuted);
			PageInfo<RiskExcuted> pageInfo = new PageInfo<RiskExcuted>(ls);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(ls);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryBySourceCode", "分页查询RiskExcuted失败", e);
			message.setStatus(MessageStatus.ERROR_CODE);
		}
		return message;
	}
}