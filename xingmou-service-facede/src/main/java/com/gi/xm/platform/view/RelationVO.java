package com.gi.xm.platform.view;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vincent on 16-9-12.
 */
public class RelationVO implements Serializable{
    //项目列表
    private List<InvestEventsInfo> projectList;
    //投融资关系列表
    private List<InvestProjectInvestfirmInfo> piList;
    //投资机构列表
    private List<InvestfirmsInfo> investfirmList;


    public List<InvestEventsInfo> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<InvestEventsInfo> projectList) {
        this.projectList = projectList;
    }

    public List<InvestProjectInvestfirmInfo> getPiList() {
        return piList;
    }

    public void setPiList(List<InvestProjectInvestfirmInfo> piList) {
        this.piList = piList;
    }

    public List<InvestfirmsInfo> getInvestfirmList() {
        return investfirmList;
    }

    public void setInvestfirmList(List<InvestfirmsInfo> investfirmList) {
        this.investfirmList = investfirmList;
    }
}
