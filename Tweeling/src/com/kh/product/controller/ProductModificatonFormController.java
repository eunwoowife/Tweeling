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
import com.kh.product.model.vo.PCategory;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class ProductModificatonFormController
 */
@WebServlet("/modificationForm.pro")
public class ProductModificatonFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductModificatonFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService2 ps2 = new ProductService2();
		
		int productNo = Integer.parseInt(request.getParameter("pno"));
		
		Product p = ps2.selectProductManagement(productNo);
		ArrayList<PCategory>pcList = ps2.selectProductCategoryList();
		ArrayList<PAttachment>paList = ps2.selectProductManagementAttachmentList(productNo);
		
		request.setAttribute("p", p);
		request.setAttribute("pcList", pcList);
		request.setAttribute("paList", paList);
		
		request.getRequestDispatcher("views/product/productModificationForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
