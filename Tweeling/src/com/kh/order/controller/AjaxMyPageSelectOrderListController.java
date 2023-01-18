package com.kh.order.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.member.model.vo.Member;
import com.kh.order.model.service.OrderService;
import com.kh.order.model.vo.OrderList;

/**
 * Servlet implementation class AjaxMyPageSelectOrderListController
 */
@WebServlet("/ajaxSelectOrderList.mp")
public class AjaxMyPageSelectOrderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMyPageSelectOrderListController() {
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
        
        // 입력받은 날짜를 문자열로 담음
        String startTemp = request.getParameter("startDay");
        String endTemp = request.getParameter("endDay");
//        System.out.println("Ajax::SelectOrderList:: startTemp : "+startTemp);
//        System.out.println("Ajax::SelectOrderList:: endTemp : "+endTemp);
        
        // Date타입으로 형변환
        Date startDate = java.sql.Date.valueOf(startTemp);
        Date endDate = java.sql.Date.valueOf(endTemp);
        System.out.println("버튼주문조회 ::"+startDate+"~"+endDate+"까지 조회");
        
        ArrayList<OrderList> olList = null;
        
        olList = new OrderService().selectOrderListView(userNo, startDate, endDate);
        
        response.setContentType("application/json; charset=UTF-8");
        new Gson().toJson(olList, response.getWriter());
        
	}

}
