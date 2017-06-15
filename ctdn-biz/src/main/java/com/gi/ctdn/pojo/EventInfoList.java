package com.gi.ctdn.pojo;

import java.util.List;

/**
 * Created by wanghao on 17-6-15.
 */
public class EventInfoList extends EventInfo{

    /**
     * @Fileds eventDetailList 投资事件详情
     */
    private List<EventDetail> eventDetailList;

    public List<EventDetail> getEventDetailList() {
        return eventDetailList;
    }

    public void setEventDetailList(List<EventDetail> eventDetailList) {
        this.eventDetailList = eventDetailList;
    }
}
