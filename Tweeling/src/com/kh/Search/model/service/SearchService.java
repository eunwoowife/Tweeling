package com.kh.Search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.Search.model.dao.SearchDao;
import com.kh.common.JDBCTemplate;
import com.kh.product.model.vo.Product;

public class SearchService {

	public ArrayList<Product> searchListView(String keyword) {
		

		Connection conn = JDBCTemplate.getConnection();
	    
	    ArrayList<Product> list = new SearchDao().searchListView(conn,keyword);
	    
	    JDBCTemplate.close(conn);      
	    
	    return list;
		
		
	}

}
