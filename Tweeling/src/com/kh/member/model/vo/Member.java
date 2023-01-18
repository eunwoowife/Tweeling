package com.kh.member.model.vo;

import java.sql.Date;

public class Member {
    private int userNo;             // 회원 번호
    private String userId;          // 회원 아이디
    private String userPwd;         // 회원 비밀번호
    private String userName;        // 회원 이름            
    private String userNinkname;    // 회원 닉네임
    private String phone;           // 전화번호
    private String email;           // 이메일
    private String gender;          // 성별
    private String address;         // 주소
    private Date userBday;          // 생일
    private String userBias;        // 관심 셀럽
    private Date enrollDate;        // 회원가입일
    private int point;              // 적립 포인트
    private String userStatus;      // 회원 상태(Y/N)
    private String adminStatus;     // 관리자여부(Y/N)
    
    public Member() {
        super();
    }

    public Member(String userId) {
        super();
        this.userId = userId;
    }
    
    public Member(String userId, String userPwd, String userName, String userNinkname, String phone, String email,
            String gender, String address, Date userBday, String userBias) {
        super();
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userNinkname = userNinkname;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.userBday = userBday;
        this.userBias = userBias;
    }
    
     public Member(String userId, String userName, String email, String userStatus) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.userStatus = userStatus;
    }
    
    
    public Member(int userNo, String userName, String phone, String email, String address) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public Member(int userNo, String userId, String userPwd, String userName, String userNinkname, String phone,
            String email, String gender, String address, Date userBday, String userBias, Date enrollDate, int point,
            String userStatus, String adminStatus) {
        super();
        this.userNo = userNo;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userNinkname = userNinkname;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.userBday = userBday;
        this.userBias = userBias;
        this.enrollDate = enrollDate;
        this.point = point;
        this.userStatus = userStatus;
        this.adminStatus = adminStatus;
    }
	
	public Member(String userId, String userPwd, String userNinkname, String phone, String email, String gender,
            String address, String userBias) {
        super();
        this.userId = userId;
        this.userPwd = userPwd;
        this.userNinkname = userNinkname;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.userBias = userBias;
    }
	
	
    public Member(int userNo, String userId, String userPwd, String userName, String userNinkname, String phone,
            String email, String gender, String address, Date userBday, String userBias, Date enrollDate, int point,
            String userStatus) {
        super();
        this.userNo = userNo;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userNinkname = userNinkname;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.userBday = userBday;
        this.userBias = userBias;
        this.enrollDate = enrollDate;
        this.point = point;
        this.userStatus = userStatus;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNinkname() {
        return userNinkname;
    }

    public void setUserNinkname(String userNinkname) {
        this.userNinkname = userNinkname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getUserBday() {
        return userBday;
    }

    public void setUserBday(Date userBday) {
        this.userBday = userBday;
    }

    public String getUserBias() {
        return userBias;
    }

    public void setUserBias(String userBias) {
        this.userBias = userBias;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    @Override
    public String toString() {
        return "Member [userNo=" + userNo + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
                + ", userNinkname=" + userNinkname + ", phone=" + phone + ", email=" + email + ", gender=" + gender
                + ", address=" + address + ", userBday=" + userBday + ", userBias=" + userBias + ", enrollDate="
                + enrollDate + ", point=" + point + ", userStatus=" + userStatus + ", adminStatus=" + adminStatus + "]";
    }
    
}
