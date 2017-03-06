package com.gi.ctdn.restful.controller;

import com.gi.ctdn.biz.IndustryLabelBiz;
import com.gi.ctdn.biz.ProjectContactBiz;
import com.gi.ctdn.pojo.IndustryLabel;
import com.gi.ctdn.pojo.ProjectContactInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import org.springframework.asm.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zcy on 17-2-20.
 */
@Controller
@RequestMapping("labels")
public class LabelController {

    @Autowired
    private IndustryLabelBiz labelBiz;

    /**
     * 查询projectId下的联系我们
     */
    @RequestMapping("queryLabel")
    @ResponseBody
    public MessageInfo<List<IndustryLabel>> queryLabel(@RequestBody IndustryLabel industryLabel){
        MessageInfo<List<IndustryLabel>> messageInfo = new MessageInfo<List<IndustryLabel>>();
        messageInfo = labelBiz.queryLabel(industryLabel);
        return messageInfo;
    }
}

