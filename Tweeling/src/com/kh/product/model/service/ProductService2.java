package com.kh.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.product.model.dao.ProductDao2;
import com.kh.product.model.vo.PAttachment;
import com.kh.product.model.vo.PCategory;
import com.kh.product.model.vo.Product;
import com.kh.review.model.vo.Review;

public class ProductService2 {

	public ArrayList<Product> selectProductManagementAllList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>pList = new ProductDao2().selectProductManagementAllList(conn);
		
		JDBCTemplate.close(conn);
		return pList;
	}

	public ArrayList<PCategory> selectProductCategoryList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<PCategory>pcList = new ProductDao2().selectProductCategoryList(conn);
		
		JDBCTemplate.close(conn);
		return pcList;
	}

	public int insertProduct(Product p, ArrayList<PAttachment> paList) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result1 = new ProductDao2().insertProductRegistration(conn, p);
		int result2 = new ProductDao2().insertProductAttachment(conn, paList);
		
		int finalResult = result1*result2;
		
		if(finalResult>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return finalResult;
	}

	//관리자용 상품디테일 페이지
	public Product selectProductManagement(int productNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		Product p = new ProductDao2().selectProductManagement(conn, productNo);
		
		JDBCTemplate.close(conn);
		return p;
		
	}
	//관리자용 상품디테일 페이지 첨부파일
	public ArrayList<PAttachment> selectProductManagementAttachmentList(int productNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<PAttachment>paList = new ProductDao2().selectProductManagementAttachmentList(conn, productNo);

		JDBCTemplate.close(conn);
		return paList;
	}

	public int modificationProduct(Product p, PAttachment pa, PAttachment pa2, PAttachment pa3) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ProductDao2().modificationProduct(conn, p);
		int result2 = 1;
		int result3 = 1;
		int result4 = 1;
		
		//썸네일이미지에 새로운 이미지파일이 있을 경우
		if(pa!=null) {
			result2 = new ProductDao2().modificationProductAttachment(conn, pa);
		}
		
		//컨텐츠이미지1에 새로운 이미지파일이 있을 경우
		if(pa2!=null) {
			if(pa2.getFileNo()!=0) { //기존에 이미지파일이 있었을 경우에는 update
				result3 =new ProductDao2().modificationProductAttachment2(conn, pa2);
			}else { //기존에 이미지 파일이 없었을 경우에는 insert
				result3 = new ProductDao2().insertNewProductAttachment2(conn, pa2);
			}
		}
		
		//컨텐츠이미지2에 새로운 첨부파일이 있을 경우
		if(pa3!=null) {
			if(pa3.getFileNo()!=0) { //기존에 이미지파일이 있었을 경우에는 update
				result4 = new ProductDao2().modificationProductAttachment3(conn, pa3);
			}else { //기존에 이미지 파일이 없었을 경우에는 insert
				result4 = new ProductDao2().insertNewProductAttachment3(conn, pa3);
			}
		}
		
		int finalResult = result*result2*result3*result4;
		
		if(finalResult>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return finalResult;
	}

	//상품 삭제
	public int deleteProduct(int productNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new ProductDao2().deleteProduct(conn, productNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	//정렬을 낮은가격순으로 select했을 때,
	public ArrayList<Product> selectProductLineupLowprice(String lineup) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao2().selectProductLineupLowprice(conn, lineup);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//정렬을 높은가격순으로 select했을 때,
	public ArrayList<Product> selectProductLineupHighprice(String lineup) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao2().selectProductLineupHighprice(conn, lineup);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectProductLineupNew(String lineup) {
		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Product>list = new ProductDao2().selectProductLineupNew(conn, lineup);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectProductLineupLowprice2(String lineup) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao2().selectProductLineupLowprice2(conn, lineup);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectProductLineupHighprice2(String lineup) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao2().selectProductLineupHighprice2(conn, lineup);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectProductLineupNew2(String lineup) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao2().selectProductLineupNew2(conn, lineup);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectProductLineupNames(String lineup) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao2().selectProductLineupNames(conn, lineup);
		
		JDBCTemplate.close(conn);
		return list;
	}

	
	
	
	//디테일 페이지에 들어갈 리뷰 리스트
	public ArrayList<Review> selectReview(int productNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Review>rList = new ProductDao2().selectReview(conn, productNo);
		
		JDBCTemplate.close(conn);
		return rList;
	}
	
	

	
	

}
