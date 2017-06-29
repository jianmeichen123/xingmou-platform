package com.gi.ctdn.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;
import com.gi.xm.platform.view.common.PojoInfo;

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
	private Timestamp invstId;
	
	/**
	 * @Fields perId : 成员ID
	 */
	private Timestamp perId;
	
	/**
	 * @Fields name : 成员名字
	 */
	private Timestamp name;
	
	/**
	 * @Fields positions : 成员职位
	 */
	private Timestamp positions;
	
	/**
	 * @Fields status : 成员状态
	 */
	private Timestamp status;
	
	/**
	 * @Fields phoneNum : 电话号码
	 */
	private Timestamp phoneNum;
	
	/**
	 * @Fields email : 邮箱
	 */
	private Timestamp email;
	
    
	public Timestamp getInvstId(){
		return invstId;
	}

	public void setInvstId(Timestamp invstId){
		this.invstId = invstId;
	}
    
	public Timestamp getPerId(){
		return perId;
	}

	public void setPerId(Timestamp perId){
		this.perId = perId;
	}
    
	public Timestamp getName(){
		return name;
	}

	public void setName(Timestamp name){
		this.name = name;
	}
    
	public Timestamp getPositions(){
		return positions;
	}

	public void setPositions(Timestamp positions){
		this.positions = positions;
	}
    
	public Timestamp getStatus(){
		return status;
	}

	public void setStatus(Timestamp status){
		this.status = status;
	}
    
	public Timestamp getPhoneNum(){
		return phoneNum;
	}

	public void setPhoneNum(Timestamp phoneNum){
		this.phoneNum = phoneNum;
	}
    
	public Timestamp getEmail(){
		return email;
	}

	public void setEmail(Timestamp email){
		this.email = email;
	}
    }