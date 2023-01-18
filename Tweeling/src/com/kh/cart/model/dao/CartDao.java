package com.kh.cart.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.cart.model.vo.Cart;
import com.kh.common.JDBCTemplate;

public class CartDao {
    
    private Properties prop = new Properties();

    public CartDao() {
        
        try {
            prop.loadFromXML(new FileInputStream(CartDao.class.getResource("/db/sql/cart-mapper.xml").getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    
    
    //移댄듃 由ъ뒪�듃 議고쉶
    public ArrayList<Cart> CartListView(Connection conn, int userNo) {
        
        ArrayList<Cart> cart = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("CartListView");
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userNo);
            
            rset=pstmt.executeQuery();
            
            while (rset.next()) {
                cart.add(new Cart(rset.getInt("USER_NO")
                                 ,rset.getInt("PRODUCT_NO")
                                 ,rset.getInt("PRODUCT_QUANTITY")
                                 ,rset.getInt("PRODUCT_STOCK")
                                 ,rset.getString("CELEB_NAME")
                                 ,rset.getString("PRODUCT_NAME")
                                 ,rset.getString("PRODUCT_PRICE")
                                 ,rset.getString("TITLEIMG")));
            }
            
                        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rset);
        }
        
        
        return cart;
    }


    //�옣諛붽뎄�땲 �쟾泥� 鍮꾩슦湲� 硫붿냼�뱶
    public int AllDeleteCart(Connection conn, int userNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("AllDeleteCart");
               
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, userNo);      
      
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
        
    
        return result;        


    }     


    public int updateCount(Connection conn, int userNo, int count, int productNo) {
        int result = 0;
        PreparedStatement pstmt = null;
        String sql = prop.getProperty("updateCount");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            //移댄뀒怨좊━�� �옉�꽦�옄�뒗 �뜲�씠�꽣 異붽��븷�븣�뒗 NUMBER���엯�씠湲� �븣臾몄뿉 �삎蹂��솚 
            pstmt.setInt(1, count);
            pstmt.setInt(2, productNo);
            pstmt.setInt(3, userNo);
            
            result = pstmt.executeUpdate();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            JDBCTemplate.close(pstmt);
        }
        return result;
    }



	public int selectDelete(Connection conn, int userNo, int productNo) {
		 int result = 0;
	        PreparedStatement pstmt = null;
	        String sql = prop.getProperty("selectDelete");
	               
	        
	        try {
	            pstmt = conn.prepareStatement(sql);
	            
	            pstmt.setInt(1, userNo);  
	            pstmt.setInt(2, productNo);
	      
	            result = pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally {
	            JDBCTemplate.close(pstmt);
	        }
	        
	    
	        return result;   
	}



	public int insertCart(Connection conn, int userNo, int productNo, int quantity) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertCart");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, productNo);
			pstmt.setInt(3, quantity);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}



	public int insertCartUpdateQuantity(Connection conn, int userNo, int productNo, int quantity) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertCartUpdateQuantity");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, userNo);
			pstmt.setInt(3, productNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}



	public int checkCart(Connection conn, int userNo, int productNo) {
		int count = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("checkCart");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, productNo);
			
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



	public int CheckDelete(Connection conn, int userNo, String checkPno) {
		 	int result = 0;
	        PreparedStatement pstmt = null;
	        String sql = prop.getProperty("CheckDelete");
	        
	        
	        try {
	            pstmt = conn.prepareStatement(sql);
	            
	            pstmt.setInt(1, userNo);
	            pstmt.setString(2, checkPno);
	            
	            result = pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally {
	            JDBCTemplate.close(pstmt);
	        }
	        return result;
	}

}
