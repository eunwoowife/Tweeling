package com.kh.wish.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.wish.model.dao.WishDao;

public class WishService {

	
	public ArrayList <Integer> WishList(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
        
		ArrayList <Integer> WishList = new WishDao().WishListView(conn,userNo);
        JDBCTemplate.close(conn);      
		return WishList;
	}

	public int WishAdd(int userNo, int productNo) {
		Connection conn = JDBCTemplate.getConnection();
        int result = new WishDao().WishAdd(conn,userNo, productNo);
        
        if(result>0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        
        return result;
	}

}
