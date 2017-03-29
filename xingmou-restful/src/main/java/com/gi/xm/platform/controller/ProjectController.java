package com.gi.xm.platform.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gi.xm.platform.facede.*;
import com.gi.xm.platform.view.*;
import com.gi.xm.platform.view.common.MessageInfo;
import com.gi.xm.platform.view.common.QueryResultInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("project")
public class ProjectController {

    @Reference
	private ProjectFacede projectFacede;
	@Reference
	private FilesFacede filesFacede;
    @Reference
    private IndustryFacede industryFacede;
    @Reference
    private RoundFacede roundFacede;
    @Reference
    private DistrictFacede districtFacede;


    @RequestMapping("query")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectInfo>>  queryProject (@RequestBody ProjectQueryInfo projectQueryInfo) {
		MessageInfo<QueryResultInfo<ProjectInfo>> resultMessageInfo = projectFacede.queryProject(projectQueryInfo);
		return resultMessageInfo;
	}
	
	/**
	 * 根据id查项目
	 * @param id
	 * @return
	 */
    @RequestMapping("get/{id}")
    @ResponseBody
    @Cacheable(value = "project:id",keyGenerator = "api")
    public MessageInfo<ProjectInfo> getProject( @PathVariable Long id ){
		MessageInfo<ProjectInfo> messageInfo =  projectFacede.getProject(id);
		return messageInfo;
	}


    @RequestMapping("getSearchTitle")
    @ResponseBody
    public MessageInfo searchTitle() {
        //MessageInfo<ProjectSearchTitleInfo> messageInfo = projectFacede.getProjectSearchTitleInfo();
        MessageInfo<ProjectSearchTitleInfo> messageInfo = null;
        //行业
        MessageInfo<List<IndustryInfo>> m1 = industryFacede.getAllIndustry();
        if (!m1.isSuccess()){
            return m1;
        }
        //轮次
        MessageInfo<List<RoundInfo>> m2 = roundFacede.selectByTypeParentId(1,null);
        if (!m2.isSuccess()){
            return m2;
        }
        //国内国家
        MessageInfo<List<DistrictInfo>> home = districtFacede.getListByTypeLevel(1,1);
        if (!home.isSuccess()){
            return home;
        }
        //国外
        MessageInfo<List<DistrictInfo>> outer = districtFacede.getListByTypeLevel(2,2);
        if (!home.isSuccess()) {
            return outer;
        }
        //构建行业集合 start
        List<IndustryInfo> industryInfoList = m1.getData();
        List<IndustryInfo> industryInfoFather = new ArrayList<>();
        Map<Integer,List<IndustryInfo>> industryInfoSons = new HashMap<>();
        for (IndustryInfo i :industryInfoList){
            if (i.getParentId()==0){
                industryInfoFather.add(i);
            }else {
                List<IndustryInfo> sons = industryInfoSons.get(i.getParentId());
                if (sons == null){
                    sons = new ArrayList<>();
                    industryInfoSons.put(i.getParentId(),sons);
                }
                sons.add(i);
            }
        }
        //构建行业集合 end

        //构建轮次 start
        List<RoundInfo> roundInfos = m2.getData();
        List<RoundInfo> roundInfoFather = new ArrayList<>();
        Map<Long,List<RoundInfo>> roundInfoSons = new HashMap<>();
        for (RoundInfo r : roundInfos){
            if (r.getParentId()==0){
                roundInfoFather.add(r);
            }else {
                List<RoundInfo> sons = roundInfoSons.get(r.getParentId());
                if (sons == null){
                    sons = new ArrayList<>();
                    roundInfoSons.put(r.getParentId(),sons);
                }
                sons.add(r);
            }
        }
        ProjectSearchTitleInfo r = new ProjectSearchTitleInfo();

        r.setHome(home.getData());
        r.setOuter(outer.getData());
        r.setIndustryInfoFather(industryInfoFather);
        r.setIndustryInfoSon(industryInfoSons);
        r.setRoundInfoFather(roundInfoFather);
        r.setRoundInfoSon(roundInfoSons);
        messageInfo = new MessageInfo<>();
        messageInfo.setData(r);
        //构建轮次 end
        return messageInfo;
    }


	@RequestMapping("search")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectInfo>>  searchProject (@RequestBody ProjectQueryInfo projectQueryInfo) {
        if(projectQueryInfo.getCreateDateEnd()!=null){
            projectQueryInfo.setCreateDateEnd(((Integer.parseInt(projectQueryInfo.getCreateDateEnd())+1)+""));
        }

        if (projectQueryInfo.getOrder() != null&&projectQueryInfo.getOrderBy() != null){
			if (projectQueryInfo.getOrderBy().equalsIgnoreCase("createDate")){
				projectQueryInfo.setOrderBy("create_date");
			}else if (projectQueryInfo.getOrderBy().equalsIgnoreCase("newestEventRoundId")) {
				projectQueryInfo.setOrderBy("newest_event_round_id");
			}else if (projectQueryInfo.getOrderBy().equalsIgnoreCase("investMoney")) {
				projectQueryInfo.setOrderBy("invest_money");
			}else if (projectQueryInfo.getOrderBy().equalsIgnoreCase("newestEventMoney")) {
				projectQueryInfo.setOrderBy("newest_event_money");
			}else {
                projectQueryInfo.setOrderBy("create_date");
            }
		}else {
			projectQueryInfo.setOrder("desc");
			projectQueryInfo.setOrderBy("info_integrity");
		}
		String returnFields = projectQueryInfo.getSearchFields();
        projectQueryInfo.setReturnFields(returnFields);
		MessageInfo<QueryResultInfo<ProjectInfo>> messageInfo = projectFacede.searchProject(projectQueryInfo);
        if (messageInfo.isSuccess()&&messageInfo.getData()!=null&&!messageInfo.getData().getRecords().isEmpty()){
            List<Long> sourceIds = new ArrayList<>();
            List<ProjectInfo> projectInfos = messageInfo.getData().getRecords();
            for (ProjectInfo projectInfo: projectInfos){

                projectInfo.setPic("/project/pic/"+projectInfo.getSourceId()+".png");
                if(projectInfo.getSourceId()!=null){
                    sourceIds.add(projectInfo.getSourceId());
                }
            }
            MessageInfo<List<FilesInfo>> fileMessageInfo = filesFacede.getListBySourceIdsType(sourceIds,1);
            if(fileMessageInfo.isSuccess()&&fileMessageInfo.getData()!=null&&!fileMessageInfo.getData().isEmpty()){
                for(FilesInfo filesInfo :fileMessageInfo.getData()){
                    for (ProjectInfo projectInfo: projectInfos){
                       if (projectInfo.getSourceId()!=null&&filesInfo.getPic()!=null&&filesInfo.getSourceId().intValue()==projectInfo.getSourceId()){
                            projectInfo.setPic(filesInfo.getPic());
                       }
                    }
                }
            }

        }
		return messageInfo;
	}
	

	@RequestMapping("queryCompetationlist")
	@ResponseBody
	public MessageInfo<QueryResultInfo<ProjectInfo>>  queryCompetationlist (@RequestBody ProjectQueryInfo projectQueryInfo) {
		MessageInfo<QueryResultInfo<ProjectInfo>> resultMessageInfo = projectFacede.queryCompetationlist(projectQueryInfo);
		return resultMessageInfo;
	}

}
