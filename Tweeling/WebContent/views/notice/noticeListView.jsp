<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.kh.notice.model.vo.Notice"%>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com"> 
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin> 
<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic&family=Sono&display=swap" rel="stylesheet"> 

 <style>
 #noticetitle{
 font-family: 'Nanum Gothic', sans-serif;

 }
 #header{
 	background:#D7BFDC;
 	width:1200px;
 	border-radius: 30px 10px 50px;
 	margin-top:120px;
 }
    .outer{
		background:white;
		color:black;
		width:1200px;
		margin:auto;  
		margin-top:50px; 
	}
    .list-area{
        border: 1px solid white;
        text-align: center;
    }
    .list-area>tbody>tr:hover{
        background-color: #F9F2FB;
        cursor: pointer;
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
    <!-- include -->
    <%@include file="/views/common/realMenubar.jsp" %>
    <div class="outer">
    <div id="header">
        <br>
        <h1 align="center" id="noticetitle"><b>N O T I C E</b></h1>
        <br>
        </div>
        
        
        

        <table width="1200px"class="list-area" align="center">
            <thead>
                <tr>
                    <th height="50" width="10%">번호</th>
                    <th width="70%">제목</th>
                    <!--  <th width="100">작성자</th>-->
                    <th width="10%">작성일</th>
                    <th>조회</th>
                </tr>
            </thead>
            
            <tbody>
               
 			<%if(list!=null) {%>
 			<%if(list.isEmpty()) {%>
				<tr>
					<td colspan="5">존재하는 공지사항이 없습니다.</td>
				</tr> 			
 			
 			<%}else{ %>
 			
 				<%for(Notice n : list){  %>
 				
 				<tr>
                    <td height="50"><b><%=n.getNoticeNo() %></b></td>
                    
                    <td align="left"><%=n.getNoticeTitle() %></td>
                   <!-- <td><%=n.getNoticeWriter() %></td>--> 
                    <td><%=n.getCreateDate() %></td>
                    <td><%=n.getCount() %></td>
          
                </tr>
                
 				<%} %>
 			<%} %>
 			<%} %>
            </tbody>

        </table>
        <br><br><br>
    </div>
    
    <script>
    	$(function(){
    		$(".list-area>tbody>tr").click(function(){
    			
    			var nno = $(this).children().eq(0).text();
    			
    			location.href="<%=contextPath%>/detail.no?nno="+nno;				
    		});
    		
    	});
    
    
    </script>
    
        
        <%if(loginUser != null && loginUser.getUserId().equals("admin")){%> 
        <div align="center">
        	
        	<a href="<%=contextPath%>/enrollForm.no" class="abutton" style="font-size:15px;">글 작성</a>
        	
        </div>
        <br>
        <%} %>
    

</body>
</html>