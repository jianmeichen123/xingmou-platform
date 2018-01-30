package com.gi.ctdn.biz;

import com.gi.ctdn.dao.EventStagesDAO;
import com.gi.ctdn.pojo.EventStages;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EventStagesBiz")
public class EventStagesBiz {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventStagesBiz.class);

    @Autowired
    EventStagesDAO eventStagesDAO;

    public MessageInfo<List<EventStages>> getEventStagesList(Integer districtSubId,Integer timeType){
        MessageInfo<List<EventStages>> messageInfo = new MessageInfo<>();
        try{
            List<EventStages> eventStagesList = eventStagesDAO.selectByDistrictAndTimeType(districtSubId,timeType);
            messageInfo.setData(eventStagesList);
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
