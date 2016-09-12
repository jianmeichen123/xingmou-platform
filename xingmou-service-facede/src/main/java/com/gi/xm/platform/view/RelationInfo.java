package com.gi.xm.platform.view;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vincent on 16-9-12.
 */
public class RelationInfo implements Serializable{

    private List<ProjectEventRelationInfo> ps;

    private List<InvestfirmsRelationInfo> is;

    public List<ProjectEventRelationInfo> getPs() {
        return ps;
    }

    public void setPs(List<ProjectEventRelationInfo> ps) {
        this.ps = ps;
    }

    public List<InvestfirmsRelationInfo> getIs() {
        return is;
    }

    public void setIs(List<InvestfirmsRelationInfo> is) {
        this.is = is;
    }
}
