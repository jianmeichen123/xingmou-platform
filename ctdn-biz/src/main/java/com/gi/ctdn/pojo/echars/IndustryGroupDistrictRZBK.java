package com.gi.ctdn.pojo.echars;

import java.util.List;

/**
 * Created by zcy on 18-1-17.
 */
public class IndustryGroupDistrictRZBK {
    private Integer industryId;

    private String name;

    private String districtSubName;

    private Integer value;

    private Integer parentId;

    private List<IndustryGroupDistrictRZBK> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Integer industryId) {
        this.industryId = industryId;
    }

    public String getDistrictSubName() {
        return districtSubName;
    }

    public void setDistrictSubName(String districtSubName) {
        this.districtSubName = districtSubName;
    }

    public List<IndustryGroupDistrictRZBK> getChildren() {
        return children;
    }

    public void setChildren(List<IndustryGroupDistrictRZBK> children) {
        this.children = children;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

}
