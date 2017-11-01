package com.gi.ctdn.pojo;

import java.sql.Timestamp;

import com.gi.ctdn.view.common.PojoInfo;

public class OrgRank extends PojoInfo {

        public static final String ID = "id";
        public static final String ORGID = "机构id";
        public static final String ORGNAME = "机构名称";
        public static final String INDUSTRYID = "一级行业id";
        public static final String INDUSTRYNAME = "一级行业名称";
        public static final String TIMES = "投资次数";
        public static final String TYPE = "1.全部 2.本季度 3.近7天";
        public static final String CREATEDTIME = "创建时间";
    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields orgid : 机构id
	 */
	private Integer orgid;
	
	/**
	 * @Fields orgname : 机构名称
	 */
	private String orgname;
	
	/**
	 * @Fields industryid : 一级行业id
	 */
	private Integer industryid;
	
	/**
	 * @Fields industryname : 一级行业名称
	 */
	private String industryname;
	
	/**
	 * @Fields times : 投资次数
	 */
	private Integer times;
	
	/**
	 * @Fields type : 1.全部 2.本季度 3.近7天
	 */
	private Integer type;
	
	/**
	 * @Fields createdtime : 创建时间
	 */
	private Timestamp createdtime;
	
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public Integer getOrgid(){
		return orgid;
	}

	public void setOrgid(Integer orgid){
		this.orgid = orgid;
	}
    
	public String getOrgname(){
		return orgname;
	}

	public void setOrgname(String orgname){
		this.orgname = orgname;
	}
    
	public Integer getIndustryid(){
		return industryid;
	}

	public void setIndustryid(Integer industryid){
		this.industryid = industryid;
	}
    
	public String getIndustryname(){
		return industryname;
	}

	public void setIndustryname(String industryname){
		this.industryname = industryname;
	}
    
	public Integer getTimes(){
		return times;
	}

	public void setTimes(Integer times){
		this.times = times;
	}
    
	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type = type;
	}
    
	public Timestamp getCreatedtime(){
		return createdtime;
	}

	public void setCreatedtime(Timestamp createdtime){
		this.createdtime = createdtime;
	}
    }