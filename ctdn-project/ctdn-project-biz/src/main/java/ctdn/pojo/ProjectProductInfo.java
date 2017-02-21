package ctdn.pojo;

import java.io.Serializable;

public class ProjectProductInfo extends CtdnPojo implements Serializable {

	/**   
	 * @Fields serialVersionUID : 序列化版本号 
	 */ 
	private static final long serialVersionUID = 1L;

			
	/**
	 * @Fields id : 
	 */
	private Long id;
			
	/**
	 * @Fields projectId : 关联项目id
	 */
	private Long projectId;
			
	/**
	 * @Fields addressType : 产品地址类别
	 */
	private String addressType;
			
	/**
	 * @Fields productName : 产品名称
	 */
	private String productName;
			
	/**
	 * @Fields productAddress : 产品地址
	 */
	private String productAddress;

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
    
    }