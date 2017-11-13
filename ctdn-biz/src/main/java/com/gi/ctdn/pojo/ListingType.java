package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Pagination;

import java.util.List;

public class ListingType extends Pagination {

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String TYPEID = "typeId";
        public static final String TYPENAME = "typeName";
        public static final String PARENTID = "parentId";
        public static final String VAL = "val";
        public static final String CHILDREN = "children";

    
	
	/**
	 * @Fields id : 
	 */
	private Integer id;
	
	/**
	 * @Fields name : 
	 */
	private String name;
	
	/**
	 * @Fields typeId : 
	 */
	private Integer typeId;
	
	/**
	 * @Fields typeName : 
	 */
	private String typeName;
	
	/**
	 * @Fields parentId : 
	 */
	private Integer parentId;
	
	/**
	 * @Fields val : 
	 */
	private Integer val;

	/**
	 * @Fields listingTypeList :
	 */
	private List<ListingType> children;
	
    
	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}
    
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
    
	public Integer getTypeId(){
		return typeId;
	}

	public void setTypeId(Integer typeId){
		this.typeId = typeId;
	}
    
	public String getTypeName(){
		return typeName;
	}

	public void setTypeName(String typeName){
		this.typeName = typeName;
	}
    
	public Integer getParentId(){
		return parentId;
	}

	public void setParentId(Integer parentId){
		this.parentId = parentId;
	}
    
	public Integer getVal(){
		return val;
	}

	public void setVal(Integer val){
		this.val = val;
	}

	public List getChildren() { return children; }

	public void setChildren(List children) { this.children = children; }
    }