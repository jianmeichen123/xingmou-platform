package com.gi.xm.platform.facede.convertor;


import com.gi.xm.platform.biz.common.Message;
import com.gi.xm.platform.view.common.MessageInfo;

public abstract class MessageConvertor {

	public static <E> MessageInfo<E> toMessageInfo(Message<?> message) {
		MessageInfo<E> messageInfo = new MessageInfo<E>();
		messageInfo.setStatus(message.getStatus());
		messageInfo.setMessage(message.getMessage());
		return messageInfo;
	}
}
