package com.gi.ctdn.pojo;

import com.gi.ctdn.view.common.Query;

/**
 * Created by wanghao on 17-11-15.
 */
public class CompSub extends Query {
    public static final String COMPCODE = "公司唯一标识";
    public static final String COMPFULLTITLE = "公司全称";
    public static final String COMPSUBFULLTITLE = "子公司全称";

    private String compCode;
    private String compFulltitle;
    private String compSubFulltitle;

    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    public String getCompFulltitle() {
        return compFulltitle;
    }

    public void setCompFulltitle(String compFulltitle) {
        this.compFulltitle = compFulltitle;
    }

    public String getCompSubFulltitle() {
        return compSubFulltitle;
    }

    public void setCompSubFulltitle(String compSubFulltitle) {
        this.compSubFulltitle = compSubFulltitle;
    }
}
