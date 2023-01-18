<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		margin-top:100px; 
	}
	
		.content{
		margin-left:150px;
	}
	
	#enroll-form>table {border:1px solid white;}
	#enroll-form input,#enroll-form textarea{
		width:100%; 
		box-sizing:border-box; 
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
	
	
</style>
</head>
<body>
<%@include file="/views/common/realMenubar.jsp" %>
	<div class="outer">
	<div class="content">
		<h2 style="margin-left:280px;;">공지작성</h2>
		<br>
		<form action="<%=contextPath %>/insert.no" method="post" id="enroll-form">
		<input type="hidden" name="userNo" value="<%=loginUser.getUserNo() %>">
		
			<table align="center">
				<tr>
					<th width="50">제목</th>
					<td width="600"><input type="text" name="title" required></td>
				</tr>
				<tr>
					<th>내용</th>
					<td></td>
				</tr>
				<tr>
					<td colspan="2">
						<textarea name="content" rows="20" style="resize:none" required></textarea>
					</td>
				</tr>
			</table>
			</div>
			<br>
			<div align="center">
				<button type="submit" class="abutton">등록하기</button>
			</div>
			<br><br>
		
		
		</form>
		</div>
		
		
		
</body>
</html>