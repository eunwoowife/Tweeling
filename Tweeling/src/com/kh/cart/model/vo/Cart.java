package com.kh.cart.model.vo;

public class Cart {
      
    
    private int userNo;
    private int productNo;
    private int productQuality;
    private int productStock;
    private String celebName;
    private String productName;
    private String productPrice;
    private String titleImg;
    
    public Cart() {
        super();
    }

	public Cart(int userNo, int productNo, int productQuality, int productStock, String celebName, String productName,
			String productPrice, String titleImg) {
		super();
		this.userNo = userNo;
		this.productNo = productNo;
		this.productQuality = productQuality;
		this.productStock = productStock;
		this.celebName = celebName;
		this.productName = productName;
		this.productPrice = productPrice;
		this.titleImg = titleImg;
	}
	
	
	
	


	public Cart(int productNo, int productQuality, String celebName, String productName, String productPrice,
			String titleImg) {
		super();
		this.productNo = productNo;
		this.productQuality = productQuality;
		this.celebName = celebName;
		this.productName = productName;
		this.productPrice = productPrice;
		this.titleImg = titleImg;
	}

	public Cart(int userNo, int productNo, int productQuality) {
		super();
		this.userNo = userNo;
		this.productNo = productNo;
		this.productQuality = productQuality;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getProductQuality() {
		return productQuality;
	}

	public void setProductQuality(int productQuality) {
		this.productQuality = productQuality;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public String getCelebName() {
		return celebName;
	}

	public void setCelebName(String celebName) {
		this.celebName = celebName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	@Override
	public String toString() {
		return "Cart [userNo=" + userNo + ", productNo=" + productNo + ", productQuality=" + productQuality
				+ ", productStock=" + productStock + ", celebName=" + celebName + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", titleImg=" + titleImg + "]";
	}
   
    
    
    
    
    }
