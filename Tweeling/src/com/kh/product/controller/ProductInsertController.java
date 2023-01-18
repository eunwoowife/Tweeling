package com.kh.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.product.model.service.ProductService2;
import com.kh.product.model.vo.PAttachment;
import com.kh.product.model.vo.Product;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ProductInsertController
 */
@WebServlet("/insert.pro")
public class ProductInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsertController() {
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
		
		if(ServletFileUpload.isMultipartContent(request)) {

			String savePath = request.getSession().getServletContext().getRealPath("/resources/product_upfiles/");
			int maxSize = 10*1024*1024;
			
			//origin name 사용할것임
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8");
			
			String celebName = multiRequest.getParameter("celebName");
			String pCategory = multiRequest.getParameter("pCategory");
			String pName = multiRequest.getParameter("pName");
			int pPrice = Integer.parseInt(multiRequest.getParameter("pPrice"));
			int pStock = Integer.parseInt(multiRequest.getParameter("pStock"));
			String pComment = multiRequest.getParameter("pComment");
			String pContent = multiRequest.getParameter("pContent");
			
			Product p = new Product();
			p.setCelebName(celebName);
			p.setCategoryNo(pCategory);
			p.setProductName(pName);
			p.setProductPrice(pPrice);
			p.setProductStock(pStock);
			p.setProductComment(pComment);
			p.setProductContent(pContent);
			
			ArrayList<PAttachment>paList = new ArrayList<>();
			for(int i=1; i<=3; i++) {
				String key = "file"+i;
				
				if(multiRequest.getOriginalFileName(key) != null) {
					PAttachment pa = new PAttachment();
					pa.setOriginName(multiRequest.getOriginalFileName(key));
					pa.setFilePath("/resources/product_upfiles/");
					
					if(i==1) {
						pa.setFileLevel(1);
					}else {
						pa.setFileLevel(2);
					}
					
					paList.add(pa);
				}
			}
			
			int finalResult = new ProductService2().insertProduct(p, paList);

			if(finalResult>0) {
				request.getSession().setAttribute("alertMsg", "상품이 정상적으로 등록되었습니다.");
				response.sendRedirect(request.getContextPath()+"/productManagement.pro");
			}else {
				request.setAttribute("errorMsg", "상품 등록 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}
	}

}
