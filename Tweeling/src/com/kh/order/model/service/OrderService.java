package com.kh.order.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.kh.cart.model.dao.CartDao;
import com.kh.cart.model.vo.Cart;
import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;
import com.kh.order.model.dao.OrderDao;
import com.kh.order.model.vo.OrderShipping;
import com.kh.product.model.vo.PAttachment;
import com.kh.order.model.vo.Order;
import com.kh.order.model.vo.OrderList;
import com.kh.product.model.vo.Product;


public class OrderService {
	
	

	public ArrayList<Member> OrderMemberListView(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
	    ArrayList<Member> member = new OrderDao().OrderMemeberListView(conn,userNo);
	        
	    JDBCTemplate.close(conn);      
	        
	    return member;
	}

	public int OrderDefaultInsert(int userNo, int totalAmount, int finalAmount) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result1 = new OrderDao().OrderDefaultInsert(userNo, totalAmount,finalAmount, conn);
		
		if(result1>0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        
        return result1;
		
	
	}
	
	
	
	public int OrderNumberSelect(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		int orderNo = new OrderDao().OrderNumberSelect(userNo, conn);
		
		JDBCTemplate.close(conn);
		return orderNo;
	}
	
	

	public int OrderDetailInsert(int cartNo, ArrayList<Cart> cart) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result1 = new OrderDao().OrderDetailInsert(cartNo, cart, conn);
		
		if(result1>0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        
        return result1;
	}
	

	public int OrderShippingInsert(int orderNo, OrderShipping os) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result1 = new OrderDao().OrderShippingInsert(orderNo, os, conn);
		
		if(result1>0) {
            JDBCTemplate.commit(conn);
        }else {
            JDBCTemplate.rollback(conn);
        }
        JDBCTemplate.close(conn);
        return result1;
	}
	
	

	public ArrayList<Cart> OrderListView(int userNo, ArrayList<Integer> pNo, ArrayList<Integer> pCount) {
		Connection conn = JDBCTemplate.getConnection();
        
        ArrayList<Cart> cart = new OrderDao().OrderListView(conn,userNo, pNo, pCount);
        
        JDBCTemplate.close(conn);      
        
        return cart;
		
	}

	public ArrayList<Cart> OrderOneListView(int userNo, int pno, int pcount) {
		Connection conn = JDBCTemplate.getConnection();
        
        ArrayList<Cart> cart = new OrderDao().OrderOneListView(conn,userNo, pno, pcount);
        
        JDBCTemplate.close(conn);      
        
        return cart;
	}

	//----------------------------------------------------- 아래는 마이페이지 관련 OrderDao 

	public Order selectLastOrder(int userNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        Order lastOrder = new OrderDao().selectLastOrder(conn, userNo);
        
        JDBCTemplate.close(conn);
        
        return lastOrder;
    }

    public PAttachment selectExpensiveThumbnail(int orderNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        // 주문번호 -> 가장 비싼 상품번호 -> 상품번호에 맞는 썸네일
        PAttachment pa = new OrderDao().selectExpensiveThumbnail(conn, orderNo);
        
        JDBCTemplate.close(conn);
        
        return pa;
    }

    public Integer selectOrderProductNum(int orderNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        int orderProductNum = new OrderDao().selectOrderProductNum(conn, orderNo);
        
        JDBCTemplate.close(conn);
        
        return new Integer(orderProductNum);
    }

    public ArrayList<Order> selectOrderList(int userNo, Date startDate, Date endDate) {
        Connection conn = JDBCTemplate.getConnection();
        
        ArrayList<Order> oList = new OrderDao().selecrOrderList(conn, userNo, startDate, endDate);
        
        JDBCTemplate.close(conn);
        
        return oList;
    }

    public ArrayList<String> selectExpensiveProductNameList(int[] orderNoArr) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<String> pNameArr = new ArrayList<>();
        
        for(int i=0; i<orderNoArr.length; i++) {
            pNameArr.add(new OrderDao().selectExpensiveProductName(conn, orderNoArr[i]));           
        }
        
        JDBCTemplate.close(conn);
        
        return pNameArr;
    }

    public ArrayList<PAttachment> selectExpensiveProductThumbnailList(int[] orderNoArr) {
        Connection conn = JDBCTemplate.getConnection();
        
        ArrayList<PAttachment> paList = new ArrayList<>();
        
        for(int i=0; i<orderNoArr.length; i++) {
            paList.add(new OrderDao().selectExpensiveThumbnail(conn, orderNoArr[i]));
        }
        
        JDBCTemplate.close(conn);
        
        return paList;
    }

    public ArrayList<Product> selectLastOrderProductList(int orderNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        ArrayList<Product> pList = new OrderDao().selectLastOrderProductList(conn, orderNo);
        
        JDBCTemplate.close(conn);
        
        return pList;
    }

    public ArrayList<PAttachment> selectLastOrderThumbnailList(int orderNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        ArrayList<PAttachment> paList = new OrderDao().selectLastOrderThumbnailList(conn, orderNo);
        
        JDBCTemplate.close(conn);
        
        return paList;
    }

    public ArrayList<OrderList> selectOrderListView(int userNo, Date startDate, Date endDate) {
        Connection conn = JDBCTemplate.getConnection();
        ArrayList<OrderList> odList = new ArrayList<>();
        ArrayList<Order> oList = new OrderDao().selecrOrderList(conn, userNo, startDate, endDate);
//        System.out.println("SERVICE :: oList : "+oList);
        int[] orderNoArr = new int[oList.size()];
        ArrayList<PAttachment> paList = new ArrayList<>();
        ArrayList<String> pNameArr = new ArrayList<>();
        int[] orderProductNumArr = new int[oList.size()];
        if(!(oList.isEmpty())) {
            for(int i=0; i<oList.size();i++) {
                orderNoArr[i] = oList.get(i).getOrderNo();
                // 주문번호로 가장 비싼 상품명과 썸네일 가져오기
                paList.add(new OrderDao().selectExpensiveThumbnail(conn, orderNoArr[i]));
                orderProductNumArr[i] = new OrderDao().selectOrderProductNum(conn, orderNoArr[i]);
                // 주문번호로 상품 종류 수 가져오기
                pNameArr.add(new OrderDao().selectExpensiveProductName(conn, orderNoArr[i]));
                System.out.println("DAO::orderNoArr[i] :"+orderNoArr[i]);
                System.out.println(userNo);
                System.out.println(orderProductNumArr[i]);
                System.out.println(paList.get(i).getOriginName());
                System.out.println(paList.get(i).getFilePath());
                System.out.println(oList.get(i).getOrderDate());
                // OrderList에 데이터 담기
                odList.add(new OrderList(orderNoArr[i]
                                       , userNo
                                       , orderProductNumArr[i]
                                       , pNameArr.get(i)
                                       , paList.get(i).getOriginName()
                                       , paList.get(i).getFilePath()
                                       , oList.get(i).getOrderDate()
                                        )
                        );
//                System.out.println("odList.get("+i+") : "+odList.get(i));
            }
        }
        
        JDBCTemplate.close(conn);
        
        return odList;
    }

    public ArrayList<OrderList> selectOrderListByOrderNo(int orderNo) {
        Connection conn = JDBCTemplate.getConnection();
        
        ArrayList<OrderList> oList = new ArrayList<>();
        
        oList = new OrderDao().selectOrderListByOrderNo(conn, orderNo);
        
        JDBCTemplate.close(conn);
        
        return oList;
    }

	

	
}
