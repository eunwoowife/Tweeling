package com.kh.order.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.order.model.service.OrderService;
import com.kh.order.model.vo.Order;
import com.kh.product.model.vo.PAttachment;
import com.kh.product.model.vo.PAttachment;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class OrderListController
 */
@WebServlet("/orderList.mp")
public class MyPageOrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageOrderListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // --- 마이페이지 상단 데이터 수집. ------------------ START
	    // 사용자의 번호를 얻어 옴
	    HttpSession session = request.getSession();
        Member loginUser = (Member)session.getAttribute("loginUser");
        int userNo = loginUser.getUserNo();
//      System.out.println("MaPage::Ctrl::userNo : "+userNo);
        // 마이페이지에 출력할 내용들을 받아서 전달
        
        // 주문내역 건수 (해당 사용자의 총 주문 건으로 조회)
        int orderCount = new MemberService().orderCount(userNo);
        request.setAttribute("orderCount", orderCount);
//      System.out.println("MaPage::Ctrl::orderCount : "+orderCount);
        
        // 취소/교환/반품 건수
        // Order 객체에 컬럼을 추가하면 좋을 듯
        
        // 적립금액
        int mileage = new MemberService().selectMileage(userNo);
        request.setAttribute("mileage", mileage);
//      System.out.println("MaPage::Ctrl::mileage : "+mileage);
        
        // 쿠폰 수
        int couponNum = new MemberService().selectCouponNum(userNo);
        request.setAttribute("couponNum", couponNum);
//      System.out.println("MaPage::Ctrl::couponNum : "+couponNum);
        
        // --- 마이페이지 상단 데이터 수집. ------------------ END
	    
	    // --- 주문 내역 조회 --------------------------- START 
	    // 오늘 날짜 - 날짜선택지 기본값 세팅하기 위해
	    // 주문 리스트 - 일단 있는대로 출력되도록
        Date endDate = new Date(System.currentTimeMillis());
        
        // 3달전 날짜 구하기
        Calendar mon = Calendar.getInstance();
        mon.add(Calendar.MONTH, -3);
        String beforeMonth = new SimpleDateFormat("yyyy-MM-dd").format(mon.getTime());
        
        // 3달 전 날짜 스트링을 넣어서 Date타입으로 변경
        Date startDate = Date.valueOf(beforeMonth);
        
//        System.out.println("startDate : "+startDate);
//        System.out.println("endDate : "+endDate);
        
        // 최근 3개월 간의 주문 내역 
        ArrayList<Order> oList = new OrderService().selectOrderList(userNo, startDate, endDate);
        request.setAttribute("oList", oList);
//        System.out.println("OrderList::Ctrl::oList : 전-"+oList);
        
        // 검색한 주문 내역의 주문 건 수 조회
        int orderNo = 0;
        ArrayList<Integer> odCountList = new ArrayList<>();
        for(int i=0; i<oList.size(); i++) {
            if(oList.get(i) !=null) {
                orderNo = oList.get(i).getOrderNo();
//                System.out.println("i : "+i);
//                System.out.println("orderNo : "+orderNo);
                odCountList.add(new Integer(new OrderService().selectOrderProductNum(orderNo)));
//                System.out.println("odCount : "+odCountList[i]);
            }
        }
        request.setAttribute("odCountList", odCountList);
//        System.out.println("OrderList::Ctrl::odCountList : "+odCountList);
        
        if(!(oList.isEmpty())) {
        	
        	// 매 주문의 가장 비싼 상품명 목록
        	int[] orderNoArr = new int[oList.size()];
        	ArrayList<String> pNameArr = new ArrayList<>();
        	for(int i=0; i<oList.size(); i++) {
        		orderNoArr[i] = oList.get(i).getOrderNo();
        	}
        	pNameArr = new OrderService().selectExpensiveProductNameList(orderNoArr);
        	request.setAttribute("pNameArr", pNameArr);
//        System.out.println("OrderList::Ctrl::pNameArr : "+pNameArr);
        	
        	// 매 주문의 가장 비싼 상품의 썸네일 목록
        	ArrayList<PAttachment> paList = null;
        	paList = new OrderService().selectExpensiveProductThumbnailList(orderNoArr);
        	request.setAttribute("paList", paList);
//        	System.out.println("OrderList::Ctrl::paList : "+paList);
        	
        	// 추후 페이징 처리 추가. 한 페이지에 5개씩 표시할 것
        	
        	// --- 주문 내역 조회 --------------------------- End 
        	
        	// 가장 마지막 주문한 상품 정보 ----------------------- Start
        	// 가장 마지막 주문의 상품 목록
        	ArrayList<Product> pLastList = null;
        	pLastList = new OrderService().selectLastOrderProductList(orderNoArr[0]);
        	request.setAttribute("pLastList", pLastList);
        	
        	// 가장 마지막 주문의 상품들의 첨부파일 목록
        	ArrayList<PAttachment> paLastList = null;
        	paLastList = new OrderService().selectLastOrderThumbnailList(orderNoArr[0]);
        	request.setAttribute("paLastList", paLastList);
        	// 가장 마지막 주문한 상품 정보 ----------------------- End 
        	
        }
        
	    request.getRequestDispatcher("/views/myPage/myPageOrderList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
