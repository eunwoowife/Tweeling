package com.kh.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.review.model.service.ReviewService;
import com.kh.review.model.vo.Review;

/**
 * Servlet implementation class InsertReviewController
 */
@WebServlet("/insert.rev")
public class InsertReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertReviewController() {
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
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int productNo = Integer.parseInt(request.getParameter("productNo"));
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		int score = Integer.parseInt(request.getParameter("reviewStar"));
		String reviewContent = request.getParameter("reviewcontent");
		
		Review r = new Review();
		r.setUserNo2(userNo);
		r.setRefPno(productNo);
		r.setOrderNo(orderNo);
		r.setReviewScore(score);
		r.setReviewContent(reviewContent);
		
		int result = new ReviewService().insertReview(r);
		
		if(result>0) {
			request.getSession().setAttribute("alertMsg", "리뷰가 정상적으로 등록되었습니다.");
			response.sendRedirect(request.getContextPath()+"/detail.pro?pno="+productNo);
		}else {
			request.setAttribute("errorMsg", "리뷰 등록 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

}
