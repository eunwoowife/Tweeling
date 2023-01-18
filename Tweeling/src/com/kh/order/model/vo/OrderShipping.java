package com.kh.order.model.vo;

public class OrderShipping {
	
	private int orderNo;
	private String Receiver;
	private String address;
	private String zipCode;
	private String shippingComment;
	private String phone1;
	private String phone2;
	private String status;
	public OrderShipping() {
		super();
	}
	public OrderShipping(int orderNo, String receiver, String address, String zipCode, String shippingComment, String phone1,
			String phone2, String status) {
		super();
		this.orderNo = orderNo;
		Receiver = receiver;
		this.address = address;
		this.zipCode = zipCode;
		this.shippingComment = shippingComment;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.status = status;
	}
	
	public OrderShipping(int orderNo, String receiver, String address, String shippingComment, String phone1,
			String phone2) {
		super();
		this.orderNo = orderNo;
		Receiver = receiver;
		this.address = address;
		this.shippingComment = shippingComment;
		this.phone1 = phone1;
		this.phone2 = phone2;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getReceiver() {
		return Receiver;
	}
	public void setReceiver(String receiver) {
		Receiver = receiver;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getShippingComment() {
		return shippingComment;
	}
	public void setShippingComment(String shippingComment) {
		this.shippingComment = shippingComment;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", Receiver=" + Receiver + ", address=" + address + ", zipCode=" + zipCode
				+ ", shippingComment=" + shippingComment + ", phone1=" + phone1 + ", phone2=" + phone2 + ", status="
				+ status + "]";
	}

}
