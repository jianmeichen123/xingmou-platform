package com.gi.xm.platform.mongodb.repositor;

import com.gi.xm.platform.mongodb.pojo.BaiduNews;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by vincent on 16-8-22.
 */
public interface BaiduNewsRepository extends MongoRepository<BaiduNews,String> {

}
