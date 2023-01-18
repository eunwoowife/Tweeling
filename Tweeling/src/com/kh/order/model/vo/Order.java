package com.kh.order.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class Order {
	
	private int orderNo;
	private int userNo;
	private int couponNo;
	private int orderPoint;
	private Date orderDate;
	private int orderTotalAmount;
	private int deliveryFee;
	private int orderFinalAmount;
	private String orderStatus;
	
	private ArrayList<OrderDetail> odList;

	public Order() {
		super();
	}
	
	public Order(int orderNo, int userNo, int couponNo, int orderPoint, Date orderDate, int orderTotalAmount,
			int deliveryFee, int orderFinalAmount, String orderStatus) {
		super();
		this.orderNo = orderNo;
		this.userNo = userNo;
		this.couponNo = couponNo;
		this.orderPoint = orderPoint;
		this.orderDate = orderDate;
		this.orderTotalAmount = orderTotalAmount;
		this.deliveryFee = deliveryFee;
		this.orderFinalAmount = orderFinalAmount;
		this.orderStatus = orderStatus;
	}

	public Order(int orderNo, int userNo, int couponNo, int orderPoint, Date orderDate, int orderTotalAmount,
            int deliveryFee, int orderFinalAmount, String orderStatus, ArrayList<OrderDetail> odList) {
        super();
        this.orderNo = orderNo;
        this.userNo = userNo;
        this.couponNo = couponNo;
        this.orderPoint = orderPoint;
        this.orderDate = orderDate;
        this.orderTotalAmount = orderTotalAmount;
        this.deliveryFee = deliveryFee;
        this.orderFinalAmount = orderFinalAmount;
        this.orderStatus = orderStatus;
        this.odList = odList;
    }
	

	public int getOrderNo() {
		return orderNo;
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
	public int getCouponNo() {
		return couponNo;
	}
	public void setCouponNo(int couponNo) {
		this.couponNo = couponNo;
	}
	public int getOrderPoint() {
		return orderPoint;
	}
	public void setOrderPoint(int orderPoint) {
		this.orderPoint = orderPoint;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderTotalAmount() {
		return orderTotalAmount;
	}
	public void setOrderTotalAmount(int orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}
	public int getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(int deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	public int getOrderFinalAmount() {
		return orderFinalAmount;
	}
	public void setOrderFinalAmount(int orderFinalAmount) {
		this.orderFinalAmount = orderFinalAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", userNo=" + userNo + ", couponNo=" + couponNo + ", orderPoint="
				+ orderPoint + ", orderDate=" + orderDate + ", orderTotalAmount=" + orderTotalAmount + ", deliveryFee="
				+ deliveryFee + ", orderFinalAmount=" + orderFinalAmount + ", OrderStatus=" + orderStatus + "]";
	}
	
	
	
	
	
	
	
}
