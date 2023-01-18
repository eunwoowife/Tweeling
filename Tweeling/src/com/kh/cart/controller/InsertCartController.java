package com.kh.cart.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.cart.model.service.CartService;
import com.kh.cart.model.vo.Cart;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class InsertCartController
 */
@WebServlet("/insert.ca")
public class InsertCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCartController() {
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
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
        Member loginUser = (Member)session.getAttribute("loginUser");
        int userNo = loginUser.getUserNo();
		//상품번호 가져오기
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		//수량 가져오기
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
			
		int result = 0;
		
		//해당 상품이 유저의 카트에 이미 담겨져있는지 확인하기~~
		int count = new CartService().checkCart(userNo, productNo);
		
		//유저의 카트에 이미 있는 상품이라면
		if(count>0) { //해당 상품의 갯수를 추가해서 장바구니에 넣어주기
			result = new CartService().insertCartUpdateQuantity(userNo, productNo, quantity);
		}else { //유저의 카트에 없는 상품일 경우 해당 상품 자체를 장바구니에 추가하기
			result = new CartService().insertCart(userNo, productNo, quantity);
		}
		
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(result, response.getWriter());
	}

}
