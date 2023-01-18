package com.kh.order.controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.kh.cart.model.service.CartService;
import com.kh.cart.model.vo.Cart;
import com.kh.order.model.service.OrderService;
import com.kh.order.model.vo.Order;
import com.kh.order.model.vo.OrderShipping;
/**
 * Servlet implementation class OrderCompleteController
 */
@WebServlet("/OrderComplete.or")
public class OrderCompleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderCompleteController() {
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
	
	int userNo = Integer.parseInt(request.getParameter("userNo"));
	
	ArrayList <Cart> cart = new CartService().CartListView(userNo);
	int selectPrice  =0;
	int oneProductCount =0;
	if(cart.isEmpty()) {
		int oneProductNo = Integer.parseInt(request.getParameter("oneProductNo"));
		oneProductCount = Integer.parseInt(request.getParameter("oneProductCount"));
		selectPrice = Integer.parseInt(request.getParameter("oneProductPrice"));
		cart.add(new Cart (userNo, oneProductNo, oneProductCount));
		
	}
	
	//상품합계
	int totalAmount = 0;
	for(int i=0; i<cart.size(); i++) {
		
		if(cart.get(i).getProductPrice()==null) {
			totalAmount = (oneProductCount*selectPrice);
			
		}else {
		totalAmount += Integer.parseInt(cart.get(i).getProductPrice())*(cart.get(i).getProductQuality());
		}
		
		
	}
	
	//배송료 하드코딩했습니다~
	int finalAmount = totalAmount+3000;
	
	//db다녀옵니다~
	//디폴트 오더스 디비
	int result1 = new OrderService().OrderDefaultInsert(userNo, totalAmount, finalAmount); //그냥 orders테이블에 insert
	
	//orders 테이블에서 orderNo 뽑아오자
	int orderNo = new OrderService().OrderNumberSelect(userNo);
	
	
	 //orderDetail에 보낼 insert
	int result2 = new OrderService().OrderDetailInsert(orderNo, cart);
	
	
	
	String orderPerson = request.getParameter("orderPerson");
	String orderAddress = request.getParameter("orderAddress");
	String addressDetail = request.getParameter("addressDetail");
	String orderAddressTotal = orderAddress+addressDetail;
	String orderPhone1 = request.getParameter("orderPhone");
	String orderPhone2 = request.getParameter("orderLine");
	String orderEmail =request.getParameter("orderEmail");
	String orderRequirement = request.getParameter("orderRequirement");
	OrderShipping os = new OrderShipping(orderNo,orderPerson,orderAddressTotal, orderRequirement,orderPhone1, orderPhone2);
	
	 // orderShipping 테이블에 보낼 insert
	int result3 = new OrderService().OrderShippingInsert(orderNo, os);
	
	//테이블에 인저트 3번 하니까 세개 다 완료되면 토탈 리절트가 3이 되어야 해용
	int totalResult = result1+result2+result3;
	System.out.println(result1+" "+result2+" "+result3);
	
	if(totalResult==3) {
		request.setAttribute("orderNo", orderNo);
		request.getRequestDispatcher("views/order/orderResultView.jsp").forward(request, response);
		
		//성공적으로 오더 인절트
		//카트 올 딜리트꺼 가져왓음.
		new CartService().AllDeleteCart(userNo);
		
		
	}else {
		request.setAttribute("errorMsg", "주문오류입니다. 다시 시도해주세요.");
		request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
	}
	  
	
	}
}