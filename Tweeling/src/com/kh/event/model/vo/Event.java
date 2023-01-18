package com.kh.event.model.vo;

import java.sql.Date;

public class Event {

    private int eventNo;
    private int eventType;
    private String eventTopic;
    private String eventTitle;
    private String eventContent;
    private String eventStartDate;
    private String eventEndDate;
    private Date createDate;
    private String status;
    private String gotchaYn;

    public Event() {
        super();
    }

    public Event(int eventNo, int eventType, String eventTopic, String eventTitle,
            String eventContent, String eventStartDate, String eventEndDate, Date createDate, String status, String gotchaYn) {
        super();
        this.eventNo = eventNo;
        this.eventType = eventType;
        this.eventTopic = eventTopic;
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.createDate = createDate;
        this.status = status;
        this.gotchaYn = gotchaYn;
    }

    public Event(int eventNo, int eventType, String eventTopic, String eventTitle, String eventContent,
            String eventStartDate, String eventEndDate, Date createDate, String gotchaYn) {
        super();
        this.eventNo = eventNo;
        this.eventType = eventType;
        this.eventTopic = eventTopic;
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.createDate = createDate;
        this.gotchaYn = gotchaYn;
    }

    public Event(int eventNo, int eventType, String eventTopic, String eventTitle, String eventStartDate,
            String eventEndDate, Date createDate) {
        super();
        this.eventNo = eventNo;
        this.eventType = eventType;
        this.eventTopic = eventTopic;
        this.eventTitle = eventTitle;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.createDate = createDate;
    }

    public Event(int eventNo, int eventType, String eventTopic, String eventTitle, String eventContent,
            String eventStartDate, String eventEndDate, Date createDate) {
        super();
        this.eventNo = eventNo;
        this.eventType = eventType;
        this.eventTopic = eventTopic;
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
        this.eventStartDate = eventStartDate;
        this.eventEndDate = eventEndDate;
        this.createDate = createDate;
    }

    public int getEventNo() {
        return eventNo;
    }

    public void setEventNo(int eventNo) {
        this.eventNo = eventNo;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getEventTopic() {
        return eventTopic;
    }

    public void setEventTopic(String eventTopic) {
        this.eventTopic = eventTopic;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getGotchaYn() {
        return gotchaYn;
    }

    public void setGotchaYn(String gotchaYn) {
        this.gotchaYn = gotchaYn;
    }

    @Override
    public String toString() {
        return "Event [eventNo=" + eventNo + ", eventType=" + eventType
                + ", eventTopic=" + eventTopic + ", eventTitle=" + eventTitle + ", eventContent=" + eventContent
                + ", eventStartDate=" + eventStartDate + ", eventEndDate=" + eventEndDate + ", createDate=" + createDate
                + ", status=" + status + ", gotchaYn=" + gotchaYn + "]";
    }

}
