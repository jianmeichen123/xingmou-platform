
package com.gi.xm.platform.facede.impl;

import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import org.springframework.beans.factory.annotation.Autowired;

import com.gi.xm.platform.biz.DmCompanyBiz;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;

import com.gi.xm.platform.view.DmCompanyInfo;
import com.gi.xm.platform.view.DmCompanyQueryInfo;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.biz.common.QueryResult;
import com.gi.xm.platform.pojo.DmCompany;
import com.gi.xm.platform.query.DmCompanyQuery;


import com.gi.xm.platform.facede.DmCompanyFacede;
import com.gi.xm.platform.facede.convertor.DmCompanyConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Service
@Path("dmCompany")
@Produces({ContentType.APPLICATION_JSON_UTF_8})
public class DmCompanyFacedeImpl implements DmCompanyFacede {

	@Autowired
	private DmCompanyBiz dmCompanyBiz;
				
	public MessageInfo<Integer> deleteDmCompany(Long id){
		
		Message<Integer> message  = dmCompanyBiz.deleteDmCompany(id);
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;		
	}
		
    public MessageInfo<Long> createDmCompany(DmCompanyInfo dmCompanyInfo){
		
		DmCompany dmCompany = DmCompanyConvertor.toDmCompany(dmCompanyInfo);
		Message<Long> message  =  dmCompanyBiz.createDmCompany( dmCompany );
		MessageInfo<Long> messageInfo  = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}
	public MessageInfo<Integer> updateDmCompany(DmCompanyInfo dmCompanyInfo){
		
		DmCompany dmCompany = DmCompanyConvertor.toDmCompany(dmCompanyInfo);
		Message<Integer> message  =  dmCompanyBiz.updateDmCompany( dmCompany );
		MessageInfo<Integer> messageInfo = MessageConvertor.toMessageInfo(message);
		messageInfo.setData(message.getData());
		return messageInfo;	
	}


    @GET
    @Path("{id : \\d+}")
    @Produces({MediaType.APPLICATION_JSON})
	public MessageInfo<DmCompanyInfo> getDmCompany(@PathParam("id") Long id ){
		Message<DmCompany> message  = dmCompanyBiz.getDmCompany( id );
		MessageInfo<DmCompanyInfo> messageInfo = MessageConvertor.toMessageInfo(message);
		DmCompanyInfo dmCompanyInfo = DmCompanyConvertor.toDmCompanyInfo(message.getData());
		messageInfo.setData(dmCompanyInfo);
		return messageInfo;
	}

    public MessageInfo<List<DmCompanyInfo>> getAllDmCompany(){
	
		Message<List<DmCompany>> message  = dmCompanyBiz.getAllDmCompany();
		MessageInfo<List<DmCompanyInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<DmCompanyInfo> dmCompanyInfoList = DmCompanyConvertor.toDmCompanyInfoList(message.getData());
		messageInfo.setData(dmCompanyInfoList);
		return messageInfo;	
	}

	public MessageInfo<QueryResultInfo<DmCompanyInfo>> queryDmCompany(DmCompanyQueryInfo dmCompanyQueryInfo) {
		DmCompanyQuery dmCompanyQuery = DmCompanyConvertor.toDmCompanyQuery(dmCompanyQueryInfo);
		Message<QueryResult<DmCompany>> message = dmCompanyBiz.queryDmCompany(dmCompanyQuery);
		MessageInfo<QueryResultInfo<DmCompanyInfo>> messageInfo = new MessageInfo<QueryResultInfo<DmCompanyInfo>>();
		QueryResultInfo<DmCompanyInfo> queryResultInfo = DmCompanyConvertor.toQueryResultInfo(message.getData());
		messageInfo.setData(queryResultInfo);
		return messageInfo;
	}
   
	
}