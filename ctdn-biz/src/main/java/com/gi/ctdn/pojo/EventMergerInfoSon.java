package com.gi.ctdn.pojo;

import java.util.List;

/**
 * Created by wanghao on 17-6-15.
 */
public class EventMergerInfoSon extends EventMergerInfo{

    /**
     * @Fileds eventMergerDetailList 并购详情列表
     */
    private List<EventMergerDetail> eventMergerDetailList;

    /**
     * @Fileds mergeSideList 并购详情列表
     */
    private List<EventMergerDetail> mergeSideList;

    /**
     * @Fileds beenMergeSideList 并购详情列表
     */
    private List<EventMergerDetail> beenMergeSideList;

    public List<EventMergerDetail> getBeenMergeSideList() {
        return beenMergeSideList;
    }

    public void setBeenMergeSideList(List<EventMergerDetail> beenMergeSideList) {
        this.beenMergeSideList = beenMergeSideList;
    }

    public List<EventMergerDetail> getMergeSideList() {

        return mergeSideList;
    }

    public void setMergeSideList(List<EventMergerDetail> mergeSideList) {
        this.mergeSideList = mergeSideList;
    }

    public List<EventMergerDetail> getEventMergerDetailList() {
        return eventMergerDetailList;
    }

    public void setEventMergerDetailList(List<EventMergerDetail> eventMergerDetailList) {
        this.eventMergerDetailList = eventMergerDetailList;
    }
}
