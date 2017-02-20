package ctdn.pojo;

import java.io.Serializable;

public class FilesInfo extends CtdnPojo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields type : 类型:1.产品图片,2.团队成员头像
	 */
	private Integer type;
			
	/**
	 * @Fields relationId : 关联id :1.project_id
	 */
	private Long relationId;
			
	/**
	 * @Fields filePath : 文件存放地址
	 */
	private String filePath;
			
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
    
    }