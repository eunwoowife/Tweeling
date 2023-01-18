<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member"%>
<%
String contextPath = request.getContextPath();
String alertMsg = (String)session.getAttribute("alertMsg");
Member loginUser = (Member)session.getAttribute("loginUser");
Cookie[] cookies = request.getCookies();
String id = null;
if (cookies != null){
	for (int i = 0; i < cookies.length; i++){
		if(cookies[i].getName().equals("userId")){
			id = cookies[i].getValue();
		}
	}
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
   <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Bitter:wght@300&family=Cinzel:wght@800&family=Courier+Prime:ital@1&family=Montserrat:wght@300;400&display=swap" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
   <style>
      #logo p a {
	  text-align: center;
	  text-decoration: none;
	  color: inherit;
	  font-size: 33px;
      font-weight: bold;
	}
    body{
    	position:realtive;
        font-family: 'Montserrat', sans-serif;
    }
    *{padding:0;margin:0}
    li{list-style:none}
    a{text-decoration:none;font-size:16px}
    #top {
        width: 100%;
        height: 58px;
        background-color: #D0B2D6;
        top:0;
      	position:fixed;
      	z-index:2;
      	opacity:0.8;
    }
    #top div{
        float: left;
        line-height: 50px;
    }
    #navibar{
        width: 25%;
        margin-left: 200px;
        position:absolute;
    }
    #navibar ul{
        margin-top: 4px;
    }
    #logo{
        width: 10%;
        margin-top: 4px;
        position:absolute;
        left:850px;
    }
    #logo p{
        font-size: 35px;
        font-weight: bold;
        position:absolute;
    }
    #icon{
        width: 400px;
        margin-top: 5px;
        position:absolute;
        right: 250px;
    }
    #icon img{
        margin-left: 40px;
    }
    .menu {
    width: 800px;
    overflow: hidden;
    }
    .menu > li {
    width: 15%; /*20*5=100%*/
    float: left;
    text-align: center;
    line-height: 50px;
    }
    .menu a {
    color: black
    }
    .submenu > li {
    line-height: 50px;
    background-color: #D0B2D6;
    }
    .submenu {
    height: 0; /*ul의 높이를 안보이게 처리*/
    overflow: hidden;
    }
    .menu > li:hover {
    background-color:#d0b2d6;
    transition-duration: 0.5s;
    }
    .menu > li:hover #submenu1 {
    height: 300px; /*서브메뉴 li한개의 높이 50*5*/
    transition-duration: 1s;
    }
    .menu > li:hover #submenu2 {
    height: 250px; /*서브메뉴 li한개의 높이 50*5*/
    transition-duration: 1s;
    }
    .menu > li .submenu a:hover{
    font-weight: bold;
    color: aliceblue;
    text-decoration: underline;
    font-style: italic;
    }
    .iconArea{
	position:absolute;
    overflow: hidden;
    }
    .iconArea a{
    color: black;
    }
    .iconArea > li{
    	float: left;
	    text-align: center;
	    line-height: 50px;
    }
     .iconArea > li >img{
     margin-top:12px;
    }
    .iconSubmenu > li {
    background-color: #D0B2D6;
    }
     .iconSubmenu{
    height: 0; /*ul의 높이를 안보이게 처리*/
    overflow: hidden;
    }
    .iconArea > li:hover{
    background-color:#d0b2d6;
    transition-duration: 0.5s;
    }
    .iconArea > li:hover #iconSubmenu{
    height: 100px; /*서브메뉴 li한개의 높이 50*5*/
    transition-duration: 1s;
    }
    #goCart,#goSetting,#goSearch,#goHeart :hover{
    cursor:pointer;
    }
    </style>
    
    
</head>
<body>
	<script>
		var msg = "<%=alertMsg%>";
		if(msg!="null"){
			alert(msg);
			<%session.removeAttribute("alertMsg");%>
		}
	</script>

    <div id="top">
        <div id="navibar">
            <ul class="menu">
                <li>
                <a href="#">CELEB</a>
                <ul class="submenu" id="submenu1">
                    <li ><a href="<%=contextPath%>/agAllList.pro" style="font-size: 13px;">ARIANA GRANDE</a></li>
                    <li><a href="<%=contextPath%>/dcAllList.pro">DOJA CAT</a></li>
                    <li><a href="<%=contextPath%>/dlAllList.pro">DUA LIPA</a></li>
                     <li><a href="<%=contextPath%>/jbAllList.pro">JUSTIN BIEBER</a></li>
                    <li><a href="<%=contextPath%>/tsAllList.pro">TAYLOR SWIFT</a></li>
                    <li><a href="<%=contextPath%>/wdwAllList.pro">WHY DON'T WE</a></li>
                </ul>
                </li>
                <li>
                <a href="#">PRODCUT</a>
                <ul class="submenu" id="submenu2">
                    <li><a href="<%=contextPath%>/allList.pro">ALL</a></li>
                    <li><a href="<%=contextPath%>/musicList.pro">MUSIC</a></li>
                    <li><a href="<%=contextPath%>/clothingList.pro">CLOTHING</a></li>
                    <li><a href="<%=contextPath%>/beautyList.pro">BEAUTY</a></li>
                    <li><a href="<%=contextPath%>/accList.pro">ACC</a></li>
                </ul>
                </li>
                <li>
                <a href="<%=contextPath %>/eventListView.event">EVENT</a>
                </li>
                <li>
                <a href="<%=contextPath%>/list.no">&nbsp;&nbsp;&nbsp;&nbsp;ANNOUNCEMENT</a>
                </li>
            </ul>
        </div>
        <div id="logo" align="center">
            <p style="font-family: 'Cinzel', serif;"><a href="<%=contextPath%>/index.jsp">Tweeling</a></p>
        </div>
        <div id="icon">
        <ul class="iconArea">
        <li>
            <img src="resources/image/user.png" alt="" width="20px" height="20px">
            <ul class="iconSubmenu" id="iconSubmenu">
             <%if(loginUser !=null) {%>
                    <li><a href="<%=contextPath%>/view.mp">Mypage</a></li>
                    <li><a href="<%=contextPath %>/logout.me">Logout</a></li>
                      <%} else{%>
                    <li><a href="<%=contextPath%>/loginForm.me">Login</a></li>
                    <li><a href="<%=contextPath%>/joinForm.me">Join</a></li>
                      <%} %>
            </ul>
        </li>
        <li id="goSearch">
            <img src="resources/image/search.png" alt="" width="18px" height="18px" onclick="goSearch();">
        </li>
        <li id="goCart">
            <img src="resources/image/cart.png" alt="" width="21px" height="21px" onclick="goCart();">
        </li>
        <li id="goHeart">
            <img src="resources/image/heart.png" alt="" width="20px" height="20px" onclick="goHeart();">
        </li>
        <%if(loginUser!=null && (loginUser.getUserId().equals("admin") || loginUser.getUserId().equals("admin02"))) {%>
        <li id="goSetting">
            <img src="resources/image/settings.png" alt="" width="20px" height="20px" onclick="goSetting();">
        </li>
        <%} %>
          </ul>
        </div>
        
        <script>
      		 function goSearch(){
    		location.href="<%=contextPath%>/search.se";
    		}
        
        	function goCart(){
        		<%if(loginUser!=null) {%>
        		location.href="<%=contextPath%>/cart.ca";
        		<%}else{%>
        		alert("로그인 후, 이용 가능한 서비스입니다.");
        		location.href="<%=contextPath%>/loginForm.me";
        		<%}%>
        	}
        	
        	function goSetting(){
        		location.href="<%=contextPath%>/productManagement.pro";
        	}
        	
        	function goHeart(){
        		<%if(loginUser!=null) {%>
        		location.href="<%=contextPath%>/wishList.mp";
        		<%}else{%>
        		alert("로그인 후, 이용 가능한 서비스입니다.");
        		location.href="<%=contextPath%>/loginForm.me";
        		<%}%>
        	}
        </script>

    </div>
    
</body>
</html>