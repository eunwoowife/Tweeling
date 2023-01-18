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
 * Servlet implementation class OrderListController
 */
@WebServlet("/order.or")
public class OrderListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderListController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

 request.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        Member loginUser = (Member)session.getAttribute("loginUser");
        int userNo = loginUser.getUserNo();
        
        ArrayList <Member> member = new OrderService().OrderMemberListView(userNo);
        
        
        
        String productNo = "productNo"; //프로덕트넘버
        String pp_num = "pp_num"; //수량
        

        ArrayList <Cart> cart = new ArrayList <Cart>();
        
        String [] a= request.getParameterValues("p_price");
        
        if(a==null) { //개별주문했을때
            int pno = Integer.parseInt(request.getParameter("pno"));
            int pcount = Integer.parseInt(request.getParameter("pcount"));
            
            cart= new OrderService().OrderOneListView(userNo, pno, pcount);
            
            
        }else { //전체주문 또는 선택주문했을 때 배열로 보내는 구문...?
            int cartSize = a.length; //카트에 상품이 몇개 들어있는지 확인하기 위한 변수
            ArrayList <Integer> pNo = new ArrayList <Integer>(); //상품번호르 담은 어레이리스트
            ArrayList <Integer> pCount = new ArrayList <Integer>(); //상품 개수를 담은 어레이리스트
           
            for(int i=1; i<cartSize+1; i++) {
                pNo.add(Integer.parseInt(request.getParameter(productNo+i)));
                pCount.add(Integer.parseInt(request.getParameter(pp_num+i)));
            };
        
            //어레이리스트들에 정보 담아서 DAO로 갔다옵니다.
            cart = new OrderService().OrderListView(userNo, pNo, pCount);
        
        }
        request.setAttribute("member", member);
        request.setAttribute("cart", cart);
        
        
        request.getRequestDispatcher("views/order/orderListView.jsp").forward(request, response);
    

    }

}
