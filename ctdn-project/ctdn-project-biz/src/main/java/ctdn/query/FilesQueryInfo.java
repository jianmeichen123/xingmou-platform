package ctdn.query;


import com.gi.xm.platform.view.common.QueryInfo;

public class FilesQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Integer type;
	
	private Long relationId;
	
	private String filePath;
	
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
    
	public Integer getType(){
		return type;
	}
	
	public void setType(Integer type){
		this.type = type;
	}
    
	public Long getRelationId(){
		return relationId;
	}
	
	public void setRelationId(Long relationId){
		this.relationId = relationId;
	}
    
	public String getFilePath(){
		return filePath;
	}
	
	public void setFilePath(String filePath){
		this.filePath = filePath;
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