package com.gi.ctdn.pojo;

import java.util.Date;

/**
 * Created by zcy on 17-2-17.
 */
public class CtdnPojo {
    /**
     * @Fields addTime :
     */
    private Date addTime;

    /**
     * @Fields updateTime :
     */
    private Date updateTime;

    /**
     * @Fields createdUid : 创建人id
     */
    private Long createdUid;

    /**
     * @Fields createdUname : 创建人名称
     */
    private String createdUname;

    /**
     *@Fields idDelete : 逻辑删除字段
     * @return
     */
    private Integer isDeleted;

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreatedUid() {
        return createdUid;
    }

    public void setCreatedUid(Long createdUid) {
        this.createdUid = createdUid;
    }

    public String getCreatedUname() {
        return createdUname;
    }

    public void setCreatedUname(String createdUname) {
        this.createdUname = createdUname;
    }
}
