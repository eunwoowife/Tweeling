package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberDelete
 */
@WebServlet(name = "delete.me", urlPatterns = { "/delete.me" })
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDelete() {
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
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");
		String userId = loginUser.getUserId();
		
		
		String userPwd = request.getParameter("userPwd");
		
		int result = new MemberService().deleteMember(userId,userPwd);
		
		if(result>0) {
		//성공시
		//변경에 성공했으면 성공적으로 회원 탈퇴 되었습니다 메세지를 alertMsg에 세팅
		//로그아웃처리를 해주면서 메인 페이지로 이동 (재요청)
			session.setAttribute("alertMsg", "성공적으로 회원 탈퇴 되었습니다.");
			//세션에 등록되어있는 로그인유저 정보를 삭제해서 로그아웃처리
			session.removeAttribute("loginUser");
			System.out.println("go to main. here is DELETE CTRL");
			response.sendRedirect(request.getContextPath());
			
		}else {
		//실패시
		//에러페이지에 errorMsg 메세지 회원탈퇴 실패 보내고 포워딩 
			request.setAttribute("errorMsg", "회원 탈퇴 실패");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
		}
		
		
		
	
	}

}
