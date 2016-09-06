package com.gi.xm.platform.dao;

import com.gi.xm.platform.pojo.Pojo;

/**
 * Created by vincent on 16-8-19.
 */
public interface BaseDAO<T extends Pojo> {

    T selectByid(Long id);
}
