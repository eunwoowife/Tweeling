package com.kh.Search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.Search.model.service.SearchService;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class SearchListController
 */
@WebServlet("/searchListView.se")
public class SearchListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String keyword =request.getParameter("keyword");		 
		 ArrayList<Product> list = new SearchService().searchListView(keyword);
		 
		 request.setAttribute("list", list);
		 
		 
		 
		 response.setContentType("application/json; charset=UTF-8");
		 new Gson().toJson(list, response.getWriter());
		 
		
	}

}
