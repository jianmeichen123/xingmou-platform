package com.gi.ctdn.ods.dao;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.gi.ctdn.ods.pojo.RiskJudgmentDocument;

public interface RiskJudgmentDocumentDAO {


	List<RiskJudgmentDocument> selectBySourceCode(@Param("sourceCode") String sourceCode);
		
}