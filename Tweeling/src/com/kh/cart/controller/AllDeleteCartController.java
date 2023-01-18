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
 * Servlet implementation class llDeleteCart
 */
@WebServlet("/allDeleteCart.ca")
public class AllDeleteCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllDeleteCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String result = request.getParameter("result");
	    HttpSession session = request.getSession();
        Member loginUser = (Member)session.getAttribute("loginUser");
        int userNo = loginUser.getUserNo();
        int deleteResult = 0;
        
        if(result.equals("YYYY")){
        deleteResult = new CartService().AllDeleteCart(userNo);
        }
        JSONObject jOrr = new JSONObject();
        
        jOrr.put("deleteResult", deleteResult);
        
        response.setContentType("text/html; charset=UTF-8");
        
	}

}
