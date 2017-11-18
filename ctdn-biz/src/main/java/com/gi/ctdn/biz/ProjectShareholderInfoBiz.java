

package com.gi.ctdn.biz;

import com.gi.ctdn.dao.ProjectShareholderInfoDAO;
import com.gi.ctdn.pojo.ProjectShareholderInfo;
import com.gi.ctdn.view.common.MessageInfo;
import com.gi.ctdn.view.common.MessageStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectShareholderInfoBiz")
public class ProjectShareholderInfoBiz  {


    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectShareholderInfoBiz.class);

    @Autowired
    ProjectShareholderInfoDAO projectShareholderInfoDAO;



    public MessageInfo<List<ProjectShareholderInfo>> getListBySourceCode(String sourceCode){

        MessageInfo<List<ProjectShareholderInfo>> messageInfo = new MessageInfo<List<ProjectShareholderInfo>>();
        try {
            List<ProjectShareholderInfo> projectShareholderInfoList = projectShareholderInfoDAO.selectBySourceCode(sourceCode);
            messageInfo.setData(projectShareholderInfoList);
        } catch (Exception e) {
            LOGGER.error("getListBySourceCode","查询ProjectShareholderInfo失败", e);
            messageInfo.setStatus(MessageStatus.ERROR_CODE);
        }
        return messageInfo;
    }



    public MessageInfo<List<ProjectShareholderInfo>> getAllProjectShareholderInfo(){

        MessageInfo<List<ProjectShareholderInfo>> messageInfo = new MessageInfo<List<ProjectShareholderInfo>>();
        try {
            List<ProjectShareholderInfo> projectShareholderInfoList = projectShareholderInfoDAO.selectAll();
            messageInfo.setData( projectShareholderInfoList);
        } catch (Exception e) {
            LOGGER.error("getAllProjectShareholderInfo","查询全部ProjectShareholderInfo失败", e);
            messageInfo.setStatus(10001);
        }
        return messageInfo;
    }
}