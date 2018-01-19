package com.gi.ctdn.biz;

import com.gi.ctdn.dao.EventDistrictDAO;
import com.gi.ctdn.pojo.EventDistrict;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EventDistrictBiz")
public class EventDistrictBiz {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventDistrictBiz.class);

    @Autowired
    EventDistrictDAO eventDistrictDAO;

    public MessageInfo<List<EventDistrict>> getListByTimeType(Integer timeType){

        MessageInfo<List<EventDistrict>> messageInfo = new MessageInfo<List<EventDistrict>>();
        try {
            List<EventDistrict> eventDistrictList = eventDistrictDAO.selectByTimeType(timeType);
            messageInfo.setData(eventDistrictList);
            messageInfo.setStatus(MessageStatus.OK_CODE);
            messageInfo.setMessage(MessageStatus.OK_MESSAGE);
        } catch (Exception e) {
            LOGGER.error("getListByTimeType","查询EventDistrict失败", e);
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
        }
        return messageInfo;
    }

    public MessageInfo<List<EventDistrict>> getListByTimeAndDistrict(Integer timeType,String districtSubName){

        MessageInfo<List<EventDistrict>> messageInfo = new MessageInfo<List<EventDistrict>>();
        try {
            List<EventDistrict> eventDistrictList = eventDistrictDAO.selectByTimeAndDistrict(timeType,districtSubName);
            messageInfo.setData(eventDistrictList);
            messageInfo.setStatus(MessageStatus.OK_CODE);
            messageInfo.setMessage(MessageStatus.OK_MESSAGE);
        } catch (Exception e) {
            LOGGER.error("getListByTimeAndDistrict","查询EventDistrict失败", e);
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
        }
        return messageInfo;
    }
}
