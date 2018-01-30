package com.gi.ctdn.biz;

import com.gi.ctdn.dao.StagesDistrictDAO;
import com.gi.ctdn.pojo.StagesDistrict;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("StagesDistictBiz")
public class StagesDistictBiz {
    private static final Logger LOGGER = LoggerFactory.getLogger(StagesDistictBiz.class);

    @Autowired
    StagesDistrictDAO stagesDistrictDAO;

    public MessageInfo<List<StagesDistrict>> getStagesDistricts(String timeType, String districtSubName){
        MessageInfo<List<StagesDistrict>> messageInfo = new MessageInfo<>();
        try {
            List<StagesDistrict> stagesDistrictList = stagesDistrictDAO.selectStagesDistricts(timeType,districtSubName);
            messageInfo.setData(stagesDistrictList);
            messageInfo.setStatus(MessageStatus.OK_CODE);
            messageInfo.setMessage(MessageStatus.OK_MESSAGE);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
            messageInfo.setMessage(MessageStatus.ERROR_MESSAGE);
        }
        return messageInfo;
    }

    public MessageInfo<List<List<StagesDistrict>>> getStages(String timeType,String districtSubName){
        MessageInfo<List<List<StagesDistrict>>> messageInfo = new MessageInfo<>();
        try {
            List<StagesDistrict> stagesOne = stagesDistrictDAO.selectStages(timeType,districtSubName,"初创期");
            List<StagesDistrict> stagesTwo = stagesDistrictDAO.selectStages(timeType,districtSubName,"发展期");
            List<StagesDistrict> stagesThree = stagesDistrictDAO.selectStages(timeType,districtSubName,"成熟期");
            List bigList = new ArrayList();
            bigList.add(stagesOne);
            bigList.add(stagesTwo);
            bigList.add(stagesThree);
            messageInfo.setData(bigList);
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
