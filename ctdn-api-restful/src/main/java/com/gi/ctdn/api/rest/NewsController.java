package com.gi.ctdn.api.rest;

import com.gi.ctdn.biz.NewsBiz;
import com.gi.ctdn.pojo.News;
import com.gi.ctdn.view.common.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wanghao on 17-11-3.
 */
@Controller
@RequestMapping("news")
public class NewsController {

    @Autowired
    NewsBiz newsBiz;

    @RequestMapping("getAllnews")
    @ResponseBody
    public MessageInfo<List<News>> getAllnews(){

        MessageInfo<List<News>> messageInfo = newsBiz.getAllnews();
        return  messageInfo;
    }

    @RequestMapping("getNewsByTypeName/{newsTypeName}")
    @ResponseBody
    public MessageInfo<List<News>> getNewsByTypeName(@PathVariable String newsTypeName){

        MessageInfo<List<News>> messageInfo = newsBiz.getNewsByNewsTypeName(newsTypeName);
        return  messageInfo;
    }

    @RequestMapping("getByLabels")
    @ResponseBody
    public MessageInfo<List<News>> getByLabels(){

        MessageInfo<List<News>> messageInfo = newsBiz.getNewsByLabels();
        return  messageInfo;
    }

    @RequestMapping("getNewsByLabel/{labels}")
    @ResponseBody
    public MessageInfo<List<News>> getNewsByLabel(@PathVariable String label){

        MessageInfo<List<News>> messageInfo = newsBiz.getNewsByLabel(label);
        return  messageInfo;
    }
}
