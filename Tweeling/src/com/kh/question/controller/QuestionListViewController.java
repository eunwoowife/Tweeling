package com.kh.question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.common.PagingTemplate;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.question.model.service.QuestionService;
import com.kh.question.model.vo.Question;

/**
 * Servlet implementation class QuestionListViewController
 */
@WebServlet("/listView.question")
public class QuestionListViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionListViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession session = request.getSession();
        
        // 사용자의 번호를 얻어 옴
        Member loginUser = (Member)session.getAttribute("loginUser");
        int userNo = loginUser.getUserNo();
//      System.out.println("MaPage::Ctrl::userNo : "+userNo);
        
        //--------------------------- myPage 상단 정보에 필요한 데이터 Start -------
        
        // 주문내역 건수 (해당 사용자의 총 주문 건으로 조회)
        int orderCount = new MemberService().orderCount(userNo);
        request.setAttribute("orderCount", orderCount);
//      System.out.println("MaPage::Ctrl::orderCount : "+orderCount);
        
        // 취소/교환/반품 건수
        // Order 객체에 컬럼을 추가하면 좋을 듯
        
        // 적립금액
        int mileage = new MemberService().selectMileage(userNo);
        request.setAttribute("mileage", mileage);
//      System.out.println("MaPage::Ctrl::mileage : "+mileage);
        
        // 쿠폰 수
        int couponNum = new MemberService().selectCouponNum(userNo);
        request.setAttribute("couponNum", couponNum);
//      System.out.println("MaPage::Ctrl::couponNum : "+couponNum);
        
        //--------------------------- myPage 상단 정보에 필요한 데이터 End -------
        
        // 페이징 처리
        int listCount = new QuestionService().selectListCount(userNo);
        int currentPage = Integer.parseInt(request.getParameter("currentPage"));
        int pageLimit = 10;  // 일단 고정
        int boardLimit = 10; // 일단 고정
        
        PageInfo pi = PagingTemplate.getPageInfo(listCount, currentPage, pageLimit, boardLimit);
//        System.out.println("listView.question:: ctrl ::pi"+pi);
        request.setAttribute("pi", pi);
        
        // 문의내역 리스트 
        ArrayList<Question> qList = new QuestionService().selectList(userNo, pi);
        request.setAttribute("qList", qList);
//        System.out.println("listView.question:: ctrl :: " + qList);
        
	    request.getRequestDispatcher("views/question/listQuestion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
