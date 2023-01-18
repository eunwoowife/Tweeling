package com.kh.product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.product.model.vo.PAttachment;
import com.kh.product.model.vo.PCategory;
import com.kh.product.model.vo.Product;
import com.kh.review.model.vo.Review;

public class ProductDao2 {

	private Properties prop = new Properties();
	
	public ProductDao2() {
		String filePath = ProductDao2.class.getResource("/db/sql/product-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Product> selectProductManagementAllList(Connection conn) {
		ArrayList<Product>pList = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductManagementAllList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				pList.add(new Product(rset.getInt("PRODUCT_NO"),
												rset.getString("PRODUCT_CATEGORY_NAME"),
												rset.getString("PRODUCT_NAME"),
												rset.getString("CELEB_NAME"),
												rset.getInt("PRODUCT_STOCK"),
												rset.getString("PRODUCT_CONTENT"),
												rset.getInt("PRODUCT_PRICE"),
												rset.getString("PRODUCT_COMMENT"),
												rset.getString("PRODUCT_STATUS"),
												rset.getString("TITLEIMG")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return pList;
	}

	public ArrayList<PCategory> selectProductCategoryList(Connection conn) {
		ArrayList<PCategory>pcList = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductCategoryList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				pcList.add(new PCategory(rset.getInt("PRODUCT_CATEGORY_NO"),
														rset.getString("PRODUCT_CATEGORY_NAME")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return pcList;
	}

	public int insertProductRegistration(Connection conn, Product p) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertProductRegistration");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getCelebName());
			pstmt.setInt(2, Integer.parseInt(p.getCategoryNo()));
			pstmt.setString(3, p.getProductName());
			pstmt.setInt(4, p.getProductPrice());
			pstmt.setInt(5, p.getProductStock());
			pstmt.setString(6, p.getProductComment());
			pstmt.setString(7, p.getProductContent());
			
			System.out.println(p);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertProductAttachment(Connection conn, ArrayList<PAttachment> paList) {
		int result = 1;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertProductAttachment");
		
		try {
			for(PAttachment pa : paList) {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, pa.getOriginName());
			pstmt.setString(2, pa.getFilePath());
			pstmt.setInt(3, pa.getFileLevel());
			
			result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//관리자용 상품디테일 페이지
	public Product selectProductManagement(Connection conn, int productNo) {
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductManagement");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Product(rset.getInt("PRODUCT_NO"),
										rset.getString("PRODUCT_CATEGORY_NAME"),
										rset.getString("PRODUCT_NAME"),
										rset.getString("CELEB_NAME"),
										rset.getInt("PRODUCT_STOCK"),
										rset.getString("PRODUCT_CONTENT"),
										rset.getInt("PRODUCT_PRICE"),
										rset.getString("PRODUCT_COMMENT"),
										rset.getDate("PRODUCT_ENROLLDATE"),
										rset.getString("PRODUCT_STATUS"),
										rset.getInt("FILE_NO"),
										rset.getString("FILE_PATH"),
										rset.getString("ORIGIN_NAME"));
				
//				System.out.println("DAO :: selectProductManagement :: "+p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return p;
	}

	//관리자용 상품디테일 페이지 첨부파일
	public ArrayList<PAttachment> selectProductManagementAttachmentList(Connection conn, int productNo) {
		ArrayList<PAttachment>paList = new ArrayList<>();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductManagementAttachmentList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				paList.add(new PAttachment(rset.getInt("FILE_NO"),
														rset.getString("ORIGIN_NAME"),
														rset.getString("FILE_PATH")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return paList;
	}

	//상품정보 수정
	public int modificationProduct(Connection conn, Product p) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("modificationProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getCelebName());
			pstmt.setString(2, p.getCategoryNo());
			pstmt.setString(3, p.getProductName());
			pstmt.setInt(4, p.getProductPrice());
			pstmt.setInt(5, p.getProductStock());
			pstmt.setString(6, p.getProductComment());
			pstmt.setString(7, p.getProductContent());
			pstmt.setInt(8, p.getProductNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//상품썸네일 이미지 수정
	public int modificationProductAttachment(Connection conn, PAttachment pa) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("modificationProductAttachment");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pa.getOriginName());
			pstmt.setString(2, pa.getFilePath());
			pstmt.setInt(3, pa.getFileNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	//상품컨텐츠이미지1 수정
	public int modificationProductAttachment2(Connection conn, PAttachment pa2) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("modificationProductAttachment2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pa2.getOriginName());
			pstmt.setString(2, pa2.getFilePath());
			pstmt.setInt(3, pa2.getFileNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//상품컨텐츠이미지1 추가
	public int insertNewProductAttachment2(Connection conn, PAttachment pa2) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNewProductAttachment2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pa2.getRefPno());
			pstmt.setString(2, pa2.getOriginName());
			pstmt.setString(3, pa2.getFilePath());
			
//			System.out.println("dao2 : "+pa2);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//상품컨텐츠이미지2 수정
	public int modificationProductAttachment3(Connection conn, PAttachment pa3) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("modificationProductAttachment3");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, pa3.getOriginName());
			pstmt.setString(2, pa3.getFilePath());
			pstmt.setInt(3, pa3.getFileNo());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//상품컨텐츠이미지3 추가
	public int insertNewProductAttachment3(Connection conn, PAttachment pa3) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNewProductAttachment3");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pa3.getRefPno());
			pstmt.setString(2, pa3.getOriginName());
			pstmt.setString(3, pa3.getFilePath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//상품삭제 메소드
	public int deleteProduct(Connection conn, int productNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//정렬을 낮은가격순으로 select했을 때,
	public ArrayList<Product> selectProductLineupLowprice(Connection conn, String lineup) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductLineupLowprice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getInt("PRODUCT_NO"),
									rset.getString("PRODUCT_NAME"),
									rset.getString("CELEB_NAME"),
									rset.getInt("PRODUCT_PRICE"),
									rset.getString("TITLEIMG")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	//정렬을 높은가격순으로 select했을 때,
	public ArrayList<Product> selectProductLineupHighprice(Connection conn, String lineup) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductLineupHighprice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getInt("PRODUCT_NO"),
									rset.getString("PRODUCT_NAME"),
									rset.getString("CELEB_NAME"),
									rset.getInt("PRODUCT_PRICE"),
									rset.getString("TITLEIMG")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	//정렬을 최신순으로 select했을 때,
	public ArrayList<Product> selectProductLineupNew(Connection conn, String lineup) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductAllList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getInt("PRODUCT_NO"),
									rset.getString("PRODUCT_NAME"),
									rset.getString("CELEB_NAME"),
									rset.getInt("PRODUCT_PRICE"),
									rset.getString("TITLEIMG")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	
	//관리자화면 상품 정렬
	public ArrayList<Product> selectProductLineupLowprice2(Connection conn, String lineup) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductLineupLowprice2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getInt("PRODUCT_NO"),
									rset.getString("PRODUCT_NAME"),
									rset.getString("CELEB_NAME"),
									rset.getInt("PRODUCT_PRICE"),
									rset.getString("PRODUCT_STATUS"),
									rset.getString("TITLEIMG")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public ArrayList<Product> selectProductLineupHighprice2(Connection conn, String lineup) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductLineupHighprice2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getInt("PRODUCT_NO"),
									rset.getString("PRODUCT_NAME"),
									rset.getString("CELEB_NAME"),
									rset.getInt("PRODUCT_PRICE"),
									rset.getString("PRODUCT_STATUS"),
									rset.getString("TITLEIMG")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public ArrayList<Product> selectProductLineupNew2(Connection conn, String lineup) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductLineupNew2");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getInt("PRODUCT_NO"),
									rset.getString("PRODUCT_NAME"),
									rset.getString("CELEB_NAME"),
									rset.getInt("PRODUCT_PRICE"),
									rset.getString("PRODUCT_STATUS"),
									rset.getString("TITLEIMG")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public ArrayList<Product> selectProductLineupNames(Connection conn, String lineup) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductLineupNames");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Product(rset.getInt("PRODUCT_NO"),
									rset.getString("PRODUCT_NAME"),
									rset.getString("CELEB_NAME"),
									rset.getInt("PRODUCT_PRICE"),
									rset.getString("PRODUCT_STATUS"),
									rset.getString("TITLEIMG")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	
	
	//디테일 페이지에 들어갈 리뷰 리스트
	public ArrayList<Review> selectReview(Connection conn, int productNo) {
		ArrayList<Review>rList = new ArrayList<>();
		Review r = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				rList.add(new Review(rset.getString("USER_NAME"),
												rset.getString("REVIEW_CONTENT"),
												rset.getInt("REVIEW_SCORE"),
												rset.getDate("CREATE_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		System.out.println("DAO :: selectReview : rList : "+rList);
		return rList;
	}

	

}
