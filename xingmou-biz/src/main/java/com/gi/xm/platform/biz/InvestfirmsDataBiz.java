

package com.gi.xm.platform.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gi.xm.platform.dao.InvestfirmsDataDAO;

import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.InvestfirmsData;
import com.gi.xm.platform.query.InvestfirmsDataQuery;

@Service("investfirmsDataBiz")
public class InvestfirmsDataBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(InvestfirmsDataBiz.class);

    @Autowired
	InvestfirmsDataDAO investfirmsDataDAO;



	
	public Message<Integer> deleteInvestfirmsData(Integer id){
		Message<Integer> message = new Message<Integer>();
		try {

			int result = investfirmsDataDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	

    public Message<Integer> createInvestfirmsData(InvestfirmsData investfirmsData){
		Message<Integer> message = new Message<Integer>();
		try {
						        							investfirmsDataDAO.insert( investfirmsData );
			message.setData(investfirmsData.getId());

		} catch (Exception e) {
			LOGGER.error("createInvestfirmsData","创建InvestfirmsData失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
	public Message<Integer> updateInvestfirmsData(InvestfirmsData investfirmsData){
		Message<Integer> message = new Message<Integer>();
		try {

			InvestfirmsData investfirmsDataLast = investfirmsDataDAO.selectByPrimaryKeyForUpdate( investfirmsData.getId() );
			if( investfirmsDataLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}

						        							int result = investfirmsDataDAO.updateByPrimaryKey( investfirmsData );
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("updateInvestfirmsData","更新InvestfirmsData失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<InvestfirmsData> getInvestfirmsData( Integer id ){
		Message<InvestfirmsData> message = new Message<InvestfirmsData>();
		try {
			InvestfirmsData investfirmsData = investfirmsDataDAO.selectByPrimaryKey( id );
			message.setData(investfirmsData);

		} catch (Exception e) {
			LOGGER.error("getInvestfirmsData","根据主键查询InvestfirmsData失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<InvestfirmsData>> getAllInvestfirmsData(){

		Message<List<InvestfirmsData>> message = new Message<List<InvestfirmsData>>();
		try {
			List<InvestfirmsData> investfirmsDataList = investfirmsDataDAO.selectAll();
			message.setData( investfirmsDataList);
		} catch (Exception e) {
			LOGGER.error("getAllInvestfirmsData","查询全部InvestfirmsData失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

	public Message<QueryResult<InvestfirmsData>> queryInvestfirmsData(InvestfirmsDataQuery investfirmsDataQuery) {
		Message<QueryResult<InvestfirmsData>> message = new Message<QueryResult<InvestfirmsData>>();
		try {
			QueryResult<InvestfirmsData> queryResult = new QueryResult<InvestfirmsData>();
			PageHelper.startPage(investfirmsDataQuery.getPageIndex(), investfirmsDataQuery.getPageSize());
			List<InvestfirmsData> investfirmsDataList = investfirmsDataDAO.queryInvestfirmsData(investfirmsDataQuery);
			PageInfo<InvestfirmsData> pageInfo = new PageInfo<InvestfirmsData>(investfirmsDataList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(investfirmsDataList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryInvestfirmsData", "分页查询InvestfirmsData失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    	public Message<List<InvestfirmsData>> query(InvestfirmsDataQuery investfirmsDataQuery) {
    		Message<List<InvestfirmsData>> message = new Message<List<InvestfirmsData>>();
    		try {
    			List<InvestfirmsData> investfirmsDataList = investfirmsDataDAO.queryInvestfirmsData(investfirmsDataQuery);
    			message.setData(investfirmsDataList);
    		} catch (Exception e) {
    			LOGGER.error("queryInvestfirmsData", "多条件查询InvestfirmsData失败", e);
    			message.setMessageStatus(MessageStatus.SYS_ERROR);
    		}
    		return message;
    	}

		
	public Message<List<InvestfirmsData>> getListByInvestfirmId(Long investfirmId){

		Message<List<InvestfirmsData>> message = new Message<List<InvestfirmsData>>();
		try {
			List<InvestfirmsData> investfirmsDataList = investfirmsDataDAO.selectByInvestfirmId(investfirmId);
			message.setData(investfirmsDataList);
		} catch (Exception e) {
			LOGGER.error("getListByInvestfirmId","查询InvestfirmsData失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
		

}