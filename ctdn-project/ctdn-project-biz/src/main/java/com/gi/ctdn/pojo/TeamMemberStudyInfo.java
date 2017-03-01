package com.gi.ctdn.pojo;

import java.io.Serializable;
import java.util.Date;

public class TeamMemberStudyInfo extends CtdnPojo implements Serializable {

        public static final String ID = "id";
        public static final String MEMBER_ID = "memberId";
        public static final String SHOOL_NAME = "学院名称";
        public static final String START_DATE = "开始日期";
        public static final String END_DATE = "结束日期";
        public static final String MAJOR = "专业名称";
        public static final String DEGREE = "学位";
        public static final String DESCRIP = "详情说明";
        public static final String CREATED_UID = "创建人uid";
        public static final String CREATED_UNAME = "创建人名称";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields memberId : 
	 */
	private Long memberId;
	
	/**
	 * @Fields shoolName : 学院名称
	 */
	private String shoolName;
	
	/**
	 * @Fields startDate : 开始日期
	 */
	private Date startDate;
	
	/**
	 * @Fields endDate : 结束日期
	 */
	private Date endDate;
	
	/**
	 * @Fields major : 专业名称
	 */
	private String major;
	
	/**
	 * @Fields degree : 学位
	 */
	private String degree;
	
	/**
	 * @Fields descrip : 详情说明
	 */
	private String descrip;
	
	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
    
	public Long getMemberId(){
		return memberId;
	}

	public void setMemberId(Long memberId){
		this.memberId = memberId;
	}
    
	public String getShoolName(){
		return shoolName;
	}

	public void setShoolName(String shoolName){
		this.shoolName = shoolName;
	}
    
	public Date getStartDate(){
		return startDate;
	}

	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}
    
	public Date getEndDate(){
		return endDate;
	}

	public void setEndDate(Date endDate){
		this.endDate = endDate;
	}
    
	public String getMajor(){
		return major;
	}

	public void setMajor(String major){
		this.major = major;
	}
    
	public String getDegree(){
		return degree;
	}

	public void setDegree(String degree){
		this.degree = degree;
	}
    
	public String getDescrip(){
		return descrip;
	}

	public void setDescrip(String descrip){
		this.descrip = descrip;
	}
    
    }