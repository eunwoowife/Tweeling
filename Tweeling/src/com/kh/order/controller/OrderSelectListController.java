package com.kh.order.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.cart.model.vo.Cart;
import com.kh.member.model.vo.Member;
import com.kh.order.model.service.OrderService;


/**
 * Servlet implementation class OrderSelectListController
 */
@WebServlet("/order2.or")
public class OrderSelectListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderSelectListController() {
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

        HttpSession session = request.getSession();
        Member loginUser = (Member) session.getAttribute("loginUser");
        int userNo = loginUser.getUserNo();

        ArrayList<Member> member = new OrderService().OrderMemberListView(userNo);


        ArrayList<Cart> cart = new ArrayList<Cart>();


        String selectpno = request.getParameterValues("selectpno")[0];
        String selectpcount = (request.getParameterValues("selectpcount")[0]);


        
            String[] arrSelectPno = selectpno.split(",");
            String[] arrSelectpcount = selectpcount.split(",");

            int cartSize = arrSelectPno.length;
            ArrayList<Integer> pNo = new ArrayList<Integer>(); // 상품번호르 담은 어레이리스트
            ArrayList<Integer> pCount = new ArrayList<Integer>(); // 상품 개수를 담은 어레이리스트

            for (int i = 0; i < cartSize; i++) {
                pNo.add(Integer.parseInt(arrSelectPno[i]));
                pCount.add(Integer.parseInt(arrSelectpcount[i]));
            }
            ;

            // 어레이리스트들에 정보 담아서 DAO로 갔다옵니다.
            cart = new OrderService().OrderListView(userNo, pNo, pCount);


        request.setAttribute("member", member);
        request.setAttribute("cart", cart);

        request.getRequestDispatcher("views/order/orderListView.jsp").forward(request, response);
	}

}
