

package com.gi.ctdn.ods.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gi.ctdn.ods.dao.OpIndiceSummaryDAO;
import com.gi.xm.platform.view.common.MessageStatus;
import com.gi.xm.platform.view.common.MessageInfo;

import com.gi.ctdn.ods.pojo.OpIndiceSummary;

@Service("opIndiceSummaryBiz")
public class OpIndiceSummaryBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(OpIndiceSummaryBiz.class);

    @Autowired
	OpIndiceSummaryDAO opIndiceSummaryDAO;


		
	public MessageInfo<List<OpIndiceSummary>> getListByCode(String code){

		MessageInfo<List<OpIndiceSummary>> messageInfo = new MessageInfo<List<OpIndiceSummary>>();
		try {
			List<OpIndiceSummary> opIndiceSummaryList = opIndiceSummaryDAO.selectByCode(code);
			messageInfo.setData(opIndiceSummaryList);
		} catch (Exception e) {
			LOGGER.error("getListByCode","查询OpIndiceSummary失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}

}