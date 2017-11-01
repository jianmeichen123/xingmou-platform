package com.gi.ctdn.mongodb.service.impl;

import com.gi.ctdn.mongodb.pojo.Pojo;
import com.gi.ctdn.mongodb.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vincent on 16-8-22.
 */
@NoRepositoryBean
public abstract  class BaseServiceImpl<S extends Pojo,ID extends Serializable> implements BaseService<S,String> {

    @Override
    public <S1 extends S> S1 save(S1 entity) {
        return getBaseRepository().save(entity);
    }

    @Override
    public S findOne(String s) {
        return getBaseRepository().findOne(s);
    }

    @Override
    public boolean exists(String s) {
        return getBaseRepository().exists(s);
    }

    @Override
    public Iterable<S> findAll(Iterable<String> strings) {
        return getBaseRepository().findAll(strings);
    }

    @Override
    public long count() {
        return getBaseRepository().count();
    }

    @Override
    public void delete(String s) {
        getBaseRepository().delete(s);
    }

    @Override
    public void delete(S entity) {
        getBaseRepository().delete(entity);
    }

    @Override
    public void delete(Iterable<? extends S> entities) {
        getBaseRepository().delete(entities);
    }

    @Override
    public Page<S> findAll(Pageable pageable) {
        return getBaseRepository().findAll(pageable);
    }

    @Override
    public <S1 extends S> List<S1> save(Iterable<S1> entites) {
        return getBaseRepository().save(entites);
    }

    @Override
    public List<S> findAll(Sort sort) {
        return getBaseRepository().findAll(sort);
    }

    @Override
    public <S1 extends S> S1 insert(S1 entity) {
        return insert(entity);
    }

    @Override
    public <S1 extends S> List<S1> insert(Iterable<S1> entities) {
        return insert(entities);
    }
}