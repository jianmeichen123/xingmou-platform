package ctdn.pojo;

import java.io.Serializable;

public class LabelInfo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields relationId : 关联id
	 */
	private Long relationId;
			
	/**
	 * @Fields title : 标签名称
	 */
	private String title;
			
	/**
	 * @Fields type : 1.项目的行业标签
	 */
	private Integer type;
			
	/**
	 * @Fields createdUid : 创建人id
	 */
	private Long createdUid;
			
	/**
	 * @Fields createdUname : 创建人名称
	 */
	private String createdUname;
			
	/**
	 * @Fields addTime : 
	 */
	private Long addTime;
			
	/**
	 * @Fields updateTime : 
	 */
	private Long updateTime;
		
    
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public Long getRelationId(){
		return relationId;
	}
	
	public void setRelationId(Long relationId){
		this.relationId = relationId;
	}
    
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
    
	public Integer getType(){
		return type;
	}
	
	public void setType(Integer type){
		this.type = type;
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