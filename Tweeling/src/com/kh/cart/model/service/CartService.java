package com.kh.cart.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.cart.model.dao.CartDao;
import com.kh.cart.model.vo.Cart;
import com.kh.common.JDBCTemplate;

public class CartService {

    public ArrayList<Cart> CartListView(int userNo) {
        
        Connection conn = JDBCTemplate.getConnection();
        
        ArrayList<Cart> cart = new CartDao().CartListView(conn,userNo);
        
        JDBCTemplate.close(conn);      
        
        return cart;
    }

    public int AllDeleteCart(int userNo) {
        Connection conn = JDBCTemplate.getConnection();
      
    
        
        int deleteResult = new CartDao().AllDeleteCart(conn,userNo);
        
        if(deleteResult>0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        
        return deleteResult;
        
    }

    public int updateCount(int userNo, int count, int productNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        int updateCount = new CartDao().updateCount(conn,userNo,count,productNo);
        
        if(updateCount>0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        
        return updateCount;
        
        
    }

	public int selectDelete(int userNo, int productNo) {
		 Connection conn = JDBCTemplate.getConnection();
	      
		    
	        
	        int deleteResult = new CartDao().selectDelete(conn,userNo, productNo);
	        
	        if(deleteResult>0) {
	            JDBCTemplate.commit(conn);
	        }else {
	            JDBCTemplate.rollback(conn);
	        }
	        JDBCTemplate.close(conn);
	        
	        return deleteResult;
	        
	}

	public int insertCart(int userNo, int productNo, int quantity) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new CartDao().insertCart(conn, userNo, productNo, quantity);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertCartUpdateQuantity(int userNo, int productNo, int quantity) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new CartDao().insertCartUpdateQuantity(conn, userNo, productNo, quantity);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int checkCart(int userNo, int productNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int count = new CartDao().checkCart(conn, userNo, productNo);

		JDBCTemplate.close(conn);
		return count;
	}

	public int CheckDelete(String checkPno, int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new CartDao().CheckDelete(conn, userNo, checkPno);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
