package com.kh.wish.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.cart.model.dao.CartDao;
import com.kh.cart.model.vo.Cart;
import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;

public class WishDao {
	
	 private Properties prop = new Properties();

	    public WishDao() {
	        
	        try {
	            prop.loadFromXML(new FileInputStream(CartDao.class.getResource("/db/sql/wish-mapper.xml").getPath()));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	    }

	public  ArrayList <Integer> WishListView(Connection conn, int userNo) {

		ArrayList <Integer> WishList = new ArrayList<>();
		
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("WishListView");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNo);
            
            rset=pstmt.executeQuery();
            
            while (rset.next()) {
            	WishList.add(new Integer(rset.getInt("PRODUCT_NO")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rset);
        }
        
        
        return WishList;
	}

	public int WishAdd(Connection conn, int userNo, int productNo) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("WishAdd");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, productNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

}
