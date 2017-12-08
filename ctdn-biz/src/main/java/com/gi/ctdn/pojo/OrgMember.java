package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Query;

public class OrgMember extends Query {

        public static final String INVSTID = "机构ID";
        public static final String PERID = "成员ID";
        public static final String NAME = "成员名字";
        public static final String POSITIONS = "成员职位";
        public static final String STATUS = "成员状态";
        public static final String PHONENUM = "电话号码";
        public static final String EMAIL = "邮箱";
    
	
	/**
	 * @Fields invstCode : 机构code
	 */
	private String invstCode;
	
	/**
	 * @Fields personCode : 成员ID
	 */
	private String personCode;
	
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


	public String getInvstCode() {
		return invstCode;
	}

	public void setInvstCode(String invstCode) {
		this.invstCode = invstCode;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
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