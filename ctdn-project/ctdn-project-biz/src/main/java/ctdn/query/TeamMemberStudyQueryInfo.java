package ctdn.query;


import com.gi.xm.platform.view.common.QueryInfo;

import java.util.Date;

public class TeamMemberStudyQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Long memberId;
	
	private String shoolName;
	
	private Date startDate;
	
	private Date endDate;
	
	private String major;
	
	private String degree;
	
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
    
	public String getShoolName(){
		return shoolName;
	}
	
	public void setShoolName(String shoolName){
		this.shoolName = shoolName;
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
    
	public String getMajor(){
		return major;
	}
	
	public void setMajor(String major){
		this.major = major;
	}
    
	public String getDegree(){
		return degree;
	}
	
	public void setDegree(String degree){
		this.degree = degree;
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