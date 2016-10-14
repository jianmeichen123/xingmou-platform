package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.RoundInfo;
import com.gi.xm.platform.view.RoundQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.Round;
import com.gi.xm.platform.query.RoundQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class RoundConvertor {

	private static final BeanCopier beanCopierForRoundInfo = BeanCopier.create(Round.class, RoundInfo.class, false);
	private static final BeanCopier beanCopierForRound = BeanCopier.create(RoundInfo.class, Round.class, false);
	private static final BeanCopier beanCopierForRoundQuery = BeanCopier.create(RoundQueryInfo.class, RoundQuery.class, false);

	public static RoundInfo toRoundInfo(Round round)
	{
		if (round == null) {
			return null;
		}
		RoundInfo roundInfo = new RoundInfo();
		beanCopierForRoundInfo.copy(round, roundInfo, null);
		return roundInfo;
	}

	public static Round toRound(RoundInfo roundInfo)
	{
		Round round = new Round();
		beanCopierForRound.copy(roundInfo, round, null);
		return round;
	}

	public static List<RoundInfo> toRoundInfoList(List<Round> roundList)
	{
		if (roundList == null || roundList.isEmpty()) {
			return null;
		}
		List<RoundInfo> roundInfoList = new ArrayList<RoundInfo>(roundList.size());
		for (Round round : roundList) {
			roundInfoList.add(toRoundInfo(round));
		}
		return roundInfoList;
	}

	public static List<Round> toRoundList(List<RoundInfo> roundInfoList)
	{
		if (roundInfoList == null || roundInfoList.isEmpty()) {
			return null;
		}
		List<Round> roundList = new ArrayList<Round>(roundInfoList.size());
		for (RoundInfo roundInfo : roundInfoList) {
			roundList.add(toRound(roundInfo));
		}
		return roundList;
	}
	
	public static RoundQuery toRoundQuery(RoundQueryInfo roundQueryInfo)
	{
		if (roundQueryInfo== null) {
			return null;
		}
		RoundQuery roundQuery = new RoundQuery();
		beanCopierForRoundQuery.copy(roundQueryInfo, roundQuery, null);
		return roundQuery;
	}

	public static QueryResultInfo<RoundInfo> toQueryResultInfo(QueryResult<Round> queryResult)
	{
		QueryResultInfo<RoundInfo> queryResultInfo = new QueryResultInfo<RoundInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toRoundInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}