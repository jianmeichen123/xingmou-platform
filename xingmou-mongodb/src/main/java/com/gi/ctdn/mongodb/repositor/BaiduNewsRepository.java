package com.gi.ctdn.mongodb.repositor;

import com.gi.ctdn.mongodb.pojo.BaiduNews;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vincent on 16-8-22.
 */
@Repository
public interface BaiduNewsRepository extends MongoRepository<BaiduNews,String> {

}
