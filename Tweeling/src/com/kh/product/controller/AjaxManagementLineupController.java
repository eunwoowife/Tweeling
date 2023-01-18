package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.product.model.dao.ProductDao2;
import com.kh.product.model.service.ProductService2;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class AjaxManagementLineupController
 */
@WebServlet("/sortLineup2.pro")
public class AjaxManagementLineupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxManagementLineupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lineup = request.getParameter("lineup");
		
		//낮은가격순으로 정렬
		if(lineup.equals("lowprice")) {
			ArrayList<Product>list = new ProductService2().selectProductLineupLowprice2(lineup);
			
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(list, response.getWriter());
		}
		
		//높은가격순으로 정렬
		if(lineup.equals("highprice")) {
			ArrayList<Product>list = new ProductService2().selectProductLineupHighprice2(lineup);
			
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(list, response.getWriter());
		}
		
		//최신순으로 정렬
		if(lineup.equals("new")) {
			ArrayList<Product>list = new ProductService2().selectProductLineupNew2(lineup);
			
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(list, response.getWriter());
		}
		
		//아티스트명 이름순으로 정렬
		if(lineup.equals("names")) {
			ArrayList<Product>list = new ProductService2().selectProductLineupNames(lineup);
			
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
