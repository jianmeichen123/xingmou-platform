package com.gi.xm.platform.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.facede.FilesFacede;
import com.gi.xm.platform.facede.InvestfirmsFacede;
import com.gi.xm.platform.view.FilesInfo;
import com.gi.xm.platform.view.InvestfirmsInfo;
import com.gi.xm.platform.view.InvestfirmsQueryInfo;
import com.gi.xm.platform.view.ProjectInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.report.biz.InvestfirmsDataBiz;
import com.gi.xm.report.pojo.Area;
import com.gi.xm.report.pojo.InvestfirmsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("tzjg")
public class InvestfirmsDataController {

	@Autowired
	private InvestfirmsDataBiz investfirmsDataBiz;

	@Reference
	private FilesFacede filesFacede;

	@RequestMapping("search")
	@ResponseBody
	public MessageInfo<QueryResultInfo<InvestfirmsData>>  queryInvestfirms (@RequestBody InvestfirmsData investfirmsData) {
		if (investfirmsData.getOrder() != null&&investfirmsData.getOrderBy() != null){
			if (investfirmsData.getOrderBy().equalsIgnoreCase("createDate")){
				investfirmsData.setOrderBy("create_date");
			}else if (investfirmsData.getOrderBy().equalsIgnoreCase("investMonthRate")) {
				investfirmsData.setOrderBy("invest_month_rate");
			}else if (investfirmsData.getOrderBy().equalsIgnoreCase("investMoney")) {
				investfirmsData.setOrderBy("invest_money");
			}else if (investfirmsData.getOrderBy().equalsIgnoreCase("investNum")) {
				investfirmsData.setOrderBy("invest_num");
			}else {
				investfirmsData.setOrderBy("create_date");
			}
		}

		MessageInfo<QueryResultInfo<InvestfirmsData>> resultMessageInfo = investfirmsDataBiz.queryInvestfirmsData(investfirmsData);

        if (resultMessageInfo.isSuccess()&&resultMessageInfo.getData()!=null&&!resultMessageInfo.getData().getRecords().isEmpty()){
            List<Long> sourceIds = new ArrayList<>();
            List<InvestfirmsData> investfirmsDatas = resultMessageInfo.getData().getRecords();
            for (InvestfirmsData i: investfirmsDatas){
                i.setPic("/investfirms/pic/"+i.getSourceId()+".png");
                if(i.getSourceId()!=null){
                    sourceIds.add(i.getSourceId());
                }
            }
            MessageInfo<List<FilesInfo>> fileMessageInfo = filesFacede.getListBySourceIdsType(sourceIds,2);
            if(fileMessageInfo.isSuccess()&&fileMessageInfo.getData()!=null&&!fileMessageInfo.getData().isEmpty()){
                for(FilesInfo filesInfo :fileMessageInfo.getData()){
                    for (InvestfirmsData i: investfirmsDatas){
                        if (i.getSourceId()!=null&&filesInfo.getPic()!=null&&filesInfo.getSourceId().intValue()==i.getSourceId()){
                            i.setPic(filesInfo.getPic());
                        }
                    }
                }
            }

        }

        return resultMessageInfo;
	}
	@RequestMapping("top10InvestMoney")
	@ResponseBody
    @Cacheable(value = "top10InvestMoney",keyGenerator = "api")
	public  MessageInfo<List<InvestfirmsData>>  top10InvestMoney () {
		MessageInfo<List<InvestfirmsData>> resultMessageInfo = investfirmsDataBiz.top10InvestMoney();
		return resultMessageInfo;
	}

	@RequestMapping("top10InvestNum")
	@ResponseBody
    @Cacheable(value = "top10InvestNum",keyGenerator = "api")
    public  MessageInfo<List<InvestfirmsData>>  top10InvestNum () {
		MessageInfo<List<InvestfirmsData>> resultMessageInfo = investfirmsDataBiz.top10InvestNum();
		return resultMessageInfo;
	}


	@RequestMapping("investfirmField")
	@ResponseBody
    @Cacheable(value = "investfirmField",keyGenerator = "api")
	public  MessageInfo<List<Area>> investfirmField() {
		MessageInfo<List<Area>> resultMessageInfo = investfirmsDataBiz.investfirmField();
		return resultMessageInfo;
	}


}
