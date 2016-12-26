package com.gi.xm.platform.mongodb.service;

import com.gi.xm.platform.mongodb.pojo.BaiduNews;
import com.gi.xm.platform.mongodb.query.BaiduNewsQuery;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import java.util.List;

/**
 * Created by vincent on 16-8-22.
 */
public interface BaiduNewsService extends BaseService<BaiduNews,String>{

    List<BaiduNews> findListByName(String name,int limit,int skip);

    long findCountByName(String name);

    MessageInfo<QueryResultInfo<BaiduNews>> pageByName(BaiduNewsQuery baiduNewsQuery);


     MessageInfo<QueryResultInfo<BaiduNews>> page(BaiduNewsQuery query);

}
