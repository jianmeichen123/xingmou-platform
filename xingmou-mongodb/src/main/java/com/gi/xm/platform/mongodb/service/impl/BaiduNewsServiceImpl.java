package com.gi.xm.platform.mongodb.service.impl;

import com.gi.xm.platform.mongodb.pojo.BaiduNews;
import com.gi.xm.platform.mongodb.query.BaiduNewsQuery;
import com.gi.xm.platform.mongodb.repositor.BaiduNewsRepository;
import com.gi.xm.platform.mongodb.service.BaiduNewsService;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vincent on 16-8-22.
 */
@Service("baiduNewsService")
public  class BaiduNewsServiceImpl extends BaseServiceImpl<BaiduNews,String> implements BaiduNewsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaiduNewsServiceImpl.class);


    @Autowired
    private BaiduNewsRepository baiduNewsRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public MongoRepository<BaiduNews, String> getBaseRepository() {
        return baiduNewsRepository;
    }


    @Override
    public List<BaiduNews> findListByName(String name,int limit,int skip) {
        List<BaiduNews> list = mongoTemplate.find(new Query(new Criteria().orOperator(Criteria.where("titlle").regex(name))).skip(skip).limit(limit), BaiduNews.class);
        return list;
    }

    @Override
    public long findCountByName(String name) {
        long count = mongoTemplate.count(new Query(new Criteria().orOperator(Criteria.where("titlle").regex(name), Criteria.where("abs").regex(name))), BaiduNews.class);
        return count;

    }




    @Override
    public MessageInfo<QueryResultInfo<BaiduNews>> page(BaiduNewsQuery baiduNewsQuery) {
        int limit = baiduNewsQuery.getPageSize();
        int skip = (baiduNewsQuery.getPageIndex()-1)*baiduNewsQuery.getPageSize();
        MessageInfo<QueryResultInfo<BaiduNews>> messageInfo = new MessageInfo<>();
        Query query = new Query();
        try {
            long count = mongoTemplate.count(query,BaiduNews.class);
            QueryResultInfo<BaiduNews> resultInfo = new QueryResultInfo<>();
            resultInfo.setTotal(count);
            resultInfo.setPages(baiduNewsQuery.getPageIndex());
            if (count >0){
                query.with(new Sort(Sort.Direction.DESC,"sortTime"));
                query.skip(skip).limit(limit);
                List<BaiduNews> list = mongoTemplate.find(query,BaiduNews.class);
                resultInfo.setRecords(list);
                messageInfo.setData(resultInfo);
            }

        } catch (Exception e) {
            LOGGER.error("BaiduNewsService","page", e);
            messageInfo.setStatus(10001);
            messageInfo.setMessage("系统繁忙请稍后");
        }
        return messageInfo;
    }


    @Override
    public MessageInfo<QueryResultInfo<BaiduNews>> pageByName(BaiduNewsQuery query) {
        int limit = query.getPageSize();
        int skip = (query.getPageIndex()-1)*query.getPageSize();
        MessageInfo<QueryResultInfo<BaiduNews>> messageInfo = new MessageInfo<>();
        try {
            long count = findCountByName(query.getName());
            QueryResultInfo<BaiduNews> resultInfo = new QueryResultInfo<>();
            resultInfo.setTotal(count);
            resultInfo.setPages(query.getPageIndex());
            if (count >0){
                List<BaiduNews> list = findListByName(query.getName(),skip,limit);
                resultInfo.setRecords(list);
                messageInfo.setData(resultInfo);
            }

        } catch (Exception e) {
            LOGGER.error("getCompany","pageByName", e);
            messageInfo.setStatus(10001);
            messageInfo.setMessage("系统繁忙请稍后");
        }
        return messageInfo;
    }


}