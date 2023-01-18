<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% int orderNo = (int)request.getAttribute("orderNo"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CompleteOrder</title>
</head>
<style>
        .outerpx{
            margin: auto;
            position: relative;
            text-align: center;
        }
        .outer{
            width: 70%;
            margin: auto
        }

        #orderCompleteForm{
            margin-top: 200px;
            color: #D7BFDC;
            margin-bottom: 50px;
        }

        .button{
            border: 1px solid gray;
            width: 130px;
            height: 40px;
            cursor:pointer;
            background-color: white;
            color: gray;
            padding: 5px;
            border-radius: 15em;
            
        }

        .button:hover{
            border: none;
            width: 130px;
            height: 40px;
            cursor:pointer;
            background-color: #D7BFDC;
            color: white;
            padding: 5px;
            border-radius: 15em;
           
        }


</style>
<body>
<%@include file="/views/common/realMenubar.jsp" %>

    <div class="outerpx">

        <div class="outer">

            <div id="orderCompleteForm">
                <h1> 주문 번호: Tweeling-tw221109<%=orderNo %></h1>
                <h2 style="color: rgb(172, 172, 172)"> 상품 주문이 완료되었습니다.</h2>
            </div>
            <button class="button" onclick="goHome();">HOME</button>
            <button class="button" onclick="goMypage();">MY PAGE</button> 


			<script>
				function goHome(){
					location.href="<%=contextPath%>/index.jsp";
				}
				
				function goMypage(){
					location.href="<%=contextPath %>/view.mp";
				}
			</script>
        </div>

    </div>

</body>
</html>