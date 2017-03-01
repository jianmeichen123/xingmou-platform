package com.gi.ctdn.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zcy on 17-2-17.
 */
public class CtdnPojo {
    /**
     * @Fields addTime :
     */
    private Long addTime;

    /**
     * @Fields updateTime :
     */
    private Long updateTime;

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

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
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
