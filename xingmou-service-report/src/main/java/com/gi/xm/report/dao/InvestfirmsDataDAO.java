package com.gi.xm.report.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

import com.gi.xm.report.pojo.Area;
import org.apache.ibatis.annotations.Param;

import com.gi.xm.report.pojo.InvestfirmsData;

public interface InvestfirmsDataDAO {

    List<InvestfirmsData> queryInvestfirmsData(InvestfirmsData investfirmsDataQuery);

    List<Area> investfirmField();
    List<InvestfirmsData>top10InvestMoney();
    List<InvestfirmsData>top10InvestNum();
}