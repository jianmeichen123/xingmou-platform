package ctdn.query;


import com.gi.xm.platform.view.common.QueryInfo;

import java.util.Date;

public class TeamMemberJobQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Long memberId;
	
	private String companyName;
	
	private String companyUrl;
	
	private String position;
	
	private Date startDate;
	
	private Date endDate;
	
	private String descrip;
	
	private Long createdUid;
	
	private String createdUname;
	
	private Long addTime;
	
	private Long updateTime;
		
    
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
    
	public String getCompanyName(){
		return companyName;
	}
	
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
    
	public String getCompanyUrl(){
		return companyUrl;
	}
	
	public void setCompanyUrl(String companyUrl){
		this.companyUrl = companyUrl;
	}
    
	public String getPosition(){
		return position;
	}
	
	public void setPosition(String position){
		this.position = position;
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
    
	public String getDescrip(){
		return descrip;
	}
	
	public void setDescrip(String descrip){
		this.descrip = descrip;
	}
    
	public Long getCreatedUid(){
		return createdUid;
	}
	
	public void setCreatedUid(Long createdUid){
		this.createdUid = createdUid;
	}
    
	public String getCreatedUname(){
		return createdUname;
	}
	
	public void setCreatedUname(String createdUname){
		this.createdUname = createdUname;
	}
    
	public Long getAddTime(){
		return addTime;
	}
	
	public void setAddTime(Long addTime){
		this.addTime = addTime;
	}
    
	public Long getUpdateTime(){
		return updateTime;
	}
	
	public void setUpdateTime(Long updateTime){
		this.updateTime = updateTime;
	}
    }