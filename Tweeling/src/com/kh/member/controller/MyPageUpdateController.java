package com.kh.member.controller;

import java.io.IOException;
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
import com.kh.order.model.service.OrderService;
import com.kh.order.model.vo.Order;
import com.kh.product.model.vo.PAttachment;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class MyPageUpdateController
 */
@WebServlet("/updatemy.me")
public class MyPageUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageUpdateController() {
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
        
		String userId=request.getParameter("userId");
        String userPwd=request.getParameter("userPwd");
        String userNickname=request.getParameter("userNickname");
        String userPhone=request.getParameter("Phone");
        String userEmail=request.getParameter("email");
        String userGender=request.getParameter("gender");
        String userbias=request.getParameter("userbias");
        String userAddress=request.getParameter("address");
        
       
    
       
       
       Member m1 = new Member(userId,userPwd,userNickname,userPhone,userEmail,userGender,userAddress,userbias);
      
       
       int result = new MemberService().updateMember(m1);
     
       
      // ----------------------------------------------- Member 수정 완료
       
       // ------------------------------ MyPage 데이터 수집 Start
       
       HttpSession session = request.getSession();
       // 사용자의 번호를 얻어 옴
       Member loginUser = (Member)session.getAttribute("loginUser");
       int userNo = loginUser.getUserNo();
       
       // userNo로 다시 Member 정보 조회
       Member newMember = new MemberService().selectMember(userNo);
           
       System.out.println("updateCTRL::"+newMember);
       session.setAttribute("loginUser", newMember);
       
       if(session.getAttribute("loginUser")==null) {   // 아이디 비밀번호로 조회된 회원 정보가 없을 경우
           // 에러 페이지로 응답
           request.setAttribute("errorMsg", "로그인에 실패했습니다.");
           RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
           view.forward(request, response);
           
       }
       else {     // 로그인 된 상태
//         System.out.println("MaPage::Ctrl::userNo : "+userNo);
           // 마이페이지에 출력할 내용들을 받아서 전달
           
           // 주문내역 건수 (해당 사용자의 총 주문 건으로 조회)
           int orderCount = new MemberService().orderCount(userNo);
           request.setAttribute("orderCount", orderCount);
//         System.out.println("MaPage::Ctrl::orderCount : "+orderCount);
           
           // 취소/교환/반품 건수
           // Order 객체에 컬럼을 추가하면 좋을 듯
           
           // 적립금액
           int mileage = new MemberService().selectMileage(userNo);
           request.setAttribute("mileage", mileage);
//         System.out.println("MaPage::Ctrl::mileage : "+mileage);
           
           // 쿠폰 수
           int couponNum = new MemberService().selectCouponNum(userNo);
           request.setAttribute("couponNum", couponNum);
//         System.out.println("MaPage::Ctrl::couponNum : "+couponNum);
           
           // 가장 마지막 주문 내역 검색
           Order lastOrder = new OrderService().selectLastOrder(userNo);
           request.setAttribute("lastOrder", lastOrder);
//         System.out.println("MaPage::Ctrl::lastOrder : "+lastOrder);
           
           
           // 주문이 있을 경우 주문한 상품 한가지(가장 비싼 것)의 썸네일을 전달
           if(lastOrder !=null) {
               // 가장 마지막 주문의 상품 건수 검색(상품 개수의 합이 아닌 상품 종류 수로 계산)
               int orderNo = lastOrder.getOrderNo();
               int orderProductNum = new OrderService().selectOrderProductNum(orderNo);
               request.setAttribute("orderProductNum", orderProductNum);
//         System.out.println("MaPage::Ctrl::orderProductNum : "+orderProductNum);
               
               // 주문번호 -> 가장 비싼 상품번호 -> 상품번호에 맞는 썸네일
               PAttachment pa = new OrderService().selectExpensiveThumbnail(orderNo);
               request.setAttribute("pAttachment", pa);
//             System.out.println("MyPage::Ctrl::P_Attachment : "+pa);
               
           }
           
           // 관심상품 리스트
           ArrayList<Product> wishList = new MemberService().selectWishList(userNo);  // 썸네일 titleImg 포함
           request.setAttribute("wishList", wishList);
//         System.out.println("MyPage::CTRL:: wishList : "+ wishList);
       }
           //------------------------- MyPage 데이터 수집 End
       
       if(result>0) { 
           session.setAttribute("alertMsg", "정보수정이 완료되었습니다.");
           RequestDispatcher view = request.getRequestDispatcher("views/myPage/myPage.jsp");
			view.forward(request, response);
           
           
       }else {
           request.setAttribute("errorMsg", "정보수정 실패하였습니다.");
           
           RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
           view.forward(request, response);
       }
   
       
   }


}
