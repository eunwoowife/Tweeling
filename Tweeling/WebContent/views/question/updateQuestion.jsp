<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import="com.kh.question.model.vo.Question,
    		com.kh.question.model.vo.QAttachment"%>
<%
	int orderCount = (int)request.getAttribute("orderCount");			// 총 주문 건 수
	int mileage = (int)request.getAttribute("mileage");					// 보유 적립금
	int couponNum = (int)request.getAttribute("couponNum");				// 보유 쿠폰 수
	
	Question q = (Question)request.getAttribute("question");
	QAttachment qat = (QAttachment)request.getAttribute("attachment");
	
	System.out.println("updateQuestion.jap::q :"+q);
	System.out.println("updateQuestion.jap::qat :"+qat);
	
	String qType = "";
	int temp = q.getQuestionType();
	switch(temp){
	case 1: 
		qType = "상품문의"; break;
	case 2:
		qType = "결제문의"; break;
	case 3:
		qType = "배송문의"; break;
	case 4:
		qType = "이벤트문의"; break;	
	case 5:
		qType = "회원문의"; break;	
		default:
		qType = "기타문의";
	}
%>
<!DOCTYPE html>
<html>
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
        .updateArea{
        	margin: auto;
        	width: 80%;
        }
        .qTypeArea{
        	margin: auto;
        	width: 100%;
        }
        .qBtnArea {
        	text-align: center;
        }
        .submitBtn{
        	width: 50px;
        	height: 30px;
        	background-color: #D7BFDC;
            border-radius: 30px;
            border: 0;
        }
	</style>
</head>
<body>
	<%@ include file="../common/realMenubar.jsp" %>
	<div class="myPageOuter">
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
                    <span class="myPageMenuSpan" style=margin-right:70%;">&nbsp&nbsp1:1 문의</span>
                    <hr width="100%" align="left" color="black">
                    <br>
                    <form action="<%=contextPath %>/update.question" id="update-form" method="post" enctype="multipart/form-data">
                    	<div class="updateArea">
		                    <input type="hidden" name="userNo" value="<%=loginUser.getUserNo() %>">
		                    <input type="hidden" name="questionNo" value="<%=q.getQuestionNo()%>">
		                    <div class="qTypeArea"><!-- 질문 유형 -->
		                    	<span style="margin-right:20px;">- 질문 유형 </span>
		                    	<select id="qType" name="qType" style="margin-bottom:10px; width: 150px; height: 25px;">
		                    		<option value="1">상품문의</option>
		                    		<option value="2">결제문의</option>
		                    		<option value="3">배송문의</option>
		                    		<option value="4">이벤트문의</option>
		                    		<option value="5">회원문의</option>
		                    	</select>
		                    </div>
		                    <script>
		                    	$(function(){
		                    		$("#update-form option").each(function(){
		                    			if($(this).text()=="<%=qType%>"){
		                    				$(this).attr("selected", true);
		                    			}
		                    		})
		                    	})
		                    </script>
		                    <br>
		                    <div class="qTitleArea">
		                    	<label for="qTitleInput" style="margin-right:20px;" id="qTitleSpan">- 문의 제목</label>
		                    	<input id="qTitleInput" name="qTitle" style="margin-bottom:20px; width:85%; height: 25px;" value="<%=q.getQuestionTitle()%>" required>
		                    </div>
		                    <div class="qContentArea">
		                    	<textarea id="qContent" name="qContent" rows="40" cols="100" maxlength="1000" style="resize:none" required><%=q.getQuestionContent()%></textarea>
		                    </div>
		                    <br>
		                    <div class="qAttachArea">
		                    	<%if(qat != null) {%>
		                    	<%=qat.getOriginName() %>
		                    	<input type="hidden" name="originFileNo" value="<%=qat.getFileNo()%>">
								<input type="hidden" name="originFileName" value="<%=qat.getOriginName() %>">
		                    	<%} %>
		                    	<input type="file" name="reUpfile" id="fileInput">
		                    </div>
		                    <br>
                    		<hr width="100%" align="left" color="black">
                    		<br>
		                    <div class="qBtnArea">
								<span style="margin-right:20px;">글 수정</span><input type="submit" style="margin-right:50px;" class="submitBtn">
								<span style="margin-right:20px;">수정 취소</span><input type="reset" class="submitBtn">
								<br><br>
		                    </div>
						</div>
					</form>
                    <br>
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
</body>
</html>