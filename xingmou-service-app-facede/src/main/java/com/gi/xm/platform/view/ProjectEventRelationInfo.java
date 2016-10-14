package com.gi.xm.platform.view;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by vincent on 16-9-10.
 */
public class ProjectEventRelationInfo implements Serializable {

    private String projectName;
    private Long projectId;
    private Set<Long> investfirmId;
    private Integer total = 1;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Set<Long> getInvestfirmId() {
        return investfirmId;
    }

    public void setInvestfirmId(Set<Long> investfirmId) {
        this.investfirmId = investfirmId;
    }
}
