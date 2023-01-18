package com.kh.event.model.vo;

public class EventGotchaMember {
    
    private String gotchaUserNo;
    private String gotchaUserNickname;
    private int gotchaUserPhone;
    public EventGotchaMember() {
        super();
    }
    public EventGotchaMember(String gotchaUserNo, String gotchaUserNickname, int gotchaUserPhone) {
        super();
        this.gotchaUserNo = gotchaUserNo;
        this.gotchaUserNickname = gotchaUserNickname;
        this.gotchaUserPhone = gotchaUserPhone;
    }
    public String getGotchaUserNo() {
        return gotchaUserNo;
    }
    public void setGotchaUserNo(String gotchaUserNo) {
        this.gotchaUserNo = gotchaUserNo;
    }
    public String getGotchaUserNickname() {
        return gotchaUserNickname;
    }
    public void setGotchaUserNickname(String gotchaUserNickname) {
        this.gotchaUserNickname = gotchaUserNickname;
    }
    public int getGotchaUserPhone() {
        return gotchaUserPhone;
    }

    public void setGotchaUserPhone(int gotchaUserPhone) {
        this.gotchaUserPhone = gotchaUserPhone;
    }
    @Override
    public String toString() {
        return "EventGotchaMember [gotchaUserNo=" + gotchaUserNo + ", gotchaUserNickname=" + gotchaUserNickname
                + ", gotchaUserPhone=" + gotchaUserPhone + "]";
    }


}
