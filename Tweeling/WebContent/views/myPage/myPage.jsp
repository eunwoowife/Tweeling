<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.order.model.vo.*,
    		com.kh.product.model.vo.Product,
    		com.kh.product.model.vo.PAttachment,
    		java.text.DateFormat,
    		java.text.SimpleDateFormat,
    		java.util.Date,
    		java.util.Calendar,
    		java.util.ArrayList"%>
<%
	int orderCount = (int)request.getAttribute("orderCount");			// 총 주문 건 수
	int mileage = (int)request.getAttribute("mileage");					// 보유 적립금
	int couponNum = (int)request.getAttribute("couponNum");				// 보유 쿠폰 수
	
	Order lastOrder = (Order)request.getAttribute("lastOrder");			// 마지막 주문 정보

	int orderProductNum = 0;
	PAttachment pa = null;
	int len = 0;
	String pName = "";
	String orderDate = "";
	String orderDateStr = "";
	
	if(lastOrder != null){
		orderProductNum = (int)request.getAttribute("orderProductNum");	// 마지막 주문의 상품 종류 수
		pa = (PAttachment)request.getAttribute("pAttachment");	// 마지막 주문의 가장 비싼 상품의 썸네일
		
		if(pa != null){
			// 상품이름 가져오기 귀찮아서 그냥 pa의 originName 문자열 잘라서 구함
			len = pa.getOriginName().length();
			pName = pa.getOriginName().substring(0,len-4);
			//System.out.println(pName);
		}
		
		//System.out.println("myPage::view::orderCount : "+orderCount);
		//System.out.println("myPage::view::mileage : "+mileage);
		//System.out.println("myPage::view::couponNum : "+couponNum);
		//System.out.println("myPage::view::lastOrder : "+lastOrder);
		//System.out.println("myPage::view::orderProductNum : "+orderProductNum);
		//System.out.println("myPage::view::pa : "+pa);
		
		// Date -> String
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		orderDate = dateFormat.format(lastOrder.getOrderDate());  
		//System.out.println("orderDetail::view:: orderDateStr : "+orderDate);
		
		//주문날짜 '-' 제거
		//str = str.replace(String.valueOf(-), "");
		orderDateStr = orderDate.replace(String.valueOf('-'), "");
		
	}
	
	
	// 관심상품 리스트
	ArrayList<Product> wishList = (ArrayList<Product>)request.getAttribute("wishList");
	//System.out.println("myPage::view:"+wishList.get(0).getTitleImg());
	
%>

<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Tweeling</title>
    <style>
        .myPageOuter{
            width: 70%;
            /* border: 1px solid black; */
            /* background-color: antiquewhite; */
            /*margin-top: 100px;*/
            margin: 3% auto;
        }
        
        /* myPageTop 영역 스타일 시작 */
        .header{
        	margin-top: 100px;
        }
        .myPageTop{
            margin:0 auto;      /*myPageBody영역 내에 div들이 가운데 정렬*/
            width:100%;
            height: 150px;
        }
        .myPageCeleb {
        	float:left;
        	height: 100%;
        	width: 170px;
        	text-align:center;
        }
        .myCelebName{
            width:100%;
        }
        .celebImg{
        	width:100%;
        	height:100%;
        }
        .myPageInfo{
            /*border: 1px solid aqua;*/
            float:left;
            margin-left: 7%;
            width: 50%;
            height: 100%;
        }
        #myPageInfoTable{
            text-align: center;
            font-size: 1rem;
        }
        #userName{
            font-size: 2rem;
            font-weight: bold;
        }
        #userName-sub{
            font-size: 1.2rem;
            font-weight: bold;
            padding-right: 5%;
        }
        .userGrade{
            font-size: 1.2rem;
            font-weight: bold;
        }
        /* myPageTop 영역 스타일 끝 */

        /* myMenu 스타일 시작 */
        .myPageBottom{
            /* border: 1px solid red; */
            margin-top: 10%;
        }
        .myPageContent{
            /* border: 1px solid aqua; */
            float:left;
            margin: 0 3% 0 3%;
            width: 70%;
            height: 100%;
            clear:both;
        }
        .myPageNavigator{
            /* border: 1px solid black; */
            float: right;
            width: 20%;
            height: 100%;
        }
        .myPageMenuSpan{
            font-size: 1.1rem;
            font-weight: bold;
        }
        .myPage-main-li {
            margin-left: 0px;
            list-style: none;
            line-height: 200%;
            font-size: 0.8rem;
        }
        .myPage-sub-li{
            margin-left: 0px;
            list-style: none;
            line-height: 150%;
        }
        .myPage-a{
            font-size: 0.9rem;
            color: black;
            text-decoration: none;		/*링크 스타일 안먹음*/
        }
        .myPage-a:hover{
            color: black;
            font-weight: bold;
            text-decoration: none;
        }
        #myPage{
            font-size: 0.9rem;
        }
        /* myMenu 스타일 끝 */

        /* myPageContent 스타일 시작 */
		.myPageOrderList{
			width: 100%;
		}
		.myPageOrderTable{
			margin: auto;
			font-size: 0.9rem;
		}
		
		#myPageOrderThumnailArea{	/* 주문내역 썸네일 DIV */
			display: inline-block;
		}
        #myPage-orderThumbnail{		/* 주문내역 썸네일 */
        	width: 100px;
        	height: 100px;
        }
        #myPageOrderContentArea{	/* 주문내역 상품명 DIV */
        	display: inline-block;
        }
        .myPageWishProduct{
            display: inline-block;
            /*border: 1px solid black;*/
            width: 160px;
            height:240px;
            margin-right: 10px;
            margin-left: 5px;
        }
        .myPage-wisiImg{			/* 관심상품 이미지 */
            width: 160px;
            height: 160px;
        }
        .nothingResult{
			font-size: 2rem;
			color: #D7BFDC;
			font-weight: bold;        	
        }
    </style>
</head>
<body>
	<%@ include file="../common/realMenubar.jsp" %>
    <div class="container myPageOuter">
        <div class="header">
        </div>
        <div class="myPageBody">
            <!-- myPageTop 추가 시작 -->
            <div class="myPageTop">
                <div class="myPageCeleb">
                	<img class="celebImg" src="resources/member_upfiles/<%=loginUser.getUserBias() %>.png" alt="<%=loginUser.getUserBias()%>">
                </div>
                <div class="myPageInfo">
                    <br>
                    <span id="userName"><%=loginUser.getUserNinkname() %></span><span id="userName-sub">님</span>
                    <span class="userGrade">Lv</span><span class="userGrade">99</span>
                    <br><br>
                    <table id="myPageInfoTable">
                        <tr>
                            <td width="200px">주문 내역</td>
                            <td width="250px">취소/교환/반품</td>
                            <td width="150px">적립금</td>
                            <td width="150px">쿠폰</td>
                        </tr>
                        <tr>
                            <td><%=orderCount%>건</td>
                            <td>0 / 0 / 0</td>
                            <td><%=mileage %>원</td>
                            <td><%=couponNum %>개</td>
                        </tr>
                    </table>
                </div>
            </div>
            <!-- myPageTop 추가 끝 -->
            <div class="myPageBottom">
                <div class="myPageContent">
                    <!--우측 myPageNavigator에 따라 변경되는 부분 -->
                    <span class="myPageMenuSpan" style=margin-right:70%;">&nbsp&nbsp최근 주문</span>
                    <!-- 
                    <span class="myPageDetailBtn" style="font-size: 0.8rem;"><a class="myPage-a" href="">자세히 보기</a></span>
                     -->
                    <hr width="100%" align="left" color="black">
                    <br>
					<!--게시판 형식으로 주문내역 출력할 것 가장 마지막 건-->
					<%if(lastOrder ==null) { // 주문내역이 없으면%>
						<table class="myPageOrderTable">
							<thead>
								<tr align="center">
									<td style="border-bottom :1px solid black;" width="100px" class="myPageOrderTableHead">주문 번호</td>
									<td style="border-bottom :1px solid black;" width="550px" class="myPageOrderTableHead">주문 상품</td>
									<td style="border-bottom :1px solid black;" width="150px" class="myPageOrderTableHead">주문 일자</td>
								</tr>
							</thead>
							<tbody>
								<tr align="center">
									<td colspan="3" class="nothingResult">조회된 결과가 없습니다.</td>
								</tr>
							</tbody>
						</table>
					<%}else{ // 주문내역이 있으면%>
					<div class="myPageOrderList">
						<table class="myPageOrderTable">
							<thead>
								<tr align="center">
									<td style="border-bottom :1px solid black;" width="150px" class="myPageOrderTableHead">주문 번호</td>
									<td style="border-bottom :1px solid black;" width="550px" class="myPageOrderTableHead">주문 상품</td>
									<td style="border-bottom :1px solid black;" width="150px" class="myPageOrderTableHead">주문 일자</td>
								</tr>
							</thead>
							<tbody>
								<tr align="center">
									<td id="orderNoLink"><a href="<%=contextPath %>/orderDetailView.mp?orderNo=<%=lastOrder.getOrderNo()%>">Tweeling-tw<%=orderDateStr%><%=lastOrder.getOrderNo() %>번</a></td>
									<td>
										<div id="myPageOrderThumnailArea">
										<%if(pa != null) {%>
					 						<img id="myPage-orderThumbnail" src="<%=contextPath %><%=pa.getFilePath() %><%=pa.getOriginName()%>" alt="<%=pa.getOriginName()%>">
					 					<%} else { %>
					 						<img id="myPage-orderThumbnail" src="" alt="기본이미지.">
					 					<%} %>
										</div>
										<div id="myPageOrderContentArea">
					    					<span><%=pName%>외 <%=orderProductNum %>건</span>
										</div>
										<br clear="both">
									</td>
									<td><%=lastOrder.getOrderDate() %></td>
								</tr>
							</tbody>
						</table>
					</div>
					<%} %>
                    <br clear="both"><br><br>

                    <span class="myPageMenuSpan" style=margin-right:70%;">&nbsp&nbsp관심 상품&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
                    <!-- 
                    <span class="myPageDetailBtn" style="font-size: 0.8rem;"><a class="myPage-a" href="">자세히 보기</a></span>
                     -->
                    <hr width="100%" align="left" color="black">
                    <div class="myPageInterestProduct">	<!-- 관심 상품 -->
                   	<%if (!(wishList.isEmpty())){%>
                        <%for(int i=0; i<wishList.size(); i++) { %>
	                        <div class="myPageWishProduct">
	                        	<a class="myPage-a" href="<%=contextPath%>/detail.pro?pno=<%=wishList.get(i).getProductNo() %>">
		                            <img class="myPage-wisiImg" src="<%=contextPath %><%=wishList.get(i).getTitleImg() %>" alt="<%=wishList.get(i).getProductName()%>"><br>
		                            <span><%=wishList.get(i).getProductName()%></span><br>
		                            <span><%=wishList.get(i).getProductPrice()%>원</span>
	                            </a>
	                        </div>
                        <%} %>
                    <%} else {%>
                    <div align="center";>
                    	<span class="nothingResult">관심 상품이 없습니다.</span>
                    </div>
                    <%} %>
                    </div>
                </div>
                <div class="myPageNavigator">
                    <div>
                        <li class="myPageMenuSpan myPage-main-li" ><a class="myPage-a" href="">&nbsp&nbspMy Page</a></li>
                        <p clear:both;></p>
                        <hr width="150" align="left" color="black">
                        <div>
                            <li class="myPage-main-li">&nbsp나의 쇼핑 정보</li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/orderList.mp">&nbsp&nbsp&nbsp&nbsp&nbsp주문 내역</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/wishList.mp">&nbsp&nbsp&nbsp&nbsp&nbsp관심 상품</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/selectCoupon.mp">&nbsp&nbsp&nbsp&nbsp&nbsp쿠폰</a></li>
                        </div>
                        <br><br>
                        <div>
                            <li class="myPage-main-li">&nbsp회원 정보</li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/updatemyForm.me">&nbsp&nbsp&nbsp&nbsp&nbsp회원 정보 수정</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/deleteForm.me">&nbsp&nbsp&nbsp&nbsp&nbsp회원 탈퇴</a></li>
                        </div>
                        <br><br>
                        <div>
                            <li class="myPage-main-li">&nbsp고객 센터</li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/listView.question?currentPage=1">&nbsp&nbsp&nbsp&nbsp&nbsp1:1 문의</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/noticeList.no">&nbsp&nbsp&nbsp&nbsp&nbsp공지사항</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=request.getContextPath()%>/view.ma">&nbsp&nbsp&nbsp&nbsp&nbsp찾아오시는 길</a></li>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="footer">
            <!-- include footer-->
        </div>
    </div>
</body>
</html>