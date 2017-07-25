

package com.gi.ctdn.ods.biz;

import com.gi.ctdn.ods.dao.RiskOperationExceptionDAO;
import com.gi.ctdn.ods.pojo.RiskOperationException;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("riskOperationExceptionBiz")
public class RiskOperationExceptionBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(RiskOperationExceptionBiz.class);

    @Autowired
	RiskOperationExceptionDAO riskOperationExceptionDAO;


		
	public MessageInfo<List<RiskOperationException>> getBySourceCode(String sourceCode){
		MessageInfo<List<RiskOperationException>> messageInfo = new MessageInfo<List<RiskOperationException>>();
		try {
			List<RiskOperationException> riskOperationExceptionList = riskOperationExceptionDAO.selectBySourceCode(sourceCode);
			messageInfo.setData( riskOperationExceptionList);
		} catch (Exception e) {
			LOGGER.error("getBySourceCode","查询RiskOperationException失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
}