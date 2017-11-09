package com.gi.ctdn.biz;

import com.gi.ctdn.dao.NewsDao;
import com.gi.ctdn.pojo.News;
import com.gi.ctdn.view.common.MessageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wanghao on 17-11-3.
 */
@Service("newsBiz")
public class NewsBiz {

    private static final Logger LOGGER = LoggerFactory.getLogger(NewsBiz.class);

    @Autowired
    NewsDao newsDao;


    public MessageInfo<List<News>> getAllnews(){

        MessageInfo<List<News>> messageInfo = new MessageInfo<List<News>>();
        try {
            List<News> newsList = newsDao.selectAll();
            messageInfo.setData( newsList);
        } catch (Exception e) {
            LOGGER.error("getAllnews","查询全部news失败", e);
            messageInfo.setStatus(10001);
        }
        return messageInfo;
    }

    public MessageInfo<List<News>> getNewsByNewsTypeName(String newsTypeName){

        MessageInfo<List<News>> messageInfo = new MessageInfo<List<News>>();
        try {
            List<News> newsList = newsDao.selectByNewsType(newsTypeName);
            messageInfo.setData( newsList);
        } catch (Exception e) {
            LOGGER.error("getNewsByTypeName","查询news失败", e);
            messageInfo.setStatus(10001);
        }
        return messageInfo;
    }

    public MessageInfo<List<News>> getNewsByLabels(){

        MessageInfo<List<News>> messageInfo = new MessageInfo<List<News>>();
        try {
            List<News> newsList = newsDao.selectBylabels();
            messageInfo.setData( newsList);
        } catch (Exception e) {
            LOGGER.error("getNewsByLabels","查询news失败", e);
            messageInfo.setStatus(10001);
        }
        return messageInfo;
    }

    public MessageInfo<List<News>> getNewsByLabel(String label){

        MessageInfo<List<News>> messageInfo = new MessageInfo<List<News>>();
        try {
            List<News> newsList = newsDao.selectNewsByLabel(label);
            messageInfo.setData( newsList);
        } catch (Exception e) {
            LOGGER.error("getNewsByLabel","查询news失败", e);
            messageInfo.setStatus(10001);
        }
        return messageInfo;
    }
}
