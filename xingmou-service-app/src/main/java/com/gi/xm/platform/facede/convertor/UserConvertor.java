/*
package com.gi.xm.platform.facede.convertor;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import org.springframework.cglib.beans.BeanCopier;

import com.gi.xm.platform.view.UserInfo;
import com.gi.xm.platform.view.UserQueryInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import com.gi.xm.platform.pojo.User;
import com.gi.xm.platform.query.UserQuery;
import com.gi.xm.platform.biz.common.QueryResult;

public abstract class UserConvertor {

	private static final BeanCopier beanCopierForUserInfo = BeanCopier.create(User.class, UserInfo.class, false);
	private static final BeanCopier beanCopierForUser = BeanCopier.create(UserInfo.class, User.class, false);
	private static final BeanCopier beanCopierForUserQuery = BeanCopier.create(UserQueryInfo.class, UserQuery.class, false);

	public static UserInfo toUserInfo(User user)
	{
		if (user == null) {
			return null;
		}
		UserInfo userInfo = new UserInfo();
		beanCopierForUserInfo.copy(user, userInfo, null);
		return userInfo;
	}

	public static User toUser(UserInfo userInfo)
	{
		User user = new User();
		beanCopierForUser.copy(userInfo, user, null);
		return user;
	}

	public static List<UserInfo> toUserInfoList(List<User> userList)
	{
		if (userList == null || userList.isEmpty()) {
			return null;
		}
		List<UserInfo> userInfoList = new ArrayList<UserInfo>(userList.size());
		for (User user : userList) {
			userInfoList.add(toUserInfo(user));
		}
		return userInfoList;
	}

	public static List<User> toUserList(List<UserInfo> userInfoList)
	{
		if (userInfoList == null || userInfoList.isEmpty()) {
			return null;
		}
		List<User> userList = new ArrayList<User>(userInfoList.size());
		for (UserInfo userInfo : userInfoList) {
			userList.add(toUser(userInfo));
		}
		return userList;
	}
	
	public static UserQuery toUserQuery(UserQueryInfo userQueryInfo)
	{
		if (userQueryInfo== null) {
			return null;
		}
		UserQuery userQuery = new UserQuery();
		beanCopierForUserQuery.copy(userQueryInfo, userQuery, null);
		return userQuery;
	}

	public static QueryResultInfo<UserInfo> toQueryResultInfo(QueryResult<User> queryResult)
	{
		QueryResultInfo<UserInfo> queryResultInfo = new QueryResultInfo<UserInfo>();
		queryResultInfo.setPages(queryResult.getPages());
		queryResult.setRecords(queryResult.getRecords());
		queryResultInfo.setTotal(queryResult.getTotal());
		queryResultInfo.setRecords(toUserInfoList(queryResult.getRecords()));
		return queryResultInfo;
	}
}*/
