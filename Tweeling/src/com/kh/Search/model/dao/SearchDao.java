package com.kh.Search.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.product.model.vo.Product;

public class SearchDao {
	
	 private Properties prop = new Properties();
	 
	 public SearchDao() {
	        
	        try {
	            prop.loadFromXML(new FileInputStream(SearchDao.class.getResource("/db/sql/search-mapper.xml").getPath()));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	    }
	 
	 

	public ArrayList<Product> searchListView(Connection conn, String keyword) {
			ArrayList<Product> list = new ArrayList<>();
			String keyword2 = "%"+keyword+"%"; //like 검색을 위해서 % 붙여 처리해둠
	        
	        PreparedStatement pstmt = null;
	        ResultSet rset = null;
	        String sql = prop.getProperty("searchListView");
	        try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, keyword2);
	            pstmt.setString(2, keyword2);
	            
	            rset=pstmt.executeQuery();
	            
	            while(rset.next()) {
					list.add(new Product(rset.getInt("PRODUCT_NO"),
										rset.getString("PRODUCT_NAME"),
										rset.getString("CELEB_NAME"),
										rset.getInt("PRODUCT_PRICE"),
										rset.getString("TITLEIMG")));
	            }
	            
	                        
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally{
	            JDBCTemplate.close(pstmt);
	            JDBCTemplate.close(rset);
	        }
	        
	        
	        return  list;
	}

}
