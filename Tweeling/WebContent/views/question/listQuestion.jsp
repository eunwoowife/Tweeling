<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.common.model.vo.PageInfo,
    		com.kh.question.model.vo.Question,
    		java.util.ArrayList"%>
<%
	int orderCount = (int)request.getAttribute("orderCount");			// 총 주문 건 수
	int mileage = (int)request.getAttribute("mileage");					// 보유 적립금
	int couponNum = (int)request.getAttribute("couponNum");				// 보유 쿠폰 수
	
	// 페이징 정보
	PageInfo pi = (PageInfo)request.getAttribute("pi");
	// 문의내역
	ArrayList<Question> qList = (ArrayList<Question>)request.getAttribute("qList");
	// 질문 타입이 int로 설정되어있어서 String으로 변환
	// 질의 타입 (상품관련1/결제관련2/배송관련3/이벤트관련4/회원관련5)
	String[] questionType = new String[qList.size()];
	for(int i=0; i<qList.size(); i++){
		switch(qList.get(i).getQuestionType()){
		case 1: questionType[i] = "상품";		break;
		case 2: questionType[i] = "결제";		break;
		case 3: questionType[i] = "배송";		break;
		case 4: questionType[i] = "이벤트";	break;
		case 5: questionType[i] = "회원";		break;
		default: questionType[i] = "기타";
		}
	}
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
        .myPageCeleb{
            float:left;
            height: 100%;
            background-color: lightpink; /*셀럽에 알맞는 색상 지정*/
            border-radius:100%;  /*셀럽명의 배경이 되는 원 그리려고*/
            width: 170px;
            position: relative; /*셀럽이름 넣는 곳 위아래 조절을 위해*/
        }
        .myPageInfo{
            /*border: 1px solid aqua;*/
            float:left;
            margin-left: 7%;
            width: 60%;
            height: 100%;
        }
        .myCelebName{
            position: absolute; /*셀럽이름 넣는 곳 위아래 조절을 위해*/
            top:30%;            /*셀럽이름 넣는 곳 위아래 조절을 위해*/
            width:100%;
            border: 1px solid black;
        }
        #myPageInfoTable{
            text-align: center;
            font-size: 1rem;
        }
        #celebName{
            position: absolute; /*셀럽이름 넣는 곳 위아래 조절을 위해*/
            top:45%;            /*셀럽이름 넣는 곳 위아래 조절을 위해*/
            text-align: center;
            color: white;
            font-size: 1.2rem;
            width:100%;
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
        #questionTable{
            width: 90%;
            
        }
		#addQuestion{
            margin-left: 90%;
            background-color: #D7BFDC;
            border-radius: 30px;
            font-size:1rem;
            width: 80px;
            height: 50px;
            border: none;  
        }
        #addQuestion:hover{
        	
        }
        .questionTable>tbody>tr{	/* 적용 안됨 */
            height: 40px;
            border-bottom :1px solid purple;
        }
        .questionTH{
            height: 40px;
            border-bottom :1px solid red;
        }
        .qListArea>tr{
        	align: center;
        }
        .pagingArea>button {
        	width: 30px;
        	height: 30px;
        }
    </style>
</head>
<body>
	<%@ include file="../common/realMenubar.jsp" %>
    <div class="myPageOuter">
        <div class="header">
        </div>
        <div class="myPageBody">
            <!-- myPageTop 추가 시작 -->
            <div class="myPageTop">
                <div class="myPageCeleb">
                    <span name="celebName" id="celebName"><%=loginUser.getUserBias() %></span>
                </div>
                <div class="myPageInfo">
                    <br>
                    <span id="userName"><%=loginUser.getUserName() %></span><span id="userName-sub">님</span>
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
                    <span class="myPageMenuSpan" style=margin-right:70%;">&nbsp&nbsp문의 내역</span>
                    <hr width="100%" align="left" color="black">
                    <br>
                    <table class="questionTable">
                        <thead>
                            <tr align="center">
                                <th width="150px" class="questionTH">글 번호</th>
                                <th width="150px" class="questionTH">질문 유형</th>
                                <th width="500px" class="questionTH">제목</th>
                                <th width="150px" class="questionTH">작성일</th>
                            </tr>
                        </thead>
                        <tbody class="qListArea">
                        <%if(qList.isEmpty()){ %>
                        	<tr align="center">
                        		<td colspan="6">조회된 게시글이 없습니다.</td>
                        	</tr>
                        <%} else { %>
                        	<%for(int i=0; i<qList.size();i++) {%>
                            <tr align="center">
                                <td><%=qList.get(i).getQuestionNo() %></td>
                                <td><%=questionType[i] %></td>
                                <td><%=qList.get(i).getQuestionTitle() %></td>
                                <td><%=qList.get(i).getCreateDate() %></td>
                            </tr>
                            <%} %>
                        <%}%>
                        </tbody>
                    </table>
                    <br clear="both"><br>
                    <hr width="100%" align="left" color="black">
                    <br>
                    <!-- 페이징 바 -->
	                <div align="center" class="pagingArea">
	                	<%if(pi.getCurrentPage() == 1){ %>
	                		<button disabled>&laquo;</button>
	                	<%} else { %>
	                		<button onclick="location.href='<%=contextPath %>/listView.question?currentPage=<%=pi.getCurrentPage()-1 %>'">&laquo;</button>
	                	<%} %>
	                	<%for(int i = pi.getStartPage(); i <= pi.getEndPage(); i++) {%>
	                		<% if(i==pi.getCurrentPage()) {%>
	                			<button disabled><%=i %></button>
	                		<%} else { %>
	                			<button onclick="location.href='<%=contextPath %>/listView.question?currentPage=<%=i %>'"><%=i %></button>
	                		<%} %>
	                	<%} %>
	                	<% if(pi.getCurrentPage() == pi.getMaxPage()) {%>
			        		<button disabled>&raquo;</button>
			        	<%} else {%>
			        		<button onclick="location.href='<%=contextPath%>/listView.question?currentPage=<%=pi.getCurrentPage()+1%>'">&raquo;</button>
			        	<%} %>
	                </div>
					<br>
                    <button id="addQuestion">글쓰기</button>
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
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/selectPoint.mp">&nbsp&nbsp&nbsp&nbsp&nbsp적립금</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/selectCoupon.mp">&nbsp&nbsp&nbsp&nbsp&nbsp쿠폰</a></li>
                        </div>
                        <br><br>
                        <div>
                            <li class="myPage-main-li">&nbsp회원 정보</li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/updateMember.me">&nbsp&nbsp&nbsp&nbsp&nbsp회원 정보 수정</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/shippingManage.mp">&nbsp&nbsp&nbsp&nbsp&nbsp배송지 관리</a></li>
                        </div>
                        <br><br>
                        <div>
                            <li class="myPage-main-li">&nbsp고객 센터</li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/listView.question?currentPage=1">&nbsp&nbsp&nbsp&nbsp&nbsp1:1 문의</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/noticeList.no">&nbsp&nbsp&nbsp&nbsp&nbsp공지사항</a></li>
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/announcement.no">&nbsp&nbsp&nbsp&nbsp&nbsp이용 안내</a></li>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>

        <div class="footer">
            <!-- include footer-->
        </div>
        <script>
        	$("#addQuestion").click(function(){		// 글쓰기 버튼 -> 글 쓰기 페이지 이동
        		location.href="<%=contextPath%>/insertForm.question";
        	});
        	
        	$(".qListArea>tr").click(function(){	// 게시글 클릭 -> 글 상세 페이지 이동
        		var qno = $(this).children().eq(0).text();
        		console.log("qno : "+qno);
        		location.href="<%=contextPath%>/detail.question?qno="+qno;
        	});
        </script>
    </div>
</body>
</html>