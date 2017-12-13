package com.gi.ctdn.pojo.me;

import com.gi.ctdn.pojo.OrgInfo;
import com.gi.ctdn.pojo.ProjectList;
import com.gi.ctdn.view.common.PojoInfo;
import com.gi.ctdn.view.common.Query;

import java.util.List;

/**
 * Created by zcy on 17-12-5.
 */
public class UserCollection extends Query {

    private Integer userId;

    private Integer type;

    private String code;

    private  Integer id;

    private Integer typeNum;

    public Integer getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(Integer typeNum) {
        this.typeNum = typeNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
