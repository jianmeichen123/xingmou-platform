

package com.gi.ctdn.ods.biz;

import com.gi.ctdn.ods.dao.RiskJudgmentDocumentDAO;
import com.gi.ctdn.ods.pojo.RiskJudgmentDocument;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("riskJudgmentDocumentBiz")
public class RiskJudgmentDocumentBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(RiskJudgmentDocumentBiz.class);

    @Autowired
	RiskJudgmentDocumentDAO riskJudgmentDocumentDAO;


		
	public  MessageInfo<List<RiskJudgmentDocument>>  getBySourceCode(String sourceCode){
		MessageInfo<List<RiskJudgmentDocument>> messageInfo = new MessageInfo<List<RiskJudgmentDocument>>();
		try {
			List<RiskJudgmentDocument> riskJudgmentDocumentList =  riskJudgmentDocumentDAO.selectBySourceCode(sourceCode);
			messageInfo.setData( riskJudgmentDocumentList);
		} catch (Exception e) {
			LOGGER.error("getBySourceCode","查询RiskJudgmentDocument失败", e);
			messageInfo.setStatus(MessageStatus.ERROR_CODE);
		}
		return messageInfo;
	}
		

}