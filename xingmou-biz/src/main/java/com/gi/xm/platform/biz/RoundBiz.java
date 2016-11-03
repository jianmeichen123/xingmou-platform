

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.RoundDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Round;
import com.gi.xm.platform.query.RoundQuery;

@Service("roundBiz")
public class RoundBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(RoundBiz.class);

    @Autowired
	RoundDAO roundDAO;



	
	public Message<Integer> deleteRound(Integer id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = roundDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Integer> createRound(Round round){
		Message<Integer> message = new Message<Integer>();
		try {
									roundDAO.insert( round );
			message.setData(round.getId());

		} catch (Exception e) {
			LOGGER.error("createRound","创建Round失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateRound(Round round){
		Message<Integer> message = new Message<Integer>();
		try {

			Round roundLast = roundDAO.selectByPrimaryKeyForUpdate( round.getId() );
			if( roundLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = roundDAO.updateByPrimaryKey( round );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateRound","更新Round失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<Round> getRound( Integer id ){
		Message<Round> message = new Message<Round>();
		try {
			Round round = roundDAO.selectByPrimaryKey( id );
			message.setData(round);

		} catch (Exception e) {
			LOGGER.error("getRound","根据主键查询Round失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Round>> getAllRound(){

		Message<List<Round>> message = new Message<List<Round>>();
		try {
			List<Round> roundList = roundDAO.selectAll();
			message.setData( roundList);
		} catch (Exception e) {
			LOGGER.error("getAllRound","查询全部Round失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<Round>> queryRound(RoundQuery roundQuery) {
		Message<QueryResult<Round>> message = new Message<QueryResult<Round>>();
		try {
			QueryResult<Round> queryResult = new QueryResult<Round>();
			PageHelper.startPage(roundQuery.getPageIndex(), roundQuery.getPageSize());
			List<Round> roundList = roundDAO.queryRound(roundQuery);
			PageInfo<Round> pageInfo = new PageInfo<Round>(roundList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(roundList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryRound", "分页查询Round失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<List<Round>> getByTypeParentId(Integer type,Integer parentId){

		Message<List<Round>> message = new Message<List<Round>>();
		try {
			List<Round> roundList = roundDAO.selectByTypeParentId(type,parentId);
			message.setData(roundList);
		} catch (Exception e) {
			LOGGER.error("getListByType","查询Round失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

}