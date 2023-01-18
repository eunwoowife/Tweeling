package com.kh.question.model.vo;

import java.sql.Date;

public class Question {
    private int rnum;
    private int questionNo;
    private int questionWriter;
    private int questionType;
    private String questionTitle;
    private String questionContent;
    private Date createDate;
    private String status;
    public Question() {
        super();
    }
    
    public Question(int questionWriter, int questionType, String questionTitle, String questionContent) {
        super();
        this.questionWriter = questionWriter;
        this.questionType = questionType;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
    }

    public Question(int questionNo, int questionWriter, int questionType, String questionTitle, String questionContent) {
        super();
        this.questionNo = questionNo;
        this.questionWriter = questionWriter;
        this.questionType = questionType;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
    }

    public Question(int questionNo, int questionWriter, int questionType, String questionTitle, String questionContent,
            Date createDate, String status) {
        super();
        this.questionNo = questionNo;
        this.questionWriter = questionWriter;
        this.questionType = questionType;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.createDate = createDate;
        this.status = status;
    }

    public Question(int rnum, int questionNo, int questionWriter, int questionType, String questionTitle,
            String questionContent, Date createDate, String status) {
        super();
        this.rnum = rnum;
        this.questionNo = questionNo;
        this.questionWriter = questionWriter;
        this.questionType = questionType;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.createDate = createDate;
        this.status = status;
    }

    public int getRnum() {
        return rnum;
    }

    public void setRnum(int rnum) {
        this.rnum = rnum;
    }

    public int getQuestionNo() {
        return questionNo;
    }
    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }
    public int getQuestionWriter() {
        return questionWriter;
    }
    public void setQuestionWriter(int questionWriter) {
        this.questionWriter = questionWriter;
    }
    public int getQuestionType() {
        return questionType;
    }
    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }
    public String getQuestionTitle() {
        return questionTitle;
    }
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }
    public String getQuestionContent() {
        return questionContent;
    }
    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
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
        return "Question [questionNo=" + questionNo + ", questionWriter=" + questionWriter + ", questionType="
                + questionType + ", questionTitle=" + questionTitle + ", questionContent=" + questionContent
                + ", createDate=" + createDate + ", status=" + status + "]";
    }
    
}
