package com.gi.ctdn.biz;

import com.gi.ctdn.dao.MergerEquityDAO;
import com.gi.ctdn.pojo.MergerEquity;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MergerEquityBiz")
public class MergerEquityBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(MergerEquityBiz.class);

    @Autowired
    MergerEquityDAO mergerEquityDAO;

    public MessageInfo<List<MergerEquity>> getMergerEquitys(Integer timeType){
        MessageInfo<List<MergerEquity>> messageInfo = new MessageInfo<>();
        try{
            List<MergerEquity> mergerEquityList = mergerEquityDAO.selectMergerEquityList(timeType);
            messageInfo.setData(mergerEquityList);
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
