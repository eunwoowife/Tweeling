<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.order.model.vo.OrderList,
    		java.util.ArrayList,
    		java.text.DateFormat,
    		java.text.SimpleDateFormat,
    		java.util.Date,
    		java.util.Calendar"%>
<%
	// 기본정보
	int orderCount = (int)request.getAttribute("orderCount");			// 총 주문 건 수
	int mileage = (int)request.getAttribute("mileage");					// 보유 적립금
	int couponNum = (int)request.getAttribute("couponNum");				// 보유 쿠폰 수
	//System.out.println("orderDetail::view::orderCount : "+orderCount);
	//System.out.println("orderDetail::view::mileage : "+mileage);
	//System.out.println("orderDetail::view::couponNum : "+couponNum);
	
	ArrayList<OrderList> oList = (ArrayList<OrderList>)request.getAttribute("oList");
	//for(int i=0; i<oList.size(); i++){
	//	System.out.println("orderDetail::view:: oList : "+ oList.get(i));
	//}
	
	// Date -> String
	Date date = Calendar.getInstance().getTime();  
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
	String orderDate = dateFormat.format(oList.get(0).getOrderDate());  
	//System.out.println("orderDetail::view:: orderDateStr : "+orderDate);
	
	//주문날짜 '-' 제거
	//str = str.replace(String.valueOf(-), "");
	String orderDateStr = orderDate.replace(String.valueOf('-'), "");
%>
<!DOCTYPE html>
<html>
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
        .myPageCeleb{
            float:left;
        	height: 100%;
        	width: 170px;
        	text-align:center;
        }
        .myPageInfo{
            /* border: 1px solid aqua; */
            float:left;
            margin-left: 7%;
            width: 50%;
            height: 100%;
        }
        .myCelebName{
            width:100%;
        }
        .celebImg{
        	width:100%;
        	height:100%;
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
        .orderDetailArea{
        	width: 100%;
        }
        .orderDetailTable{
        	margin: auto;
        	width: 90%;
			font-size: 0.9rem;
		}
		#orderDetailArea>tr {
			/*background-color: lightpink;*/
			height: 250px;
		}
		#orderDetailArea>tr>td {
			border-bottom: 1px solid lightpink;
		}
		
		.ordeerDetailThumbnailImg{
			width: 150px;
			height: 150px;
		}
        .reviewBtn{
            border: none;
            width: 70px;
            height: 40px;
            font-size:0.8rem;
            border-radius: 60px;
        }
       .reviewBtn:hover{
            background-color:#D7BFDC;
        }
        
        .reviewBtn:hover{
       	 	cursor:pointer;]
        }
    </style>
</head>
<body>
	<%@ include file="../common/realMenubar.jsp" %>
    <div class="container myPageOuter"><!--부트스트랩에 맞게 class명 변경할 것-->
        <div class="header">
        </div>
        <div class="myPageBody">
            <!--myPageTop 추가 시작-->
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
                    <!--우측 navigator에 따라 변경되는 부분 -->
                    <span class="myPageMenuSpan" style="margin-right:10%; margin-right:40%;">&nbsp&nbsp주문 번호 : Tweeling-tw<%=orderDateStr %><%=oList.get(0).getOrderNo() %>번</span>
                    <span class="myPageMenuSpan">주문 날짜 : <%=oList.get(0).getOrderDate() %></span>
                    <hr width="100%" align="left" color="black" style="margin-bottom:3%;">
                    <br>
                    
					<div class="orderDetailArea">
						<table class="orderDetailTable">
							<thead align="center">
								<tr>
									<td style="border-bottom :1px solid black;" width="300px" class="myPageOrderTableHead">주문 상품</td>
									<td style="border-bottom :1px solid black;" width="100px" class="myPageOrderTableHead">가격</td>
									<td style="border-bottom :1px solid black;" width="80px" class="myPageOrderTableHead">리뷰</td>
								</tr>
							</thead>
							<tbody id="orderDetailArea" align="center">
							<%if(oList.isEmpty()) {%>
								<tr>
									<td>조회된 결과가 없을리가 없을텐데..?</td>
								</tr>
							<%}else{ %>
								<%for(int i=0; i<oList.size(); i++) {%>
								<tr>
									<td><br>
										<a class="myPage-a" href="<%=contextPath%>/detail.pro?pno=<%=oList.get(i).getProductNum() %>">
											<div class="orderDetailThumnailArea">
						 						<img class="ordeerDetailThumbnailImg" src="<%=contextPath %><%=oList.get(i).getThumbnailPath() %><%=oList.get(i).getThumbnailName() %>" alt="<%=oList.get(i).getProductName() %>">
											</div>
											<div class="orderDetailProductArea">
					    						<span><%=oList.get(i).getProductName() %></span>
											</div>
										</a>
										<br clear="both">
									</td>
									<td><%=oList.get(i).getProductPrice() %>원</td>
									<td>
										<button class="reviewBtn"  id="goReview<%=i%>">리뷰 쓰기</button>
										<script>
										$(function(){
											$("#goReview<%=i%>").click(function(){
												$.ajax({
													url : "check.rev",
													data : {productNo : <%=oList.get(i).getProductNum()%>,
																orderNo : <%=oList.get(i).getOrderNo()%>,
																userNo : <%=loginUser.getUserNo()%>},
													type : "post",
													success : function(result){
														console.log("통신성공");
														if(result>0){
															alert("이미 해당 상품의 리뷰를 작성하셨습니다.");
															return false;
														}else{
															location.href="<%=contextPath%>/write.rev?pno="+<%=oList.get(i).getProductNum()%>+"&ono="+<%=oList.get(i).getOrderNo()%>
														}
													},
													error : function(){
														console.log("통신실패");
													}
												})
											})
										})
									</script>
									</td>
									
									
									
										
								</tr>
								
								
								<%} %>
							<%} %>
							</tbody>
						</table>
						<br>
					</div>
                    <br><br>
                </div>
                <div class="myPageNavigator">
                    <div>
                        <li class="myPageMenuSpan myPage-main-li"><a class="myPage-a" href="<%=contextPath%>/view.mp">&nbsp&nbspMy Page</a></li>
                        <p clear:both;></p>
                        <hr width="150" align="left" color="black">
                        <div>
                            <li class="myPage-main-li">&nbsp나의 쇼핑 정보</li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/orderList.mp"><b>&nbsp&nbsp&nbsp&nbsp&nbsp주문 내역</b></a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/wishList.mp">&nbsp&nbsp&nbsp&nbsp&nbsp관심 상품</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/selectCoupon.mp">&nbsp&nbsp&nbsp&nbsp&nbsp쿠폰</a></li>
                        </div>
                        <br><br>
                        <div>
                            <li class="myPage-main-li">&nbsp회원 정보</li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/updateMember.me">&nbsp&nbsp&nbsp&nbsp&nbsp회원 정보 수정</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/deleteForm.me">&nbsp&nbsp&nbsp&nbsp&nbsp회원 탈퇴</a></li>
                        </div>
                        <br><br>
                        <div>
                            <li class="myPage-main-li">&nbsp고객 센터</li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/listView.question">&nbsp&nbsp&nbsp&nbsp&nbsp1:1 문의</a></li>
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