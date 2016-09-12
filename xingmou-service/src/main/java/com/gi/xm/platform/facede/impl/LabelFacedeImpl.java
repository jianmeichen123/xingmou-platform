
package com.gi.xm.platform.facede.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.gi.xm.platform.biz.LabelBiz;
import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.facede.LabelFacede;
import com.gi.xm.platform.facede.convertor.LabelConvertor;
import com.gi.xm.platform.facede.convertor.MessageConvertor;
import com.gi.xm.platform.pojo.Label;
import com.gi.xm.platform.view.LabelInfo;
import com.gi.xm.platform.view.common.MessageInfo;

@Service
public class LabelFacedeImpl implements LabelFacede {

	@Autowired
	private LabelBiz labelBiz;
   
	//@Cacheable(value = "labelInfo",keyGenerator = "wiselyKeyGenerator")
	public MessageInfo<List<LabelInfo>> getListByTypeRelationId(Integer type, Long relationId){
		
		Message<List<Label>> message  = labelBiz.getListByTypeRelationId(type, relationId);
		MessageInfo<List<LabelInfo>> messageInfo = MessageConvertor.toMessageInfo(message);
		List<LabelInfo> labelInfoList = LabelConvertor.toLabelInfoList(message.getData());
		messageInfo.setData(labelInfoList);
		return messageInfo;	
	}
		
}