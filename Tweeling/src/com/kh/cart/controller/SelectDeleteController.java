package com.kh.cart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.kh.cart.model.service.CartService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class SelectDeleteController
 */
@WebServlet("/selectDelete.ca")
public class SelectDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectDeleteController() {
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
			int productNo = Integer.parseInt(request.getParameter("productNo"));
			HttpSession session = request.getSession();
	        Member loginUser = (Member)session.getAttribute("loginUser");
	        int userNo = loginUser.getUserNo();
	        int deleteResult = 0;
		    
	        
	        deleteResult = new CartService().selectDelete(userNo, productNo);
	        
	        JSONObject jOrr = new JSONObject();
	        
	        response.setContentType("text/html; charset=UTF-8");
	}

}
