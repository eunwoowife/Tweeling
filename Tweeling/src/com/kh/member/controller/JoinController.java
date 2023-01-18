package com.kh.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
 * Servlet implementation class JoinController
 */
@WebServlet("/join.me")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
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
        
        String userId=request.getParameter("userId");
        String userPwd=request.getParameter("userPwd");
        String userName=request.getParameter("userName");
        String userNickname=request.getParameter("userNickname");
        String userPhone=request.getParameter("Phone");
        String userEmail=request.getParameter("email");
        String userGender=request.getParameter("gender");
        
        
       
        String zip=request.getParameter("zipcode");
        String add1=request.getParameter("add1");
        String add2=request.getParameter("add2");
        String add3=request.getParameter("add3");
        
        String year=request.getParameter("byear");
        String month=request.getParameter("bmonth");
        String day=request.getParameter("bday");
        String userbias=request.getParameter("userbias");
        
        //주소처리 
        
        ArrayList<String> Taddress =new ArrayList<String>();
        
        
        Taddress.add(add1);
        Taddress.add(add3);
        Taddress.add(add2);
        Taddress.add(zip);
        
        String userAddress=String.join(" ", Taddress);
        
        
        // 생일처리 
        ArrayList<String> Nday = new ArrayList<String>();
        
        Nday.add(year);
        Nday.add(month);
        Nday.add(day);
       
     
        String Bday=String.join("-", Nday);
        
        // String -> Date 형변환
        Date BirthDay = Date.valueOf(Bday);
      
        Member m = new Member(userId,userPwd,userName,userNickname,userPhone,userEmail,userGender,userAddress,BirthDay,userbias);
       
      
       
        
        int result = new MemberService().insertMember(m);
        
       
        
        if(result>0) { //성공
            //회원가입 성공시 index페이지 띄우면서 alert 메세지에 회원가입 성공했습니다 띄우기 
            
            //성공 메세지 담기 (재요청을 할것이기때문에 session에 담아서 보내기)
            HttpSession session = request.getSession();
          
          //  session.setAttribute("alertMsg", "회원가입이 완료되었습니다.");
            
            //메인페이지 재요청
         response.sendRedirect(request.getContextPath());
            
//            RequestDispatcher view = request.getRequestDispatcher("views/common/realMenubar.jsp");
//    		
//			view.forward(request, response);
        
            
            
        }else {//실패
            //회원가입 실패시 error 페이지에 회원가입 실패 메세지 띄우기 
            request.setAttribute("errorMsg", "회원가입에 실패하였습니다.");
            
            RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
            view.forward(request, response);
        }
    
    }

}