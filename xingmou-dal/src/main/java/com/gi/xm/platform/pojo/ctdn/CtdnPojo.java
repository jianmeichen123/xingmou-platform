package com.gi.xm.platform.pojo.ctdn;

import java.awt.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * Created by zcy on 17-2-16.
 */
public class CtdnPojo implements Serializable{

    /**
     * @Fields createdUid : 创建人ｉd
     */
    private  Long createdUid;

    /**
     * @Fields createUname : 创建人
     */
    private String createUname;

    /**
     * @Fields addTime : 添加时间
     */
    private Date addTime;

    /**
     * @Fields updateTime : 修改时间
     */
    private Date updateTime;

    public Long getCreatedUid() {
        return createdUid;
    }

    public void setCreatedUid(Long createdUid) {
        this.createdUid = createdUid;
    }

    public String getCreateUname() {
        return createUname;
    }

    public void setCreateUname(String createUname) {
        this.createUname = createUname;
    }

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
}
