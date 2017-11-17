package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.CompSub;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wanghao on 17-11-15.
 */
public interface CompSubDao {
    List<CompSub> selectCompSubs(@Param("compCode") String compCode);
}
