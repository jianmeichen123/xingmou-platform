package com.gi.xm.platform.view;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vincent on 16-9-10.
 */
public class InvestRelationInfo implements Serializable {

    private String projectName;
    private Long projectId;
    private List<InvestfirmsInfo> investfirmsInfos;
    private List<Long> eventId;

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

    public List<InvestfirmsInfo> getInvestfirmsInfos() {
        return investfirmsInfos;
    }

    public void setInvestfirmsInfos(List<InvestfirmsInfo> investfirmsInfos) {
        this.investfirmsInfos = investfirmsInfos;
    }

    public List<Long> getEventId() {
        return eventId;
    }

    public void setEventId(List<Long> eventId) {
        this.eventId = eventId;
    }
}
