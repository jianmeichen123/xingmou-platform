package com.gi.xm.platform.mongodb.service;

import com.gi.xm.platform.mongodb.pojo.BaiduNews;
import com.gi.xm.platform.mongodb.pojo.Page;

import java.util.List;

/**
 * Created by vincent on 16-8-22.
 */
public interface BaiduNewsService extends BaseService<BaiduNews,String>{

    List<BaiduNews> findListByName(String name,int limit,int skip);

    long findCountByName(String name);


    Page<BaiduNews> pageByName(String name,Page page);
}
