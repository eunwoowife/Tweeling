package com.kh.wish.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kh.cart.model.service.CartService;
import com.kh.member.model.vo.Member;
import com.kh.wish.model.service.WishService;

/**
 * Servlet implementation class WishAddController
 */
@WebServlet("/wishAdd.wi")
public class WishController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishController() {
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
		HttpSession session = request.getSession();
        Member loginUser = (Member)session.getAttribute("loginUser");
        int userNo = loginUser.getUserNo();
		//상품번호 가져오기
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		
//		System.out.println(productNo);
		
		ArrayList <Integer> wishList = new ArrayList<>();
		
		//일단 유저넘버의 위시리스트를 뽑아오기
		wishList = new WishService().WishList(userNo);
		
		 boolean check = wishList.contains(productNo);

		 String result = "";
		 
		 if(check==false) { //위시리스트에 상품번호가 없어서 insert 해주는 경우
		     new WishService().WishAdd(userNo, productNo);
			 result = "YYYY";
			 response.getWriter().print(result);
		 }else { //상품번호가 존재해서 아무것도 안하고 결과값 반환해주는 경우
			 result = "NNNN";
			 response.getWriter().print(result);
		 }
		 

		 
		 
		 
		
		
		
	}

}
