package com.gi.xm.platform.view;

import java.math.BigDecimal;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class FilesInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
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
    
    }