package com.kh.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.question.model.service.QuestionService;

/**
 * Servlet implementation class QuestionDeleteController
 */
@WebServlet("/delete.question")
public class QuestionDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int questionNo = Integer.parseInt(request.getParameter("qno"));
        
        int result = new QuestionService().deleteQuestion(questionNo);
        
        if(result>0) {
            request.getSession().setAttribute("alertMsg", "문의글 삭제 성공");
            response.sendRedirect(request.getContextPath()+"/listView.question?currentPage=1");
        }else {
            request.setAttribute("errorMsg", "문의글 삭제 실패");
            request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
            
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
