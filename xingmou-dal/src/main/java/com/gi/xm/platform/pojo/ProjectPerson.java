package com.gi.xm.platform.pojo;

import java.sql.Timestamp;
import java.util.List;

public class ProjectPerson extends Pojo {

        public static final String ID = "id";
        public static final String PROJECT_ID = "项目id";
        public static final String NAME = "姓名";
        public static final String ICON = "头像";
        public static final String IS_CORE_MEMBER = "1核心成员 0非核心成员";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
        
       
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields projectId : 项目id
	 */
	private Long projectId;
	
	/**
	 * @Fields name : 姓名
	 */
	private String name;
	
	/**
	 * @Fields name : 职位
	 */
	private String postionName;
	public String getPostionName() {
		return postionName;
	}

	public void setPostionName(String postionName) {
		this.postionName = postionName;
	}

	/**
	 * @Fields icon : 头像
	 */
	private String icon;
	
	/**
	 * @Fields isCoreMember : 1核心成员 0非核心成员
	 */
	private Integer isCoreMember;
	
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
	
	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;
	
	/**
	 * 成员工作经历
	 * @return
	 */
	private List<ProjectPersonJob> jobList;
	/**
	 * 成员学习经历
	 * @return
	 */
	private List<ProjectPersonStudy> studyList;
	/**
	 * 标签列表
	 * @return
	 */
	private List<Label> labelList;
	
	public List<ProjectPersonJob> getJobList() {
		return jobList;
	}

	public void setJobList(List<ProjectPersonJob> jobList) {
		this.jobList = jobList;
	}

	public List<ProjectPersonStudy> getStudyList() {
		return studyList;
	}

	public void setStudyList(List<ProjectPersonStudy> studyList) {
		this.studyList = studyList;
	}

	public List<Label> getLabelList() {
		return labelList;
	}

	public void setLabelList(List<Label> labelList) {
		this.labelList = labelList;
	}

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public Long getProjectId(){
		return projectId;
	}

	public void setProjectId(Long projectId){
		this.projectId = projectId;
	}
    
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
    
	public String getIcon(){
		return icon;
	}

	public void setIcon(String icon){
		this.icon = icon;
	}
    
	public Integer getIsCoreMember(){
		return isCoreMember;
	}

	public void setIsCoreMember(Integer isCoreMember){
		this.isCoreMember = isCoreMember;
	}
    
	public Timestamp getAddTime(){
		return addTime;
	}

	public void setAddTime(Timestamp addTime){
		this.addTime = addTime;
	}
    
	public Timestamp getUpdateTime(){
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime){
		this.updateTime = updateTime;
	}
    }