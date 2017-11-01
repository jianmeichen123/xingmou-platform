package com.gi.ctdn.ods.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gi.ctdn.view.common.PojoInfo;

public class WeiboIndice extends PojoInfo {

        public static final String ID = "id";
        public static final String DATE = "date";
        public static final String TITLE = "title";
        public static final String WBID = "wbid";
        public static final String WEIBO = "weibo";
        public static final String FANS = "fans";
        public static final String FOLLOW = "follow";
        public static final String GROUP = "group";
        public static final String INTERACT = "interact";
    
	
	/**
	 * @Fields id : 
	 */
	@JsonIgnore
	private Integer id;
	
	/**
	 * @Fields date : 
	 */
	private Integer date;
	
	/**
	 * @Fields title : 
	 */
	@JsonIgnore
	private String title;
	
	/**
	 * @Fields wbid : 
	 */
	private Long wbid;
	
	/**
	 * @Fields weibo : 
	 */
	private Integer weibo;
	
	/**
	 * @Fields fans : 
	 */
	private Long fans;
	
	/**
	 * @Fields follow : 
	 */
	private Integer follow;
	
	/**
	 * @Fields group : 
	 */
	private Integer group;
	
	/**
	 * @Fields interact : 
	 */
	private Integer interact;
	
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public Integer getDate(){
		return date;
	}

	public void setDate(Integer date){
		this.date = date;
	}
    
	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}
    
	public Long getWbid(){
		return wbid;
	}

	public void setWbid(Long wbid){
		this.wbid = wbid;
	}
    
	public Integer getWeibo(){
		return weibo;
	}

	public void setWeibo(Integer weibo){
		this.weibo = weibo;
	}
    
	public Long getFans(){
		return fans;
	}

	public void setFans(Long fans){
		this.fans = fans;
	}
    
	public Integer getFollow(){
		return follow;
	}

	public void setFollow(Integer follow){
		this.follow = follow;
	}
    
	public Integer getGroup(){
		return group;
	}

	public void setGroup(Integer group){
		this.group = group;
	}
    
	public Integer getInteract(){
		return interact;
	}

	public void setInteract(Integer interact){
		this.interact = interact;
	}
    }