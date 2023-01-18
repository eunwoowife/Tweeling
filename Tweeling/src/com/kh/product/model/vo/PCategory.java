package com.kh.product.model.vo;

public class PCategory {
//	PRODUCT_CATEGORY_NO	NUMBER
//	PRODUCT_CATEGORY_NAME	VARCHAR2(30 BYTE)
	private int productCategoryNo;
	private String productCategoryName;
	
	public PCategory() {
		super();
	}

	public PCategory(int productCategoryNo, String productCategoryName) {
		super();
		this.productCategoryNo = productCategoryNo;
		this.productCategoryName = productCategoryName;
	}

	public int getProductCategoryNo() {
		return productCategoryNo;
	}

	public void setProductCategoryNo(int productCategoryNo) {
		this.productCategoryNo = productCategoryNo;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	@Override
	public String toString() {
		return "P_Category [productCategoryNo=" + productCategoryNo + ", productCategoryName=" + productCategoryName
				+ "]";
	}
	
	
}
