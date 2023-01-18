package com.kh.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.product.model.dao.ProductDao;
import com.kh.product.model.vo.PAttachment;
import com.kh.product.model.vo.Product;

public class ProductService {

	//All Celeb, All Product 리스트
	public ArrayList<Product> selectProductAllList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectProductAllList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> slectProductMusicList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().slectProductMusicList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectProductClothingList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectProductClothingList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectProductBeautyList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectProductBeautyList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectProductAccList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectProductAccList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//Celeb별 Prdouct_Category 리스트
	//1. Justin Bieber....♥
	public ArrayList<Product> selectJbAllList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectJbAllList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectJbMusicList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectJbMusicList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectJbClothingList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectJbClothingList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectJbBeautyList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectJbBeautyList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}
	
	public ArrayList<Product> selectJbAccList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectJbAccList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	
	//2. Dua Lipa
	public ArrayList<Product> selectDlAllList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectDlAllList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectDlMusicList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectDlMusicList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectDlClothingList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectDlClothingList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectDlBeautyList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectDlBeautyList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectDlAccList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectDlAccList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//3. Why Don't We
	public ArrayList<Product> selectWdwAllList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectWdwAllList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectWdwMusicList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectWdwMusicList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectWdwClothingList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectWdwClothingList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectWdwBeautyList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectWdwBeautyList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectWdwAccList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectWdwAccList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//4. Ariana Grande
	public ArrayList<Product> selectAgAllList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectAgAllList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectAgMusicList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectAgMusicList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectAgClothingList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectAgClothingList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectAgBeautyList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectAgBeautyList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectAgAccList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectAgAccList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//5. Taylor Swift
	public ArrayList<Product> selectTsAllList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectTsAllList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectTsMusicList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectTsMusicList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectTsClothingList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectTsClothingList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectTsBeautyList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectTsBeautyList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectTsAccList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectTsAccList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectDcAllList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectDcAllList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectDcMusicList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectDcMusicList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectDcClothingList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectDcClothingList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectDcBeautyList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectDcBeautyList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<Product> selectDcAccList() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Product>list = new ProductDao().selectDcAccList(conn);
		
		JDBCTemplate.close(conn);
		return list;
	}

	//상품디테일 페이지
	public Product selectProduct(int productNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		Product p = new ProductDao().selectProduct(conn, productNo);
		
		JDBCTemplate.close(conn);
		return p;
	}


	//상품디테일 첨부파일
	public ArrayList<PAttachment> selectProductAttachmentList(int productNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<PAttachment>paList = new ProductDao().selectProductAttachmentList(conn, productNo);
	
		JDBCTemplate.close(conn);
		return paList;
	}



	
	
}
