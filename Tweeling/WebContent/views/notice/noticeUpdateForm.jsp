<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.notice.model.vo.Notice"%>
<% 
	Notice n = (Notice)request.getAttribute("notice");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	 .outer{
		background:white;
		color:black;
		width:1000px;
		margin:auto;  
		margin-top:50px; 
	}
	
	.content{
		margin-left:150px;
	}
	
	#update-form input,#update-form textarea{
		 width:100%;
	}
	
	    .abutton {
	background: white;
	border: solid 1px gray;
	color: gray;
	padding: 3px 5px;
	margin: 1px;
	width: 100px;
	word-break: keep-all;
	border-radius: 100px;
	text-decoration: none;
	font-size: 12px;
	float: inherit;
}

.abutton:hover {
	color: white;
	background: rgb(215, 191, 220);
	border: solid 1px rgb(215, 191, 220);
	float: inherit;
}

input{
	margin-top:12px;
	border:none;
	margin-bottom:15px;
}
textarea{
	border:solid 1px gray;
}

	
</style>
</head>
<body>
<%@include file="/views/common/realMenubar.jsp" %>
	<div class="outer">
	<div class="content">
	<br><br>
		<h2 style="margin-left:230px;">공지사항 수정</h2>
		<br>
		<form action="<%=contextPath %>/update.no" method="post" id="update-form">
		
		<input type="hidden" name="nno" value="<%=n.getNoticeNo()%>">
			<table align="center">
				<tr>
					<th width="50">제목</th>
					<td width="550"><input type="text" name="title" required value="<%=n.getNoticeTitle()%>"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea name="content" rows="20" style="resize:none" required><%=n.getNoticeContent() %></textarea>
					</td>
				</tr>
			</table>
			<br><br>
			</div>
			<div align="center">
				<button type="submit" class="abutton">수정하기</button>
				<button type="button" onclick="history.back();" class="abutton">뒤로가기</button>
			
			</div>
			<br><br>
		
		
		</form>
		</div>
		
</body>
</html>
