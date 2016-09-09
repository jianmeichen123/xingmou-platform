package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.PostionInfo;
import com.gi.xm.platform.view.PostionQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.Postion;
import com.gi.xm.platform.query.PostionQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class PostionConvertor {

	private static final BeanCopier beanCopierForPostionInfo = BeanCopier.create(Postion.class, PostionInfo.class, false);
	private static final BeanCopier beanCopierForPostion = BeanCopier.create(PostionInfo.class, Postion.class, false);
	private static final BeanCopier beanCopierForPostionQuery = BeanCopier.create(PostionQueryInfo.class, PostionQuery.class, false);

	public static PostionInfo toPostionInfo(Postion postion)
	{
		if (postion == null) {
			return null;
		}
		PostionInfo postionInfo = new PostionInfo();
		beanCopierForPostionInfo.copy(postion, postionInfo, null);
		return postionInfo;
	}

	public static Postion toPostion(PostionInfo postionInfo)
	{
		Postion postion = new Postion();
		beanCopierForPostion.copy(postionInfo, postion, null);
		return postion;
	}

	public static List<PostionInfo> toPostionInfoList(List<Postion> postionList)
	{
		if (postionList == null || postionList.isEmpty()) {
			return null;
		}
		List<PostionInfo> postionInfoList = new ArrayList<PostionInfo>(postionList.size());
		for (Postion postion : postionList) {
			postionInfoList.add(toPostionInfo(postion));
		}
		return postionInfoList;
	}

	public static List<Postion> toPostionList(List<PostionInfo> postionInfoList)
	{
		if (postionInfoList == null || postionInfoList.isEmpty()) {
			return null;
		}
		List<Postion> postionList = new ArrayList<Postion>(postionInfoList.size());
		for (PostionInfo postionInfo : postionInfoList) {
			postionList.add(toPostion(postionInfo));
		}
		return postionList;
	}
	
	public static PostionQuery toPostionQuery(PostionQueryInfo postionQueryInfo)
	{
		if (postionQueryInfo== null) {
			return null;
		}
		PostionQuery postionQuery = new PostionQuery();
		beanCopierForPostionQuery.copy(postionQueryInfo, postionQuery, null);
		return postionQuery;
	}

	public static QueryResultInfo<PostionInfo> toQueryResultInfo(QueryResult<Postion> queryResult)
	{
		QueryResultInfo<PostionInfo> queryResultInfo = new QueryResultInfo<PostionInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toPostionInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}