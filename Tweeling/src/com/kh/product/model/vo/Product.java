package com.kh.product.model.vo;

import java.sql.Date;

public class Product {

//	PRODUCT_NO	NUMBER
//	PRODUCT_CATEGORY_NO	NUMBER
//	PRODUCT_NAME	VARCHAR2(200 BYTE)
//	CELEB_NAME	VARCHAR2(30 BYTE)
//	PRODUCT_STOCK	NUMBER
//	PRODUCT_CONTENT	VARCHAR2(4000 BYTE)
//	PRODUCT_PRICE	NUMBER
//	PRODUCT_COMMENT	VARCHAR2(400 BYTE)
//	PRODUCT_ENROLLDATE	DATE
//	PRODUCT_STATUS	VARCHAR2(1 BYTE)
	
	private int productNo;
	private String categoryNo;
	private String productName;
	private String celebName;
	private int productStock;
	private String productContent;
	private int productPrice;
	private String productComment;
	private Date productEnrollDate;
	private String status;
	
	private String titleImg;
	
	private int fileNo;
	private String filePath;
	private String originName;
	
	public Product() {
		super();
	}

	public Product(int productNo, String productName, int productPrice, String titleImg) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.titleImg = titleImg;
	}
	
	public Product(int productNo, String productName, String celebName, int productPrice, String titleImg) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.celebName = celebName;
		this.productPrice = productPrice;
		this.titleImg = titleImg;
	}

	public Product(int productNo, String productName, String celebName, int productPrice, String status,
			String titleImg) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.celebName = celebName;
		this.productPrice = productPrice;
		this.status = status;
		this.titleImg = titleImg;
	}

	public Product(int productNo, String productName, String celebName, int productStock, String productContent,
			int productPrice, String productComment) {
		super();
		this.productNo = productNo;
		this.productName = productName;
		this.celebName = celebName;
		this.productStock = productStock;
		this.productContent = productContent;
		this.productPrice = productPrice;
		this.productComment = productComment;
	}

	public Product(int productNo, String productName, String celebName, int productStock, String productContent,
            int productPrice, String productComment, String titleImg) {
        super();
        this.productNo = productNo;
        this.productName = productName;
        this.celebName = celebName;
        this.productStock = productStock;
        this.productContent = productContent;
        this.productPrice = productPrice;
        this.productComment = productComment;
        this.titleImg = titleImg;
    }

	public Product(int productNo, String categoryNo, String productName, String celebName, int productStock,
			String productContent, int productPrice, String productComment, Date productEnrollDate, String status) {
		super();
		this.productNo = productNo;
		this.categoryNo = categoryNo;
		this.productName = productName;
		this.celebName = celebName;
		this.productStock = productStock;
		this.productContent = productContent;
		this.productPrice = productPrice;
		this.productComment = productComment;
		this.productEnrollDate = productEnrollDate;
		this.status = status;
	}
	
	public Product(int productNo, String categoryNo, String productName, String celebName, int productStock,
			String productContent, int productPrice, String productComment, String status, String titleImg) {
		super();
		this.productNo = productNo;
		this.categoryNo = categoryNo;
		this.productName = productName;
		this.celebName = celebName;
		this.productStock = productStock;
		this.productContent = productContent;
		this.productPrice = productPrice;
		this.productComment = productComment;
		this.status = status;
		this.titleImg = titleImg;
	}

	public Product(int productNo, String categoryNo, String productName, String celebName, int productStock,
			String productContent, int productPrice, String productComment, String titleImg) {
		super();
		this.productNo = productNo;
		this.categoryNo = categoryNo;
		this.productName = productName;
		this.celebName = celebName;
		this.productStock = productStock;
		this.productContent = productContent;
		this.productPrice = productPrice;
		this.productComment = productComment;
		this.titleImg = titleImg;
	}
	
	public Product(int productNo, String categoryNo, String productName, String celebName, int productStock,
			String productContent, int productPrice, String productComment, Date productEnrollDate, String status,
			int fileNo, String filePath, String originName) {
		super();
		this.productNo = productNo;
		this.categoryNo = categoryNo;
		this.productName = productName;
		this.celebName = celebName;
		this.productStock = productStock;
		this.productContent = productContent;
		this.productPrice = productPrice;
		this.productComment = productComment;
		this.productEnrollDate = productEnrollDate;
		this.status = status;
		this.fileNo = fileNo;
		this.filePath = filePath;
		this.originName = originName;
	}
	

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getTitleImg() {
		return titleImg;
	}

	public void setTitleImg(String titleImg) {
		this.titleImg = titleImg;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCelebName() {
		return celebName;
	}

	public void setCelebName(String celebName) {
		this.celebName = celebName;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public String getProductContent() {
		return productContent;
	}

	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductComment() {
		return productComment;
	}

	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}

	public Date getProductEnrollDate() {
		return productEnrollDate;
	}

	public void setProductEnrollDate(Date productEnrollDate) {
		this.productEnrollDate = productEnrollDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [productNo=" + productNo + ", categoryNo=" + categoryNo + ", productName=" + productName
				+ ", celebName=" + celebName + ", productStock=" + productStock + ", productContent=" + productContent
				+ ", productPrice=" + productPrice + ", productComment=" + productComment + ", productEnrollDate="
				+ productEnrollDate + ", status=" + status + "]";
	}
	

}
