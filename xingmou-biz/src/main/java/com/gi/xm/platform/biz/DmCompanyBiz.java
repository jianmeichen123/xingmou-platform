

package com.gi.xm.platform.biz;

import com.gi.xm.platform.dao.DmCompanyDAO;
import com.gi.xm.platform.pojo.DmCompany;
import com.gi.xm.platform.query.DmCompanyQuery;
import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.MessageStatus;
import com.gi.xm.platform.biz.common.QueryResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dmCompanyBiz")
public class DmCompanyBiz  {


	private static final Logger LOGGER = LoggerFactory.getLogger(DmCompanyBiz.class);

    @Autowired
	DmCompanyDAO dmCompanyDAO;


	
		
	public Message<Integer> deleteDmCompany(Long id){
		Message<Integer> message = new Message<Integer>();
		try {
		
			int result = dmCompanyDAO.deleteByPrimaryKey(id);
			message.setData(result);

		} catch (Exception e) {
			LOGGER.error("delete","删除失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;		
	}
		

    public Message<Long> createDmCompany(DmCompany dmCompany){
		Message<Long> message = new Message<Long>();
		try {
									dmCompanyDAO.insert( dmCompany );
			message.setData(dmCompany.getId());

		} catch (Exception e) {
			LOGGER.error("createDmCompany","创建DmCompany失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	public Message<Integer> updateDmCompany(DmCompany dmCompany){
		Message<Integer> message = new Message<Integer>();
		try {
			
			DmCompany dmCompanyLast = dmCompanyDAO.selectByPrimaryKeyForUpdate( dmCompany.getId() );
			if( dmCompanyLast == null){
				message.setMessageStatus(MessageStatus.DATA_NOT_EXISTS, "TODO：这里请写清楚");
				return message;
			}
			
									int result = dmCompanyDAO.updateByPrimaryKey( dmCompany );
			message.setData(result);
			
		} catch (Exception e) {
			LOGGER.error("updateDmCompany","更新DmCompany失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

		public Message<DmCompany> getDmCompany( Long id ){
		Message<DmCompany> message = new Message<DmCompany>();
		try {
			DmCompany dmCompany = dmCompanyDAO.selectByPrimaryKey( id );
			message.setData(dmCompany);

		} catch (Exception e) {
			LOGGER.error("getDmCompany","根据主键查询DmCompany失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}

    public Message<List<DmCompany>> getAllDmCompany(){
	
		Message<List<DmCompany>> message = new Message<List<DmCompany>>();
		try {
			List<DmCompany> dmCompanyList = dmCompanyDAO.selectAll();
			message.setData( dmCompanyList);
		} catch (Exception e) {
			LOGGER.error("getAllDmCompany","查询全部DmCompany失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;	
	}
	
	public Message<QueryResult<DmCompany>> queryDmCompany(DmCompanyQuery dmCompanyQuery) {
		Message<QueryResult<DmCompany>> message = new Message<QueryResult<DmCompany>>();
		try {
			QueryResult<DmCompany> queryResult = new QueryResult<DmCompany>();
			PageHelper.startPage(dmCompanyQuery.getPageIndex(), dmCompanyQuery.getPageSize());
			List<DmCompany> dmCompanyList = dmCompanyDAO.queryDmCompany(dmCompanyQuery);
			PageInfo<DmCompany> pageInfo = new PageInfo<DmCompany>(dmCompanyList);
			queryResult.setPages(pageInfo.getPages());
			queryResult.setTotal(pageInfo.getTotal());
			queryResult.setRecords(dmCompanyList);
			message.setData(queryResult);
		} catch (Exception e) {
			LOGGER.error("queryDmCompany", "分页查询DmCompany失败", e);
			message.setMessageStatus(MessageStatus.SYS_ERROR);
		}
		return message;
	}
   
	

}