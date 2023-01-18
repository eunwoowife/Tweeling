package com.kh.review.model.vo;

import java.sql.Date;

public class Review {

//	REVIEW_NO	NUMBER
//	USER_NO	NUMBER
//	REF_PNO	NUMBER
//	REVIEW_CONTENT	VARCHAR2(1000 BYTE)
//	REVIEW_SCORE	NUMBER
//	CREATE_DATE	DATE
//	REVIEW_STATUS	VARCHAR2(1 BYTE)
	
	private int reviewNo;
	private String userNo;
	private int refPno;
	private int orderNo;
	private String reviewContent;
	private int reviewScore;
	private Date createDate;
	private String reviewStatus;

	private int userNo2;
	
	public Review() {
		super();
	}

	
	public Review(int reviewNo, String userNo, int refPno, int orderNo, String reviewContent, int reviewScore,
			Date createDate, String reviewStatus, int userNo2) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.refPno = refPno;
		this.orderNo = orderNo;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
		this.createDate = createDate;
		this.reviewStatus = reviewStatus;
		this.userNo2 = userNo2;
	}

	public Review(int reviewNo, String userNo, int refPno, String reviewContent, int reviewScore, Date createDate,
			String reviewStatus) {
		super();
		this.reviewNo = reviewNo;
		this.userNo = userNo;
		this.refPno = refPno;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
		this.createDate = createDate;
		this.reviewStatus = reviewStatus;
	}
	
	

	public Review(String userNo, String reviewContent, int reviewScore, Date createDate) {
		super();
		this.userNo = userNo;
		this.reviewContent = reviewContent;
		this.reviewScore = reviewScore;
		this.createDate = createDate;
	}
	
	

	public Review(int userNo2, int refPno, int reviewScore, String reviewContent) {
		super();
		this.userNo2 = userNo2;
		this.refPno = refPno;
		this.reviewScore = reviewScore;
		this.reviewContent = reviewContent;
	}

	
	
	
	public int getUserNo2() {
		return userNo2;
	}

	public void setUserNo2(int userNo2) {
		this.userNo2 = userNo2;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public int getRefPno() {
		return refPno;
	}

	public void setRefPno(int refPno) {
		this.refPno = refPno;
	}
	
	public int getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}


	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", userNo=" + userNo + ", refPno=" + refPno + ", reviewContent="
				+ reviewContent + ", reviewScore=" + reviewScore + ", createDate=" + createDate + ", reviewStatus="
				+ reviewStatus + "]";
	}
	
	
}
