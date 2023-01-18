<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="preconnect" href="https://fonts.googleapis.com"> 
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
<link href="https://fonts.googleapis.com/css2?family=Noto+Serif+KR:wght@300&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<title>아이디 결과값</title>

<style>
    #msg{
        padding: 200px;
    }

</style>
</head>
<body>
<%@ include file="../common/realMenubar.jsp" %>

	<%
		String Msg = (String)request.getAttribute("Msg");
	%>
	
	
	<div style="text-align: center;" id="msg">

        <h1 style="font-family: 'Noto Serif KR', serif;"><%=Msg%></h1>
        <br>
	<a href="<%=contextPath%>/loginForm.me">로그인하러가기</a>
    </div>
	

</body>


<%@include file="/views/common/footer.jsp" %>
</html>