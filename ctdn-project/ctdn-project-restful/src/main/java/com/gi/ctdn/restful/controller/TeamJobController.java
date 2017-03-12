package com.gi.ctdn.restful.controller;

import com.gi.ctdn.query.TeamMemberJobQueryInfo;
import com.gi.ctdn.util.DateUtil;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.ctdn.biz.TeamMemberJobBiz;
import com.gi.ctdn.pojo.TeamMemberJobInfo;
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
@RequestMapping("teamJob")
public class TeamJobController {

    @Autowired
    private TeamMemberJobBiz teamMemberJobBiz;

    /**
     * 添加团队成员工作经历
     * @param teamMemberJobInfo
     * @return
     */
    @RequestMapping("createTeamJob")
    @ResponseBody
    public MessageInfo<Long> createTeamJob (@RequestBody TeamMemberJobInfo teamMemberJobInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        if(teamMemberJobInfo.getMemberId()== null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("teammember id 缺失！");
            return messageInfo;
        }
        if(StringUtils.isEmpty(teamMemberJobInfo.getCompanyName()) ||StringUtils.isEmpty(teamMemberJobInfo.getPosition())||
                 teamMemberJobInfo.getStartDate() ==null|| teamMemberJobInfo.getEndDate() == null ){
            messageInfo.setMessage("必填项未填写完整!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        if(StringUtils.isEmpty(teamMemberJobInfo.getDescrip()) && teamMemberJobInfo.getDescrip().length()>150){
            messageInfo.setMessage("详情描述超出限制长度!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        if(teamMemberJobInfo.getId()==null){
            messageInfo = teamMemberJobBiz.createTeamMemberJob(teamMemberJobInfo);
        }else{
            messageInfo = teamMemberJobBiz.updateTeamMemberJob(teamMemberJobInfo);
        }
        return messageInfo;
    }

    /**
     * 修改团队成员工作经历
     * @param teamMemberJobInfo
     * @return
     */
    @RequestMapping("updateTeamJob")
    @ResponseBody
    public MessageInfo<Long> updateTeamStudy (@RequestBody TeamMemberJobInfo teamMemberJobInfo){
        MessageInfo<Long> messageInfo = new MessageInfo<>();
        if(teamMemberJobInfo.getId() ==null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("id缺失！");
            return messageInfo;
        }
        if(StringUtils.isEmpty(teamMemberJobInfo.getCompanyName()) ||StringUtils.isEmpty(teamMemberJobInfo.getPosition())||
                teamMemberJobInfo.getStartDate() ==null|| teamMemberJobInfo.getEndDate() == null ){
            messageInfo.setMessage("必填项未填写完整!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        if(StringUtils.isEmpty(teamMemberJobInfo.getDescrip()) && teamMemberJobInfo.getDescrip().length()>150){
            messageInfo.setMessage("详情描述超出限制长度!");
            messageInfo.setStatus(10001);
            return messageInfo;
        }
        messageInfo = teamMemberJobBiz.updateTeamMemberJob(teamMemberJobInfo);
        return messageInfo;
    }

    /**
     * 查询成员工作经历列表
     * @param memberId　团队成员id
     * @return
     */
    @RequestMapping("queryList/{memberId}")
    @ResponseBody
    public MessageInfo<List<TeamMemberJobInfo>> query(@PathVariable("memberId") Long memberId){
        MessageInfo<List<TeamMemberJobInfo>> messageInfo = new MessageInfo<List<TeamMemberJobInfo>>();
        if(memberId == null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("memberId 缺失！");
            return messageInfo;
        }
        messageInfo = teamMemberJobBiz.queryByMemberId(memberId);
        return  messageInfo;
    }

    /**
     * 根据id删除团队成员
     * @param id
     * @return
     */
    @RequestMapping("deleteMemberJob/{id}")
    @ResponseBody
    public MessageInfo deleteMember(@PathVariable("id") Long id){
        MessageInfo messageInfo = new MessageInfo();
        if(id == null){
            messageInfo.setStatus(10001);
            messageInfo.setMessage("job id 缺失！");
            return messageInfo;
        }
        TeamMemberJobQueryInfo job = new TeamMemberJobQueryInfo();
        job.setId(id);
        messageInfo = teamMemberJobBiz.deleteMemberJob(job);
        return  messageInfo;
    }

    /**
     *
     */
    @RequestMapping("queryOneJob/{id}")
    @ResponseBody
    public MessageInfo<TeamMemberJobInfo> queryOneJob(@PathVariable("id") Long id){
        MessageInfo<TeamMemberJobInfo> messageInfo = new MessageInfo<TeamMemberJobInfo>();
        if(id == null) {
            messageInfo.setStatus(10001);
            messageInfo.setMessage("job id 缺失！");
            return messageInfo;
        }
        messageInfo = teamMemberJobBiz.queryById(id);
        return  messageInfo;
    }
}
