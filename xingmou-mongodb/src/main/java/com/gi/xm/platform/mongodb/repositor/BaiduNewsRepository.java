package com.gi.xm.platform.mongodb.repositor;

import com.gi.xm.platform.mongodb.pojo.BaiduNews;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vincent on 16-8-22.
 */
@Repository
public interface BaiduNewsRepository extends MongoRepository<BaiduNews,String> {

}
