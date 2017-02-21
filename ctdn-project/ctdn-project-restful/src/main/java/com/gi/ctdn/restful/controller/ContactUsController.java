package com.gi.ctdn.restful.controller;

import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.ctdn.biz.ProjectContactBiz;
import com.gi.ctdn.pojo.ProjectContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by zcy on 17-2-20.
 */
public class ContactUsController {

    @Autowired
    private ProjectContactBiz projectContactBiz;

    /**
     * 创建联系信息
     * @param projectContactInfo
     * @return
     */
    @RequestMapping("createContact")
    @ResponseBody
    public MessageInfo<Long> createCompany(@RequestBody ProjectContactInfo projectContactInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        //验证表单必填项
        if(projectContactInfo.getProjectId() == null || projectContactInfo.getContactRole()== null ||
                projectContactInfo.getContactName() == null ||projectContactInfo.getContactPosition()== null ||
                projectContactInfo.getContactEmail() == null || projectContactInfo.getContactPhone() == null){

            messageInfo.setStatus(10001);
            messageInfo.setMessage("必填项未填写完整!");
            return messageInfo;
        }
        projectContactInfo.setAddTime(new Date());
        messageInfo = projectContactBiz.createProjectContact(projectContactInfo);
        return messageInfo;
    }

    /**
     * 修改联系信息
     */
    @RequestMapping("updateContact")
    @ResponseBody
    public MessageInfo<Long> updateContact(@RequestBody ProjectContactInfo projectContactInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        if(null != projectContactInfo.getProjectId() ){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("project id 缺失!");
            return messageInfo;
        }
        //验证表单必填项
        if(projectContactInfo.getProjectId() == null || projectContactInfo.getContactRole()== null ||
                projectContactInfo.getContactName() == null ||projectContactInfo.getContactPosition()== null ||
                projectContactInfo.getContactEmail() == null || projectContactInfo.getContactPhone() == null){

            messageInfo.setStatus(10001);
            messageInfo.setMessage("必填项未填写完整!");
            return messageInfo;
        }
        projectContactInfo.setUpdateTime(new Date());
        messageInfo = projectContactBiz.updateProjectContact(projectContactInfo);
        return messageInfo;
    }

    /**
     * 查询projectId下的联系我们
     */
    @RequestMapping("queryByProjectId")
    @ResponseBody
    public MessageInfo<ProjectContactInfo> queryByProjectId(Long projectId){
        MessageInfo<ProjectContactInfo> messageInfo = new MessageInfo<ProjectContactInfo>();
        if(projectId == null ){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("project id 缺失!");
            return messageInfo;
        }
        messageInfo = projectContactBiz.queryByProjectId(projectId);
        return messageInfo;
    }
}

