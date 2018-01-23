package com.gi.ctdn.biz;

import com.gi.ctdn.dao.MergerCurrencyDAO;
import com.gi.ctdn.pojo.MergerCurrency;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MergerCurrencyBiz")
public class MergerCurrencyBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(MergerCurrencyBiz.class);

    @Autowired
    MergerCurrencyDAO mergerCurrencyDAO;

    public MessageInfo<List<MergerCurrency>> getMergerCurrencyList(Integer timeType){
        MessageInfo<List<MergerCurrency>> messageInfo = new MessageInfo<>();
        try{
            List<MergerCurrency> mergerCurrencyList = mergerCurrencyDAO.selectMergerCurrencyList(timeType);
            messageInfo.setData(mergerCurrencyList);
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