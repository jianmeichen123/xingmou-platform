package com.gi.ctdn.pojo;

/**
 * Created by wanghao on 17-11-15.
 */
public class CompMember {
    public static final String COMPCODE = "公司唯一标识";
    public static final String COMPJOB = "任职职务";
    public static final String MEMBERNAME = "姓名";

    private String compCode;
    private String compJob;
    private String memberName;

    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    public String getCompJob() {
        return compJob;
    }

    public void setCompJob(String compJob) {
        this.compJob = compJob;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
