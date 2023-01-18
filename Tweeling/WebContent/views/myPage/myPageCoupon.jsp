<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.kh.member.model.vo.*
    		, java.util.ArrayList" %>
<%
	int orderCount = (int)request.getAttribute("orderCount");			// 총 주문 건 수
	int mileage = (int)request.getAttribute("mileage");					// 보유 적립금
	int couponNum = (int)request.getAttribute("couponNum");				// 보유 쿠폰 수
	
	// 보유 쿠폰 리스트
	ArrayList<Coupon> cList = (ArrayList<Coupon>)request.getAttribute("cList");
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

        /* MyPagecontent 스타일 시작 */
        
        #couponTable{
        	margin: auto;
        }
        #couponTable>thead>tr{
        	height: 30px;	
        }
        #couponTable>tbody>tr {
        	height: 30px;
        }
    </style>
</head>
<body>
	<%@ include file="../common/realMenubar.jsp" %>
    <div class="container myPageOuter">
        <div class="header">
        </div>
        <!-- myPageTop 추가 시작 -->
        <div class="myPageBody">
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
                    <span class="myPageMenuSpan" style=margin-right:70%;">&nbsp&nbsp쿠폰</span>
                    <!-- 
                    <span class="myPageDetailBtn" style="font-size: 0.8rem;"><a class="myPage-a" href="">자세히 보기</a></span>
                     -->
                    <hr width="100%" align="left" color="black">
                    <br>
                    <!--게시판 형식으로 사용 가능한 쿠폰 보유내역 출력할 것-->
                    <table id="couponTable" align="center" width="80%;">
                        <thead align="center">
                        	<tr>
	                            <th>쿠폰 번호</th>
	                            <th>쿠폰명</th>
	                            <th>할인율(%)</th>
                            </tr>
                        </thead>
                        <tbody align="center">
                       	<%if(cList.isEmpty()) { %>
                            <tr><td colspan="3" align="center">보유 쿠폰이 없습니다.</td></tr>
                        <%}else{ %>
                        	<%for(int i=0; i<cList.size(); i++){ %>
                            <tr>
                            	<td><%=cList.get(i).getCouponNo() %></td>
                            	<td><%=cList.get(i).getCouponName() %></td>
                            	<td><%=cList.get(i).getCouponPercent() %></td>
                            </tr>
                            <%} %>
                        <%} %>
                        </tbody>
                    </table>
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
                            <li class="myPage-sub-li"><a class="myPage-a" href="<%=contextPath%>/selectCoupon.mp"><b>&nbsp&nbsp&nbsp&nbsp&nbsp쿠폰</b></a></li>
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

        <div class="footer">
            <!-- include footer-->
        </div>
    </div>
</body>
</html>