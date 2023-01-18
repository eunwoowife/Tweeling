package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.product.model.service.ProductService;
import com.kh.product.model.service.ProductService2;
import com.kh.product.model.vo.PAttachment;
import com.kh.product.model.vo.Product;
import com.kh.review.model.vo.Review;

/**
 * Servlet implementation class ProductDetailController
 */
@WebServlet("/detail.pro")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo = Integer.parseInt(request.getParameter("pno"));
//				System.out.println(productNo);
		
		//상품정보 가져오기
		Product p =new ProductService().selectProduct(productNo);
		//상품디테일 이미지 가져오기
		ArrayList<PAttachment>paList = new ProductService().selectProductAttachmentList(productNo);
		//상품리뷰 가져오기
		ArrayList<Review>rList = new ProductService2().selectReview(productNo);
		
		request.setAttribute("p", p);
		request.setAttribute("paList", paList);
		request.setAttribute("rList", rList);
		
//		System.out.println(p);
//		System.out.println(paList);

		request.getRequestDispatcher("views/product/productDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
