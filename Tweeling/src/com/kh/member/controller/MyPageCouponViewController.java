package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Coupon;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MyPageCouponViewController
 */
@WebServlet("/selectCoupon.mp")
public class MyPageCouponViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageCouponViewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    System.out.println("MyPageCouponViewController 동작");
	 // --- 마이페이지 상단 데이터 수집. ------------------ START
        // 사용자의 번호를 얻어 옴
        HttpSession session = request.getSession();
        Member loginUser = (Member)session.getAttribute("loginUser");
        int userNo = loginUser.getUserNo();
//      System.out.println("MaPage::Ctrl::userNo : "+userNo);
        // 마이페이지에 출력할 내용들을 받아서 전달
        
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
        
        // --- 마이페이지 상단 데이터 수집. ------------------ END
        
        // --- 보유 쿠폰 검색 
        ArrayList<Coupon> cList = new MemberService().selectCouponList(userNo);
        request.setAttribute("cList", cList);
//        System.out.println("MaPage::Ctrl::cList : "+cList);

        request.getRequestDispatcher("/views/myPage/myPageCoupon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
