package com.gi.ctdn.restful;


import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.QueryResultInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gi.ctdn.mongodb.query.BaiduNewsQuery;
import com.gi.ctdn.mongodb.service.BaiduNewsService;
import com.gi.ctdn.mongodb.pojo.BaiduNews;

@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    private BaiduNewsService baiduNewsService;

    @RequestMapping("query")
    @ResponseBody
    @ApiOperation(value = "百度新闻")
    public MessageInfo<QueryResultInfo<BaiduNews>> page(@RequestBody BaiduNewsQuery baiduNewsQuery){
        
        return baiduNewsService.page(baiduNewsQuery);
    }
	
}
