package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.IndexHeaderStatBiz;
import com.gi.ctdn.biz.UserIndustryBiz;
import com.gi.ctdn.pojo.IndexHeaderStat;
import com.gi.ctdn.pojo.me.UserIndustry;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zcy on 17-9-5.
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @Autowired
    private UserIndustryBiz userIndustryBiz;

    @Autowired
    private IndexHeaderStatBiz indexHeaderStatBiz;

    /**
     *查询用户关注行业
     * @return messageInfo
     */
    @RequestMapping("userIndustry/{userId}")
    @ResponseBody
    public MessageInfo<UserIndustry> getUserIndustry (@PathVariable("userId") Integer userId){
        MessageInfo<UserIndustry> messageInfo = userIndustryBiz.getUserIndustry(userId);
        return messageInfo;
    }

    /**
     *设置用户关注行业
     * @return messageInfo
     */
    @RequestMapping("updateUserIndustry")
    @ResponseBody
    public MessageInfo<UserIndustry> updateUserIndustry (@RequestBody UserIndustry userIndustry){
        MessageInfo messageInfo = userIndustryBiz.updateUserIndustry(userIndustry);
        return messageInfo;
    }

    @RequestMapping("queryIndexHeaderStat")
    @ResponseBody
    @Cacheable(value = "queryIndexHeaderStat",keyGenerator = "baseKG")
    public MessageInfo<IndexHeaderStat> queryIndexHeaderStat (){
        MessageInfo messageInfo = indexHeaderStatBiz.getIndexHeaderStat();
        return messageInfo;
    }
}
