package com.kh.product.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.product.model.vo.PAttachment;
import com.kh.product.model.vo.Product;

public class ProductDao {

	private Properties prop = new Properties();
	
	public ProductDao() {
		String filePath = ProductDao.class.getResource("/db/sql/product-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Product> selectProductAllList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		DecimalFormat decFormat = new DecimalFormat("###,###");
		
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
		}finally{
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}
	public ArrayList<Product> slectProductMusicList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("slectProductMusicList");
		
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
	public ArrayList<Product> selectProductClothingList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductClothingList");
		
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
	public ArrayList<Product> selectProductBeautyList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductBeautyList");
		
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
	
	public ArrayList<Product> selectProductAccList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductAccList");
		
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
	
	
	
	//셀럽 시작
	//1. Justin Biber
	public ArrayList<Product> selectJbAllList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectJbAllList");
		
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
	public ArrayList<Product> selectJbMusicList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectJbMusicList");
		
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
	
	public ArrayList<Product> selectJbClothingList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectJbClothingList");
		
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
	
	public ArrayList<Product> selectJbBeautyList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectJbBeautyList");
		
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
	public ArrayList<Product> selectJbAccList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectJbAccList");
		
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
	
	//2. Dua Lipa
	public ArrayList<Product> selectDlAllList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectDlAllList");
		
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
	public ArrayList<Product> selectDlMusicList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectDlMusicList");
		
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
	public ArrayList<Product> selectDlClothingList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectDlClothingList");
		
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
	public ArrayList<Product> selectDlBeautyList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectDlBeautyList");
		
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
	public ArrayList<Product> selectDlAccList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectDlAccList");
		
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
	
	//3. Why Don't We
	public ArrayList<Product> selectWdwAllList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectWdwAllList");
		
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
	public ArrayList<Product> selectWdwMusicList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectWdwMusicList");
		
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
	public ArrayList<Product> selectWdwClothingList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectWdwClothingList");
		
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
	public ArrayList<Product> selectWdwBeautyList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectWdwBeautyList");
		
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
	public ArrayList<Product> selectWdwAccList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectWdwAccList");
		
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
	
	//4. Ariana Grande
	public ArrayList<Product> selectAgAllList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectAgAllList");
		
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
	public ArrayList<Product> selectAgMusicList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectAgMusicList");
		
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
	public ArrayList<Product> selectAgClothingList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectAgClothingList");
		
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
	
	public ArrayList<Product> selectAgBeautyList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectAgBeautyList");
		
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
	public ArrayList<Product> selectAgAccList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectAgAccList");
		
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
	
	//5. Taylor Swift
	public ArrayList<Product> selectTsAllList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectTsAllList");
		
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
	public ArrayList<Product> selectTsMusicList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectTsMusicList");
		
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
	public ArrayList<Product> selectTsClothingList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectTsClothingList");
		
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
	public ArrayList<Product> selectTsBeautyList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectTsBeautyList");
		
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
	public ArrayList<Product> selectTsAccList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectTsAccList");
		
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
	
	//6. Doja Cat
	public ArrayList<Product> selectDcAllList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectDcAllList");
		
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
	public ArrayList<Product> selectDcMusicList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectDcMusicList");
		
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
	public ArrayList<Product> selectDcClothingList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectDcClothingList");
		
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
	
	public ArrayList<Product> selectDcBeautyList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectDcBeautyList");
		
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
	public ArrayList<Product> selectDcAccList(Connection conn) {
		ArrayList<Product>list = new ArrayList<>();
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectDcAccList");
		
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
	
	//상품디테일 페이지
	public Product selectProduct(Connection conn, int productNo) {
		Product p = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProduct");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, productNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				p = new Product(rset.getInt("PRODUCT_NO"),
						rset.getString("PRODUCT_NAME"),
						rset.getString("CELEB_NAME"),
						rset.getInt("PRODUCT_STOCK"),
						rset.getString("PRODUCT_CONTENT"),
						rset.getInt("PRODUCT_PRICE"),
						rset.getString("PRODUCT_COMMENT"),
						rset.getString("TITLEIMG"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return p;
	}
	
	//상품디테일 첨부파일
	public ArrayList<PAttachment> selectProductAttachmentList(Connection conn, int productNo) {
		ArrayList<PAttachment>paList = new ArrayList<>();
		PAttachment pat = null;
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("selectProductAttachmentList");
		
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
	
}
