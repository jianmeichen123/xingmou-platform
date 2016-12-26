package com.gi.xm.platform.restful;

import com.gi.xm.platform.mongodb.pojo.BaiduNews;
import com.gi.xm.platform.mongodb.query.BaiduNewsQuery;
import com.gi.xm.platform.mongodb.service.BaiduNewsService;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("news")
public class AreaController {

    @Autowired
    private BaiduNewsService baiduNewsService;

    @RequestMapping("query")
    @ResponseBody
    public MessageInfo<QueryResultInfo<BaiduNews>> page(@RequestBody BaiduNewsQuery baiduNewsQuery){
        return baiduNewsService.page(baiduNewsQuery);
    }
	
}
