package ctdn.query;


import com.gi.xm.platform.view.common.QueryInfo;

public class ProjectProductQueryInfo extends QueryInfo {
	
	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	private Long projectId;
	
	private String addressType;
	
	private String productName;
	
	private String productAddress;
	
	private Long addTime;
	
	private Long updateTime;
		
    
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
    
	public Long getProjectId(){
		return projectId;
	}
	
	public void setProjectId(Long projectId){
		this.projectId = projectId;
	}
    
	public String getAddressType(){
		return addressType;
	}
	
	public void setAddressType(String addressType){
		this.addressType = addressType;
	}
    
	public String getProductName(){
		return productName;
	}
	
	public void setProductName(String productName){
		this.productName = productName;
	}
    
	public String getProductAddress(){
		return productAddress;
	}
	
	public void setProductAddress(String productAddress){
		this.productAddress = productAddress;
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