package com.kh.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.review.model.service.ReviewService;

/**
 * Servlet implementation class CheckReviewController
 */
@WebServlet("/check.rev")
public class CheckReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckReviewController() {
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
		
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));

		System.out.println(orderNo);
		int count = new ReviewService().checkReview(productNo, orderNo, userNo);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(count, response.getWriter());
	}

}
