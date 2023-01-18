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

import com.google.gson.Gson;
import com.kh.member.model.vo.Member;
import com.kh.order.model.service.OrderService;
import com.kh.order.model.vo.Order;
import com.kh.order.model.vo.OrderList;

/**
 * Servlet implementation class AjaxMyPageOrderListController
 */
@WebServlet("/ajaxOrderList.mp")
public class AjaxMyPageOrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMyPageOrderListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // 사용자의 번호를 얻어 옴
        HttpSession session = request.getSession();
        Member loginUser = (Member)session.getAttribute("loginUser");
        int userNo = loginUser.getUserNo();
	    
	    final int TODAY = 1;           // 오늘
	    final int ONE_WEEK = 2;        // 일주일 전
	    final int ONE_MONTH = 3;       // 한 달 전
	    final int THREE_MONTH = 4;     // 3개월 전
	    final int SIX_MONTH = 5;       // 6개월 전
	    
	    // 시작날 구분자를 받음
	    int startDay = Integer.parseInt(request.getParameter("startDay"));
//	    System.out.println("Ajax::OrderList:: startDay : "+startDay);
	    
	    Date startDate = null; 
	    Date endDate = new Date(System.currentTimeMillis());
	    
	    ArrayList<OrderList> olList = null;
	    String before = "";
	    Calendar temp = null;
	    
	    switch(startDay) {
	        case TODAY: 
	            startDate = new Date(System.currentTimeMillis());
	            System.out.println("버튼주문조회 ::"+startDate+"~"+endDate+"까지 조회");
	            olList = new OrderService().selectOrderListView(userNo, startDate, endDate);
	            
	            break;
            case ONE_WEEK:
                temp = Calendar.getInstance();
                temp.add(Calendar.DATE, -7); // 일주일 전
                before = new SimpleDateFormat("yyyy-MM-dd").format(temp.getTime());
                // 일주일 전 날짜 스트링을 넣어서 Date타입으로 변경
                startDate = Date.valueOf(before);
                System.out.println("버튼주문조회 ::"+startDate+"~"+endDate+"까지 조회");
                olList = new OrderService().selectOrderListView(userNo, startDate, endDate);
                break;
            case ONE_MONTH:
                // 한달전 날짜 구하기
                temp = Calendar.getInstance();
                temp.add(Calendar.MONTH, -1);
                before = new SimpleDateFormat("yyyy-MM-dd").format(temp.getTime());
                
                // 한달 전 날짜 스트링을 넣어서 Date타입으로 변경
                startDate = Date.valueOf(before);
                System.out.println("버튼주문조회 ::"+startDate+"~"+endDate+"까지 조회");
                olList = new OrderService().selectOrderListView(userNo, startDate, endDate);
                break;
            case THREE_MONTH:
             // 한달전 날짜 구하기
                temp = Calendar.getInstance();
                temp.add(Calendar.MONTH, -3);
                before = new SimpleDateFormat("yyyy-MM-dd").format(temp.getTime());
                
                // 한달 전 날짜 스트링을 넣어서 Date타입으로 변경
                startDate = Date.valueOf(before);
                System.out.println("버튼주문조회 ::"+startDate+"~"+endDate+"까지 조회");
                olList = new OrderService().selectOrderListView(userNo, startDate, endDate);
                break;
            case SIX_MONTH:
             // 한달전 날짜 구하기
                temp = Calendar.getInstance();
                temp.add(Calendar.MONTH, -6);
                before = new SimpleDateFormat("yyyy-MM-dd").format(temp.getTime());
                
                // 한달 전 날짜 스트링을 넣어서 Date타입으로 변경
                startDate = Date.valueOf(before);
                System.out.println("버튼주문조회 ::"+startDate+"~"+endDate+"까지 조회");
                olList = new OrderService().selectOrderListView(userNo, startDate, endDate);
                break;
	    default: System.out.println("AjaxOrderListController::startDay 범위 에러");
	    }
//	    System.out.println("AjaxOrderListController:: oList : "+oList);
	    
	    response.setContentType("application/json; charset=UTF-8");
        new Gson().toJson(olList, response.getWriter());
	}
}
