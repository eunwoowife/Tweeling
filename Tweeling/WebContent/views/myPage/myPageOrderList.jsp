<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.order.model.vo.*,
    		com.kh.product.model.vo.PAttachment,
    		com.kh.product.model.vo.Product,
    		java.util.*,
    		java.text.DateFormat,
    		java.text.SimpleDateFormat,
    		java.util.Calendar"%>
<%
	// 기본정보
	int orderCount = (int)request.getAttribute("orderCount");			// 총 주문 건 수
	int mileage = (int)request.getAttribute("mileage");					// 보유 적립금
	int couponNum = (int)request.getAttribute("couponNum");				// 보유 쿠폰 수
	//System.out.println("myPage::view::orderCount : "+orderCount);
	//System.out.println("myPage::view::mileage : "+mileage);
	//System.out.println("myPage::view::couponNum : "+couponNum);
	
	ArrayList<Order> oList = (ArrayList<Order>)request.getAttribute("oList");	// 주문 내역
	//System.out.println(oList);
	
	ArrayList<Integer> odCountList = null;
	ArrayList<String> pNameArr = null;
	ArrayList<PAttachment> paList = null;
	ArrayList<Product> pLastList = null;
	ArrayList<PAttachment> paLastList = null;
	String[] orderDateStr = null;
	
	if(!(oList.isEmpty())){
		// 주문 내역 게시글 정보
		odCountList = (ArrayList<Integer>)request.getAttribute("odCountList");		// 매 주문 마다의 상품 종류 수
		
		pNameArr = (ArrayList<String>)request.getAttribute("pNameArr");	// 매 주문의 가장 비싼 상품명 목록
		paList = (ArrayList<PAttachment>)request.getAttribute("paList");	// 가장 마지막 주문의 상품 첨부파일 목록
		//System.out.println("VIEW::paList"+paList);
		
		// 가장 마지막 주문 상품 정보
		pLastList = (ArrayList<Product>)request.getAttribute("pLastList");	// 가장 마지막 주문의 상품 목록
		paLastList = (ArrayList<PAttachment>)request.getAttribute("paLastList");	// 가장 마지막 주문의 상품들의 첨부파일 목록
		// Date -> String
		Date date = Calendar.getInstance().getTime();  
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		orderDateStr = new String[20];
		String tempDate = "";
		for(int i=0; i<oList.size(); i++){
			tempDate = dateFormat.format(oList.get(i).getOrderDate());  
			orderDateStr[i] = tempDate.replace(String.valueOf('-'), "");
			//System.out.println("myPageorderList::view:: orderDateStr["+i+"] : "+orderDateStr[i]);
	}
	//System.out.println("orderDetail::view:: orderDateStr : "+orderDate);
	
	//주문날짜 '-' 제거
	//str = str.replace(String.valueOf(-), "");
		
	}
	
%>
<!DOCTYPE html>
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
        .celebImg{
        	width:100%;
        	height:100%;
        }
        .myCelebName{
            width:100%;
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
        .order-search{
            border: 1px dashed black;
        }
        .date-choice{
            text-align: right;
            padding-right: 5%;
        }
        .order-date{
            text-align: right;
            font-size:0.8rem;
            border: none;
        }
        .myPageOrderBtn{
            border: none;
            font-size:0.8rem;
        }
        .duration-btn .myPageOrderBtn:hover{
            background-color:#D7BFDC;
        }
        #order-date-btn{
            background-color: #D7BFDC;
            border-radius: 60px;
        }
        #month6-order{
            border-top-right-radius: 30%;
            border-bottom-right-radius: 30%;
        }
        #today-order{
            border-top-left-radius: 30%;
            border-bottom-left-radius: 30%;
        }
        .order-search{
            border: 1px dashed black;
        }
        
		.myPageOrderList{
			width: 100%;
		}
		.myPageOrderTable{
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
        .orderListArea>tr>td>a{		/* 효과 안 들어간 듯? */
        	font-weight: bold;
            text-decoration: none;
            border: 1px solid black;
        }
        .myPageOrderProduct{
            display: inline-block;
            /*border: 1px solid black;*/
            width: 200px;
            height:300px;
            margin-right: 10px;
            margin-left: 5px;
        }
        .myPage-orderImg{			/* 주문상품 이미지 */
            width: 200px;
            height: 200px;
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
                    <span class="myPageMenuSpan" style="margin-right:70%;">&nbsp&nbsp주문 내역 조회</span>
                    <!-- 
                    <span class="myPageDetailBtn" style="font-size: 0.8rem;"><a class="myPage-a" href="">자세히 보기</a></span>
                     -->
                    <hr width="100%" align="left" color="black" style="margin-bottom:3%;">
                    <div class="order-search">
                        <div class="duration-btn">
                            <button class="myPageOrderBtn" id="today-order" style="margin-left:20%;">오늘</button><button class="myPageOrderBtn" id="week-order">1주일</button><button class="myPageOrderBtn" id="month-order">1개월</button><button class="myPageOrderBtn" id="month3-order">3개월</button><button class="myPageOrderBtn" id="month6-order">6개월</button>
                        </div>
                        <div class="date-choice">
                        	<label for="startDay" style="font-size:0.8rem;">시작일</label>
                            <input type="date" name="startDay" id="startDay" class="order-date" style="margin-right:30px;">
                            <label for="endDay" style="font-size:0.8rem;">종료일</label>
                            <input type="date" name="endDay" id="endDay" class="order-date" style="margin-right:30px;">
                            <button class="myPageOrderBtn" id="order-date-btn">조회</button>
                        </div>
                        <div><!-- 안내 -->
                            <span style="color:gray; font-size: 0.6rem; padding:3%;">- 기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 지난 주문내역을 조회하실 수 있습니다.</span><br>
                            <span style="color:gray; font-size: 0.6rem; padding:3%;">- 주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.</span><br><br>
                        </div>
                    </div>
                    <br>
					<div class="myPageOrderList">
						<table class="myPageOrderTable">
							<thead>
								<tr align="center">
									<td style="border-bottom :1px solid black;" width="150px" class="myPageOrderTableHead">주문 번호</td>
									<td style="border-bottom :1px solid black;" width="550px" class="myPageOrderTableHead">주문 상품</td>
									<td style="border-bottom :1px solid black;" width="150px" class="myPageOrderTableHead">주문 일자</td>
								</tr>
							</thead>
							<tbody id="orderListArea">
	                        <%if(oList.isEmpty()) { // 주문내역이 없으면%>
								<tr align="center">
									<td colspan="3">조회된 결과가 없습니다.</td>
								</tr>
							<%}else{ // 주문내역이 있으면%>
							
                  				<%for(int i=0; i<oList.size(); i++) { %>
								<tr align="center">
									<!-- <td class="goToDetail" id="goToDetailId<%=oList.get(i).getOrderNo()%>">Tweeling-tw<%=orderDateStr[i]%><%=oList.get(i).getOrderNo() %>번</td> -->
									<td><a href="<%=contextPath%>/orderDetailView.mp?orderNo=<%=oList.get(i).getOrderNo()%>">Tweeling-tw<%=orderDateStr[i]%><%=oList.get(i).getOrderNo() %>번</a></td>
									<td>
										<div id="myPageOrderThumnailArea">
										<%if(paList != null) {%>
					 						<img id="myPage-orderThumbnail" src="<%=contextPath %><%=paList.get(i).getFilePath() %><%=paList.get(i).getOriginName()%>" >
					 					<%}else { %>
					 						<img id="myPage-orderThumbnail" src="" alt="기본이미지.파일없음">
					 					<%} %>
										</div>
										<div id="myPageOrderContentArea">
											<%if(pNameArr != null) {%>
					    					<span><%=pNameArr.get(i) %>외 <%=odCountList.get(i).intValue()-1 %>건</span>
					    					<%} else { %>
					    					<span>총 <%=odCountList.get(i).intValue() %>건</span>
					    					<%} %>
										</div>
										<br clear="both">
									</td>
									<td><%=oList.get(i).getOrderDate() %></td>
								</tr>
								<%} %>
							<%} %>
							</tbody>
						</table>
						<br>
					</div>
            		<br clear="both">
                    <% if(oList.isEmpty()) {%>
                    	<span class="myPageMenuSpan" style=margin-right:70%;">&nbsp&nbsp마지막 주문 상품 정보&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 0건</span>
                    <%} else { %>
                    	<span class="myPageMenuSpan" style=margin-right:70%;">&nbsp&nbsp마지막 주문 상품 정보&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <%=odCountList.get(0) %>건</span>
                    <%} %>
                    <!-- 
                    <span class="myPageDetailBtn" style="font-size: 0.8rem;"><a class="myPage-a" href="">자세히 보기</a></span>
                     -->
                    <hr width="100%" align="left" color="black">
                    <div class="myPageOrderProductArea">
                    <%if(oList != null && pLastList != null) { %>
                        <%for(int i=0; i<pLastList.size(); i++){%>
	                        <div class="myPageOrderProduct">
	                        	<a class="myPage-a" href="<%=contextPath%>/detail.pro?pno=<%=paLastList.get(i).getRefPno() %>">
	                            	<img class="myPage-orderImg" src="<%=contextPath %><%=paLastList.get(i).getFilePath() %><%=paLastList.get(i).getOriginName() %>" alt="해바라기"><br>
	                            	<br>
	                            	<span><%=pLastList.get(i).getProductName() %></span><br>
	                            	<span><%=pLastList.get(i).getProductPrice() %>원</span>
	                            </a>
	                        </div>
                        <%} %>
                    <%} %>
                    </div>
                    <br><br>
                </div>
                <div class="myPageNavigator">
                    <div>
                        <li class="myPageMenuSpan myPage-main-li" ><a class="myPage-a" href="<%=contextPath%>/view.mp">&nbsp&nbspMy Page</a></li>
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
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/listView.question?currentPage=1">&nbsp&nbsp&nbsp&nbsp&nbsp1:1 문의</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/noticeList.no">&nbsp&nbsp&nbsp&nbsp&nbsp공지사항</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=request.getContextPath()%>/view.ma">&nbsp&nbsp&nbsp&nbsp&nbsp찾아오시는 길</a></li>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		<script>
			$(function(){
				// startDate는 시작일자를 언제로 설정할지를 결정하는 변수로
				// startDate값에 따라 컨트롤러에서 시작일을 변경하도록 되어 있음
				var startDate = 0;
				$("#today-order").click(function(){
					startDate = 1; // 오늘 날짜
					selectOrderList(startDate);
				});
				$("#week-order").click(function(){
					startDate = 2;	// 일주일 전
					selectOrderList(startDate);
				});
				$("#month-order").click(function(){
					startDate = 3;	// 한 달 전
					selectOrderList(startDate);
				});
				$("#month3-order").click(function(){
					startDate = 4;	// 세 달 전
					selectOrderList(startDate);
				});
				$("#month6-order").click(function(){
					startDate = 5;	// 여섯 달 전
					selectOrderList(startDate);
				});
				
			})
			// 시작일~오늘까지 주문 내역 출력하도록 되어 있음
			var selectOrderList = function(startDay){
				console.log(startDay);
				$.ajax({
					url : "ajaxOrderList.mp",
					data :{
						startDay : startDay
					},
					type : "post",
					success : function(oList){
						console.log(oList);
						var str = "";
						if(oList.length != 0){
							for(var i in oList){
								//------------------------------------------ orderDate 형식 변환 Start -- 
								//11월 5, 2022 -> 20221105   : 바꾸는 코드
								var beforeDate = oList[i].orderDate;
								var arr = beforeDate.split(/[" ",'월', ',']/); // 공백, 쉼표, 월 로 구분해서 문자열 자르면
								//console.log(arr);
								// "11", "", "5", "", "2022"   로 잘린다.
								var year = arr[4];
								// 월이 한 자리수이면 앞에 '0'을 붙이도록
								var month = arr[0];
								if(month<10){
									month = "0"+month;
								}
								var day = arr[2];
								// 날이 한 자리수이면 앞에 '0'붙이도록
								if(arr[2] <10){
									day = "0"+day;
								}
								
								//console.log("year : "+year);
								//console.log("month : "+month);
								//console.log("day : "+day);
								
								// 20221105처럼 바꾼 문자열은 주문번호 조합에 쓰인다.
								var resultDate = year+month+day;
								//console.log(resultDate);
								
								// 이번에는 주문날짜 출력을 위한 문자열을 만든다.
								var resultDate2 = year+"-"+month+"-"+day;
								//console.log(resultDate2);
								//------------------------------------------ orderDate 형식 변환 End -- 
								
								str += "<tr align='center'>"
									 + "<td><a href='<%=contextPath%>/orderDetailView.mp?orderNo="+oList[i].orderNo+"'>"
									 + "Tweeling-tw" + resultDate + oList[i].orderNo+"번"
									 + "</td>"
								     + "<td><div id='myPageOrderThumnailArea'>"
								     + "<img id='myPage-orderThumbnail' src='<%=contextPath%>"+oList[i].thumbnailPath+oList[i].thumbnailName+"' alt='"+oList[i].thumbnailName+"'>"
									 + "</div>"
									 + "<div id='myPageOrderContentArea'>"
									 + "<span>"+oList[i].productName+"외 "+oList[i].productNum+"건</span>"
				    				 + "</div>"
									 + "</td>"
									 + "<td>"+resultDate2+"</td>"
									 + "</tr>";
								console.log(str);
								$("#orderListArea").html(str);
							}
						}
						else{
							str += "<tr><td colspan='3' align='center'><h3>조회된 결과가 없습니다.</h3></td></tr>";
							$("#orderListArea").html(str);
						}
					},
					error : function(){
						console.log("ajaxOrderList.mp is failed")
					}
				});
			};
			
			//주문내역 조회용 시작, 종료일자 input 태그를 오늘 날짜로 설정하도록
			$(function(){
				document.getElementById("startDay").valueAsDate = new Date();
				document.getElementById("endDay").valueAsDate = new Date();
			});
			
			$("#order-date-btn").click(function(){
				console.log($("#startDay").val());
				console.log($("#endDay").val());
				
				$.ajax({
					url : "ajaxSelectOrderList.mp",
					data : {
						startDay : $("#startDay").val(),
						endDay : $("#endDay").val()
					},
					type : "post",
					success : function(oList){
						//console.log(oList);
						var str = "";
						if(oList.length != 0){
							for(var i in oList){
								//------------------------------------------ orderDate 형식 변환 Start -- 
								//11월 5, 2022 -> 20221105   : 바꾸는 코드
								var beforeDate = oList[i].orderDate;
								var arr = beforeDate.split(/[" ",'월', ',']/); // 공백, 쉼표, 월 로 구분해서 문자열 자르면
								//console.log(arr);
								// "11", "", "5", "", "2022"   로 잘린다.
								var year = arr[4];
								// 월이 한 자리수이면 앞에 '0'을 붙이도록
								var month = arr[0];
								if(month<10){
									month = "0"+month;
								}
								var day = arr[2];
								// 날이 한 자리수이면 앞에 '0'붙이도록
								if(arr[2] <10){
									day = "0"+day;
								}
								
								//console.log("year : "+year);
								//console.log("month : "+month);
								//console.log("day : "+day);
								
								// 20221105처럼 바꾼 문자열은 주문번호 조합에 쓰인다.
								var resultDate = year+month+day;
								//console.log(resultDate);
								
								// 이번에는 주문날짜 출력을 위한 문자열을 만든다.
								var resultDate2 = year+"-"+month+"-"+day;
								//console.log(resultDate2);
								//------------------------------------------ orderDate 형식 변환 End -- 
								
								str += "<tr align='center'>"
									 + "<td><a href='<%=contextPath%>/orderDetailView.mp?orderNo="+oList[i].orderNo+"'>"
									 + "Tweeling-tw" + resultDate + oList[i].orderNo+"번"
									 + "</td>"
								     + "<td><div id='myPageOrderThumnailArea'>"
								     + "<img id='myPage-orderThumbnail' src='<%=contextPath%>"+oList[i].thumbnailPath+oList[i].thumbnailName+"' alt='"+oList[i].thumbnailName+"'>"
									 + "</div>"
									 + "<div id='myPageOrderContentArea'>"
									 + "<span>"+oList[i].productName+"외 "+oList[i].productNum+"건</span>"
				    				 + "</div>"
									 + "</td>"
									 + "<td>"+resultDate2+"</td>"
									 + "</tr>";
								$("#orderListArea").html(str);
								
							}
						}
						else{
							str += "<tr><td colspan='3' align='center'><h3>조회된 결과가 없습니다.</h3></td></tr>";
							$("#orderListArea").html(str);
						}
					},
					error : function(){
						console.log("ajaxSelectOrderList.mp is failed")
					}
				});
			});
			
			$(".goToDetail").click(function(){
				var orderNo = $(this).attr('id');
				console.log(orderNo);
				
			})
			
			
		</script>
        <div class="footer">
            <!-- include footer-->
        </div>
    </div>
</body>
</html>