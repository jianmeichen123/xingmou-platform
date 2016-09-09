package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.LabelInfo;
import com.gi.xm.platform.view.LabelQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.Label;
import com.gi.xm.platform.query.LabelQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class LabelConvertor {

	private static final BeanCopier beanCopierForLabelInfo = BeanCopier.create(Label.class, LabelInfo.class, false);
	private static final BeanCopier beanCopierForLabel = BeanCopier.create(LabelInfo.class, Label.class, false);
	private static final BeanCopier beanCopierForLabelQuery = BeanCopier.create(LabelQueryInfo.class, LabelQuery.class, false);

	public static LabelInfo toLabelInfo(Label label)
	{
		if (label == null) {
			return null;
		}
		LabelInfo labelInfo = new LabelInfo();
		beanCopierForLabelInfo.copy(label, labelInfo, null);
		return labelInfo;
	}

	public static Label toLabel(LabelInfo labelInfo)
	{
		Label label = new Label();
		beanCopierForLabel.copy(labelInfo, label, null);
		return label;
	}

	public static List<LabelInfo> toLabelInfoList(List<Label> labelList)
	{
		if (labelList == null || labelList.isEmpty()) {
			return null;
		}
		List<LabelInfo> labelInfoList = new ArrayList<LabelInfo>(labelList.size());
		for (Label label : labelList) {
			labelInfoList.add(toLabelInfo(label));
		}
		return labelInfoList;
	}

	public static List<Label> toLabelList(List<LabelInfo> labelInfoList)
	{
		if (labelInfoList == null || labelInfoList.isEmpty()) {
			return null;
		}
		List<Label> labelList = new ArrayList<Label>(labelInfoList.size());
		for (LabelInfo labelInfo : labelInfoList) {
			labelList.add(toLabel(labelInfo));
		}
		return labelList;
	}
	
	public static LabelQuery toLabelQuery(LabelQueryInfo labelQueryInfo)
	{
		if (labelQueryInfo== null) {
			return null;
		}
		LabelQuery labelQuery = new LabelQuery();
		beanCopierForLabelQuery.copy(labelQueryInfo, labelQuery, null);
		return labelQuery;
	}

	public static QueryResultInfo<LabelInfo> toQueryResultInfo(QueryResult<Label> queryResult)
	{
		QueryResultInfo<LabelInfo> queryResultInfo = new QueryResultInfo<LabelInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toLabelInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}