<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
	<%
		String errorMsg = (String)request.getAttribute("errorMsg");
	%>
	<h1><%=errorMsg %></h1>
	<br><br><br><br><br><br><br><br><br><br>
</body>
<%@include file="/views/common/footer.jsp" %>
</html>