package com.gi.ctdn.restful.controller;

import com.gi.ctdn.util.DateUtil;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.ctdn.biz.ProjectContactBiz;
import com.gi.ctdn.pojo.ProjectContactInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by zcy on 17-2-20.
 */
@Controller
@RequestMapping("contactUs")
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
        if(projectContactInfo.getProjectId() == null || StringUtils.isEmpty(projectContactInfo.getContactRole()) ||
                StringUtils.isEmpty(projectContactInfo.getContactName()) ||StringUtils.isEmpty(projectContactInfo.getContactPosition()) ||
                StringUtils.isEmpty(projectContactInfo.getContactEmail()) || StringUtils.isEmpty(projectContactInfo.getContactPhone())){

            messageInfo.setStatus(10001);
            messageInfo.setMessage("必填项未填写完整!");
            return messageInfo;
        }
        if(projectContactInfo.getId()==null){
            messageInfo = projectContactBiz.createProjectContact(projectContactInfo);
        }else{
            messageInfo = projectContactBiz.updateProjectContact(projectContactInfo);
        }

        return messageInfo;
    }

    /**
     * 修改联系信息
     */
    @RequestMapping("updateContact")
    @ResponseBody
    public MessageInfo<Long> updateContact(@RequestBody ProjectContactInfo projectContactInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        if(null == projectContactInfo.getProjectId() ){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("project id 缺失!");
            return messageInfo;
        }
        //验证表单必填项
        if(projectContactInfo.getProjectId() == null || StringUtils.isEmpty(projectContactInfo.getContactRole()) ||
                StringUtils.isEmpty(projectContactInfo.getContactName()) ||StringUtils.isEmpty(projectContactInfo.getContactPosition()) ||
                StringUtils.isEmpty(projectContactInfo.getContactEmail()) || StringUtils.isEmpty(projectContactInfo.getContactPhone())){

            messageInfo.setStatus(10001);
            messageInfo.setMessage("必填项未填写完整!");
            return messageInfo;
        }

        messageInfo = projectContactBiz.updateProjectContact(projectContactInfo);
        return messageInfo;
    }

    /**
     * 查询projectId下的联系我们
     */
    @RequestMapping("queryByProjectId/{projectId}")
    @ResponseBody
    public MessageInfo<ProjectContactInfo> queryByProjectId(@PathVariable("projectId") Long projectId){
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

