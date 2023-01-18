package com.kh.question.model.vo;

public class QAttachment {
    private int fileNo;
    private int questionNo;
    private String originName;
    private String changeName;
    private String filePath;
    private int fileLevel;
    
    public QAttachment() {
        super();
    }

    public QAttachment(int fileNo, int questionNo, String originName, String changeName) {
        super();
        this.fileNo = fileNo;
        this.questionNo = questionNo;
        this.originName = originName;
        this.changeName = changeName;
    }
    
    public QAttachment(int fileNo, int questionNo, String originName, String filePath, int fileLevel) {
        super();
        this.fileNo = fileNo;
        this.questionNo = questionNo;
        this.originName = originName;
        this.filePath = filePath;
        this.fileLevel = fileLevel;
    }

    public QAttachment(int fileNo, int questionNo, String originName, String changeName, String filePath,
            int fileLevel) {
        super();
        this.fileNo = fileNo;
        this.questionNo = questionNo;
        this.originName = originName;
        this.changeName = changeName;
        this.filePath = filePath;
        this.fileLevel = fileLevel;
    }

    public int getFileNo() {
        return fileNo;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getChangeName() {
        return changeName;
    }

    public void setChangeName(String changeName) {
        this.changeName = changeName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public int getFileLevel() {
        return fileLevel;
    }

    public void setFileLevel(int fileLevel) {
        this.fileLevel = fileLevel;
    }

    @Override
    public String toString() {
        return "QAttachment [fileNo=" + fileNo + ", questionNo=" + questionNo + ", originName=" + originName
                + ", changeName=" + changeName + ", filePath=" + filePath + ", fileLevel=" + fileLevel + "]";
    }
    
}
