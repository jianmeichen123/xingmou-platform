package com.gi.xm.platform.mongodb.service.impl;

import com.gi.xm.platform.mongodb.pojo.BaiduNews;
import com.gi.xm.platform.mongodb.pojo.Page;
import com.gi.xm.platform.mongodb.repositor.BaiduNewsRepository;
import com.gi.xm.platform.mongodb.service.BaiduNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vincent on 16-8-22.
 */
@Service("baiduNewsServiceImpl")
public  class BaiduNewsServiceImpl extends BaseServiceImpl<BaiduNews,String> implements BaiduNewsService {

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
        List<BaiduNews> list = mongoTemplate.find(new Query(new Criteria().orOperator(Criteria.where("titlle").regex(name), Criteria.where("abs").regex(name))).skip(skip).limit(limit), BaiduNews.class);
        return list;
    }

    @Override
    public long findCountByName(String name) {
        long count = mongoTemplate.count(new Query(new Criteria().orOperator(Criteria.where("titlle").regex(name), Criteria.where("abs").regex(name))), BaiduNews.class);
        return count;

    }

    @Override
    public Page<BaiduNews> pageByName(String name, Page page) {
        int limit = page.getPageSize();
        int skip = (page.getPageNow()-1)*page.getPageSize();
        long count = findCountByName(name);
        if (count >0){
            List<BaiduNews> list = findListByName(name,skip,limit);
            page.setData(list);
        }
        page.setLimit(limit);
        page.setSkip(skip);
        page.setPageTotal(count);
        return page;
    }


}