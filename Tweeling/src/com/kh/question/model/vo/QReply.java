package com.kh.question.model.vo;

import java.sql.Date;

public class QReply {
    private int replyNo;            //  QUESTION_REPLY_NO    NUMBER
    private int refQno;             //  REF_QNO NUMBER
    private String replyWriter;     //  REPLY_WRITER    NUMBER
    private String replyContent;    //  REPLY_CONTENT   VARCHAR2(400 BYTE)
    private Date createDate;        //  CREATE_DATE DATE
    private String status;          //  STATUS  VARCHAR2(1 BYTE)
    
    public QReply() {
        super();
    }

    public QReply(int replyNo, String replyContent, String replyWriter, Date createDate) {
        super();
        this.replyNo = replyNo;
        this.replyContent = replyContent;
        this.replyWriter = replyWriter;
        this.createDate = createDate;
    }

    public QReply(int replyNo, String replyContent, int refQno, String replyWriter, Date createDate, String status) {
        super();
        this.replyNo = replyNo;
        this.replyContent = replyContent;
        this.refQno = refQno;
        this.replyWriter = replyWriter;
        this.createDate = createDate;
        this.status = status;
    }

    public int getReplyNo() {
        return replyNo;
    }

    public void setReplyNo(int replyNo) {
        this.replyNo = replyNo;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public int getRefQno() {
        return refQno;
    }

    public void setRefQno(int refQno) {
        this.refQno = refQno;
    }

    public String getReplyWriter() {
        return replyWriter;
    }

    public void setReplyWriter(String replyWriter) {
        this.replyWriter = replyWriter;
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

    @Override
    public String toString() {
        return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", refQno=" + refQno + ", replyWriter="
                + replyWriter + ", createDate=" + createDate + ", status=" + status + "]";
    }
    
    
}
