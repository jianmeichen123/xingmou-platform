package com.gi.xm.platform.pojo.ctdn;

import com.gi.xm.platform.pojo.Pojo;

import java.util.List;

/**项目
 * Created by zcy on 17-2-16.
 */
public class CtdnProject extends CtdnPojo {

    /**
     * @Fields id :
     */
    private Long id;

    /**
     * @Fields title :项目名
     */
    private String title;

    /**
     * @Fields industryId : 行业id
     */
    private Long industryId;

    /**
     * @Fields industrySubId : 子行业id
     */
    private Long industrySubId;

    /**
     * @Fields projectInfo :项目简介
     */
    private String projectInfo;

    /**
     * @Fields projectCompete :竞品及竞争优势
     */
    private String projectCompete;

    /**
     * @Fields bpFile :bp文件
     */
    private String  bpFile;

    /**
     * @Fields productLogo :产品logo
     */
    private String productLogo;

    /**
     * @Fields productAchievements :运营数据
     */
    private String  productAchievements;

    /**
     * @Fields industryName : 冗余：行业名称
     */
    private String industryName;

    /**
     * @Fields industrySubName : 冗余：子行业名称
     */
    private String industrySubName;

    /**
     * @Fields picList :(冗余)项目图片
     */
    private List<String> picList;

    /**
     * @Fields labelList :（冗余）行业标签
     */
    private List<String>  labelList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(Long industryId) {
        this.industryId = industryId;
    }

    public Long getIndustrySubId() {
        return industrySubId;
    }

    public void setIndustrySubId(Long industrySubId) {
        this.industrySubId = industrySubId;
    }

    public String getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(String projectInfo) {
        this.projectInfo = projectInfo;
    }

    public String getProjectCompete() {
        return projectCompete;
    }

    public void setProjectCompete(String projectCompete) {
        this.projectCompete = projectCompete;
    }

    public String getBpFile() {
        return bpFile;
    }

    public void setBpFile(String bpFile) {
        this.bpFile = bpFile;
    }

    public String getProductLogo() {
        return productLogo;
    }

    public void setProductLogo(String productLogo) {
        this.productLogo = productLogo;
    }

    public String getProductAchievements() {
        return productAchievements;
    }

    public void setProductAchievements(String productAchievements) {
        this.productAchievements = productAchievements;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getIndustrySubName() {
        return industrySubName;
    }

    public void setIndustrySubName(String industrySubName) {
        this.industrySubName = industrySubName;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }

    public List<String> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<String> labelList) {
        this.labelList = labelList;
    }
}
