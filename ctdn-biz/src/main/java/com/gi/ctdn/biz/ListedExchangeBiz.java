package com.gi.ctdn.biz;

import com.gi.ctdn.dao.ListedExchangeDAO;
import com.gi.ctdn.pojo.ListedExchange;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ListedExchangeBiz")
public class ListedExchangeBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListedExchangeBiz.class);

    @Autowired
    ListedExchangeDAO listedExchangeDAO;

    public MessageInfo<List<ListedExchange>> getListedExchages(){
        MessageInfo<List<ListedExchange>> messageInfo = new MessageInfo<>();
        try{
            List<ListedExchange> listedExchangeList = listedExchangeDAO.selectListedExchangeList();
            messageInfo.setData(listedExchangeList);
            messageInfo.setStatus(MessageStatus.OK_CODE);
            messageInfo.setMessage(MessageStatus.OK_MESSAGE);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }
}
