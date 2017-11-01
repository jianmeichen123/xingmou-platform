package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;

public class OrgMember extends PojoInfo {

        public static final String INVSTID = "机构ID";
        public static final String PERID = "成员ID";
        public static final String NAME = "成员名字";
        public static final String POSITIONS = "成员职位";
        public static final String STATUS = "成员状态";
        public static final String PHONENUM = "电话号码";
        public static final String EMAIL = "邮箱";
    
	
	/**
	 * @Fields invstId : 机构ID
	 */
	private Integer invstId;
	
	/**
	 * @Fields perId : 成员ID
	 */
	private Integer perId;
	
	/**
	 * @Fields name : 成员名字
	 */
	private String name;
	
	/**
	 * @Fields positions : 成员职位
	 */
	private String positions;
	
	/**
	 * @Fields status : 成员状态
	 */
	private String status;
	
	/**
	 * @Fields phoneNum : 电话号码
	 */
	private String phoneNum;
	
	/**
	 * @Fields email : 邮箱
	 */
	private String email;
	
    
	public Integer getInvstId(){
		return invstId;
	}

	public void setInvstId(Integer invstId){
		this.invstId = invstId;
	}
    
	public Integer getPerId(){
		return perId;
	}

	public void setPerId(Integer perId){
		this.perId = perId;
	}
    
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
    
	public String getPositions(){
		return positions;
	}

	public void setPositions(String positions){
		this.positions = positions;
	}
    
	public String getStatus(){
		return status;
	}

	public void setStatus(String status){
		this.status = status;
	}
    
	public String getPhoneNum(){
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum){
		this.phoneNum = phoneNum;
	}
    
	public String getEmail(){
		return email;
	}

	public void setEmail(String email){
		this.email = email;
	}
    }