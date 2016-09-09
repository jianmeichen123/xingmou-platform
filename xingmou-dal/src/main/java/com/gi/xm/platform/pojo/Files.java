package com.gi.xm.platform.pojo;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.util.Date;

public class Files extends Pojo {

        public static final String ID = "id";
        public static final String TYPE = "1. 项目图标  2.机构图标";
        public static final String SOURCE_ID = "项目表或机构表id";
        public static final String PIC = "小图标";
        public static final String PIC_BIG = "大图标";
        public static final String PIC_SHOW = "项目站点截图";
        public static final String ADD_TIME = "addTime";
        public static final String UPDATE_TIME = "updateTime";
    
	
	/**
	 * @Fields id : 
	 */
	private Long id;
	
	/**
	 * @Fields type : 1. 项目图标  2.机构图标
	 */
	private Integer type;
	
	/**
	 * @Fields sourceId : 项目表或机构表id
	 */
	private Long sourceId;
	
	/**
	 * @Fields pic : 小图标
	 */
	private String pic;
	
	/**
	 * @Fields picBig : 大图标
	 */
	private String picBig;
	
	/**
	 * @Fields picShow : 项目站点截图
	 */
	private String picShow;
	
	/**
	 * @Fields addTime : 
	 */
	private Timestamp addTime;
	
	/**
	 * @Fields updateTime : 
	 */
	private Timestamp updateTime;
	
    
	public Long getId(){
		return id;
	}

	public void setId(Long id){
		this.id = id;
	}
    
	public Integer getType(){
		return type;
	}

	public void setType(Integer type){
		this.type = type;
	}
    
	public Long getSourceId(){
		return sourceId;
	}

	public void setSourceId(Long sourceId){
		this.sourceId = sourceId;
	}
    
	public String getPic(){
		return pic;
	}

	public void setPic(String pic){
		this.pic = pic;
	}
    
	public String getPicBig(){
		return picBig;
	}

	public void setPicBig(String picBig){
		this.picBig = picBig;
	}
    
	public String getPicShow(){
		return picShow;
	}

	public void setPicShow(String picShow){
		this.picShow = picShow;
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