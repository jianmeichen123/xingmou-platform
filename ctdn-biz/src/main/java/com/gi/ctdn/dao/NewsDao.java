package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wanghao on 17-11-3.
 */
public interface NewsDao {

    List<News> selectAll();

    List<News> selectByNewsType(@Param("newsTypeName") String newsTypeName);

    List<News> selectBylabels();

    List<News> selectNewsByLabel(@Param("label") String label);

}
