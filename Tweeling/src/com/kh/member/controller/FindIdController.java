package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class FindIdController
 */
@WebServlet("/findId.me")
public class FindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindIdController() {
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
		// TODO Auto-generated method stub
	    
		request.setCharacterEncoding("UTF-8");	
		
		String userName=request.getParameter("userfindName");
		
		String email=request.getParameter("findemail");
		
		
		//Member m= new MemberService().findMember(userName,email);
		
		String findUser= new MemberService().findMember(userName,email);
	
	
		
		if(findUser==null) {
		    request.setAttribute("Msg", "찾는 아이디가 없습니다.");
		    RequestDispatcher view = request.getRequestDispatcher("views/member/Idresult.jsp");
            view.forward(request, response);
		    
		    
		}else {
			
			 request.setAttribute("Msg", "고객님의 아이디는 "+findUser+" 입니다.");
			    RequestDispatcher view = request.getRequestDispatcher("views/member/Idresult.jsp");
	            view.forward(request, response);
	
			
//			HttpSession session = request.getSession();
//			session.setAttribute("findUser", findUser);
//			
//			RequestDispatcher view = request.getRequestDispatcher("views/member/findIdresult.jsp");
//			view.forward(request, response);

		}
		
	
		
	}
}
