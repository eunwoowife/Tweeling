package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.product.model.service.ProductService2;
import com.kh.product.model.vo.PAttachment;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class ProductManagementDetailController
 */
@WebServlet("/managementDetail.pro")
public class ProductManagementDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductManagementDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productNo = Integer.parseInt(request.getParameter("pno"));
		
		//관리자용 상품디테일 페이지
		Product p = new ProductService2().selectProductManagement(productNo);
		ArrayList<PAttachment>paList = new ProductService2().selectProductManagementAttachmentList(productNo);
		
//		System.out.println(p);
//		System.out.println(paList);
		
		request.setAttribute("p", p);
		request.setAttribute("paList", paList);
		
		request.getRequestDispatcher("views/product/productManagementDetailView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
