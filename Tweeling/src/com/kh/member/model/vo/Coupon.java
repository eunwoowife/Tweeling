package com.kh.member.model.vo;

public class Coupon {
    private int couponNo;
    private int userNo;
    private String couponName;
    private int couponPercent;
    private String couponStatus;
    public Coupon() {
        super();
    }
    public Coupon(int couponNo, int userNo, String couponName, int couponPercent, String couponStatus) {
        super();
        this.couponNo = couponNo;
        this.userNo = userNo;
        this.couponName = couponName;
        this.couponPercent = couponPercent;
        this.couponStatus = couponStatus;
    }
    public int getCouponNo() {
        return couponNo;
    }
    public void setCouponNo(int couponNo) {
        this.couponNo = couponNo;
    }
    public int getUserNo() {
        return userNo;
    }
    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }
    public String getCouponName() {
        return couponName;
    }
    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }
    public int getCouponPercent() {
        return couponPercent;
    }
    public void setCouponPercent(int couponPercent) {
        this.couponPercent = couponPercent;
    }
    public String getCouponStatus() {
        return couponStatus;
    }
    public void setCouponStatus(String couponStatus) {
        this.couponStatus = couponStatus;
    }
    @Override
    public String toString() {
        return "Coupon [couponNo=" + couponNo + ", userNo=" + userNo + ", couponName=" + couponName + ", couponPercent="
                + couponPercent + ", couponStatus=" + couponStatus + "]";
    }
    
}
