package com.kh.event.model.vo;

public class EventAttachment {

    private int eventAttachmentNo;
    private int refEventNo;
    private String eventOriginName;
    private String eventChangeName;
    private String eventFilePath;
    private String status;

    public EventAttachment() {
        super();
    }

    public EventAttachment(int eventAttachmentNo, int refEventNo, String eventOriginName, String eventChangeName,
            String eventFilePath, String status) {
        super();
        this.eventAttachmentNo = eventAttachmentNo;
        this.refEventNo = refEventNo;
        this.eventOriginName = eventOriginName;
        this.eventChangeName = eventChangeName;
        this.eventFilePath = eventFilePath;
        this.status = status;
    }

    public EventAttachment(int eventAttachmentNo, String eventOriginName, String eventChangeName,
            String eventFilePath) {
        super();
        this.eventAttachmentNo = eventAttachmentNo;
        this.eventOriginName = eventOriginName;
        this.eventChangeName = eventChangeName;
        this.eventFilePath = eventFilePath;
    }

    public int getEventAttachmentNo() {
        return eventAttachmentNo;
    }

    public void setEventAttachmentNo(int eventAttachmentNo) {
        this.eventAttachmentNo = eventAttachmentNo;
    }

    public int getRefEventNo() {
        return refEventNo;
    }

    public void setRefEventNo(int refEventNo) {
        this.refEventNo = refEventNo;
    }

    public String getEventOriginName() {
        return eventOriginName;
    }

    public void setEventOriginName(String eventOriginName) {
        this.eventOriginName = eventOriginName;
    }

    public String getEventChangeName() {
        return eventChangeName;
    }

    public void setEventChangeName(String eventChangeName) {
        this.eventChangeName = eventChangeName;
    }

    public String getEventFilePath() {
        return eventFilePath;
    }

    public void setEventFilePath(String eventFilePath) {
        this.eventFilePath = eventFilePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EventAttachment [eventAttachmentNo=" + eventAttachmentNo + ", refEventNo=" + refEventNo
                + ", eventOriginName=" + eventOriginName + ", eventChangeName=" + eventChangeName + ", eventFilePath="
                + eventFilePath + ", status=" + status + "]";
    }
    
    

}
