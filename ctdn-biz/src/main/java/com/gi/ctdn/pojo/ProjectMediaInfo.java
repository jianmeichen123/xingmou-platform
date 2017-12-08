package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProjectMediaInfo extends Query {
	/**
	 * @Fields projectId : 项目code
	 */
	@ApiModelProperty(value = "项目code")
	private String projectCode;
	
	/**
	 * @Fields code : code
	 */
	@ApiModelProperty(value = "code")
	private String code;
	
	/**
	 * @Fields projTitle : 项目名称
	 */
	@ApiModelProperty(value = "项目名称")
	private String projTitle;
	
	/**
	 * @Fields date : 日期
	 */
	@ApiModelProperty(value = " 日期")
	private String date;
	
	/**
	 * @Fields source : 来源
	 */
	@ApiModelProperty(value = "来源")
	private String source;
	
	/**
	 * @Fields content : 内容
	 */
	@ApiModelProperty(value = "内容")
	private String content;
	
	/**
	 * @Fields type : 类型[H:历史]
	 */
	@ApiModelProperty(value = "type : 类型[H:历史]")
	private String type;


	/**
	 * @Fields link :link
	 */
	@ApiModelProperty(value = "点击链接")
	private String link;

	public String getCode(){
		return code;
	}

	public void setCode(String code){
		this.code = code;
	}
    
	public String getProjTitle(){
		return projTitle;
	}

	public void setProjTitle(String projTitle){
		this.projTitle = projTitle;
	}
    
	public String getDate(){
		return date;
	}

	public void setDate(String date){
		this.date = date;
	}
    
	public String getSource(){
		return source;
	}

	public void setSource(String source){
		this.source = source;
	}
    
	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content = content;
	}
    
	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
}