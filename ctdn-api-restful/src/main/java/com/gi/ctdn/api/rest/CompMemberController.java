package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.CompMemberBiz;
import com.gi.ctdn.pojo.CompMember;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wanghao on 17-11-15.
 */
@Controller
@RequestMapping("compMember")
public class CompMemberController {

    @Autowired
    CompMemberBiz compMemberBiz;

    @RequestMapping("getAllCompMember/{compCode}")
    @ResponseBody
    public MessageInfo<List<CompMember>> getAllCompMember(@PathVariable String compCode){
        MessageInfo<List<CompMember>>  messageInfo = compMemberBiz.getCompMemberList(compCode);
        return messageInfo;
    }
}
