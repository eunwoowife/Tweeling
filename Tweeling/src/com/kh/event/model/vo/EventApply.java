package com.kh.event.model.vo;

import java.util.Date;

public class EventApply {

    private int eventApplyNo;
    private int eventParticipantNo;
    private int refEventNo;
    private Date applyDate;
    private String applyStatus;

    public EventApply() {
        super();
    }

    public EventApply(int eventApplyNo, int eventParticipantNo, int refEventNo, Date applyDate, String applyStatus) {
        super();
        this.eventApplyNo = eventApplyNo;
        this.eventParticipantNo = eventParticipantNo;
        this.refEventNo = refEventNo;
        this.applyDate = applyDate;
        this.applyStatus = applyStatus;
    }

    public EventApply(String applyStatus) {
        super();
        this.applyStatus = applyStatus;
    }

    public int getEventApplyNo() {
        return eventApplyNo;
    }

    public void setEventApplyNo(int eventApplyNo) {
        this.eventApplyNo = eventApplyNo;
    }

    public int getEventParticipantNo() {
        return eventParticipantNo;
    }

    public void setEventParticipantNo(int eventParticipantNo) {
        this.eventParticipantNo = eventParticipantNo;
    }

    public int getRefEventNo() {
        return refEventNo;
    }

    public void setRefEventNo(int refEventNo) {
        this.refEventNo = refEventNo;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Override
    public String toString() {
        return "EventApply [eventApplyNo=" + eventApplyNo + ", eventParticipantNo=" + eventParticipantNo
                + ", refEventNo=" + refEventNo + ", applyDate=" + applyDate + ", applyStatus=" + applyStatus + "]";
    }

}
