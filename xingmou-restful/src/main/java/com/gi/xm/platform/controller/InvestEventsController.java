package com.gi.xm.platform.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.facede.InvestEventsFacede;
import com.gi.xm.platform.view.InvestEventsInfo;
import com.gi.xm.platform.view.InvestEventsQueryInfo;
import com.gi.xm.platform.view.InvestfirmsQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

@Controller
@RequestMapping("investEvents")
public class InvestEventsController {

	@Reference(check = false)
	private InvestEventsFacede investEventsFacede;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestEventsInfo>>  queryInvestEvents (@RequestBody InvestEventsQueryInfo investEventsQueryInfo) {
		
		 if(investEventsQueryInfo.getCreateDateEnd()!=null){
			 investEventsQueryInfo.setCreateDateEnd(((Integer.parseInt(investEventsQueryInfo.getCreateDateEnd())+1)+""));
	        }

	        if (investEventsQueryInfo.getOrder() != null&&investEventsQueryInfo.getOrderBy() != null){
				 if (investEventsQueryInfo.getOrderBy().equalsIgnoreCase("moneyNum")) {
					investEventsQueryInfo.setOrderBy("money_num");
				}else  if(investEventsQueryInfo.getOrderBy().equalsIgnoreCase("investDate")){
	                investEventsQueryInfo.setOrderBy("invest_date");
	            }
			}else {
				investEventsQueryInfo.setOrder("desc");
				investEventsQueryInfo.setOrderBy("invest_date");
			}
	    MessageInfo<QueryResultInfo<InvestEventsInfo>> resultMessageInfo = investEventsFacede.queryInvestEvents(investEventsQueryInfo);
	    return resultMessageInfo;
	}
/*

    @RequestMapping("create")
    @ResponseBody
    public MessageInfo<Long> createInvestEvents(InvestEventsInfo investEventsInfo){
        MessageInfo<Long> messageInfo =  investEventsFacede.createInvestEvents(investEventsInfo);
        return messageInfo;
    }

    @RequestMapping("update")
    @ResponseBody
	public MessageInfo<Integer> updateInvestEvents(InvestEventsInfo investEventsInfo){
		MessageInfo<Integer> messageInfo =  investEventsFacede.updateInvestEvents(investEventsInfo);
		return messageInfo;
	} 
*/

    @RequestMapping("get")
    @ResponseBody
	public MessageInfo<InvestEventsInfo> getInvestEvents( Long id ){
		MessageInfo<InvestEventsInfo> messageInfo =  investEventsFacede.getInvestEvents(id);
		return messageInfo;
	}
/*

    @RequestMapping("getAll")
    @ResponseBody
    public MessageInfo<List<InvestEventsInfo>> getAllInvestEvents(){
		MessageInfo<List<InvestEventsInfo>>  messageInfo = investEventsFacede.getAllInvestEvents();
		return messageInfo;
	}
*/

    @RequestMapping("getEventByInvestfirmId")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestEventsInfo>>  getEventByInvestfirmId (@RequestBody InvestfirmsQueryInfo investfirmsQueryInfo) {
		MessageInfo<QueryResultInfo<InvestEventsInfo>> resultMessageInfo = investEventsFacede.getEventByInvestfirmId(investfirmsQueryInfo);
		return resultMessageInfo;
	}



	@RequestMapping("getListByProjectId/{projectId}")
	@ResponseBody
	public MessageInfo<List<InvestEventsInfo>> getListByProjectId(@PathVariable("projectId") Long projectId){
		MessageInfo<List<InvestEventsInfo>> messageInfo = investEventsFacede.getListByProjectId(projectId);
		return messageInfo;
	}
}
