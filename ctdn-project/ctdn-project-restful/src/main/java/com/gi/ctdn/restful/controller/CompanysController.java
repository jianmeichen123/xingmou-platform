package com.gi.ctdn.restful.controller;

import com.gi.xm.platform.view.common.MessageInfo;
import ctdn.biz.CompanysBiz;
import ctdn.biz.ProjectsBiz;
import ctdn.pojo.CompanysInfo;
import ctdn.pojo.ProjectsInfo;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zcy on 17-2-20.
 */
@Controller
@RequestMapping("companys")
public class CompanysController {
    @Reference
    private CompanysBiz companysBiz;
    @Reference
    private ProjectsBiz projectsBiz;

    @RequestMapping("createProject")
    @ResponseBody
    public MessageInfo<Long> createCompany(@RequestBody CompanysInfo companysInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        //验证表单项
        if(companysInfo.getTitle()==null || companysInfo.getDistrictId() ==null || companysInfo.getDistrictSubId()==null
                ||companysInfo.getDistrictName()==null ||companysInfo.getDistrictSubName() ==null
                ||companysInfo.getEmployeeNumber() ==null || companysInfo.getFoundDate()==null || companysInfo.getRoundName()==null){
            messageInfo.setMessage("必填项未填写完整!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        Long projectId = companysInfo.getProjectId();
        ProjectsInfo projectsInfo = projectsBiz.queryById(projectId).getData();
        if(projectsInfo == null || projectsInfo.getCompanyId()==null){
            messageInfo.setMessage("projectId或companyId缺失！");
            messageInfo.setStatus(10001);
        }
        Long comanyId = projectsInfo.getCompanyId();
        companysBiz.update(companysInfo);
        return messageInfo;
    }
}
