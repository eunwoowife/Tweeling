package com.kh.product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.product.model.service.ProductService2;
import com.kh.product.model.vo.PAttachment;
import com.kh.product.model.vo.Product;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ProductModificationController
 */
@WebServlet("/modification.pro")
public class ProductModificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductModificationController() {
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
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8");
			
			int productNo = Integer.parseInt(multiRequest.getParameter("productNo"));
			String celebName = multiRequest.getParameter("celebName");
			String pCategory = multiRequest.getParameter("pCategory");
			String pName = multiRequest.getParameter("pName");
			int pPrice = Integer.parseInt(multiRequest.getParameter("pPrice"));
			int pStock = Integer.parseInt(multiRequest.getParameter("pStock"));
			String pComment = multiRequest.getParameter("pComment");
			String pContent = multiRequest.getParameter("pContent");
			
			Product p = new Product();
			p.setProductNo(productNo);
			p.setCelebName(celebName);
			p.setCategoryNo(pCategory);
			p.setProductName(pName);
			p.setProductPrice(pPrice);
			p.setProductStock(pStock);
			p.setProductComment(pComment);
			p.setProductContent(pContent);

			PAttachment pa = null;
			PAttachment pa2 = null;
			PAttachment pa3 = null;

			//새로 썸네일에 사진이 첨부될 경우
			if(multiRequest.getOriginalFileName("reUpfile1")!=null) {
				pa = new PAttachment();
				pa.setOriginName(multiRequest.getOriginalFileName("reUpfile1"));
				pa.setFilePath("/resources/product_upfiles/");
				
				//썸네일은 NOT NULL & required이라서 이전에 사진은 이미 무조건 등록되어있는 상태.
				//기존에 썸네일의 사진을 서버에서 삭제하기
				if(multiRequest.getParameter("tiFileNo")!=null) {
					pa.setFileNo(Integer.parseInt(multiRequest.getParameter("tiFileNo")));
					new File(savePath+multiRequest.getParameter("tiFileName")).delete();
				}
			}
			
			//컨텐트이미지1에 사진이 새롭게 첨부될 경우
			if(multiRequest.getOriginalFileName("reUpfile2")!=null) {
				pa2 = new PAttachment();
				pa2.setOriginName(multiRequest.getOriginalFileName("reUpfile2"));
				pa2.setFilePath("/resources/product_upfiles/");
				
				//컨텐트이미지는 기존에 있었을 수도 없었을 수도 있음.
				//기존에 이미지파일이 있었을 경우,
				//기존에 컨텐트이미지1의 사진을 서버에서 삭제하기
				if(multiRequest.getParameter("ciFile1No")!=null) {
					pa2.setFileNo(Integer.parseInt(multiRequest.getParameter("ciFile1No")));
					new File(savePath+multiRequest.getParameter("ciFile1Name")).delete();
				}else { //기존에 첨부파일이 없었을 경우
					pa2.setRefPno(productNo);
				}
			}
			
			//컨텐트이미지2에 사진이 새롭게 첨부될 경우
			if(multiRequest.getOriginalFileName("reUpfile3")!=null) {
				pa3 = new PAttachment();
				pa3.setOriginName(multiRequest.getOriginalFileName("reUpfile3"));
				pa3.setFilePath("/resources/product_upfiles/");
				
				//컨텐트이미지는 기존에 있었을 수도 없었을 수도 있음.
				//기존에 이미지파일이 있었을 경우,
				//기존에 컨텐트이미지2의 사진을 서버에서 삭제하기
				if(multiRequest.getParameter("ciFile2No")!=null) {
					pa3.setFileNo(Integer.parseInt(multiRequest.getParameter("ciFile2No")));
					new File(savePath+multiRequest.getParameter("ciFile2Name")).delete();
				}else { //기존에 첨부파일이 없었을 경우
					pa3.setRefPno(productNo);
				}
			}
			
			int finalResult = new ProductService2().modificationProduct(p, pa, pa2, pa3);
			
			if(finalResult>0) {
				HttpSession session = request.getSession();
				session.setAttribute("alertMsg", "상품정보가 정상적으로 수정되었습니다.");
				response.sendRedirect(request.getContextPath()+"/managementDetail.pro?pno="+productNo);
			}else {
				request.setAttribute("errorMsg", "상품정보 수정 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
		}
	}

}
