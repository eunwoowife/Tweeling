package com.kh.order.model.vo;

import java.sql.Date;

public class OrderList {
    private int orderNo;
    private int userNo;
    private int productNum; // 구매 상품 종류 수
    private int productQuantity;    // 구매수량
    private int productPrice;
    private String productName;
    private String thumbnailName;   // originName
    private String thumbnailPath;
    private Date orderDate;
    
    public OrderList() {
        super();
    }
    
    public OrderList(int orderNo, int productPrice, String productName, int productQuantity, String thumbnailPath, String thumbnailName, 
            Date orderDate) {
        super();
        this.orderNo = orderNo;
        this.productPrice = productPrice;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.thumbnailPath = thumbnailPath;
        this.thumbnailName = thumbnailName;
        this.orderDate = orderDate;
    }

    public OrderList(int orderNo, int userNo, int productNum, String productName, String thumbnailName,
            String thumbnailPath, Date orderDate) {
        super();
        this.orderNo = orderNo;
        this.userNo = userNo;
        this.productNum = productNum;
        this.productName = productName;
        this.thumbnailName = thumbnailName;
        this.thumbnailPath = thumbnailPath;
        this.orderDate = orderDate;
    }
    
    public OrderList(int orderNo,  int productPrice, int productNum, int productQuantity, String productName,
            String thumbnailPath, String thumbnailName, Date orderDate) {
       super();
       this.orderNo = orderNo;
       this.productPrice = productPrice;
       this.productNum = productNum;
       this.productQuantity = productQuantity;
       this.productName = productName;
       this.thumbnailPath = thumbnailPath;
       this.thumbnailName = thumbnailName;
       this.orderDate = orderDate;
   }
    
    public int getProductPrice() {
        return productPrice;
    }


    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
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
    public int getProductNum() {
        return productNum;
    }
    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getThumbnailName() {
        return thumbnailName;
    }
    public void setThumbnailName(String thumbnailName) {
        this.thumbnailName = thumbnailName;
    }
    public String getThumbnailPath() {
        return thumbnailPath;
    }
    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    @Override
    public String toString() {
        return "OrderList [orderNo=" + orderNo + ", userNo=" + userNo + ", productNum=" + productNum + ", productName="
                + productName + ", thumbnailName=" + thumbnailName + ", thumbnailPath=" + thumbnailPath + ", orderDate="
                + orderDate + ", orderStatus=" + "]";
    }
    
}
