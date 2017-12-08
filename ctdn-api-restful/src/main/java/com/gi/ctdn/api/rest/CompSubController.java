package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.CompSubBiz;
import com.gi.ctdn.pojo.CompSub;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wanghao on 17-11-15.
 */
@Controller
@RequestMapping("compSub")
public class CompSubController {

    @Autowired
    CompSubBiz compSubBiz;

    @RequestMapping("getAllCompSubs/{compCode}")
    @ResponseBody
    public MessageInfo<List<CompSub>> getAllCompSubs(@PathVariable String compCode){
        MessageInfo<List<CompSub>>  messageInfo = compSubBiz.getCompSubList(compCode);
        return messageInfo;
    }

    /**
     *
     */
    @RequestMapping("getAllCompSubs")
    @ResponseBody
    public MessageInfo<CompSub> getAllCompSubs(@RequestBody CompSub compSub){
        MessageInfo<CompSub> messageInfo = compSubBiz.querycompSubList(compSub);
        return messageInfo;
    }
}
