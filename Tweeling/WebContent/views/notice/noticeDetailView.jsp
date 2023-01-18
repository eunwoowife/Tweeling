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
	
	#detail-area{
		 border:2px solid white;
	}
	
	    .abutton {
	background: white;
	border: solid 1px gray;
	color: gray;
	padding: 3px 5px;
	margin: 1px;
	width: 150px;
	word-break: keep-all;
	border-radius: 100px;
	text-decoration: none;
	font-size: 12px;
	/*float: inherit;*/
}

.abutton:hover {
	color: white;
	background: rgb(215, 191, 220);
	border: solid 1px rgb(215, 191, 220);
	/*float: inherit;*/
}
	
	
</style>
</head>
<body>
<%@include file="/views/common/realMenubar.jsp" %>
	<div class="outer">
	<br><br><br>
		<h2 align="center"><b>Notice</b></h2>	
		<br>
		<hr>
		<table id="detail-area" align="center">
			<tr>
				<!--  <th width="70">제목</th>-->
				<th width="6%">제목</th>
				<td width="1000" colspan="5"><h5><b><%=n.getNoticeTitle() %></b><h5></td>
			 </tr>
			
			<tr>
				<th width="6%">작성일</th>
				<td width="14%"><%=n.getCreateDate() %></td>
			<!-- 	<th>작성자</th>
				<td><%=n.getNoticeWriter() %></td>-->
				<th width="6%">조회수</th>
				<td><%=n.getCount() %></td>
				<td width="60%"></td>
			</tr>
		<!--  <tr height="10"></tr>-->
		</table>
		<hr>
		<br>
		<table>
			<tr>
				<!-- <th>내용</th> -->
				<td colspan="5">
					<pre><%=n.getNoticeContent() %></pre>
				</td>
			</tr>
		</table>
		<br><br>
		
		<div align="center">
			<a href="<%=contextPath %>/list.no" class="abutton">목록으로</a>
			
			<%if(loginUser != null && loginUser.getUserId().equals("admin")) {%>
				<a href="<%=contextPath %>/updateForm.no?nno=<%=n.getNoticeNo() %>" class="abutton">수정하기</a>
				<a href="<%=contextPath %>/deleteForm.no?nno=<%=n.getNoticeNo() %>" onclick="return chk();" class="abutton">삭제하기</a>
		
			<%} %>
			
		</div>
		<script>
			function chk(){
				
				var result = confirm("정말로 삭제하시겠습니까? ");
				
				return result;
			}
		
		
		</script>
		
		
		<br><br>
	
	</div>

</body>
</html>