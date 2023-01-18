package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.product.model.service.ProductService2;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class AjaxLineupLowpriceController
 */
@WebServlet("/sortLineup.pro")
public class AjaxLineupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxLineupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lineup = request.getParameter("lineup");
		
		//정렬을 낮은가격순으로 select했을 때,
		if(lineup.equals("lowprice")) {
			ArrayList<Product>list = new ProductService2().selectProductLineupLowprice(lineup);
			
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(list, response.getWriter());
		}
		
		//정렬을 높은가격순으로 select했을 때,
		if(lineup.equals("highprice")) {
			ArrayList<Product>list = new ProductService2().selectProductLineupHighprice(lineup);
			
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(list, response.getWriter());
		}
		
		if(lineup.equals("new")) {
			ArrayList<Product>list = new ProductService2().selectProductLineupNew(lineup);
			
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(list, response.getWriter());
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
