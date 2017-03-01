package com.gi.ctdn.restful.controller;

import com.gi.ctdn.query.TeamMemberStudyQueryInfo;
import com.gi.ctdn.util.DateUtil;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.ctdn.biz.TeamMemberStudyBiz;
import com.gi.ctdn.pojo.TeamMemberStudyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@RequestMapping("teamStudy")
public class TeamStudyController {

    @Autowired
    private TeamMemberStudyBiz teamMemberStudyBiz;

    /**
     * 添加团队成员教育经历
     * @param teamMemberStudyInfo
     * @return
     */
    @RequestMapping("createTeamStudy")
    @ResponseBody
    public MessageInfo<Long> createTeamStudy (@RequestBody TeamMemberStudyInfo teamMemberStudyInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        if(teamMemberStudyInfo.getMemberId()== null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("member id 缺失！");
            return messageInfo;
        }
        if(teamMemberStudyInfo.getShoolName()==null ||teamMemberStudyInfo.getMajor() == null||
                teamMemberStudyInfo.getDegree() == null || teamMemberStudyInfo.getStartDate() ==null||
                teamMemberStudyInfo.getEndDate() == null ){
            messageInfo.setMessage("必填项未填写完整!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        if(teamMemberStudyInfo.getDescrip() !=null && teamMemberStudyInfo.getDescrip().length()>150){
            messageInfo.setMessage("详情描述超出限制长度!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        messageInfo = teamMemberStudyBiz.createTeamMemberStudy(teamMemberStudyInfo);
        return messageInfo;
    }

    /**
     * 修改团队成员教育经历
     * @param teamMemberStudyInfo
     * @return
     */
    @RequestMapping("updateTeamStudy")
    @ResponseBody
    public MessageInfo<Long> updateTeamStudy (@RequestBody TeamMemberStudyInfo teamMemberStudyInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        if(teamMemberStudyInfo.getId() ==null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("id缺失！");
            return messageInfo;
        }
        if(teamMemberStudyInfo.getShoolName()==null ||teamMemberStudyInfo.getMajor() == null||
                teamMemberStudyInfo.getDegree() == null || teamMemberStudyInfo.getStartDate() ==null||
                teamMemberStudyInfo.getEndDate() == null ){
            messageInfo.setMessage("必填项未填写完整!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        if(teamMemberStudyInfo.getDescrip() !=null && teamMemberStudyInfo.getDescrip().length()>150){
            messageInfo.setMessage("详情描述超出限制长度!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        messageInfo = teamMemberStudyBiz.updateTeamMemberStudy(teamMemberStudyInfo);
        return messageInfo;
    }

    /**
     * 查询成员教育经历列表
     * @param memberId　团队成员id
     * @return
     */
    @RequestMapping("queryList/{memberId}")
    @ResponseBody
    public MessageInfo<List<TeamMemberStudyInfo>> query(@PathVariable("memberId") Long memberId){
        MessageInfo<List<TeamMemberStudyInfo>> messageInfo = new MessageInfo<List<TeamMemberStudyInfo>>();
        if(memberId == null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("memberId 缺失！");
            return messageInfo;
        }
        messageInfo = teamMemberStudyBiz.queryByMemberId(memberId);
        return  messageInfo;
    }

    /**
     * 根据id删除团队成员
     * @param id
     * @return
     */
    @RequestMapping("deleteMemberStudy/{id}")
    @ResponseBody
    public MessageInfo deleteMember(@PathVariable("id") Long id){
        MessageInfo messageInfo = new MessageInfo();
        if(id == null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("study id 缺失！");
            return messageInfo;
        }
        TeamMemberStudyQueryInfo study = new TeamMemberStudyQueryInfo();
        study.setId(id);
        messageInfo = teamMemberStudyBiz.deleteMemberStudy(study);
        return  messageInfo;
    }
}
