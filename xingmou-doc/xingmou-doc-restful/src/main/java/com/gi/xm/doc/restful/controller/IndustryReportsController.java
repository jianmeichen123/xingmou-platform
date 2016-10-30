package com.gi.xm.doc.restful.controller;


import com.gi.xm.doc.biz.IndustryReportsBiz;
import com.gi.xm.doc.pojo.IndustryReportsInfo;
import com.gi.xm.doc.query.IndustryReportsQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("share")
public class IndustryReportsController {

    @Autowired
	private IndustryReportsBiz industryReportsBiz;


	@RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<IndustryReportsInfo>>  queryIndustryReports (@RequestBody IndustryReportsQueryInfo industryReportsQueryInfo) {
		MessageInfo<QueryResultInfo<IndustryReportsInfo>> resultMessageInfo = industryReportsBiz.queryIndustryReports(industryReportsQueryInfo);
		if (resultMessageInfo != null && resultMessageInfo.getData()!= null && !resultMessageInfo.getData().getRecords().isEmpty()){
			for (IndustryReportsInfo industryReportsInfo:resultMessageInfo.getData().getRecords()){
					Integer sourceType = industryReportsInfo.getSourceType();
					if ( sourceType != null && sourceType == 2){
						industryReportsInfo.setSource("艾瑞网");
                        industryReportsInfo.setIcon("http://static.galaxyinternet.com/xm/doc"+industryReportsInfo.getIcon());
					}else if ( sourceType != null && sourceType == 1){
						industryReportsInfo.setSource("易观");
						industryReportsInfo.setIcon("http://static.galaxyinternet.com/xm/doc/analysys/report/errorBg.jpg");
					}

			}
		}
		return resultMessageInfo;
	}

    @RequestMapping("get/{id}")
    @ResponseBody
    @Cacheable(value = "industryReports",keyGenerator = "docKG")
	public MessageInfo<IndustryReportsInfo> industryReports(@PathVariable("id") Integer id ){
		MessageInfo<IndustryReportsInfo> messageInfo =  industryReportsBiz.getIndustryReports(id);
		if (messageInfo.isSuccess()&&messageInfo.getData()!=null){
			IndustryReportsInfo now = messageInfo.getData();
			MessageInfo<IndustryReportsInfo> pre = industryReportsBiz.prePage(now.getId());
			if (pre.isSuccess()){
				now.setPre(pre.getData());
			}
			MessageInfo<IndustryReportsInfo> next = industryReportsBiz.nextPage(now.getId());
			if (next.isSuccess()){
				now.setNext(next.getData());
			}
			String tagStr = now.getTags();
			if (tagStr != null){
				String[] tags = tagStr.split(",");
				if (tags!= null&&tags.length > 0){
					List<IndustryReportsInfo> tagLikeList = new ArrayList<>();
					for(String tag:tags){
						MessageInfo<List<IndustryReportsInfo>> tagLikes = industryReportsBiz.selectByTag(now.getId(),tag);
                        if (tagLikeList.size() >=3){
                            break;
                        }
						if (tagLikes.isSuccess()&&!tagLikes.getData().isEmpty()){
							tagLikeList.addAll(tagLikes.getData());
						}
					}
					now.setTagLikeList(tagLikeList);
				}
			}
		}
		return messageInfo;
	}

}
