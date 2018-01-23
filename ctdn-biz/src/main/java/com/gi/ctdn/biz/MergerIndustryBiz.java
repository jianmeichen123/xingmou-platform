package com.gi.ctdn.biz;

import com.gi.ctdn.dao.MergerIndustryDAO;
import com.gi.ctdn.pojo.MergerIndustry;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MergerIndustryBiz")
public class MergerIndustryBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(MergerIndustryBiz.class);

    @Autowired
    MergerIndustryDAO mergerIndustryDAO;

    public MessageInfo<List<MergerIndustry>> getMergerIndustrys(String timeType){
        MessageInfo<List<MergerIndustry>> messageInfo = new MessageInfo<>();
        try{
            List<MergerIndustry> mergerIndustryList = mergerIndustryDAO.selectMergerIndustryList(timeType);
            messageInfo.setData(mergerIndustryList);
            messageInfo.setStatus(MessageStatus.OK_CODE);
            messageInfo.setMessage(MessageStatus.OK_MESSAGE);
        }catch(Exception e){
            LOGGER.error(e.getMessage());
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }
}
