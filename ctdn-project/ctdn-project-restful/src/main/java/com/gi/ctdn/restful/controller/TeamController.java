package com.gi.ctdn.restful.controller;

import com.gi.ctdn.util.DateUtil;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.ctdn.biz.TeamMembersBiz;
import com.gi.ctdn.pojo.TeamMembersInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by zcy on 17-2-20.
 */
@Controller
@RequestMapping("teamMembers")
public class TeamController {
    @Autowired
    private TeamMembersBiz teamMembersBiz;

    /**
     * 创建团队成员
     * @param teamMembersInfo
     * @return
     */
    @RequestMapping("createTeamMemer")
    @ResponseBody
    public MessageInfo<Long> createTeamMemer(@RequestBody TeamMembersInfo teamMembersInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        if(teamMembersInfo.getProjectId() == null || StringUtils.isEmpty(teamMembersInfo.getAvatar()) ||
                StringUtils.isEmpty(teamMembersInfo.getName())||
                StringUtils.isEmpty(teamMembersInfo.getEmail())|| StringUtils.isEmpty(teamMembersInfo.getPhone())||
                StringUtils.isEmpty(teamMembersInfo.getInfo())){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("必填项未填写完整!");
            return messageInfo;
        }
        messageInfo = teamMembersBiz.createTeamMembers(teamMembersInfo);
        return messageInfo;
    }

    /**
     * 修改团队成员
     * @param teamMembersInfo
     * @return
     */
    @RequestMapping("updateTeamMemer")
    @ResponseBody
    public MessageInfo<Long> updateTeamMemer(@RequestBody TeamMembersInfo teamMembersInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        if(teamMembersInfo.getId() == null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("id缺失!");
            return messageInfo;
        }
        if(teamMembersInfo.getProjectId() == null || StringUtils.isEmpty(teamMembersInfo.getAvatar()) ||
                StringUtils.isEmpty(teamMembersInfo.getName())||
                StringUtils.isEmpty(teamMembersInfo.getEmail())|| StringUtils.isEmpty(teamMembersInfo.getPhone())||
                StringUtils.isEmpty(teamMembersInfo.getInfo())){

            messageInfo.setStatus(10001);
            messageInfo.setMessage("必填项未填写完整!");
            return messageInfo;
        }
        messageInfo = teamMembersBiz.updateTeamMembers(teamMembersInfo);
        return messageInfo;
    }

    /**
     * 查询projectId下的团队成员列表
     * @param projectId
     * @return
     */
    @RequestMapping("queryList/{projectId}")
    @ResponseBody
    public MessageInfo<List<TeamMembersInfo>> query(@PathVariable("projectId") Long projectId){
        MessageInfo<List<TeamMembersInfo>> messageInfo = new MessageInfo<List<TeamMembersInfo>>();
        if(projectId == null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("projectId 缺失！");
            return messageInfo;
        }
        messageInfo = teamMembersBiz.queryByProjectId(projectId);
        return  messageInfo;
    }

    @RequestMapping("queryOneMember/{id}")
    @ResponseBody
    public MessageInfo<TeamMembersInfo> queryOneMember(@PathVariable("id") Long id){
        MessageInfo<TeamMembersInfo> messageInfo = new MessageInfo<TeamMembersInfo>();
        if(id == null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("id 缺失！");
            return messageInfo;
        }
        messageInfo = teamMembersBiz.queryById(id);
        return  messageInfo;
    }
    /**
     * 根据id删除团队成员
     * @param id
     * @return
     */
    @RequestMapping("deleteMember/{id}")
    @ResponseBody
    public MessageInfo deleteMember(@PathVariable("id") Long id){
        MessageInfo messageInfo = new MessageInfo();
        if(id == null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("teammember id 缺失！");
            return messageInfo;
        }
        messageInfo = teamMembersBiz.deleteMember(id);
        return  messageInfo;
    }
}
