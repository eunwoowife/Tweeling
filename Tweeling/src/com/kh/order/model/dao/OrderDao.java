package com.kh.order.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.cart.model.dao.CartDao;
import com.kh.cart.model.vo.Cart;
import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;
import com.kh.order.model.vo.OrderShipping;
import com.kh.order.model.vo.Order;
import com.kh.order.model.vo.OrderList;
import com.kh.product.model.vo.PAttachment;
import com.kh.product.model.vo.Product;

public class OrderDao {
	
	private Properties prop = new Properties();
	
	 public OrderDao() {
	        
	        try {
	            prop.loadFromXML(new FileInputStream(OrderDao.class.getResource("/db/sql/order-mapper.xml").getPath()));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	

	public ArrayList<Member> OrderMemeberListView(Connection conn, int userNo) {
	
		 ArrayList<Member> member = new ArrayList<>();
	        
	        PreparedStatement pstmt = null;
	        ResultSet rset = null;
	        String sql = prop.getProperty("OrderMemeberListView");
	        
	        try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, userNo);
	            rset=pstmt.executeQuery();
	            while (rset.next()) {
	            	 member.add(new Member(rset.getInt("USER_NO")
	                                 ,rset.getString("USER_NAME")
	                                 ,rset.getString("USER_PHONE")
	                                 ,rset.getString("USER_EMAIL")
	                                 ,rset.getString("USER_ADDRESS")));
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }finally{
	            JDBCTemplate.close(pstmt);
	            JDBCTemplate.close(rset);
	        }
	        return member;
	}



	public int OrderDefaultInsert(int userNo, int totalAmount, int finalAmount, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("OrderDefaultInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, totalAmount);
			pstmt.setInt(3, finalAmount);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
            JDBCTemplate.close(pstmt);
        }
		return result;
	}
	

	public int OrderNumberSelect(int userNo, Connection conn) {
		int orderNo = 0;
		ResultSet rset = null;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("OrderNumberSelect");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			rset = pstmt.executeQuery();
			
			 while (rset.next()) {
				 orderNo = rset.getInt("ORDER_NO");
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
            JDBCTemplate.close(pstmt);
            JDBCTemplate.close(rset);
        }
		
		return orderNo;
	}




	public int OrderDetailInsert(int cartNo, ArrayList<Cart> cart, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("OrderDetailInsert");
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<cart.size(); i++) {
				
				pstmt.setInt(1, cartNo);
				pstmt.setInt(2, cart.get(i).getProductNo());
				pstmt.setInt(3, cart.get(i).getProductQuality());
				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
            JDBCTemplate.close(pstmt);
        }
		
		return result;
	}



	public int OrderShippingInsert(int orderNo, OrderShipping os, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("OrderShippingInsert");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			pstmt.setString(2, os.getReceiver());
			pstmt.setString(3, os.getAddress());
			pstmt.setString(4, os.getShippingComment());
			pstmt.setString(5, os.getPhone1());
			pstmt.setString(6, os.getPhone2());
			
			result = pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
            JDBCTemplate.close(pstmt);
        }
		
		return result;
	}



	public ArrayList<Cart> OrderListView(Connection conn, int userNo, ArrayList<Integer> pNo,
			ArrayList<Integer> pCount) {
		ArrayList<Cart> cart = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("OrderListView");
        
        for(int i=0; i<pNo.size(); i++) {
        
	        try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, pNo.get(i));
	            rset=pstmt.executeQuery();
	            
	            while (rset.next()) {
	                cart.add(new Cart(rset.getInt("PRODUCT_NO")
	                                 ,pCount.get(i)
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
        
        }
        return cart;
	}



	public ArrayList<Cart> OrderOneListView(Connection conn, int userNo, int pno, int pcount) {
		ArrayList<Cart> cart = new ArrayList<>();
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("OrderOneListView");
        
        
	        try {
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setInt(1, pno);
	            
	            rset=pstmt.executeQuery();
	            
	            while (rset.next()) {
	                cart.add(new Cart(rset.getInt("PRODUCT_NO")
	                                 ,pcount
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

	//----------------------------------------------------- 아래는 마이페이지 관련 OrderDao 

	public Order selectLastOrder(Connection conn, int userNo) {
        Order lastOrder = null;
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectLastOrder");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, userNo);
            
            rset = pstmt.executeQuery();
            
            if (rset.next()) { // 커서가 가리킬 위치가 있는지 (조회결과가 있다면)
                lastOrder = new Order(rset.getInt("ORDER_NO")
                                    , rset.getInt("USER_NO")
                                    , rset.getInt("COUPON_NO")
                                    , rset.getInt("ORDER_POINT")
                                    , rset.getDate("ORDER_DATE")
                                    , rset.getInt("ORDER_TOTAL_AMOUNT")
                                    , rset.getInt("DELIVERY_FEE")
                                    , rset.getInt("ORDER_FINAL_AMOUNT")
                                    , rset.getString("ORDER_STATUS")
                            );
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("Order :: DAO :: selectLastOrder :: lastOrder : "+ lastOrder);
        return lastOrder;
    }

    public PAttachment selectExpensiveThumbnail(Connection conn, int orderNo) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectExpensiveThumbnail");
        
        PAttachment pa= null;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, orderNo);
            
            rset = pstmt.executeQuery();
            
            if (rset.next()) { // 커서가 가리킬 위치가 있는지 (조회결과가 있다면)
                pa = new PAttachment(rset.getInt("FILE_NO")
                                    , rset.getInt("REF_PNO")
                                    , rset.getString("ORIGIN_NAME")
                                    , rset.getString("CHANGE_NAME")
                                    , rset.getString("FILE_PATH")
                                    , rset.getInt("FILE_LEVEL")
                            );
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("Order :: DAO :: selectExpensiveThumbnail :: pa : "+ pa);
        return pa;
    }

    public int selectOrderProductNum(Connection conn, int orderNo) {
        int orderProductNum = 0;
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectOrderProductNum");
        
        PAttachment pa= null;
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, orderNo);
            
            rset = pstmt.executeQuery();
            
            if (rset.next()) { // 커서가 가리킬 위치가 있는지 (조회결과가 있다면)
                orderProductNum = rset.getInt("COUNT");
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("Order :: DAO :: selectOrderProductNum :: orderProductNum : "+ orderProductNum);
        return orderProductNum;
    }

    public ArrayList<Order> selecrOrderList(Connection conn, int userNo, Date startDate, Date endDate) {
        ArrayList<Order> oList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selecrOrderList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, userNo);
            pstmt.setDate(2, startDate);
            pstmt.setDate(3, endDate);
            
            rset = pstmt.executeQuery();
            
            while (rset.next()) { // 커서가 가리킬 위치가 있는지 (조회결과가 있다면)
                oList.add(new Order(rset.getInt("ORDER_NO")
                                  , rset.getInt("USER_NO")
                                  , rset.getInt("COUPON_NO")
                                  , rset.getInt("ORDER_POINT")
                                  , rset.getDate("ORDER_DATE")
                                  , rset.getInt("ORDER_TOTAL_AMOUNT")
                                  , rset.getInt("DELIVERY_FEE")
                                  , rset.getInt("ORDER_FINAL_AMOUNT")
                                  , rset.getString("ORDER_STATUS")
                                   )
                         );
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("Order :: DAO :: selecrOrderList :: oList : "+ oList);
        return oList;
    }
    
    public String selectExpensiveProductName(Connection conn, int orderNo) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String pName = "";
        String sql = prop.getProperty("selectExpensiveProductName");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, orderNo);
            
            rset = pstmt.executeQuery();
            
            if (rset.next()) { // 커서가 가리킬 위치가 있는지 (조회결과가 있다면)
                pName = rset.getString("PRODUCT_NAME");
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("Order :: DAO :: selectExpensiveProductName :: pName : "+ pName);
        return pName;
    }

    public ArrayList<Product> selectLastOrderProductList(Connection conn, int orderNo) {
        ArrayList<Product> pList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectLastOrderProductList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, orderNo);
            
            rset = pstmt.executeQuery();
            
            while (rset.next()) { // 커서가 가리킬 위치가 있는지 (조회결과가 있다면)
                pList.add(new Product(rset.getInt("PRODUCT_NO")
                                  , Integer.toString(rset.getInt("PRODUCT_CATEGORY_NO"))
                                  , rset.getString("PRODUCT_NAME")
                                  , rset.getString("CELEB_NAME")
                                  , rset.getInt("PRODUCT_STOCK")
                                  , rset.getString("PRODUCT_CONTENT")
                                  , rset.getInt("PRODUCT_PRICE")
                                  , rset.getString("PRODUCT_COMMENT")
                                  , rset.getDate("PRODUCT_ENROLLDATE")
                                  , rset.getString("PRODUCT_STATUS")
                                   )
                         );
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("Order :: DAO :: selectLastOrderProductList :: pList : "+ pList);
        return pList;
    }

    public ArrayList<PAttachment> selectLastOrderThumbnailList(Connection conn, int orderNo) {
        ArrayList<PAttachment> paList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selectLastOrderThumbnailList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, orderNo);
            
            rset = pstmt.executeQuery();
            
            while (rset.next()) { // 커서가 가리킬 위치가 있는지 (조회결과가 있다면)
                paList.add(new PAttachment(rset.getInt("FILE_NO")
                                        , rset.getInt("REF_PNO")
                                        , rset.getString("ORIGIN_NAME")
                                        , rset.getString("CHANGE_NAME")
                                        , rset.getString("FILE_PATH")
                                        , rset.getInt("FILE_LEVEL")
                                         )
                         );
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("Order :: DAO :: selectLastOrderThumbnailList :: paList : "+ paList);
        return paList;
    }

    public ArrayList<OrderList> selectOrderListByOrderNo(Connection conn, int orderNo) {
        ArrayList<OrderList> oList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        String sql = prop.getProperty("selecrOrderFullList");
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, orderNo);
            
            rset = pstmt.executeQuery();
            
            while (rset.next()) { // 커서가 가리킬 위치가 있는지 (조회결과가 있다면)
            	  oList.add(new OrderList(rset.getInt("ORDER_NO")
                          , rset.getInt("PRODUCT_PRICE")
                          , rset.getInt("PNO")
                          , rset.getInt("QUANTITY")
                          , rset.getString("PRODUCT_NAME")
                          , rset.getString("FILE_PATH")
                          , rset.getString("ORIGIN_NAME")
                          , rset.getDate("ORDER_DATE")
                           )
            			  );
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
//        System.out.println("Order :: DAO :: selectOrderListByOrderNo :: oList : "+ oList);
        return oList;
    }


	


	




}
