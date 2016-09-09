

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.CurrencyDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.Currency;
import com.gi.xm.platform.query.CurrencyQuery;

@Service("currencyBiz")
public class CurrencyBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(CurrencyBiz.class);

    @Autowired
	CurrencyDAO currencyDAO;



	
	public Message<Integer> deleteCurrency(Long id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = currencyDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Long> createCurrency(Currency currency){
		Message<Long> message = new Message<Long>();
		try {
									currencyDAO.insert( currency );
			message.setData(currency.getId());

		} catch (Exception e) {
			LOGGER.error("createCurrency","创建Currency失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateCurrency(Currency currency){
		Message<Integer> message = new Message<Integer>();
		try {

			Currency currencyLast = currencyDAO.selectByPrimaryKeyForUpdate( currency.getId() );
			if( currencyLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

									int result = currencyDAO.updateByPrimaryKey( currency );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateCurrency","更新Currency失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<Currency> getCurrency( Long id ){
		Message<Currency> message = new Message<Currency>();
		try {
			Currency currency = currencyDAO.selectByPrimaryKey( id );
			message.setData(currency);

		} catch (Exception e) {
			LOGGER.error("getCurrency","根据主键查询Currency失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<Currency>> getAllCurrency(){

		Message<List<Currency>> message = new Message<List<Currency>>();
		try {
			List<Currency> currencyList = currencyDAO.selectAll();
			message.setData( currencyList);
		} catch (Exception e) {
			LOGGER.error("getAllCurrency","查询全部Currency失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<Currency>> queryCurrency(CurrencyQuery currencyQuery) {
		Message<QueryResult<Currency>> message = new Message<QueryResult<Currency>>();
		try {
			QueryResult<Currency> queryResult = new QueryResult<Currency>();
			PageHelper.startPage(currencyQuery.getPageIndex(), currencyQuery.getPageSize());
			List<Currency> currencyList = currencyDAO.queryCurrency(currencyQuery);
			PageInfo<Currency> pageInfo = new PageInfo<Currency>(currencyList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(currencyList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryCurrency", "分页查询Currency失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	

}