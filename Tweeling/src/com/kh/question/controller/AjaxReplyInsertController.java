package com.kh.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.vo.Member;
import com.kh.question.model.service.QuestionService;
import com.kh.question.model.vo.QReply;

/**
 * Servlet implementation class AjaxReplyInsertController
 */
@WebServlet("/rinsert.question")
public class AjaxReplyInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyInsertController() {
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
	    String content = request.getParameter("content");
        int qno = Integer.parseInt(request.getParameter("qno"));
        Member loginUser = (Member)request.getSession().getAttribute("loginUser");
        int userNo = loginUser.getUserNo();
        
        QReply r = new QReply();
        r.setReplyContent(content);
        r.setRefQno(qno);
        r.setReplyWriter(String.valueOf(userNo));
        
        int result = new QuestionService().insertReply(r);
        
        response.getWriter().print(result);
	}

}
