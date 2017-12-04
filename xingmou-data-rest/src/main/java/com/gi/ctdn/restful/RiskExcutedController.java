package com.gi.ctdn.restful;

import com.gi.ctdn.ods.biz.*;
import com.gi.ctdn.ods.pojo.*;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("risk")
public class RiskExcutedController {

    @Autowired
	private RiskExcutedBiz riskExcutedBiz;

    @Autowired
	private RiskCourtAnnouncementBiz riskCourtAnnouncementBiz;

    @Autowired
	private RiskDishonestyExcutedBiz riskDishonestyExcutedBiz;

    @Autowired
	private RiskJudgmentDocumentBiz riskJudgmentDocumentBiz;

    @Autowired
	private RiskOperationExceptionBiz riskOperationExceptionBiz;

//	@RequestMapping("queryExcutedByPage")
//	@ResponseBody
//	public MessageInfo<QueryResultInfo<RiskExcuted>> queryExcutedByPage (@RequestBody RiskExcuted riskExcuted) {
//		MessageInfo<QueryResultInfo<RiskExcuted>> resultMessageInfo = riskExcutedBiz.queryByPage(riskExcuted);
//		return resultMessageInfo;
//	}

	@RequestMapping("queryCourtAnnouncement/{sourceCode}")
	@ResponseBody
	public MessageInfo<List<RiskCourtAnnouncement>> queryCourtAnnouncement(@PathVariable("sourceCode") String sourceCode){
		MessageInfo<List<RiskCourtAnnouncement>> messageInfo = riskCourtAnnouncementBiz.getBysourceCode(sourceCode);
		return messageInfo;
	}

	@RequestMapping("queryDishonestyExcuted/{sourceCode}")
	@ResponseBody
	public MessageInfo<List<RiskDishonestyExcuted>> queryDishonestyExcuted(@PathVariable("sourceCode") String sourceCode){
		MessageInfo<List<RiskDishonestyExcuted>> messageInfo = riskDishonestyExcutedBiz.getBySourceCode(sourceCode);
		return messageInfo;
	}

	@RequestMapping("queryRiskJudgmentDocument/{sourceCode}")
	@ResponseBody
	public MessageInfo<List<RiskJudgmentDocument>> queryRiskJudgmentDocument(@PathVariable("sourceCode") String sourceCode){
		MessageInfo<List<RiskJudgmentDocument>> messageInfo = riskJudgmentDocumentBiz.getBySourceCode(sourceCode);
		return messageInfo;
	}

	@RequestMapping("queryOperationException/{sourceCode}")
	@ResponseBody
	public MessageInfo<List<RiskOperationException>> queryOperationException(@PathVariable("sourceCode") String sourceCode){
		MessageInfo<List<RiskOperationException>> messageInfo = riskOperationExceptionBiz.getBySourceCode(sourceCode);
		return messageInfo;
	}
}
