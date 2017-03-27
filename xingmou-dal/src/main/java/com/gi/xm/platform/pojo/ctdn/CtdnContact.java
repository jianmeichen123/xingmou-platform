package com.gi.xm.platform.pojo.ctdn;

/**
 * 成员
 * Created by zcy on 17-2-16.
 */
public class CtdnContact extends CtdnPojo{

    /**
     * @Fields id :
     */
    private Long id;

    /**
     * @Fields projectId :项目id
     */
    private Long projectId;

    /**
     * @Fields contactName :联系人
     */
    private String contactName;

    /**
     * @Fields contactPosition :职位
     */
    private String  contactPosition;

    /**
     * @Fields contactEmail :邮箱
     */
    private String  contactEmail;

    /**
     * @Fields contactPhone :联系人电话
     */
    private String contactPhone;

    /**
     * @Fields contactRole :联系人在公司的角色
     */
    private String contactRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPosition() {
        return contactPosition;
    }

    public void setContactPosition(String contactPosition) {
        this.contactPosition = contactPosition;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactRole() {
        return contactRole;
    }

    public void setContactRole(String contactRole) {
        this.contactRole = contactRole;
    }
}
