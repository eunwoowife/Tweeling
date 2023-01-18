package com.kh.review.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.review.model.vo.Review;

public class ReviewDao {

	private Properties prop = new Properties();
	
	public ReviewDao() {
		String filePath = ReviewDao.class.getResource("/db/sql/review-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertReview(Connection conn, Review r) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, r.getUserNo2());
			pstmt.setInt(2, r.getRefPno());
			pstmt.setInt(3, r.getOrderNo());
			pstmt.setString(4, r.getReviewContent());
			pstmt.setInt(5, r.getReviewScore());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int checkReview(Connection conn, int productNo, int orderNo, int userNo) {
		int count = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("checkReview");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, orderNo);
			pstmt.setInt(2, productNo);
			pstmt.setInt(3, userNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return count;
	}

	
	
	
}
