package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.PojoInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ProjectBusinessChange extends PojoInfo {

	/**
	 * @Fields sourceCode : 项目code
	 */
	@ApiModelProperty("项目code")
	private String sourceCode;
	

	/**
	 * @Fields changeItems : 变更事项
	 */
	@ApiModelProperty("变更事项")
	private String changeItems;
	
	/**
	 * @Fields beforeContent : 变更前内容
	 */
	@ApiModelProperty("变更前内容")
	private String beforeContent;
	
	/**
	 * @Fields afterContent : 变更后内容
	 */
	@ApiModelProperty("变更后内容")
	private String afterContent;
	
	/**
	 * @Fields changeDate : 变更日期
	 */
	@ApiModelProperty("变更日期")
	private String changeDate;

	public String getSourceCode(){
		return sourceCode;
	}

	public void setSourceCode(String sourceCode){
		this.sourceCode = sourceCode;
	}
    
	public String getChangeItems(){
		return changeItems;
	}

	public void setChangeItems(String changeItems){
		this.changeItems = changeItems;
	}
    
	public String getBeforeContent(){
		return beforeContent;
	}

	public void setBeforeContent(String beforeContent){
		this.beforeContent = beforeContent;
	}
    
	public String getAfterContent(){
		return afterContent;
	}

	public void setAfterContent(String afterContent){
		this.afterContent = afterContent;
	}
    
	public String getChangeDate(){
		return changeDate;
	}

	public void setChangeDate(String changeDate){
		this.changeDate = changeDate;
	}
    }