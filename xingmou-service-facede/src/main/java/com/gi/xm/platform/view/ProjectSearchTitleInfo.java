package com.gi.xm.platform.view;

import java.util.List;
import java.util.Map;

/**
 * Created by vincent on 16-9-13.
 */
public class ProjectSearchTitleInfo extends SearchTitleInfo {

    private List<IndustryInfo> industryInfoFather;

    private Map<Integer,List<IndustryInfo>> industryInfoSon;

    private List<RoundInfo> roundInfoFather;

    private Map<Long,List<RoundInfo>> roundInfoSon;

    private List<DistrictInfo> home;

    private List<DistrictInfo> outer;

    public List<IndustryInfo> getIndustryInfoFather() {
        return industryInfoFather;
    }

    public void setIndustryInfoFather(List<IndustryInfo> industryInfoFather) {
        this.industryInfoFather = industryInfoFather;
    }

    public Map<Integer, List<IndustryInfo>> getIndustryInfoSon() {
        return industryInfoSon;
    }

    public void setIndustryInfoSon(Map<Integer, List<IndustryInfo>> industryInfoSon) {
        this.industryInfoSon = industryInfoSon;
    }

    public List<RoundInfo> getRoundInfoFather() {
        return roundInfoFather;
    }

    public void setRoundInfoFather(List<RoundInfo> roundInfoFather) {
        this.roundInfoFather = roundInfoFather;
    }

    public List<DistrictInfo> getHome() {
        return home;
    }

    public void setHome(List<DistrictInfo> home) {
        this.home = home;
    }

    public List<DistrictInfo> getOuter() {
        return outer;
    }

    public void setOuter(List<DistrictInfo> outer) {
        this.outer = outer;
    }

    public Map<Long, List<RoundInfo>> getRoundInfoSon() {
        return roundInfoSon;
    }

    public void setRoundInfoSon(Map<Long, List<RoundInfo>> roundInfoSon) {
        this.roundInfoSon = roundInfoSon;
    }
}