package com.gi.xm.platform.mongodb.service;

import com.gi.xm.platform.mongodb.pojo.Pojo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.Serializable;
import java.util.List;


/**
 * Created by vincent on 16-8-22.
 */
public interface BaseService<T extends Pojo, ID extends Serializable> {

    MongoRepository<T,ID> getBaseRepository();

    <S extends T> S save(S entity);

    //<S extends T> Iterable<S> save(Iterable<S> entities);

    T findOne(ID id);

    boolean exists(ID id);

    //Iterable<T> findAll();

    Iterable<T> findAll(Iterable<ID> ids);

    long count();

    void delete(ID id);

    void delete(T entity);

    void delete(Iterable<? extends T> entities);

    //void deleteAll();

   // Iterable<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);

    <S extends T> List<S> save(Iterable<S> entites);

    //List<T> findAll();

    List<T> findAll(Sort sort);

    <S extends T> S insert(S entity);

    <S extends T> List<S> insert(Iterable<S> entities);
}
