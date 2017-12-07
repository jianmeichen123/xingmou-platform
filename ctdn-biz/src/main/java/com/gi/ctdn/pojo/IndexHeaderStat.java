package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Pagination;
import com.gi.ctdn.view.common.PojoInfo;

public class IndexHeaderStat extends PojoInfo {

	public static final String ID = "id";
	public static final String PROJECTNUM = "projectNum";
	public static final String ORGNUM = "orgNum";
	public static final String EVENTNUM = "eventNum";


	/**
	 * @Fields id :
	 */
	private Integer id;

	/**
	 * @Fields projectNum :
	 */
	private Integer projectNum;

	/**
	 * @Fields orgNum :
	 */
	private Integer orgNum;

	/**
	 * @Fields eventNum :
	 */
	private Integer eventNum;

	private Integer startUpNum;

	private Integer investorNum;

	public Integer getStartUpNum() {
		return startUpNum;
	}

	public void setStartUpNum(Integer startUpNum) {
		this.startUpNum = startUpNum;
	}

	public Integer getInvestorNum() {
		return investorNum;
	}

	public void setInvestorNum(Integer investorNum) {
		this.investorNum = investorNum;
	}

	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getProjectNum(){
		return projectNum;
	}

	public void setProjectNum(Integer projectNum){
		this.projectNum = projectNum;
	}

	public Integer getOrgNum(){
		return orgNum;
	}

	public void setOrgNum(Integer orgNum){
		this.orgNum = orgNum;
	}

	public Integer getEventNum(){
		return eventNum;
	}

	public void setEventNum(Integer eventNum){
		this.eventNum = eventNum;
	}
}