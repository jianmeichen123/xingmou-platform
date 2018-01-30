package com.gi.ctdn.dao;

import com.gi.ctdn.pojo.ListedExchange;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ListedExchangeDAO {
    List<ListedExchange> selectListedExchangeList();
}
