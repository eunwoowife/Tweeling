package com.kh.cart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.cart.model.service.CartService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class CheckDeleteController
 */
@WebServlet("/checkDelete.ca")
public class CheckDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckDeleteController() {
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
		String [] checkPno = request.getParameterValues("productNo");
		 HttpSession session = request.getSession();
	     Member loginUser = (Member)session.getAttribute("loginUser");
	     int userNo = loginUser.getUserNo();
	     int result2 =0;
	    for(int i=0; i<checkPno.length; i++) {
		result2 += new CartService().CheckDelete(checkPno[i],userNo);
	    }
	    
	    
//	    System.out.println(result2);
	}

}
