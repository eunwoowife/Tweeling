package com.kh.order.model.vo;

public class OrderDetail {
	
	private int orderNo;
	private int userNo;
	private int productNo;
	private String productName;
	private int quantity;
	private String option1;
	private String option2;
	private String status;

	public OrderDetail() {
		super();
	}

	public OrderDetail(int orderNo, int productNo, String productName, int quantity, String option1, String option2,
	String status) {
		super();
		this.orderNo = orderNo;
		this.productNo = productNo;
		this.productName = productName;
		this.quantity = quantity;
		this.option1 = option1;
		this.option2 = option2;
		this.status = status;
	}


	public OrderDetail(int orderNo, int userNo, int quantity, String option1, String option2, String status) {
		super();
		this.orderNo = orderNo;
		this.userNo = userNo;
		this.quantity = quantity;
		this.option1 = option1;
		this.option2 = option2;
		this.status = status;
	}

	public int getProductNo() {
        return productNo;
    }

	public void setProductNo(int productNo){
		this.productNo = productNo;
	}

    public String getProductName() {
        return productName;
    }

	public void setProductName(String productName){
		this.productName = productName;
	}

	public int getOrderNo() {
		return
		 orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderNo=" + orderNo + ", userNo=" + userNo + ", quantity=" + quantity + ", option1="
				+ option1 + ", option2=" + option2 + ", status=" + status + "]";
	}
	
	

}
