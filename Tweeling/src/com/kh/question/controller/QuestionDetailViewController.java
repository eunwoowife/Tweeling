package com.kh.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;
import com.kh.question.model.service.QuestionService;
import com.kh.question.model.vo.QAttachment;
import com.kh.question.model.vo.Question;

/**
 * Servlet implementation class QuestionDetailViewController
 */
@WebServlet("/detail.question")
public class QuestionDetailViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionDetailViewController() {
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
//      System.out.println("qDetail::Ctrl::userNo : "+userNo);
        
        //--------------------------- myPage 상단 정보에 필요한 데이터 Start -------
        
        // 주문내역 건수 (해당 사용자의 총 주문 건으로 조회)
        int orderCount = new MemberService().orderCount(userNo);
        request.setAttribute("orderCount", orderCount);
//      System.out.println("qDetail::Ctrl::orderCount : "+orderCount);
        
        // 취소/교환/반품 건수
        // Order 객체에 컬럼을 추가하면 좋을 듯
        
        // 적립금액
        int mileage = new MemberService().selectMileage(userNo);
        request.setAttribute("mileage", mileage);
//      System.out.println("qDetail::Ctrl::mileage : "+mileage);
        
        // 쿠폰 수
        int couponNum = new MemberService().selectCouponNum(userNo);
        request.setAttribute("couponNum", couponNum);
//      System.out.println("qDetail::Ctrl::couponNum : "+couponNum);
        
        //--------------------------- myPage 상단 정보에 필요한 데이터 End -------
        
	    int qno = Integer.parseInt(request.getParameter("qno"));
//	    System.out.println("qDetail.question : qno : "+qno);
	    
	    Question q = new QuestionService().selectQuestion(qno);
	    QAttachment qat = new QuestionService().selectAttachment(qno);
        
        if(q != null) {
            // 조회한 데이터 담아서 상세보기 페이지로 포워딩
            System.out.println("문의게시판 상세페이지 클릭 -> 게시글 번호 : "+ qno);
            request.setAttribute("question", q);
            if(qat != null) {
                System.out.println("첨부파일 : "+ qat);
                request.setAttribute("attachment", qat);
            }
            else {
                System.out.println("첨부파일 없음");
            }
            request.getRequestDispatcher("/views/question/detailQuestion.jsp").forward(request, response);
        }
        else {
            // 실패 시 에러페이지
            request.setAttribute("errorMsg", "글 상세보기 에러");
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
