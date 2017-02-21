package com.gi.ctdn.restful.controller;

import com.gi.ctdn.query.CompanysQueryInfo;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.ctdn.biz.CompanysBiz;
import com.gi.ctdn.biz.ProjectsBiz;
import com.gi.ctdn.pojo.CompanysInfo;
import com.gi.ctdn.pojo.ProjectsInfo;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CompanysBiz companysBiz;

    @Autowired
    private ProjectsBiz projectsBiz;

    /**
     *创建新公司
     * @param companysInfo
     * @return
     */
    @RequestMapping("createCompany")
    @ResponseBody
    public MessageInfo<Long> createCompany(@RequestBody CompanysInfo companysInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        //验证表单必填项
        if(companysInfo.getTitle()==null || companysInfo.getDistrictId() ==null || companysInfo.getDistrictSubId()==null
                ||companysInfo.getDistrictName()==null ||companysInfo.getDistrictSubName() ==null
                ||companysInfo.getEmployeeNumber() ==null || companysInfo.getFoundDate()==null || companysInfo.getRoundName()==null){
            messageInfo.setMessage("必填项未填写完整!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        //根据projectId 查询 companyId 再update
        Long projectId = companysInfo.getProjectId();
        ProjectsInfo projectsInfo = projectsBiz.queryById(projectId).getData();
        if(projectsInfo == null || projectsInfo.getCompanyId()==null){
            messageInfo.setMessage("projectId 错误！");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        Long id = projectsInfo.getCompanyId();
        companysInfo.setId(id);
        messageInfo = companysBiz.update(companysInfo);
        return messageInfo;
    }

    /**
     *修改公司
     * @param companysInfo
     * @return
     */
    @RequestMapping("updateCompany")
    @ResponseBody
    public MessageInfo<Long> updateCompany(@RequestBody CompanysInfo companysInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        //验证表单必填项
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

    @RequestMapping("queryByProjectId")
    @ResponseBody
    public MessageInfo<CompanysInfo> queryByProjectId(Long projectId){
        MessageInfo<CompanysInfo> messageInfo = new MessageInfo<CompanysInfo>();
        if(null == projectId){
            messageInfo.setMessage("projectId 缺失！");
            messageInfo.setStatus(10001);
        }
        CompanysInfo companysInfo = companysBiz.queryByProjectId(projectId).getData();
        if(null != companysInfo){
            messageInfo.setData(companysInfo);
        }
        return messageInfo;
    }
}
