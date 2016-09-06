package com.gi.xm.platform.newsmange.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.facede.DmCompanyFacede;
import com.gi.xm.platform.mongodb.pojo.BaiduNews;
import com.gi.xm.platform.mongodb.pojo.Page;
import com.gi.xm.platform.mongodb.service.BaiduNewsService;
import com.gi.xm.platform.view.DmCompanyInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vincent on 16-8-22.
 */
@RestController
@RequestMapping("/newsManage")
public class NewsController {


    @Autowired
    private BaiduNewsService baiduNewsService;

    @Reference()
    private DmCompanyFacede dmCompanyFacede;

    @ResponseBody
    @RequestMapping("/findById/{id}" )
    public MessageInfo<DmCompanyInfo> findById(@PathVariable Long id) {
        MessageInfo<DmCompanyInfo> messageInfo = dmCompanyFacede.getDmCompany(id);
        return messageInfo;

    }


        @ResponseBody
    @RequestMapping("/pageByName/{name}/{pageSize}/{pageNow}" )
    public Page<BaiduNews> pageByName(@PathVariable("name") String name,@PathVariable("pageSize") int pageSize,@PathVariable("pageNow") int pageNow) {
        Page param = new Page();
        param.setPageNow(pageNow);
        param.setPageSize(pageSize);
        Page<BaiduNews> page = baiduNewsService.pageByName(name,param);
        return page;

    }
}

